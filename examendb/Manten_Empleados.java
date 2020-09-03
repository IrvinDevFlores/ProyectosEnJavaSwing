import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.CallableStatement;
import java.sql.Connection;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;

public class Manten_Empleados extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    public Manten_Empleados() {
        initComponents();
        setVisible(true);
        SetDefault();
        CargarList();
        EnableControl(false);

        AddListeners();
    }

    public void EnableControl(boolean... control1) {
        EmpleadosJList.setEnabled(control1[0]);
        if (control1.length > 1) {
            NewButton.setEnabled(control1[1]);
            EditButton.setEnabled(control1[2]);
            DelButton.setEnabled(control1[3]);
            RestButton.setEnabled(control1[4]);
        }

    }


    public void Getemp(){
        String sql = "{call ObtenerEmpleadosOrdenados()}";
        String emp = "";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);


            final boolean hadResults = s1.execute();
         
            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    emp += rs.getString("Identidad") + ";"
                        +rs.getString("Nombre") + ";"
                            +rs.getString("Apellido") + ";"
                                +rs.getString("Puesto") + ";"
                                +rs.getString("FechaNac") + ";"
                                +rs.getDouble("Salario") + ";"
                                +rs.getString("Estado") + ";"
                                +"\n";
            
                }
            }

            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }

        JOptionPane.showMessageDialog(null,emp);

    }


    public void SetDefault() {
        PuestoCombobox.addItem("");
        PuestoCombobox.addItem("Contabilidad");
        PuestoCombobox.addItem("Sistemas");
        PuestoCombobox.addItem("Ventas");
    }

    public void valueChanged(ListSelectionEvent e) {
        // set the text of the label to the selected value of lists
        String data = EmpleadosJList.getSelectedValue();

        final String sql = new QueryBuilder.Builder().Select()
        .WithColumn("Identidad").WithColumn("Nombre")
                .From("tbl_usuarios").WhereMatchString("Nombre", data).Build().MakeQuery();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) {

                identityKey = rs.getString("Identidad");
            }
            con.close();
        } catch (final Exception exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
            System.exit(0);
        }

        String query = new QueryBuilder.Builder().Select().WithColumn("Identidad").WithColumn("Nombre")
                .WithColumn("Apellido")
                .WithColumn("Puesto").WithColumn("FechaNac").WithColumn("Salario")
                .WithColumn("Estado").From("tbl_usuarios").WhereMatchString("Identidad", identityKey).Build()
                .MakeQuery();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(query);
            while (rs.next()) {
                Identidad.setText(rs.getString("Identidad"));
                PrimerNombre.setText(rs.getString("Nombre"));

                PrimerApellido.setText(rs.getString("Apellido"));

                SalarioEmpleado.setText(rs.getString("Salario"));
                FechaNac.setText(rs.getString("FechaNac"));

                PuestoCombobox.setSelectedItem(rs.getString("Puesto"));
            }
            con.close();

        } catch (final Exception exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
            System.exit(0);
        }

    }

    private static String identityKey = "";

    public void CargarList() {

        final String sql = "select * from tbl_usuarios";
        RenderEmpleados(sql, "activo");

    }

    public void RenderInactives() {
        final String sql = "select * from tbl_usuarios";

        RenderEmpleados(sql, "inactivo");
    }

    public void RenderEmpleados(String sql, String mode) {

        final DefaultListModel model = new DefaultListModel<>();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString("Estado").equals(mode)) {
                    model.addElement(rs.getString("Nombre"));
                    identityKey = rs.getString("Identidad");

                } else {
                }

            }
            con.close();

            EmpleadosJList.setModel(model);

        } catch (final Exception exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
            System.exit(0);
        }
    }

    public void Limpiar() {
        Getemp();
    }

    public void actionPerformed(final ActionEvent evt) {

        String crudState = GuardarButton.getText();

        if (evt.getSource() == GuardarButton) {

            switch (crudState) {
                case "Guardar":
                    SaveData();
                    EnableControl(false);
                    Limpiar();
                    break;

                case "Editar":

                    EditData();
                    break;

                case "Baja":

                    DeleteData();
                    break;

                case "Alta":

                    RestoreData();
                    break;
            }
        }

        if (evt.getSource() == EmpleadosOrdenadosButton) {
            Limpiar();
        }

        // crud
        if (evt.getSource() == NewButton) {
            GuardarButton.setText("Guardar");
            EnableControl(false);
            EnableInput(true);

            FechaNac.setVisible(false);
            calendar.Hide(true);

            Limpiar();

        }

        if (evt.getSource() == EditButton) {
            CargarList();

            EnableInput(true);
            EnableControl(true);

            FechaNac.setVisible(true);
            calendar.Hide(false);

            GuardarButton.setText("Editar");
        }
        if (evt.getSource() == DelButton) {
            CargarList();
            EnableInput(false);
            EnableControl(true);

            
            FechaNac.setVisible(true);
            calendar.Hide(false);

            GuardarButton.setText("Baja");
        }

        if (evt.getSource() == RestButton) {
            RenderInactives();
            EnableInput(false);
            EnableControl(true);
            
            FechaNac.setVisible(true);
            calendar.Hide(false);
            GuardarButton.setText("Alta");
        }

    }

    public void RestoreData() {
        final String NoIdendidad = Identidad.getText();

        final String query = new QueryBuilder.Builder().UpdateTable("tbl_usuarios").Set("Estado", "activo")
                .WhereMatchString("Identidad", identityKey).Build().MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al eliminar");
            return;
        }
        CargarList();
        JOptionPane.showMessageDialog(null, "se restauro");
    }

    public void DeleteData() {
        final String NoIdendidad = Identidad.getText();

        final String query = new QueryBuilder.Builder().UpdateTable("tbl_usuarios").Set("Estado", "inactivo")
                .WhereMatchString("Identidad", identityKey).Build().MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al eliminar");
            return;
        }
        CargarList();
        JOptionPane.showMessageDialog(null, "se elimino");
    }

    public void EditData() {

        final String NoIdendidad = Identidad.getText();
        final String Nombre = PrimerNombre.getText();

        final String FechaNaci = calendar.GetDate();

        final String Apellido = PrimerApellido.getText();
        final String Salario = SalarioEmpleado.getText();

        final String Puesto = PuestoCombobox.getSelectedItem().toString();



        final String query = new QueryBuilder.Builder().UpdateTable("tbl_usuarios")
               
                        .Set("Identidad", NoIdendidad)
                        .Set("Nombre", Nombre)
                        .Set("Apellido", Apellido)
                        .Set("Puesto", Puesto)
                        .Set("FechaNac", FechaNaci)
                        .Set("Salario", Salario)
                        .Set("Estado", "activo")
                        .WhereMatchString("Identidad", identityKey).Build().MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }
        CargarList();
        JOptionPane.showMessageDialog(null, "se inserto");
    }

    public static void main(String args[]) {

        new Manten_Empleados();
    }

    public void SaveData() {

        final String NoIdendidad = Identidad.getText();
        final String Nombre = PrimerNombre.getText();

        final String FechaNaci = calendar.GetDate();

        final String Apellido = PrimerApellido.getText();
        final String Salario = SalarioEmpleado.getText();

        final String Puesto = PuestoCombobox.getSelectedItem().toString();

        final String query = new QueryBuilder.Builder()
                .Insert("tbl_usuarios").Column("Identidad", NoIdendidad)
                .Column("Nombre", Nombre).Column("Apellido", Apellido)
                .Column("Puesto", Puesto)
                .Column("FechaNac", FechaNaci)
                .Column("Salario", Salario)
                .Column("Estado", "activo").Execute().Build()
                .MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }

        CargarList();
        JOptionPane.showMessageDialog(null, "se guardo");

    }

    public void EnableInput(boolean disable) {
        Identidad.setEnabled(disable);
        PrimerNombre.setEnabled(disable);
        FechaNac.setEnabled(disable);
        PrimerApellido.setEnabled(disable);
        SalarioEmpleado.setEnabled(disable);
        PuestoCombobox.setEnabled(disable);
    }

    public void AddListeners() {
        GuardarButton.addActionListener(this);
        EmpleadosOrdenadosButton.addActionListener(this);
        NewButton.addActionListener(this);
        EditButton.addActionListener(this);
        DelButton.addActionListener(this);
        RestButton.addActionListener(this);
        EmpleadosJList.addListSelectionListener(this);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Identidad = new javax.swing.JTextField();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DelButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();
        PrimerNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        PrimerApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PuestoCombobox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmpleadosJList = new javax.swing.JList<>();
        GuardarButton = new javax.swing.JButton();
        EmpleadosOrdenadosButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        SalarioEmpleado = new javax.swing.JTextField();
        FechaNac = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Identidad");

        NewButton.setText("New");

        EditButton.setText("Edit");

        DelButton.setText("Del");

        RestButton.setText("Rest");

        jLabel2.setText("Nombre");

        jLabel4.setText("Apellido");

        jLabel5.setText("Puesto");

        jScrollPane1.setViewportView(EmpleadosJList);

        GuardarButton.setText("Guardar");

        EmpleadosOrdenadosButton.setText("Empleados ordendos");

        jLabel7.setText("Fecha Nac");

        jLabel8.setText("Salario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup().addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(GuardarButton)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup().addComponent(NewButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(EditButton)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(DelButton))))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup().addGap(20, 20, 20)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(Identidad, javax.swing.GroupLayout.PREFERRED_SIZE, 204,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup().addGap(2, 2, 2).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup().addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel5).addComponent(jLabel7)
                                                        .addComponent(jLabel8)).addGap(20, 20, 20)
                                                        .addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(PuestoCombobox,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 158,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(FechaNac,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 158,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(SalarioEmpleado,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE, 176,
                                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel4)
                                                        .addGap(18, 18, 18).addComponent(PrimerApellido,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE, 201,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createSequentialGroup().addComponent(jLabel2)
                                                        .addGap(18, 18, 18).addComponent(PrimerNombre))))))
                                .addGroup(layout.createSequentialGroup().addGap(18, 18, 18).addComponent(RestButton))
                                .addGroup(layout.createSequentialGroup().addGap(38, 38, 38)
                                        .addComponent(EmpleadosOrdenadosButton)))
                        .addContainerGap(40, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(NewButton)
                        .addComponent(EditButton).addComponent(DelButton).addComponent(RestButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36,
                                        Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1).addComponent(Identidad,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2).addComponent(PrimerNombre,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(26, 26, 26)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(PuestoCombobox, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel7).addComponent(FechaNac,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel8).addComponent(SalarioEmpleado,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GuardarButton).addComponent(EmpleadosOrdenadosButton))
                .addContainerGap()));

        pack();

        calendar = new EjemploJCalendar();

        calendar.SetPosition(jLabel7.getX() + jLabel7.getWidth() + 10, FechaNac.getY());

        getContentPane().add(calendar.GetDateTimePicker());

        FechaNac.setVisible(false);
    }// </editor-fold>

    // Variables declaration - do not modify
    EjemploJCalendar calendar;
    private javax.swing.JButton DelButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JList<String> EmpleadosJList;
    private javax.swing.JTextField FechaNac;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JTextField Identidad;
    private javax.swing.JButton EmpleadosOrdenadosButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField PrimerApellido;
    private javax.swing.JTextField PrimerNombre;
    private javax.swing.JComboBox<String> PuestoCombobox;
    private javax.swing.JButton RestButton;
    private javax.swing.JTextField SalarioEmpleado;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
