/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;

import restApp.IView;
import java.sql.CallableStatement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.Date;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

public final class AdminUsersForm extends IView {

    public AdminUsersForm(Views name) {
        super(name);
        initComponents();

        setFormView(GestionarEmpleadosPane);
        InitMoreComponents();
        RenderActives();

        AddListeners();
        FillTable();
    }

    DefaultTableModel employeeModel;
    String cols[] = {"Id", "Empleado"};
    WM window;

    Llenado combo;

    @Override
    public void InitMoreComponents() {
        employeeModel = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        // Agregar las columnas al Model
        for (String col : cols) {
            employeeModel.addColumn(col);

        }

        Emps.setModel(employeeModel);

        Emps.addMouseListener(this);

        EnableInput(false);
        EnableControl(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        window = new WM();
        combo = new Llenado();

        // PermisosId.setVisible(false);
        combo.llenar_combo("select * from roles", PermisosId, Permisos);
    }

    public void FillTable() {
        String sql = "{call GetUsersNames()}";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);

            final boolean hadResults = s1.execute();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    employeeModel.addRow(new String[]{
                        rs.getString("EmployeeId"),
                        rs.getString("Name")
                    });

                }
            }

            con.close();

            Emps.setModel(employeeModel);

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
    }

    static String userId = "";

    public DefaultListModel FillJList(int identidad) {
        String sql = "{call GetRolesByUserId(?)}";
        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);
            s1.setInt(1, identidad);
            final boolean hadResults = s1.execute();
            DefaultListModel mod = new DefaultListModel();
            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {
                    mod.addElement(rs.getString("RoleName"));
                    userId = rs.getString("UserId");
                }
            }

            con.close();

            return mod;
        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
            return null;
        }
    }

    public DefaultListModel FillJList(String identidad) {
        String sql = "{call GetRolesByUserId(?)}";
        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);
            s1.setString(1, identidad);
            final boolean hadResults = s1.execute();
            DefaultListModel mod = new DefaultListModel();
            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {
                    mod.addElement(rs.getString("RoleName"));

                }
            }

            con.close();

            return mod;
        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
            return null;
        }
    }

    @Override
    public void EnableControl(boolean... control1) {
        Empleados.setEnabled(control1[0]);
        Emps.setEnabled(control1[0]);
        if (control1.length > 1) {
            NewButton.setEnabled(control1[1]);
            EditButton.setEnabled(control1[2]);
            DelButton.setEnabled(control1[3]);
            RestButton.setEnabled(control1[4]);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {

        String data = Empleados.getSelectedValue();

        String identidad = new GetEmployeeIdByName().Query(data);

        String query = new GetEmployeeById().Query(identidad);

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(query);
            while (rs.next()) {
                Usuario.setText(rs.getString("EmployeeId"));
                Pass.setText(rs.getString("FirstName"));
                Puesto.setText(rs.getString("MiddleName"));

                //Permisos.setSelectedItem(rs.getString("EmployeeSex"));
            }
            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "error", 0);
            System.exit(0);
        }

    }

    @Override
    public void Limpiar() {
        final String empty = "";

        Usuario.setText(empty);
        Pass.setText(empty);
        Puesto.setText(empty);

        Permisos.setSelectedItem("");
    }

    @Override
    public void actionPerformed(final ActionEvent evt) {

        HandleState(evt);
        HandleInputs(evt);

    }

    @Override
    public void RestoreData() {
        final String NoIdendidad = Usuario.getText();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("employees")
                .Set("Estado", "activo")
                .WhereMatchString("EmployeeId", NoIdendidad)
                .Build()
                .MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al eliminar");
            return;
        }
        RenderActives();
        JOptionPane.showMessageDialog(null, "se restauro");
    }

    @Override
    public void DeleteData() {
        final String NoIdendidad = Usuario.getText();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("employees")
                .Set("Estado", "inactivo")
                .WhereMatchString("EmployeeId", NoIdendidad)
                .Build()
                .MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al eliminar");
            return;
        }
        RenderActives();
        JOptionPane.showMessageDialog(null, "se elimino");
    }

    @Override
    public void EditData() {

        Usuario empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("employees")
                .Set("EmployeeId", empleado.Id)
                .Set("FirstName", empleado.username)
                .Set("MiddleName", empleado.employeeId)
                .Set("Estado", "activo")
                .WhereMatchString("EmployeeId", empleado.Id)
                .Build()
                .MakeQuery();

        JOptionPane.showMessageDialog(null, query);
        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            JOptionPane.showMessageDialog(null, "fallo editar");
            return;
        }
        RenderActives();
        JOptionPane.showMessageDialog(null, "se edito");
    }

    @Override
    public void SaveData() {

        String id = GetSelectedUser();

        Usuario empleado = GetUser();
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Calendar calendar = Calendar.getInstance();
        final String query = new QueryBuilder.Builder()
                .Insert("users")
                .Column("UserName", empleado.username)
                .Column("Password", empleado.Password)
                .Column("EmployeeId", id)
                .Column("Estado", "activo")
                // .Column("FechaDeCrecion", formatter.format(calendar.getTime()))
                .Execute()
                .Build()
                .MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            window.W("no se pudo guardar");
            return;
        }

        /*final String joinQuery = new QueryBuilder.Builder()
            
        }*/
        RenderActives();
        window.W("usuario guardado");

    }

    @Override
    public void EnableInput(boolean disable) {
        Usuario.setEnabled(disable);
        Pass.setEnabled(disable);
        Puesto.setEnabled(disable);
        Permisos.setEnabled(disable);
    }

    @Override
    public void AddListeners() {
        GuardarButton.addActionListener(this);
        LimpiarButton.addActionListener(this);
        NewButton.addActionListener(this);
        EditButton.addActionListener(this);
        DelButton.addActionListener(this);
        RestButton.addActionListener(this);
        Empleados.addListSelectionListener(this);
        Permisos.addActionListener(this);
    }

    public Usuario GetUser() {

        Usuario empleado = new Usuario() {
            {
                username = Usuario.getText();
                Password = Pass.getText();
            }
        };

        return empleado;
    }

    public void HandleState(ActionEvent evt) {
        String crudState = GuardarButton.getText();

        if (evt.getSource() == Permisos) {
            if (Permisos.getSelectedIndex() != 0) {
                PermisosId.setSelectedIndex(Permisos.getSelectedIndex());
             
            }
        }

        if (evt.getSource() == GuardarButton) {

            switch (crudState) {
                case "Guardar":

                    SaveData();

                    break;

                case "Editar":

                    EditData();
                    break;

                case "Eliminar":

                    DeleteData();
                    break;

                case "Restaurar":

                    RestoreData();
                    break;
            }
        }
    }

    public void HandleInputs(ActionEvent evt) {
        if (evt.getSource() == LimpiarButton) {
            Limpiar();
        }

        //crud
        if (evt.getSource() == NewButton) {

            GuardarButton.setText("Guardar");
            //EnableControl(false, true);
            Empleados.setEnabled(true);
            Emps.setEnabled(true);
            EnableInput(true);
            Limpiar();

        } else {
            //Limpiar();
            Emps.setEnabled(true);
        }

        if (evt.getSource() == EditButton) {
            RenderActives();

            EnableInput(true);
            EnableControl(true);

            GuardarButton.setText("Editar");
        }
        if (evt.getSource() == DelButton) {
            RenderActives();
            EnableInput(false);
            EnableControl(true);
            GuardarButton.setText("Eliminar");
        }

        if (evt.getSource() == RestButton) {
            RenderInactives();
            EnableInput(false);
            EnableControl(true);
            GuardarButton.setText("Restaurar");
        }
    }

    @Override
    public void RenderActives() {

        final String sql = "{ call GetUsersByMode(?) }";

        RenderEmpleados(sql, "activo");

    }

    @Override
    public void RenderInactives() {
        final String sql = new QueryBuilder.Builder()
                .Select()
                .WithColumn("EmployeeId")
                .WithColumn("FirstName")
                .WithColumn("Estado")
                .From("employees")
                .Build().MakeQuery();

        RenderEmpleados(sql, "inactivo");
    }

    public void RenderEmpleados(String sql, String mode) {

        final DefaultListModel model = new DefaultListModel<>();

        String identityKey = "";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);

            s1.setString(1, mode);

            final boolean hadResults = s1.execute();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    model.addElement(rs.getString("Name"));

                    //  identityKey = rs.getString("EmployeeId");
                }
            }

            con.close();

            Empleados.setModel(model);

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
    }

    public static void main(String... args) {
        new AdminUsersForm(Views.ELEGIR_MESA).setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent evt) {
        if (evt.getSource() == Emps) {

            ChangeEmployee();
        }
    }

    public String GetSelectedUser() {
        int fila = Emps.getSelectedRow();
        int col = Emps.getSelectedColumn();
        String id = "";
        if (col == 0) {
            id = employeeModel.getValueAt(fila, col).toString();
        }
        return id;
    }

    public void ChangeEmployee() {
        Limpiar();

        int fila = Emps.getSelectedRow();
        int col = Emps.getSelectedColumn();
        if (col == 0) {

            int preferedColumn = 2;

            String id = employeeModel.getValueAt(fila, col).toString();

            DefaultListModel mod = new DefaultListModel();
            int identidad = 0;

            final String joinQuery = "{call GetUserById(?)}";

            try {
                final Connection con = new Conexion().getConexion();
                CallableStatement s1 = con.prepareCall(joinQuery);

                s1.setString(1, id);

                final boolean hadResults = s1.execute();

                if (hadResults) {
                    ResultSet rs = s1.getResultSet();
                    while (rs.next()) {
                        identidad = Integer.parseInt(rs.getString("UserId"));
                        Usuario.setText(rs.getString("UserName"));
                        Pass.setText(rs.getString("Password"));
                        Puesto.setText(rs.getString("UserId"));
                        //  identityKey = rs.getString("EmployeeId");
                    }
                } else {
                    window.W("no se");
                }

                con.close();

                mod = FillJList(identidad);

                PermisoUsuario.setModel(mod);
                // Empleados.setModel(model);
            } catch (final SQLException exp) {
                JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
                System.exit(0);
            }
        }

    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        //To change body of generated methods, choose Tools | Templates.
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ActionButtons = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        GestionarEmpleadosPane = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        PermisoUsuario = new javax.swing.JList<>();
        jLabel20 = new javax.swing.JLabel();
        AgregarPermiso = new javax.swing.JButton();
        jLabel19 = new javax.swing.JLabel();
        Permisos = new javax.swing.JComboBox<>();
        jScrollPane3 = new javax.swing.JScrollPane();
        Empleados = new javax.swing.JList<>();
        PermisosId = new javax.swing.JComboBox<>();
        UsersPanel = new javax.swing.JPanel();
        Usuario = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        Pass = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        Puesto = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        Emps = new javax.swing.JTable();
        GuardarButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        DelButton = new javax.swing.JButton();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder("Permisos"));

        jScrollPane1.setViewportView(PermisoUsuario);

        jLabel20.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel20.setText("=>");

        AgregarPermiso.setText("Agregar");
        AgregarPermiso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarPermisoActionPerformed(evt);
            }
        });

        jLabel19.setText("Permiso");

        jScrollPane3.setViewportView(Empleados);

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(jLabel19)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(AgregarPermiso))
                            .addComponent(Permisos, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27)
                        .addComponent(jLabel20))
                    .addComponent(PermisosId, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 137, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarPermiso)
                    .addComponent(jLabel19))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel20, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(Permisos, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(PermisosId)
                .addGap(57, 57, 57))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        UsersPanel.setBorder(new javax.swing.border.MatteBorder(null));

        jLabel10.setText("Puesto");

        Pass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PassActionPerformed(evt);
            }
        });

        jLabel9.setText("Usuario");

        jLabel14.setText("Password");

        jLabel13.setText("Empleados");

        jLabel31.setFont(new java.awt.Font("sansserif", 0, 24)); // NOI18N
        jLabel31.setText("=>");

        Emps.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Id", "Empleado"
            }
        ));
        jScrollPane2.setViewportView(Emps);

        javax.swing.GroupLayout UsersPanelLayout = new javax.swing.GroupLayout(UsersPanel);
        UsersPanel.setLayout(UsersPanelLayout);
        UsersPanelLayout.setHorizontalGroup(
            UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsersPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel31)
                        .addGap(10, 10, 10))
                    .addGroup(UsersPanelLayout.createSequentialGroup()
                        .addComponent(jLabel13)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsersPanelLayout.createSequentialGroup()
                        .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Usuario, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9))
                        .addGap(18, 18, 18)
                        .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14)
                            .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jLabel10)
                    .addComponent(Puesto, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        UsersPanelLayout.setVerticalGroup(
            UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, UsersPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel14)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(UsersPanelLayout.createSequentialGroup()
                        .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(UsersPanelLayout.createSequentialGroup()
                                .addGroup(UsersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Usuario, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Pass, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(38, 38, 38))
                            .addGroup(UsersPanelLayout.createSequentialGroup()
                                .addComponent(jLabel31, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel10)))
                        .addComponent(Puesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(185, 185, 185))
                    .addGroup(UsersPanelLayout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        GuardarButton.setText("Guardar");

        LimpiarButton.setText("Limpiar");
        LimpiarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimpiarButtonActionPerformed(evt);
            }
        });

        jPanel10.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        DelButton.setText("Eliminar");

        NewButton.setText("Nuevo");

        EditButton.setText("Edit");

        RestButton.setText("Restaurar");

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RestButton)
                .addContainerGap(282, Short.MAX_VALUE))
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout GestionarEmpleadosPaneLayout = new javax.swing.GroupLayout(GestionarEmpleadosPane);
        GestionarEmpleadosPane.setLayout(GestionarEmpleadosPaneLayout);
        GestionarEmpleadosPaneLayout.setHorizontalGroup(
            GestionarEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEmpleadosPaneLayout.createSequentialGroup()
                .addGroup(GestionarEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarEmpleadosPaneLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(GestionarEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(UsersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(GestionarEmpleadosPaneLayout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addComponent(GuardarButton)
                        .addGap(18, 18, 18)
                        .addComponent(LimpiarButton)))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        GestionarEmpleadosPaneLayout.setVerticalGroup(
            GestionarEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEmpleadosPaneLayout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                .addComponent(UsersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(GestionarEmpleadosPaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GestionarEmpleadosPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GestionarEmpleadosPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void PassActionPerformed(java.awt.event.ActionEvent evt) {                                     
        // TODO add your handling code here:
    }                                    

    private void LimpiarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    }                                             

    private void AgregarPermisoActionPerformed(java.awt.event.ActionEvent evt) {                                               

        DefaultListModel model = new DefaultListModel<>();

        String identityKey = "";
        int i = Integer.parseInt(Puesto.getText());
        int d = Integer.parseInt(PermisosId.getSelectedItem().toString());

        final String query = new QueryBuilder.Builder()
                .Insert("userroles")
                .Column("UserId", i)
                .Column("RoleId", d)
                .Execute()
                .Build()
                .MakeQuery();
        
        
          final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            window.W("no se pudo guardar");
        }

        RenderActives();


        String f = GetSelectedUser();
        model = FillJList(i);
        PermisoUsuario.setModel(model);

        window.W("usuario guardado");
    }                                              


    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup ActionButtons;
    private javax.swing.JButton AgregarPermiso;
    private javax.swing.JButton DelButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JList<String> Empleados;
    private javax.swing.JTable Emps;
    private javax.swing.JPanel GestionarEmpleadosPane;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField Pass;
    private javax.swing.JList<String> PermisoUsuario;
    private javax.swing.JComboBox<String> Permisos;
    private javax.swing.JComboBox<String> PermisosId;
    private javax.swing.JTextField Puesto;
    private javax.swing.JButton RestButton;
    private javax.swing.JPanel UsersPanel;
    private javax.swing.JTextField Usuario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration                   

}
