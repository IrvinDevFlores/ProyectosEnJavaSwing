package Persistence;

public class DbManagerForm extends javax.swing.JFrame {

 
    public DbManagerForm(Config config) {
    
         initComponents();
        UbicacionText.setText(config.DbLocation);
        DbNameText.setText(config.DbName);
        UsuarioText.setText(config.Usuario);
        PassText.setText(config.Pass); 
    }
                          
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        UbicacionText = new javax.swing.JTextField();
        DbNameText = new javax.swing.JTextField();
        UsuarioText = new javax.swing.JTextField();
        PassText = new javax.swing.JPasswordField();
        GuardarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Ubicacion: ");

        jLabel2.setText("Nombre DB:");

        jLabel3.setText("Usuario:");

        jLabel4.setText("Pass:");

        GuardarButton.setText("Guardar");
        GuardarButton.addActionListener(this::GuardarButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(60, 60, 60)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(UsuarioText, javax.swing.GroupLayout.DEFAULT_SIZE, 193, Short.MAX_VALUE)
                            .addComponent(DbNameText)
                            .addComponent(UbicacionText)
                            .addComponent(PassText)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(154, 154, 154)
                        .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(UbicacionText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(DbNameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(UsuarioText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(PassText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 45, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(18, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt)  {                                              
        

        Config config = new Config(){
          {
                DbLocation = UbicacionText.getText()+";";
                DbName =  DbNameText.getText()+";";
                Usuario = UsuarioText.getText()+";";
                Pass = PassText.getText()+";";
          }  
        };
  
        LectorDeArchivos.RemplaceLine(config);
        
    }                                             


    // Variables declaration - do not modify                     
    private javax.swing.JTextField DbNameText;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JPasswordField PassText;
    private javax.swing.JTextField UbicacionText;
    private javax.swing.JTextField UsuarioText;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration                   
}
