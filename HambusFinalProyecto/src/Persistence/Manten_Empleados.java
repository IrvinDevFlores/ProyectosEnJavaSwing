package Persistence;

import  javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.Statement;
import java.text.ParseException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.text.MaskFormatter;


public class Manten_Empleados extends javax.swing.JFrame implements ActionListener, 
        ListSelectionListener  {

    public Manten_Empleados() {
        initComponents();
        setVisible(true);
        SetDefault();
        CargarList();
        EnableControl(false);
    }

    public void EnableControl(boolean... control1)
    {
        EmpleadosJList.setEnabled(control1[0]);
       if(control1.length > 1){
         NewButton.setEnabled(control1[1]);
        EditButton.setEnabled(control1[2]);
        DelButton.setEnabled(control1[3]);
        RestButton.setEnabled(control1[4]);
        }
   
    }

    public void SetDefault() {
        PuestoCombobox.addItem("");
        PuestoCombobox.addItem("Programador");
        PuestoCombobox.addItem("Contador");
        PuestoCombobox.addItem("Concerje");
    }

    public void valueChanged(ListSelectionEvent e) 
    { 
        //set the text of the label to the selected value of lists 
        String data = EmpleadosJList.getSelectedValue();

        final String sql = new QueryBuilder
        .Builder()
        .Select()
            .WithColumn("emp_identidad")
            .WithColumn("emp_pnombre")
            .From("tbl_empleado")
            .WhereMatchString("emp_pnombre",data )
        .Build().MakeQuery();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) {
     
                identityKey = rs.getString("emp_identidad");
            }
            con.close();
        } catch (final Exception exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
            System.exit(0);
        }


        String query = new QueryBuilder.Builder()
                             .Select()
                             .WithColumn("emp_identidad")
                              .WithColumn("emp_pnombre")
                                 .WithColumn("emp_snombre")
                                    .WithColumn("emp_papellido")
                                    .WithColumn("emp_sapellido")
                                    .WithColumn("emp_puesto")
                                     .From("tbl_empleado")
                                            .WhereMatchString("emp_identidad", identityKey)
                                            .Build()
                                            .MakeQuery();

            try {
                final Connection con = new Conexion().getConexion();
                final Statement s1 = con.createStatement();
                final ResultSet rs = s1.executeQuery(query);
                while (rs.next()) {
                    Identidad.setText(rs.getString("emp_identidad"));
                    PrimerNombre.setText(rs.getString("emp_pnombre"));
                    SegundoNombre.setText(rs.getString("emp_snombre"));
                    PrimerApellido.setText(rs.getString("emp_papellido"));
                    SegundoApellido.setText(rs.getString("emp_sapellido"));
                    PuestoCombobox.setSelectedItem(rs.getString("emp_puesto"));
                }
                con.close();
    
                
            } catch (final Exception exp) {
                JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
                System.exit(0);
            }
          
    } 
      

    private static String identityKey ="";
    public void CargarList(){

        final String sql = new QueryBuilder
        .Builder()
        .Select()
            .WithColumn("emp_identidad")
            .WithColumn("emp_pnombre")
            .WithColumn("emp_estado")
            .From("tbl_empleado")
        .Build().MakeQuery();

        RenderEmpleados(sql,"activo");

        
    }

    public void RenderInactives(){
        final String sql = new QueryBuilder
        .Builder()
        .Select()
            .WithColumn("emp_identidad")
            .WithColumn("emp_pnombre")
            .WithColumn("emp_estado")
            .From("tbl_empleado")
        .Build().MakeQuery();

        RenderEmpleados(sql,"inactivo");
    }

    public void RenderEmpleados(String sql, String mode){

        
        final DefaultListModel model = new DefaultListModel<>();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) 
            {
                 if(rs.getString("emp_estado").equals(mode))
                 {
                    model.addElement(rs.getString("emp_pnombre"));
                    identityKey = rs.getString("emp_identidad");
                  
                 }else{}
         
            
            }
            con.close();

            EmpleadosJList.setModel(model);
   
        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
            System.exit(0);
        }
    }

    public void Limpiar() {
        final String empty = "";

        Identidad.setText(empty);
        PrimerNombre.setText(empty);
        SegundoNombre.setText(empty);
        PrimerApellido.setText(empty);
        SegundoApellido.setText(empty);
        PuestoCombobox.setSelectedItem("");
    }

    @Override
    public void actionPerformed(final ActionEvent evt) {

        String crudState = GuardarButton.getText();

        if (evt.getSource() == GuardarButton) {
           
            switch(crudState){
                case "Guardar":
                SaveData();
                EnableControl(false);
                Limpiar();
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

        if(evt.getSource() == LimpiarButton){
            Limpiar();
        }

        //crud
        if (evt.getSource() == NewButton) {
            GuardarButton.setText("Guardar");
            EnableControl(false);
            EnableInput(true);
            Limpiar();
            
        }

        if (evt.getSource() == EditButton) {
            CargarList();

            EnableInput(true);
            EnableControl(true);
                            
            Identidad.setEnabled(false);
            GuardarButton.setText("Editar");
        }
        if (evt.getSource() == DelButton) {
            CargarList();
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

    public void RestoreData(){
        final String NoIdendidad = Identidad.getText();

        final String query = new QueryBuilder.Builder()
                            .UpdateTable("tbl_empleado")
                                    .Set("emp_estado", "activo")
                                    .WhereMatchString("emp_identidad", identityKey )
                                    .Build()
                                    .MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al eliminar");
            return;
        }
        CargarList();
        JOptionPane.showMessageDialog(null, "se restauro");
    }

    public void DeleteData(){
        final String NoIdendidad = Identidad.getText();

        final String query = new QueryBuilder.Builder()
                            .UpdateTable("tbl_empleado")
                                    .Set("emp_estado", "inactivo")
                                    .WhereMatchString("emp_identidad", identityKey )
                                    .Build()
                                    .MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al eliminar");
            return;
        }
        CargarList();
        JOptionPane.showMessageDialog(null, "se elimino");
    }

    public void EditData(){
        
        final String PNombre = PrimerNombre.getText();
        final String SNombre = SegundoNombre.getText();
        final String PApellido = PrimerApellido.getText();
        final String SApellido = SegundoApellido.getText();
        final String Puesto = PuestoCombobox.getSelectedItem().toString();

        final String query = new QueryBuilder.Builder()
                            .UpdateTable("tbl_empleado")
                                    .Set("emp_pnombre", PNombre)
                                    .Set("emp_snombre", SNombre)
                                    .Set("emp_papellido", PApellido)
                                    .Set("emp_sapellido", SApellido)
                                    .Set("emp_puesto", Puesto)
                                    .WhereMatchString("emp_identidad", identityKey )
                                    .Build()
                                    .MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }
        CargarList();
        JOptionPane.showMessageDialog(null, "se inserto");
    }

    public void SaveData() {

        final String NoIdendidad = Identidad.getText();
        final String PNombre = PrimerNombre.getText();
        final String SNombre = SegundoNombre.getText();
        final String PApellido = PrimerApellido.getText();
        final String SApellido = SegundoApellido.getText();
        final String Puesto = PuestoCombobox.getSelectedItem().toString();

        final String query = new QueryBuilder.Builder()
                            .Insert("tbl_empleado")
                            .Column("emp_identidad", NoIdendidad)
                                    .Column("emp_pnombre", PNombre)
                                    .Column("emp_snombre", SNombre)
                                    .Column("emp_papellido", PApellido)
                                    .Column("emp_sapellido", SApellido)
                                    .Column("emp_puesto", Puesto)
                                    .Column("emp_estado", "activo")
                                    .Execute()
                                    .Build()
                                    .MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }

                      
        final String joinQuery = new QueryBuilder.Builder()
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
       }
       
        CargarList();
        JOptionPane.showMessageDialog(null, "se inserto en join");


    }

    public void EnableInput(boolean disable){
        Identidad.setEnabled(disable);
        PrimerNombre.setEnabled(disable);
        SegundoNombre.setEnabled(disable);
        PrimerApellido.setEnabled(disable);
        SegundoApellido.setEnabled(disable);
        PuestoCombobox.setEnabled(disable);
    }



    public  void AddListeners()
    {
        GuardarButton.addActionListener(this);
        LimpiarButton.addActionListener(this);
        NewButton.addActionListener(this);
        EditButton.addActionListener(this);
        DelButton.addActionListener(this);
        RestButton.addActionListener(this);
        EmpleadosJList.addListSelectionListener(this);
    }
   



    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        Identidad = new javax.swing.JTextField();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        DelButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();
        PrimerNombre = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        SegundoNombre = new javax.swing.JTextField();
        PrimerApellido = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        PuestoCombobox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        EmpleadosJList = new javax.swing.JList<>();
        GuardarButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        SegundoApellido = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Identidad");

        NewButton.setText("New");

        EditButton.setText("Edit");

        DelButton.setText("Del");

        RestButton.setText("Rest");

        jLabel2.setText("Primer N");

        jLabel3.setText("Segundo N");

        jLabel4.setText("P. Apellido");

        jLabel5.setText("Puesto");

        jScrollPane1.setViewportView(EmpleadosJList);

        GuardarButton.setText("Guardar");

        LimpiarButton.setText("Limpiar");

        jLabel6.setText("S. Apellido");

        final javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                                .createSequentialGroup().addGap(29, 29, 29).addGroup(layout.createParallelGroup(
                                        javax.swing.GroupLayout.Alignment.LEADING).addComponent(jScrollPane1,
                                                javax.swing.GroupLayout.PREFERRED_SIZE, 158,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(
                                                layout.createSequentialGroup().addComponent(NewButton).addPreferredGap(
                                                        javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(EditButton)
                                                        .addPreferredGap(
                                                                javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addComponent(DelButton)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup().addGap(20, 20, 20).addGroup(layout
                                                .createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(Identidad, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup().addGroup(layout
                                                                .createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.TRAILING)
                                                                .addComponent(jLabel3)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel5).addComponent(
                                                                                jLabel4)
                                                                        .addComponent(jLabel6)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                        javax.swing.GroupLayout.Alignment.LEADING,
                                                                        false).addComponent(PrimerNombre)
                                                                        .addComponent(SegundoNombre)
                                                                        .addComponent(PrimerApellido)
                                                                        .addComponent(PuestoCombobox,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                158,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(SegundoApellido))))
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jLabel2).addComponent(jLabel1))))
                                        .addGroup(layout.createSequentialGroup().addGap(18, 18, 18)
                                                .addComponent(RestButton))))
                                .addGroup(layout.createSequentialGroup().addGap(126, 126, 126)
                                        .addComponent(GuardarButton).addGap(39, 39, 39).addComponent(LimpiarButton)))
                        .addContainerGap(205, Short.MAX_VALUE)));
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
                .createSequentialGroup().addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE).addComponent(NewButton)
                        .addComponent(EditButton).addComponent(DelButton).addComponent(RestButton))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup().addGap(27, 27, 27)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 203,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                                .addGap(12, 12, 12)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel3).addComponent(SegundoNombre,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(PrimerApellido, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel6).addComponent(SegundoApellido,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(PuestoCombobox, javax.swing.GroupLayout.Alignment.TRAILING,
                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(40, 40, 40)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GuardarButton).addComponent(LimpiarButton))
                .addGap(43, 43, 43)));

        setFocusable(true);
      


        AddListeners();

        pack();

    }


   
    private javax.swing.JButton DelButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JList<String> EmpleadosJList;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JTextField Identidad;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField PrimerApellido;
    private javax.swing.JTextField PrimerNombre;
    private javax.swing.JComboBox<String> PuestoCombobox;
    private javax.swing.JButton RestButton;
    private javax.swing.JTextField SegundoApellido;
    private javax.swing.JTextField SegundoNombre;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration
}
