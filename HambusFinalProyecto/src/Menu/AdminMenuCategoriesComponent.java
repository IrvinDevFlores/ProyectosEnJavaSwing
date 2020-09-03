/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

import AppTools.Interfaces.IComponent;
import FormTools.Views;
import FormTools.WM;
import Persistence.Conexion;
import Persistence.Llenado;
import Persistence.QueryBuilder;
import Persistence.SqlCommandWritter;
import java.sql.CallableStatement;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel
 */
public final class AdminMenuCategoriesComponent extends IComponent{
    
    
    public AdminMenuCategoriesComponent(String viewName)
    {
        super(viewName);
        initComponents();
        setFormView(CategoriasMenuPanel);
        InitMoreComponents();
        RenderActives();

        AddListeners();
        
    }

    
    
     DefaultTableModel employeeModel;
    String cols[] = {"Id", "Empleado"};
    WM window;

    Llenado combo;

    @Override
    public void InitMoreComponents() {
        
        EnableInput(false);
        EnableControl(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        window = new WM();
        combo = new Llenado();


    }

   
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
       /* Emps.setEnabled(control1[0]);*/
        if (control1.length > 1) {
            NewButton.setEnabled(control1[1]);
            EditButton.setEnabled(control1[2]);
            DelButton.setEnabled(control1[3]);
            RestButton.setEnabled(control1[4]);
        }

    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
   
     
        String query = "{call GetProductCategoryByName(?)}";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(query);
            s1.setString(1, Empleados.getSelectedValue());
            final boolean hadResults = s1.execute();
            DefaultListModel mod = new DefaultListModel();
            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {
                   
                     
                   Id.setText(rs.getString("MenuCategoryId"));
                      NombreCat.setText(rs.getString("MenuCategoryName"));
                         Version.setText("Menu version: "+rs.getString("MenuVersion"));
                }
            }

            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
           
        }

    }

    @Override
    public void Limpiar() {
        final String empty = "";

        Id.setText(empty);
        NombreCat.setText(empty);

       
    }

    @Override
    public void actionPerformed(final ActionEvent evt) {

        HandleState(evt);
        HandleInputs(evt);

    }

    @Override
    public void RestoreData() {
      
        CategoriaProducto empleado = GetUser();
        
     final String query = new QueryBuilder.Builder()
                .UpdateTable("menucategories")
                .Set("Estado", "activo")
                .WhereMatchString("MenuCategoryId", empleado.catId)
                .Build()
                .MakeQuery();

        final boolean deleteFailed = !SqlCommandWritter.WriteCommand(query);
        if (deleteFailed) {
            JOptionPane.showMessageDialog(null, "fallo al restaurar");
            return;
        }
        RenderActives();
        JOptionPane.showMessageDialog(null, "se restauro");
    }

    @Override
    public void DeleteData() {
     
        CategoriaProducto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("menucategories")
                .Set("Estado", "inactivo")
                .WhereMatchString("MenuCategoryId", empleado.catId)
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

        
        String id = GetUser().catId;

        CategoriaProducto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                    
                  .UpdateTable("menucategories")
                .Set("MenuCategoryId", empleado.catId)
                .Set("MenuCategoryName", empleado.nombreCat)
     
                .WhereMatchString("MenuCategoryId", empleado.catId)
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

        String id = GetUser().catId;

        CategoriaProducto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .Insert("menucategories")
                .Column("MenuCategoryId", empleado.catId)
                .Column("MenuCategoryName", empleado.nombreCat)
                .Column("RestaurantMenuId", 1)
                .Column("Estado", "activo")
                .Execute()
                .Build()
                .MakeQuery();

        final boolean insertFailed = !SqlCommandWritter.WriteCommand(query);
        if (insertFailed) {
            window.W("no se pudo guardar");
        }

        
        RenderActives();
        window.W("usuario guardado");

    }

    @Override
    public void EnableInput(boolean disable) {
        Id.setEnabled(disable);
        NombreCat.setEnabled(disable);
       
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
    }

    public CategoriaProducto GetUser() {

        CategoriaProducto empleado = new CategoriaProducto() {
            {

                catId = Id.getText();
                nombreCat = NombreCat.getText();
      
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

            GuardarButton.setText("Guardar");
            EnableInput(true);
            Empleados.setEnabled(true);

            EnableInput(true);
            Limpiar();

        } else {
            Limpiar();
            Empleados.setEnabled(true);
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

        final String sql = "select * from productcategoriesview";

        RenderEmpleados(sql, "activo");

    }

    @Override
    public void RenderInactives() {
        final String sql = "select * from inactivesproductsview";

        RenderEmpleados(sql, "inactivo");
    }

    public void RenderEmpleados(String sql, String mode) {

        final DefaultListModel model = new DefaultListModel<>();

        String identityKey = "";

        try {
            final Connection con = new Conexion().getConexion();
            Statement s1 = con.createStatement();
       
            final boolean hadResults = s1.execute(sql);

            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    model.addElement(rs.getString("MenuCategoryName"));

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
        new AdminMenuCategoriesComponent("").setVisible(true);
    }


    @Override
    public void mouseClicked(MouseEvent evt) {
        
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
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CategoriasMenuPanel = new javax.swing.JPanel();
        NombreCat = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        Id = new javax.swing.JTextField();
        jPanel9 = new javax.swing.JPanel();
        DelButton = new javax.swing.JButton();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        GuardarButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        Empleados = new javax.swing.JList<>();
        jLabel22 = new javax.swing.JLabel();
        Version = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        CategoriasMenuPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias de menu"));

        jLabel24.setText("Nombre categoria");

        jLabel21.setText("CategoriaId");

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
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DelButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EditButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(RestButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        LimpiarButton.setText("Limpiar");

        GuardarButton.setText("Guardar");

        jScrollPane1.setViewportView(Empleados);

        jLabel22.setText("Categoria");

        Version.setText("Version: ");

        javax.swing.GroupLayout CategoriasMenuPanelLayout = new javax.swing.GroupLayout(CategoriasMenuPanel);
        CategoriasMenuPanel.setLayout(CategoriasMenuPanelLayout);
        CategoriasMenuPanelLayout.setHorizontalGroup(
            CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                        .addGap(338, 338, 338)
                        .addComponent(Version))
                    .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel22))
                                .addGap(18, 18, 18)
                                .addComponent(GuardarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel21))
                                .addGap(70, 70, 70)
                                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel24)
                                    .addComponent(NombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        CategoriasMenuPanelLayout.setVerticalGroup(
            CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                .addComponent(Version)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel9, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(jLabel21))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NombreCat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(CategoriasMenuPanelLayout.createSequentialGroup()
                        .addComponent(jLabel22)
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(CategoriasMenuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(CategoriasMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(CategoriasMenuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

  
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel CategoriasMenuPanel;
    private javax.swing.JButton DelButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JList<String> Empleados;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JTextField Id;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JTextField NombreCat;
    private javax.swing.JButton RestButton;
    private javax.swing.JLabel Version;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
