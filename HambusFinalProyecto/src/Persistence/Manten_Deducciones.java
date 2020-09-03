package Persistence;


import  javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class Manten_Deducciones extends javax.swing.JFrame implements ActionListener, 
    ListSelectionListener  {

public Manten_Deducciones() 
{
    initComponents();
    setVisible(true);
    SetDefault();
    CargarList();
    EnableControl(false);
}


public void valueChanged(ListSelectionEvent e) 
{ 
    //set the text of the label to the selected value of lists 
    String data = DeduccionesJList.getSelectedValue();

    final String sql = new QueryBuilder
                        .Builder()
                        .Select()
                            .WithColumn("ded_codigo")
                            .WithColumn("ded_nombre")
                            .From("tbl_deduccion")
                            .WhereMatchString("ded_nombre",data )
                        .Build().MakeQuery();

    try {
        final Connection con = new Conexion().getConexion();
        final Statement s1 = con.createStatement();
        final ResultSet rs = s1.executeQuery(sql);
        while (rs.next()) {
 
            identityKey = rs.getString("ded_codigo");
        }
        con.close();
    } catch (final SQLException exp) {
        JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
        System.exit(0);
    }


    String query = new QueryBuilder.Builder()
                         .Select()
                            .WithColumn("ded_codigo")
                             .WithColumn("ded_nombre")
                             .WithColumn("ded_descripcion")
                             .WithColumn("ded_forma")
                                .From("tbl_deduccion")
                                  .WhereMatchString("ded_codigo", identityKey)
                                  .Build()
                                  .MakeQuery();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(query);
            while (rs.next()) 
            {
                NombreDeduccion.setText(rs.getString("ded_nombre"));
               
                FormaDeduccionCombobox.setSelectedItem(rs.getString("ded_forma"));
                DescripcionDeduccion.setText(rs.getString("ded_descripcion"));
        
            }
            con.close();

            
        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
            System.exit(0);
        }
      
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
                        
        GuardarButton.setText("Editar");
    }
    if (evt.getSource() == DelButton) {
        CargarList();
        EnableInput(false);
        EnableControl(true);
        GuardarButton.setText("Eliminar");
    }

    if (evt.getSource() == RestButton) {
        Limpiar();
        RenderInactives();
        EnableInput(false);
        EnableControl(true);
        GuardarButton.setText("Restaurar");
    }

   
}


public void EnableControl(boolean... control1)
{
    DeduccionesJList.setEnabled(control1[0]);
   if(control1.length > 1)
   {
     NewButton.setEnabled(control1[1]);
    EditButton.setEnabled(control1[2]);
    DelButton.setEnabled(control1[3]);
    RestButton.setEnabled(control1[4]);
    }

}


public void SetDefault() {
    FormaDeduccionCombobox.addItem("");
    FormaDeduccionCombobox.addItem("MON");
    FormaDeduccionCombobox.addItem("POR");
    
}


private static String identityKey ="";
public void CargarList()
{

    final String sql = new QueryBuilder
                        .Builder()
                        .Select()
                            .WithColumn("ded_codigo")
                            .WithColumn("ded_nombre")
                            .WithColumn("ded_estado")
                            .From("tbl_deduccion")
                        .Build().MakeQuery();

    LlenarListaDeducciones(sql,"activo");

    
}

public void RenderInactives(){
    final String sql = new QueryBuilder
            .Builder()
            .Select()
            .WithColumn("ded_codigo")
            .WithColumn("ded_nombre")
            .WithColumn("ded_estado")
                .From("tbl_deduccion")
            .Build().MakeQuery();

    LlenarListaDeducciones(sql,"inactivo");
}

public void LlenarListaDeducciones(String sql, String mode){

    
    final DefaultListModel model = new DefaultListModel<>();

    try {
        try (Connection con = new Conexion().getConexion()) {
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next())
            {
                if(rs.getString("ded_estado").equals(mode))
                {
                    model.addElement(rs.getString("ded_nombre"));
                    identityKey = rs.getString("ded_codigo")+"";
                    
                }else{}
                
                
            }
        }

        DeduccionesJList.setModel(model);

    } catch (final SQLException exp) {
        JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
        System.exit(0);
    }
}

public void Limpiar() {
    final String empty = "";

    NombreDeduccion.setText(empty);
    FormaDeduccionCombobox.setSelectedItem("");
    DescripcionDeduccion.setText(empty);

  
}


public void RestoreData(){
  

    final String query = new QueryBuilder.Builder()
                        .UpdateTable("tbl_deduccion")
                                .Set("ded_estado", "activo")
                                .WhereMatchInt("ded_codigo", Integer.parseInt(identityKey) )
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


    final String query = new QueryBuilder.Builder()
                        .UpdateTable("tbl_deduccion")
                                .Set("ded_estado", "inactivo")
                                .WhereMatchInt("ded_codigo", Integer.parseInt(identityKey) )
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
    
    final String PNombre = NombreDeduccion.getText();
    final String SNombre = DescripcionDeduccion.getText();
    final String Puesto = FormaDeduccionCombobox.getSelectedItem().toString();

    final String query = new QueryBuilder.Builder()
                        .UpdateTable("tbl_deduccion")
                                .Set("ded_nombre", PNombre)
                                .Set("ded_descripcion", SNombre)
                                .Set("ded_forma", Puesto)
                                .WhereMatchInt("ded_codigo", Integer.parseInt(identityKey) )
                                .Build()
                                .MakeQuery();

    final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
    if (insertFailed) {
        JOptionPane.showMessageDialog(null, "fallo al editar");
        return;
    }
    CargarList();
    JOptionPane.showMessageDialog(null, "se edito");
}

public void SaveData() {

    final String PNombre = NombreDeduccion.getText();
    final String SNombre = DescripcionDeduccion.getText();
    final String Puesto = FormaDeduccionCombobox.getSelectedItem().toString();

    final String query = new QueryBuilder.Builder()
                        .Insert("tbl_deduccion")
                                .Column("ded_nombre", PNombre)
                                .Column("ded_descripcion", SNombre)
                                .Column("ded_forma", Puesto)
                                .Column("ded_estado", "activo")
                                .Execute()
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

public void EnableInput(boolean disable){
    NombreDeduccion.setEnabled(disable);
    DescripcionDeduccion.setEnabled(disable);
    FormaDeduccionCombobox.setEnabled(disable);

}



public  void AddListeners()
{
    GuardarButton.addActionListener(this);
    LimpiarButton.addActionListener(this);
    NewButton.addActionListener(this);
    EditButton.addActionListener(this);
    DelButton.addActionListener(this);
    RestButton.addActionListener(this);
    DeduccionesJList.addListSelectionListener(this);
}
                     
private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        FormaDeduccionCombobox = new javax.swing.JComboBox<>();
        NombreDeduccion = new javax.swing.JTextField();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        GuardarButton = new javax.swing.JButton();
        DelButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        DescripcionDeduccion = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        DeduccionesJList = new javax.swing.JList<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Nombre");

        NewButton.setText("New");

        EditButton.setText("Edit");

        GuardarButton.setText("Guardar");

        DelButton.setText("Del");

        LimpiarButton.setText("Limpiar");

        RestButton.setText("Rest");

        jLabel3.setText("Desemp");

        jLabel2.setText("Forma");

        jScrollPane1.setViewportView(DeduccionesJList);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(NewButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(EditButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(DelButton)
                        .addGap(18, 18, 18)
                        .addComponent(RestButton))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(NombreDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(31, 31, 31))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel2)
                                        .addGap(42, 42, 42)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(DescripcionDeduccion, javax.swing.GroupLayout.DEFAULT_SIZE, 161, Short.MAX_VALUE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(FormaDeduccionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(146, 146, 146)
                        .addComponent(GuardarButton)
                        .addGap(34, 34, 34)
                        .addComponent(LimpiarButton)))
                .addContainerGap(96, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewButton)
                    .addComponent(EditButton)
                    .addComponent(DelButton)
                    .addComponent(RestButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(NombreDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(FormaDeduccionCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(13, 13, 13)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(DescripcionDeduccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(25, 25, 25)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton)
                    .addComponent(LimpiarButton))
                .addGap(19, 19, 19))
        );


        AddListeners();
        pack();
    }                     


    // Variables declaration - do not modify                     
    private javax.swing.JList<String> DeduccionesJList;
    private javax.swing.JButton DelButton;
    private javax.swing.JTextField DescripcionDeduccion;
    private javax.swing.JButton EditButton;
    private javax.swing.JComboBox<String> FormaDeduccionCombobox;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField NombreDeduccion;
    private javax.swing.JButton RestButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration                   
}
