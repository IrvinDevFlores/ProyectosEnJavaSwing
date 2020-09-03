/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;

import restApp.IComponent;
import restApp.Conexion;
import restApp.Llenado;
import restApp.QueryBuilder;
import restApp.SqlCommandWritter;
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
public final class AdminProductsComponent extends IComponent {

    public AdminProductsComponent(String name) {
        super(name);
        initComponents();

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
        setFormView(ProductosPanel);
        EnableInput(false);
        EnableControl(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        window = new WM();
        combo = new Llenado();

        LlenarCombo();

    }
    
    public void LlenarCombo(){
        
           combo.llenar_combo("select MenuCategoryId, MenuCategoryName from menucategories",
                ProdCategoriesId, ProdCategories);
        
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
            s1.setString(1, Productos.getSelectedValue());
            final boolean hadResults = s1.execute();
            DefaultListModel mod = new DefaultListModel();
            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    ProdNom.setText(rs.getString("MenuCategoryId"));
                    ProdDescrip.setText(rs.getString("MenuCategoryName"));
                    ProdPrice.setText("Menu version: " + rs.getString("MenuVersion"));

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

        ProdNom.setText(empty);
        ProdDescrip.setText(empty);

        ProdPrice.setText(empty);

    }

    
    @Override
    public void RestoreData() {

        Producto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("menuproducts")
                .Set("Estado", "activo")
                .WhereMatchInt("MenuItemId", empleado.ProductoId)
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

        Producto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("menuproducts")
                .Set("Estado", "inactivo")
                .WhereMatchInt("MenuItemId", empleado.ProductoId)
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

        int id = GetUser().ProductoId;

        Producto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .UpdateTable("menuproducts")
                .Set("MenuItemId", empleado.ProductoId)
                .Set("ItemName", empleado.Name)
                .WhereMatchInt("MenuItemId", empleado.ProductoId)
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

    
        public Producto GetUser() {

        Producto empleado = new Producto() {
            {

                Name = ProdNom.getText();
                Descripcion = ProdDescrip.getText();
                Price = Double.parseDouble(ProdPrice.getText());
                MenuCategoryId = ProdCategoriesId.getSelectedItem().toString();

            }
        };

        return empleado;
    }

    @Override
    public void SaveData() {

        Producto empleado = GetUser();

        final String query = new QueryBuilder.Builder()
                .Insert("menuproducts")
                .Column("MenuItemId", empleado.ProductoId)
                .Column("ItemName", empleado.Name)
                .Column("ItemDescripcion", empleado.Descripcion)
                         .Column("ItemPrice", empleado.Price)
                .Column("MenuCategoryId", empleado.MenuCategoryId)
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
        ProdNom.setEnabled(disable);
        ProdDescrip.setEnabled(disable);
        ProdPrice.setEnabled(disable);
        ProdCategories.setEnabled(disable);
    }

    @Override
    public void AddListeners() {
        GuardarButton.addActionListener(this);
        LimpiarButton.addActionListener(this);
        NewButton.addActionListener(this);
        EditButton.addActionListener(this);
        DelButton.addActionListener(this);
        RestButton.addActionListener(this);
        Productos.addListSelectionListener(this);
        ProdCategories.addActionListener(this);
    }

@Override
    public void actionPerformed(final ActionEvent evt) {

        HandleState(evt);
        HandleInputs(evt);

    }

    public void HandleState(ActionEvent evt) {
        String crudState = GuardarButton.getText();
        
       

            if (evt.getSource() == ProdCategories) {
                if (ProdCategories.getSelectedIndex() != 0) {
                    ProdCategoriesId.setSelectedIndex(ProdCategories.getSelectedIndex());


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
            EnableInput(true);
            Productos.setEnabled(true);
            ProdCategories.setEnabled(true);
            EnableControl(true);
            Limpiar();
            LlenarCombo();

        } else {
            Limpiar();
            Productos.setEnabled(true);
          
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

        final String sql = "select * from activeproducts";

        RenderEmpleados(sql, "activo");

    }

    @Override
    public void RenderInactives() {
        final String sql = "select * from inactiveproducts";

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

                    model.addElement(rs.getString("ItemName"));

                }
            }

            con.close();

            Productos.setModel(model);

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
    }

    public static void main(String... args) {
        new AdminProductsComponent("").setVisible(true);
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ProductosPanel = new javax.swing.JPanel();
        jLabel36 = new javax.swing.JLabel();
        ProdNom = new javax.swing.JTextField();
        ProdPrice = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        ProdDescrip = new javax.swing.JTextField();
        jLabel37 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        GuardarButton = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        Productos = new javax.swing.JList<>();
        jPanel10 = new javax.swing.JPanel();
        DelButton = new javax.swing.JButton();
        NewButton = new javax.swing.JButton();
        EditButton = new javax.swing.JButton();
        RestButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
        ProdCategories = new javax.swing.JComboBox<>();
        jLabel40 = new javax.swing.JLabel();
        ProdCategoriesId = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        ProductosPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        jLabel36.setText("Nombre producto");

        jLabel34.setText("Precio");

        jLabel37.setText("Descripcion");

        jLabel39.setText("Productos");

        GuardarButton.setText("Guardar");

        jScrollPane3.setViewportView(Productos);

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
                .addContainerGap(64, Short.MAX_VALUE))
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

        LimpiarButton.setText("Limpiar");

        jLabel40.setText("Categoria");

        javax.swing.GroupLayout ProductosPanelLayout = new javax.swing.GroupLayout(ProductosPanel);
        ProductosPanel.setLayout(ProductosPanelLayout);
        ProductosPanelLayout.setHorizontalGroup(
            ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosPanelLayout.createSequentialGroup()
                .addGap(24, 24, 24)
                .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosPanelLayout.createSequentialGroup()
                        .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ProdNom, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)
                            .addComponent(ProdCategories, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel40)
                            .addComponent(ProdCategoriesId, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(ProductosPanelLayout.createSequentialGroup()
                                .addComponent(ProdDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ProdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jLabel37)
                            .addGroup(ProductosPanelLayout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(GuardarButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(LimpiarButton))
                            .addComponent(jLabel39)))
                    .addGroup(ProductosPanelLayout.createSequentialGroup()
                        .addGap(316, 316, 316)
                        .addComponent(jLabel34))
                    .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
        );
        ProductosPanelLayout.setVerticalGroup(
            ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ProductosPanelLayout.createSequentialGroup()
                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(jLabel34)
                    .addComponent(jLabel37))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ProdNom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProdDescrip, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ProdPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel39)
                    .addComponent(jLabel40))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(ProductosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LimpiarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ProductosPanelLayout.createSequentialGroup()
                        .addComponent(ProdCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ProdCategoriesId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(ProductosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(ProductosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.JButton DelButton;
    private javax.swing.JButton EditButton;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton NewButton;
    private javax.swing.JComboBox<String> ProdCategories;
    private javax.swing.JComboBox<String> ProdCategoriesId;
    private javax.swing.JTextField ProdDescrip;
    private javax.swing.JTextField ProdNom;
    private javax.swing.JTextField ProdPrice;
    private javax.swing.JList<String> Productos;
    private javax.swing.JPanel ProductosPanel;
    private javax.swing.JButton RestButton;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JScrollPane jScrollPane3;
    // End of variables declaration                   

}
