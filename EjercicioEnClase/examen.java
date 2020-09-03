import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import net.sf.jasperreports.view.JasperViewer;
import java.util.Map;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.*;
import java.util.HashMap;
import java.sql.CallableStatement;

/**
 *
 * @author Ariel
 */
public class examen extends JFrame implements ActionListener {
       public examen() {
        initComponents();
        initData();
        
        productos.addActionListener(this);
        VEN.addActionListener(this);
        InitTrans();
    }
    
    public void InitTrans(){
         String id = GetLastTrans();
        
        if(id.isEmpty()){
            TransId.setText("TRA-1");
        }else{
            String num[] = id.split("-");
            int n = Integer.parseInt(num[1]) +1;
            TransId.setText("TRA-"+n);
        }
    }
    
    public void actionPerformed(ActionEvent e){
    
        String tipoTran = VEN.getSelectedItem().toString();
         
            if (e.getSource() == productos) {
                
                if (productos.getSelectedIndex() != 0) {
                    productosId.setSelectedIndex(productos.getSelectedIndex());
                
                       SetPrice(productosId.getSelectedItem().toString());
                }
                
                 
            }
            
            if(e.getSource() == VEN){
                     String id = productosId.getSelectedItem().toString();
                    SetPrice(id);
            }
            
        
    }
    
    public void SetPrice(String id){
          double p = GetPrice(id);
  
            Precio.setText(p+"");
    }
    
    
    public double GetPrice(String pId){
         String sql = "{call GetProductById(?)}";

         double precio = 0;
                 String tipoTran = VEN.getSelectedItem().toString();
        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);
          
                s1.setInt(1,Integer.parseInt(pId));
            
            
            
            final boolean hadResults = s1.execute();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {
                   
                          
                     if(tipoTran.equals("VEN")){
                              precio = Double.parseDouble(rs.getString("precioVenta"));
                    }
                    
                    if(tipoTran.equals("COM")){
                    
                     precio = Double.parseDouble(rs.getString("precioCosto"));
                    }
                }
            }

            con.close();


        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
        
        return precio;
    }

    
    Llenado fillCombo;
    public void initData(){
        
        fillCombo = new Llenado();
        String sql  = "select * from producto";
        
        fillCombo.llenar_combo(sql, productosId, productos);
       
    }
    
    public static void main(String args[]) {
                Connection con = new Conexion().getConexion();
        if(con == null){
                    
        
            final String[] data = LectorDeArchivos.ExtractConfig();

                Config config = LectorDeArchivos.GetUserConfig(data);
                
              new DbManagerForm(config).setVisible(true);
            return;
        }
        examen ex = new examen();
        ex.setVisible(true);
    
    }

    private void ReportButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        Connection c = new Conexion().getConexion();
        
        Map parametros = new HashMap();
      
                
        int id = Integer.parseInt(productosId.getSelectedItem().toString());
              
                parametros.put("ID",id);
         try{
                    new Reporte2("reportesPrueba.jasper",parametros);
            //new Reporte2("rep_tabla_posicion.jasper",parametros);
        }
        catch(Exception exp){}
        
           
    }       
    
    public void Limpiar(){
        String s = "";
        TransId.setText(s);
        VEN.setSelectedItem(s);
        productos.setSelectedItem(s);
        Precio.setText(s);
        Cantidad.setText(s);
    }

    private void AgregarProductoActionPerformed(java.awt.event.ActionEvent evt) {                                                
        
         String id = TransId.getText();
        String tipoTran = VEN.getSelectedItem().toString();
      
        String usuario = JOptionPane.showInputDialog(null, "Ingrese su usuario");
        
        int productoId = Integer.parseInt(productosId.getSelectedItem().toString());
        int cantidad = Integer.parseInt(Cantidad.getText());
        
        
        double precio = Double.parseDouble(Precio.getText());
        
 
          double subtotal = 0;
        double total = precio * cantidad;
         String query = "{call AddTransaccion(?,?,?,?,?,?,?)}";

        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(query);


            //new WM().W(d);
            s1.setString(1, id);
              s1.setString(2, tipoTran);
              s1.setDouble(3, subtotal);
               s1.setDouble(4, total);
               s1.setString(5, usuario);
               s1.setInt(6, cantidad);
               s1.setInt(7,productoId);
            
            final boolean hadResults = s1.execute();
            if(!hadResults){
                JOptionPane.showMessageDialog(null,"se inserto");
                
                Limpiar();
                InitTrans();
                initData();
            }else{
                  JOptionPane.showMessageDialog(null,"fallo ");
            }
           
      
            con.close();

        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);

        }
    }      
    
    
    public String GetLastTrans(){
         String sql = "{call GetLastTrans()}";
         String id = "";
        try {
            final Connection con = new Conexion().getConexion();
            CallableStatement s1 = con.prepareCall(sql);

            final boolean hadResults = s1.execute();

            if (hadResults) {
                ResultSet rs = s1.getResultSet();
                while (rs.next()) {

                    id = rs.getString("transacId");
                }
            }

            con.close();


        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp.toString(), "Error al renderizar", 0);
            System.exit(0);
        }
        
        return id;
    }



    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        OrderPanel = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        ReportButton = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        TransId = new javax.swing.JTextField();
        VEN = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        productos = new javax.swing.JComboBox<>();
        productosId = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        Precio = new javax.swing.JTextField();
        AgregarProducto = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        Cantidad = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        OrderPanel.setBackground(new java.awt.Color(153, 153, 255));

        jPanel2.setBackground(new java.awt.Color(255, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder("Orden")));

        ReportButton.setBackground(new java.awt.Color(51, 255, 51));
        ReportButton.setText("Reporte");
        ReportButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportButtonActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(255, 153, 51));
        jButton1.setText("Cancelar");

        VEN.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VEN", "COM", " " }));

        jLabel1.setText("Tipo transaccion");

        jLabel2.setText("Producto");

        productos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VEN", "COM", " " }));

        productosId.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "VEN", "COM", " " }));

        jLabel3.setText("Precio");

        AgregarProducto.setText("Agregar");
        AgregarProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AgregarProductoActionPerformed(evt);
            }
        });

        jLabel4.setText("Cantidad");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(TransId)
                        .addComponent(VEN, 0, 105, Short.MAX_VALUE))
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(ReportButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(AgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 117, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(productosId, javax.swing.GroupLayout.Alignment.LEADING, 0, 134, Short.MAX_VALUE)
                                    .addComponent(productos, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(19, 19, 19)
                                .addComponent(jLabel3))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addComponent(jLabel4))
                            .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(55, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(TransId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(70, 70, 70)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(VEN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(productos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Precio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Cantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(productosId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AgregarProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47)
                .addComponent(ReportButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout OrderPanelLayout = new javax.swing.GroupLayout(OrderPanel);
        OrderPanel.setLayout(OrderPanelLayout);
        OrderPanelLayout.setHorizontalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(OrderPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(23, Short.MAX_VALUE))
        );
        OrderPanelLayout.setVerticalGroup(
            OrderPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, OrderPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(OrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(94, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(OrderPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

                                               

   


    // Variables declaration - do not modify                     
    private javax.swing.JButton AgregarProducto;
    private javax.swing.JTextField Cantidad;
    private javax.swing.JPanel OrderPanel;
    private javax.swing.JTextField Precio;
    private javax.swing.JButton ReportButton;
    private javax.swing.JTextField TransId;
    private javax.swing.JComboBox<String> VEN;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JComboBox<String> productos;
    private javax.swing.JComboBox<String> productosId;
    // End of variables declaration                   
}
