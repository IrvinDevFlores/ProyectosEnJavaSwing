package restApp;

import restApp.Dashboard;
import java.sql.*;
import java.awt.event.*;
public class Principal extends javax.swing.JFrame implements ActionListener {

    
    public static void main(String args[])
    {
        
        Connection con = new Conexion().getConexion();
        if(con == null){
                    
        
            final String[] data = LectorDeArchivos.ExtractConfig();

                Config config = LectorDeArchivos.GetUserConfig(data);
                
              new DbManagerForm(config).setVisible(true);
            return;
        }
        
        new Dashboard().setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
     

    }
    
  
    public Principal() {
        initComponents();
       
    }
                        
   
    private void initComponents() {

        SalariosButton = new javax.swing.JButton();
        MantenimientoEmpleadoButton = new javax.swing.JButton();
        MantenimientoDeduccionesButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        SalariosButton.setText("Salarios de empledos");

        MantenimientoEmpleadoButton.setText("Mantenimiento empleados");

        MantenimientoDeduccionesButton.setText("Mantenimiento de deducciones");


        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(MantenimientoDeduccionesButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(SalariosButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(MantenimientoEmpleadoButton, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 191, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(143, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(SalariosButton)
                .addGap(31, 31, 31)
                .addComponent(MantenimientoEmpleadoButton)
                .addGap(26, 26, 26)
                .addComponent(MantenimientoDeduccionesButton)
                .addGap(89, 89, 89))
        );
        
       
       
        
        setFocusable(true);
        MantenimientoEmpleadoButton.addActionListener(this);
        MantenimientoDeduccionesButton.addActionListener(this);
        SalariosButton.addActionListener(this);
        pack();
    }// </editor-fold>                        

    // Variables declaration - do not modify                     
    private javax.swing.JButton MantenimientoDeduccionesButton;
    private javax.swing.JButton MantenimientoEmpleadoButton;
    private javax.swing.JButton SalariosButton;
    // End of variables declaration                   

   
}
