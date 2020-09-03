import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*;
public class Form extends JFrame implements ActionListener {

    /**
     * Creates new form Form
     */
    public Form() {
        initComponents();
        GuardarButton.addActionListener(this);
        
        LimpiarButton.addActionListener(this);
        
        NuevoButton.addActionListener(this);
        
        ModificarButton.addActionListener(this);
        
        ProvedoresCombox.addActionListener(this);
       
    }
    
    
    public void SaveData(){
        
        String nombre = NombreText.getText();
        
        String direccion = DireccionText.getText();
        
        String telefono = TelefonoText.getText();
        
        String web = PaginaWebText.getText();
        
        SqlCommandWritter cmd = new SqlCommandWritter();
        
        
        String sql = String.format("insert into provedores(NombreProveedor,DireccionProveedor,TelefonoProveedor,PaginaWebProveedor,Estado) "    
                        + " values('%s','%s','%s','%s', 'Activo')",nombre, direccion, telefono, web);
        cmd.WriteCommand(sql);
    }
    
    
    public void Modificar(){
 
        int id = Integer.parseInt(IdProvedoresCombox.getSelectedItem().toString());
        
        String sql =String.format( "select NombreProveedor, DireccionProveedor, TelefonoProveedor, PaginaWebProveedor from provedores where CodigoProveedor = %d",
                                    id);
        try
        {
            Connection con=new Conexion().getConexion();
            Statement s1=con.createStatement();
            ResultSet rs=s1.executeQuery(sql);
            while(rs.next())
            {
                NombreText.setText(rs.getString(1));
                DireccionText.setText(rs.getString(2));
                 TelefonoText.setText(rs.getString(3));
                 PaginaWebText.setText(rs.getString(4));
            }
            con.close();
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null,""+exp,"Error Llenando ComboBox",0);System.exit(0);
        }
        
    }
    
    public void ActualizarData(){
           
        String nombre = NombreText.getText();
        
        String direccion = DireccionText.getText();
        
        String telefono = TelefonoText.getText();
        
        String web = PaginaWebText.getText();
        
        int id = 0;
        if(IdProvedoresCombox.getItemCount() != 0){
            id = Integer.parseInt(IdProvedoresCombox.getSelectedItem().toString());
        }
        SqlCommandWritter cmd = new SqlCommandWritter();
           
        String sql = String.format("update provedores set  NombreProveedor = '%s', DireccionProveedor = '%s', TelefonoProveedor = '%s', PaginaWebProveedor = '%s', Estado = 'Activo' where CodigoProveedor = %d",nombre, direccion, telefono, 
        web, id);
        cmd.WriteCommand(sql);
        
    }
    
  
    public void Limpiar(){
        
    
        NombreText.setText("");
        
        DireccionText.setText("");
        
        TelefonoText.setText("");
        
        PaginaWebText.setText("");
        
        
 
        IdProvedoresCombox.setSelectedIndex(0);
        ProvedoresCombox.setSelectedIndex(0);
    }
    
    
    public boolean CleanCombobox(){
        return IdProvedoresCombox != null && ProvedoresCombox != null ;
    }
    
    
    public void actionPerformed(ActionEvent evt){
        
        /*
          JComboBox comboBox = (JComboBox)evt.getSource();
        ComboBoxEntity item = (Proveedor)comboBox.getSelectedItem();
        System.out.println( item.GetItemId() + " : " + item.GetItemName() );
    */
        
         if(CleanCombobox() != false){
                 
          if(evt.getSource() == ProvedoresCombox){
              if(ProvedoresCombox.getSelectedIndex() != 0){
                IdProvedoresCombox.setSelectedIndex(ProvedoresCombox.getSelectedIndex());
                   
                Modificar();
                     
                }
        }
            }

          if(evt.getSource() == LimpiarButton){
              ClearCombobox();
              Limpiar();
        }
        
             
           if(evt.getSource() == ModificarButton){
                  
              String query = "select CodigoProveedor,NombreProveedor from provedores order by NombreProveedor";
               GuardarButton.setText("Modificar");
               new Llenado().llenar_combo(query,  ProvedoresCombox, IdProvedoresCombox);
          
        }
        
        if(evt.getSource() == NuevoButton){
            ClearCombobox();
            Limpiar();
            GuardarButton.setText("Guardar");
          
        }
        
        if(evt.getSource() == GuardarButton){
           if(GuardarButton.getText().equals("Guardar")){
               SaveData();
                   JOptionPane.showMessageDialog(null,"Data guardada");
                 
               
                 Limpiar();
                   ClearCombobox();
            }
            
            if(GuardarButton.getText().equals("Modificar")){
                 ActualizarData();
                   JOptionPane.showMessageDialog(null,"Data actualizada");
                   GuardarButton.setText("Guardar");
                   
               
                Limpiar();
                    ClearCombobox();
            }
        
        }
        
        
   
    }
    
   public void ClearCombobox(){
       
       IdProvedoresCombox.removeAllItems();
            ProvedoresCombox.removeAllItems();
            
       IdProvedoresCombox.addItem("");
            ProvedoresCombox.addItem("");
    }
    

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        NuevoButton = new javax.swing.JButton();
        DeshabilitarButton = new javax.swing.JButton();
        ModificarButton = new javax.swing.JButton();
        HabilitarButton = new javax.swing.JButton();
        NombreText = new javax.swing.JTextField();
        DireccionText = new javax.swing.JTextField();
        TelefonoText = new javax.swing.JTextField();
        PaginaWebText = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        GuardarButton = new javax.swing.JButton();
        LimpiarButton = new javax.swing.JButton();
      
        ProvedoresCombox =  new javax.swing.JComboBox();
        
        IdProvedoresCombox = new javax.swing.JComboBox<>();
  
      
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NuevoButton.setText("Nuevo");
        GuardarButton.setText("Guardar");

        DeshabilitarButton.setText("Dehabilitar");

        ModificarButton.setText("Modificar");

        HabilitarButton.setText("Habilitar");



        jLabel1.setText("Nombre");

        jLabel2.setText("Telefono");

        jLabel3.setText("Pagina Web");

        jLabel4.setText("Direccion");


        LimpiarButton.setText("Limpiar");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(NuevoButton)
                                .addGap(25, 25, 25)
                                .addComponent(ModificarButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(1, 1, 1)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ProvedoresCombox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(IdProvedoresCombox, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(36, 36, 36)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(DeshabilitarButton)
                            .addComponent(jLabel4)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(GuardarButton)
                        .addGap(21, 21, 21)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(HabilitarButton)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(172, 172, 172)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(LimpiarButton)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NombreText)
                                    .addComponent(TelefonoText)
                                    .addComponent(PaginaWebText)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(DireccionText, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE)))
                                .addGap(35, 35, 35))))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NuevoButton)
                            .addComponent(DeshabilitarButton)
                            .addComponent(ModificarButton)
                            .addComponent(HabilitarButton))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(NombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ProvedoresCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(DireccionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(TelefonoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(IdProvedoresCombox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(PaginaWebText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton)
                    .addComponent(LimpiarButton))
                .addContainerGap(104, Short.MAX_VALUE))
        );
        
        setFocusable(true);
       

        pack();
    }// </editor-fold>                        

                                             


    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Form().setVisible(true) ;
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton DeshabilitarButton;
    private javax.swing.JTextField DireccionText;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JButton HabilitarButton;
    private javax.swing.JComboBox<String> IdProvedoresCombox;
    private javax.swing.JButton LimpiarButton;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JTextField NombreText;
    private javax.swing.JButton NuevoButton;
    private javax.swing.JTextField PaginaWebText;
    private javax.swing.JComboBox<String> ProvedoresCombox;
    private javax.swing.JTextField TelefonoText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
}
