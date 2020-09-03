/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;

import restApp.IView;
import restApp.Conexion;
import restApp.Llenado;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ariel
 */
public final class MakeOrderView extends IView {

    ArrayList<JButton> categories;

    public MakeOrderView(Views name) {
        super(name);
        initComponents();

        setFormView(OrderPanel);

        getContentPane().add(OrderPanel);
        InitMoreComponents();
        AddListeners();

        String sql = "select * from menucategories";

        try {
            final Connection con = new Conexion().getConexion();
            Statement s1 = con.createStatement();

            final boolean hadResults = s1.execute(sql);
            int i = 28;
            int x = 17;
            int w = 96, h = 48;
            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    JButton b = new JButton(rs.getString("MenuCategoryName"));
                    b.setName(rs.getString("MenuCategoryId"));
                    b.setBounds(x, i, w, h);
                    b.addMouseListener(this);
                    ProductCategories.add(b);
                    i += h + 10;
                }
            }

            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }

        transacs = new ArrayList<>();
        ProducId.setVisible(false);
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {

        String query = "{call GetMenuItemByName(?)}";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(query);

            JButton j = (JButton) arg0.getComponent();
            String d = j.getName();

            //new WM().W(d);
            s1.setString(1, d);
            final boolean hadResults = s1.execute();
            DefaultListModel mod = new DefaultListModel();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();

                int x = 15, y = 24;
                int w = 96, h = 49;
                while (rs.next()) {

                    mod.addElement(rs.getString("ItemName"));
                }
            }

            con.close();

            Products.setModel(mod);

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);

        }
    }

    @Override
    public void actionPerformed(final ActionEvent evt) {

        HandleState(evt);
        HandleInputs(evt);

    }

    ArrayList<Transac> transacs;

    public void ClearTable() {
        DefaultTableModel dmodel = (DefaultTableModel) Ordenes.getModel();
        while (dmodel.getRowCount() > 0) {
            dmodel.removeRow(0);
        }
    }

    public void HandleState(ActionEvent evt) {

        if (evt.getSource() == AgregarProducto) {
            String sql = "{call GetUsersNames()}";

            ClearTable();

            Transac t = new Transac() {
                {
                    TransacId = TransId.getText();
                    Producto = Products.getSelectedValue();
                    ProductoId = Integer.parseInt(ProducId.getText());
                    Cantidad = 0;
                    PrecioUnitario = Double.parseDouble(ProductPrice.getText());
                    Descuento = 0;
                    PrecioTotal = 0;
                }
            };

            if (transacs.isEmpty()) {
                transacs.add(t);
            }

            if (transacs.size() >= 1) {

                ClearTable();
                boolean found = false;
                for (Transac trans : transacs) {

                    if (trans.ProductoId == t.ProductoId) {
                        trans.Cantidad++;
                        trans.GetTotal();
                        found = true;
                    }

                }

                if (found) {
                    ClearTable();
                    for (Transac tt : transacs) {

                        employeeModel.addRow(new String[]{
                            tt.TransacId,
                            tt.Producto,
                            tt.Cantidad + "",
                            tt.PrecioUnitario + "",
                            tt.Descuento + "",
                            tt.PrecioTotal + ""
                        });
                    }
                }else{
                    transacs.add(t);
                }
                
                
                
                double total = 0, sub = 0, tax = 0;
                for(Transac tr : transacs){
                    tr.GetTotal();
                    total += tr.PrecioTotal;
                    sub = (total)/1.15;
                    tax = total * 0.15;        
                }
                
                Total.setText("Total: "+total);
                Subtotal.setText("Subtotal: "+Math.round(sub));
                 Inpuesto.setText("Impuestos: "+Math.round(tax));
                 Cantidad.setText("Productos cantidad: "+transacs.size());
            }

        }
        /*  String crudState = GuardarButton.getText();
        
       

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
        }*/
    }

    @Override
    public void AddListeners() {
        //To change body of generated methods, choose Tools | Templates.

        Products.addListSelectionListener(this);
        Ordenes.addMouseListener(this);
        AgregarProducto.addActionListener(this);
    }

    public void HandleInputs(ActionEvent evt) {

        /*
        //crud
        if (evt.getSource() == NewButton) {

            GuardarButton.setText("Guardar");
            EnableInput(true);
            Productos.setEnabled(true);
            ProdCategories.setEnabled(true);
            EnableControl(true);
            Limpiar();

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
        }*/
    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {

        String query = "{call GetMenuItemName(?)}";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(query);

            String d = Products.getSelectedValue();

            //new WM().W(d);
            s1.setString(1, d);
            final boolean hadResults = s1.execute();
            DefaultListModel mod = new DefaultListModel();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();

                int x = 15, y = 24;
                int w = 96, h = 49;
                while (rs.next()) {

                    ProductDescrip.setText(rs.getString("ItemDescripcion"));
                    ProductPrice.setText(rs.getString("ItemPrice"));
                    ProducId.setText(rs.getString("MenuItemId"));
                }
            }

            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);

        }

    }

    @Override
    public void RestoreData() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteData() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditData() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SaveData() {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EnableInput(boolean disable) {
        //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Limpiar() {
        //To change body of generated methods, choose Tools | Templates.
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

    }

    DefaultTableModel employeeModel;
    String cols[] = {"TransId", "Producto",
        "Cantidad", "Precio Unitario", "Descuento", "PrecioTotal"};
    WM window;

    Llenado combo;

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

            Ordenes.setModel(employeeModel);

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
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
        /* Empleados.setEnabled(control1[0]);
        Emps.setEnabled(control1[0]);
        if (control1.length > 1) {
            NewButton.setEnabled(control1[1]);
            EditButton.setEnabled(control1[2]);
            DelButton.setEnabled(control1[3]);
            RestButton.setEnabled(control1[4]);
        }*/

    }

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

        Ordenes.setModel(employeeModel);

        EnableInput(false);
        EnableControl(false);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        window = new WM();
        combo = new Llenado();

        String sql = "{call GetLastTransId()}";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);

            final boolean hadResults = s1.execute();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    TransId.setText(rs.getString("TransId"));

                }
            }

            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }

    }

    public static void main(String[] args) {
        new MakeOrderView(Views.HACER_ORDEN).setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ActionButtons = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        OrderPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        Ordenes = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        Total = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Subtotal = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel4 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JLabel();
        Inpuesto = new javax.swing.JLabel();
        TransId = new javax.swing.JTextField();
        ProductCategories = new javax.swing.JPanel();
        Productos = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Products = new javax.swing.JList<>();
        jPanel5 = new javax.swing.JPanel();
        AgregarProducto = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        ProductDescrip = new javax.swing.JLabel();
        ProductPrice = new javax.swing.JTextField();
        PBtn1 = new javax.swing.JButton();
        ProducId = new javax.swing.JTextField();

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

        OrderPanel.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Orden")));

        Ordenes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Nombre item", "Price", "Cantidad", "Total", "Tax"
            }
        ));
        jScrollPane1.setViewportView(Ordenes);

        jButton2.setBackground(new java.awt.Color(51, 255, 51));
        jButton2.setText("Pagar");

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setText("Cancelar");

        Total.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        Total.setText("Total:");

        jLabel2.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        jLabel2.setText("Descuento:");

        Subtotal.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        Subtotal.setText("Subtotal:");

        jSeparator1.setBackground(new java.awt.Color(51, 0, 51));

        jLabel4.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel4.setText("Total a pagar:");

        Cantidad.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        Cantidad.setText("Cantidad de productos:");

        Inpuesto.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        Inpuesto.setText("Impuestos:");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(63, Short.MAX_VALUE)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(121, 121, 121))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Cantidad)
                            .addComponent(jLabel4)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Subtotal)
                            .addComponent(jLabel2)
                            .addComponent(Total)
                            .addComponent(Inpuesto)))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(TransId, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(TransId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Total)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Subtotal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Inpuesto)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(Cantidad)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        ProductCategories.setBackground(new java.awt.Color(255, 153, 153));
        ProductCategories.setBorder(javax.swing.BorderFactory.createTitledBorder("Categorias"));

        javax.swing.GroupLayout ProductCategoriesLayout = new javax.swing.GroupLayout(ProductCategories);
        ProductCategories.setLayout(ProductCategoriesLayout);
        ProductCategoriesLayout.setHorizontalGroup(
            ProductCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 116, Short.MAX_VALUE)
        );
        ProductCategoriesLayout.setVerticalGroup(
            ProductCategoriesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 562, Short.MAX_VALUE)
        );

        Productos.setBackground(new java.awt.Color(102, 255, 102));
        Productos.setBorder(javax.swing.BorderFactory.createTitledBorder("Productos"));

        Products.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        jScrollPane2.setViewportView(Products);

        javax.swing.GroupLayout ProductosLayout = new javax.swing.GroupLayout(Productos);
        Productos.setLayout(ProductosLayout);
        ProductosLayout.setHorizontalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 178, Short.MAX_VALUE)
                .addContainerGap())
        );
        ProductosLayout.setVerticalGroup(
            ProductosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ProductosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 204));
        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder("Detalle"));

        AgregarProducto.setText("Agregar");

        jLabel7.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel7.setText("Descripcion:");

        jLabel8.setFont(new java.awt.Font("Fira Code", 1, 14)); // NOI18N
        jLabel8.setText("Precio");

        ProductDescrip.setFont(new java.awt.Font("Fira Code", 0, 14)); // NOI18N
        ProductDescrip.setText(".");

        PBtn1.setText("Foto");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AgregarProducto))
                        .addContainerGap(76, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(ProductDescrip, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel5Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(ProducId, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(34, 34, 34))))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(PBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(75, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(ProducId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(67, 67, 67)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductDescrip)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(AgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel5Layout.createSequentialGroup()
                    .addGap(21, 21, 21)
                    .addComponent(PBtn1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(482, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout OrderPanelLayout = new javax.swing.GroupLayout(OrderPanel);
        OrderPanel.setLayout(OrderPanelLayout);
        OrderPanelLayout.setHorizontalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ProductCategories, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        OrderPanelLayout.setVerticalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(Productos, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ProductCategories, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(OrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup ActionButtons;
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JLabel Cantidad;
    private javax.swing.JLabel Inpuesto;
    private javax.swing.JTable Ordenes;
    private javax.swing.JPanel OrderPanel;
    private javax.swing.JButton PBtn1;
    private javax.swing.JTextField ProducId;
    private javax.swing.JPanel ProductCategories;
    private javax.swing.JLabel ProductDescrip;
    private javax.swing.JTextField ProductPrice;
    private javax.swing.JPanel Productos;
    private javax.swing.JList<String> Products;
    private javax.swing.JLabel Subtotal;
    private javax.swing.JLabel Total;
    private javax.swing.JTextField TransId;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration                   
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

}
