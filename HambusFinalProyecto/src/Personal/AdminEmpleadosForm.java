/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Personal;

import App.EjemploJCalendar;
import AppTools.Interfaces.IView;
import Entidades.Empleado;
import FormTools.Views;
import Persistence.Conexion;
import Persistence.QueryBuilder;
import Persistence.SqlCommandWritter;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;

/**
 *
 * @author Ariel
 */
public final class AdminEmpleadosForm extends IView {

    EjemploJCalendar calendar;

    public AdminEmpleadosForm(Views name) {
        super(name);
        initComponents();

        setFormView(GestionarEmpleadosPanel);

        RenderActives();
        EnableControl(false);

        SetCombo();
        AddListeners();

        InitMoreComponents();

        setDefaultCloseOperation(EXIT_ON_CLOSE);

    }

    @Override
    public void InitMoreComponents() {

        calendar = new EjemploJCalendar();

        calendar.SetPosition(fechaLabel.getX(), fechaLabel.getY() + 20);

        GestionarEmpleadosPanel.add(calendar.GetDateTimePicker());

        Date.setVisible(false);

    }

    @Override
    public void EnableControl(boolean... control1) {
        EmpleadosJList.setEnabled(control1[0]);
        if (control1.length > 1) {
            NewButton.setEnabled(control1[1]);
            EditButton.setEnabled(control1[2]);
            DelButton.setEnabled(control1[3]);
            RestButton.setEnabled(control1[4]);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        //set the text of the label to the selected value of lists 
        String data = EmpleadosJList.getSelectedValue();

        String identidad = new GetEmployeeIdByName().Query(data);

        String query = new GetEmployeeById().Query(identidad);

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(query);
            while (rs.next()) {
                Identidad.setText(rs.getString("EmployeeId"));
                PrimerNombre.setText(rs.getString("FirstName"));
                SegundoNombre.setText(rs.getString("MiddleName"));
                PrimerApellido.setText(rs.getString("LastName1"));
                SegundoApellido.setText(rs.getString("LastName2"));
                PuestoCombobox.setSelectedItem(rs.getString("Puesto"));
                Date.setText(rs.getString("EmployeeDayOfBirth"));
                Sexo.setSelectedItem(rs.getString("EmployeeSex"));
                Celular.setText(rs.getString("EmployeePhone"));
            }
            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "error", 0);
            System.exit(0);
        }

    }

    @Override
    public void RenderActives() {

        final String sql = new QueryBuilder.Builder()
                .Select()
                .WithColumn("EmployeeId")
                .WithColumn("FirstName")
                .WithColumn("MiddleName")
                .WithColumn("LastName1")
                .WithColumn("LastName2")
                .WithColumn("Puesto")
                .WithColumn("Estado")
                .From("employees")
                .Build().MakeQuery();

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

    @Override
    public void Limpiar() {
        final String empty = "";

        Identidad.setText(empty);
        PrimerNombre.setText(empty);
        SegundoNombre.setText(empty);
        PrimerApellido.setText(empty);
        SegundoApellido.setText(empty);
        Sexo.setSelectedItem("");
        Celular.setText(empty);
        Date.setText(empty);
        PuestoCombobox.setSelectedItem("");
    }

    @Override
    public void actionPerformed(final ActionEvent evt) {

        HandleState(evt);
        HandleInputs(evt);

    }

    @Override
    public void RestoreData() {
        final String NoIdendidad = Identidad.getText();

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
        final String NoIdendidad = Identidad.getText();

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

        Empleado empleado = GetEmpleado();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("employees")
                .Set("EmployeeId", empleado.EmployeeId)
                .Set("FirstName", empleado.FirstName)
                .Set("MiddleName", empleado.MiddleName)
                .Set("LastName1", empleado.LastName1)
                .Set("LastName2", empleado.LastName2)
                .Set("EmployeeSex", empleado.EmployeeSex)
                .Set("EmployeePhone", empleado.EmployeePhone)
                .Set("EmployeeDayOfBirth", empleado.EmployeeDayOfBirth)
                .Set("Puesto", empleado.Puesto)
                .Set("Estado", "activo")
                .WhereMatchString("EmployeeId", empleado.EmployeeId)
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

        Empleado empleado = GetEmpleado();

        final String query = new QueryBuilder.Builder()
                .Insert("employees")
                .Column("EmployeeId", empleado.EmployeeId)
                .Column("FirstName", empleado.FirstName)
                .Column("MiddleName", empleado.MiddleName)
                .Column("LastName1", empleado.LastName1)
                .Column("LastName2", empleado.LastName2)
                .Column("EmployeeSex", empleado.EmployeeSex)
                .Column("EmployeePhone", empleado.EmployeePhone)
                .Column("EmployeeDayOfBirth", empleado.EmployeeDayOfBirth)
                .Column("Puesto", empleado.Puesto)
                .Column("Estado", "activo")
                .Execute()
                .Build()
                .MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }

        /*final String joinQuery = new QueryBuilder.Builder()
                .Insert("tbl_emp_salarios")
                .Column("emp_identidad", NoIdendidad)
                .Column("emp_salario", 0)
                .Execute()
                .Build()
                .MakeQuery();

        final boolean joinQueryFailed = !SqlCommandWritter.WriteCommand(joinQuery);
        if (joinQueryFailed) {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }*/
        RenderActives();
        JOptionPane.showMessageDialog(null, "se inserto en join");

    }

    @Override
    public void EnableInput(boolean disable) {
        Identidad.setEnabled(disable);
        PrimerNombre.setEnabled(disable);
        SegundoNombre.setEnabled(disable);
        PrimerApellido.setEnabled(disable);
        SegundoApellido.setEnabled(disable);
        Sexo.setEditable(disable);
        Celular.setEnabled(disable);
        calendar.Disable(disable);
        PuestoCombobox.setEnabled(disable);
    }

    @Override
    public void AddListeners() {
        GuardarButton.addActionListener(this);
        LimpiarButton.addActionListener(this);
        NewButton.addActionListener(this);
        EditButton.addActionListener(this);
        DelButton.addActionListener(this);
        RestButton.addActionListener(this);
        EmpleadosJList.addListSelectionListener(this);
    }

    public Empleado GetEmpleado() {

        Empleado empleado = new Empleado() {
            {
                EmployeeId = Identidad.getText();
                FirstName = PrimerNombre.getText();
                MiddleName = SegundoNombre.getText();
                LastName1 = PrimerApellido.getText();
                LastName2 = SegundoApellido.getText();
                Puesto = PuestoCombobox.getSelectedItem().toString();
                EmployeeSex = Sexo.getSelectedItem().toString();
                EmployeePhone = Celular.getText();
                EmployeeDayOfBirth = calendar.GetDate();
            }
        };

        return empleado;
    }

    public void HandleState(ActionEvent evt) {
        String crudState = GuardarButton.getText();

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
            calendar.Hide(true);
            Date.setVisible(false);
            GuardarButton.setText("Guardar");
            //EnableControl(false, true);
            EmpleadosJList.setEnabled(true);
            EnableInput(true);
            Limpiar();

        } else {
            calendar.Hide(false);
            Date.setVisible(true);
            Limpiar();
        }

        if (evt.getSource() == EditButton) {
            RenderActives();

            EnableInput(true);
            EnableControl(true);

            Identidad.setEnabled(false);
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

    public void SetCombo() {
        PuestoCombobox.addItem("");
        PuestoCombobox.addItem("Cajero");
        PuestoCombobox.addItem("Mesero");
        PuestoCombobox.addItem("Admin");

        Sexo.addItem("");
        Sexo.addItem("Hombre");
        Sexo.addItem("Mujer");

    }

    public void RenderEmpleados(String sql, String mode) {

        final DefaultListModel model = new DefaultListModel<>();

        String identityKey = "";

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("Estado").equals(mode)) {
                    model.addElement(rs.getString("FirstName"));

                    identityKey = rs.getString("EmployeeId");

                } else {
                }

            }
            con.close();

            EmpleadosJList.setModel(model);

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ActionButtons = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        GestionarEmpleadosPanel = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        SegundoNombre = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        PrimerNombre = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        PrimerApellido = new javax.swing.JTextField();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        SegundoApellido = new javax.swing.JTextField();
        PuestoCombobox = new javax.swing.JComboBox<>();
        Celular = new javax.swing.JTextField();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        Sexo = new javax.swing.JComboBox<>();
        jPanel9 = new javax.swing.JPanel();
        DelButton = new javax.swing.JButton();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        EmpleadosJList = new javax.swing.JList<>();
        jLabel30 = new javax.swing.JLabel();
        GuardarButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        CrearUsuario = new javax.swing.JButton();
        fechaLabel = new javax.swing.JLabel();
        Date = new javax.swing.JTextField();
        Identidad = new javax.swing.JFormattedTextField();

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

        GestionarEmpleadosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Gestionar Empleados"));

        jLabel21.setText("Empleados");

        jLabel22.setText("Puesto");

        jLabel23.setText("Segundo nombre");

        jLabel24.setText("Primer nombre");

        jLabel25.setText("Primer apellido");

        jLabel26.setText("Segundo apellido");

        jLabel28.setText("Celular");

        jLabel29.setText("Sexo");

        jPanel9.setBorder(javax.swing.BorderFactory.createTitledBorder("Acciones"));

        DelButton.setText("Eliminar");

        NewButton.setText("Nuevo");

        EditButton.setText("Edit");

        RestButton.setText("Restaurar");

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NewButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(DelButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(RestButton)
                .addContainerGap(64, Short.MAX_VALUE))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        jScrollPane2.setViewportView(EmpleadosJList);

        jLabel30.setText("Cedula");

        GuardarButton.setBackground(new java.awt.Color(102, 255, 102));
        GuardarButton.setText("Guardar");
        GuardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarButtonActionPerformed(evt);
            }
        });

        LimpiarButton.setBackground(new java.awt.Color(255, 0, 51));
        LimpiarButton.setText("Limpiar");

        CrearUsuario.setBackground(new java.awt.Color(255, 204, 51));
        CrearUsuario.setText("Admin user");
        CrearUsuario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearUsuarioActionPerformed(evt);
            }
        });

        fechaLabel.setText("Fecha de nacimiento");

        try {
            Identidad.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("####-####-#####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout GestionarEmpleadosPanelLayout = new javax.swing.GroupLayout(GestionarEmpleadosPanel);
        GestionarEmpleadosPanel.setLayout(GestionarEmpleadosPanelLayout);
        GestionarEmpleadosPanelLayout.setHorizontalGroup(
            GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                        .addGap(73, 73, 73)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel21))
                        .addGap(51, 51, 51)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                .addComponent(jLabel30)
                                .addGap(138, 138, 138)
                                .addComponent(jLabel22))
                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                .addGap(2, 2, 2)
                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(Sexo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(jLabel29))
                                        .addGap(18, 18, 18)
                                        .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                                .addGap(168, 168, 168)
                                                .addComponent(jLabel28))
                                            .addComponent(fechaLabel)
                                            .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jLabel24)
                                                    .addComponent(PrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                                        .addGap(16, 16, 16)
                                                        .addComponent(jLabel23))
                                                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                                        .addGap(18, 18, 18)
                                                        .addComponent(SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                            .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(CrearUsuario, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                                    .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGap(18, 18, 18)
                                                    .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGap(0, 0, Short.MAX_VALUE))))
                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(Identidad)
                                    .addComponent(PrimerApellido, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.Alignment.LEADING))
                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel26)
                                            .addComponent(SegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, GestionarEmpleadosPanelLayout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(PuestoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(170, Short.MAX_VALUE))
        );
        GestionarEmpleadosPanelLayout.setVerticalGroup(
            GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21)
                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel22)
                            .addComponent(jLabel30))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(PuestoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel26)
                                    .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(SegundoApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(jLabel24))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(SegundoNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(PrimerNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel28)
                                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18))
                            .addComponent(Celular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addComponent(fechaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(GestionarEmpleadosPanelLayout.createSequentialGroup()
                        .addComponent(jLabel21)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addGroup(GestionarEmpleadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CrearUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(GestionarEmpleadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(GestionarEmpleadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(12, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void CrearUsuarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CrearUsuarioActionPerformed
        new AdminUsersForm(Views.ADMIN_USERS).setVisible(true);
    }//GEN-LAST:event_CrearUsuarioActionPerformed

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_GuardarButtonActionPerformed

    public static void main(String... args) {
        new AdminEmpleadosForm(Views.ADMIN_EMPLEADOS).setVisible(true);
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionButtons;
    private javax.swing.JTextField Celular;
    private javax.swing.JButton CrearUsuario;
    private javax.swing.JTextField Date;
    private javax.swing.JButton DelButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JList<String> EmpleadosJList;
    private javax.swing.JPanel GestionarEmpleadosPanel;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JFormattedTextField Identidad;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField PrimerApellido;
    private javax.swing.JTextField PrimerNombre;
    private javax.swing.JComboBox<String> PuestoCombobox;
    private javax.swing.JButton RestButton;
    private javax.swing.JTextField SegundoApellido;
    private javax.swing.JTextField SegundoNombre;
    private javax.swing.JComboBox<String> Sexo;
    private javax.swing.JLabel fechaLabel;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


}
