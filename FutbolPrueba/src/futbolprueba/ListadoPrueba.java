/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbolprueba;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author Ariel
 */
public class ListadoPrueba extends javax.swing.JFrame {

    private JTextArea ResultadoTextArea;
    private JScrollPane ResultadoScrollBar;

    public void AddTextArea() {
        ResultadoTextArea = new JTextArea("", 60, 50);
        ResultadoTextArea.setLineWrap(true);
        ResultadoScrollBar = new JScrollPane(ResultadoTextArea);
        ResultadoScrollBar.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ResultadoScrollBar.setBounds(50, 180, 400, 200);
        this.add(ResultadoScrollBar);
    }

    public ListadoPrueba() {
        initComponents();
        partidosTorneo = new ArrayList<>();
        ExtraerClausuraEnArreglo();
        AddTextArea();
    }
    Archivo archivoClausura;
    String rutaClausura = "src/futbolprueba/Clausura.txt";

    public void ExtraerClausuraEnArreglo() {
        archivoClausura = new Archivo(rutaClausura);
        String[] filas = archivoClausura.ToString().split("\n");
        for (int i = 1; i < filas.length; i++) 
        {

            String props[] = filas[i].split(";");
            ResultadoJornada resultadoEquipo = new ResultadoJornada();
            
                ResultadoEquipo resultEquipo1 = new ResultadoEquipo() 
                    {
                        {
                            CodigoEquipo = props[1];
                            Goles = Integer.parseInt(props[2]);
                        }
                    };
                    
                    resultadoEquipo.resultadosPorDia.add(resultEquipo1);
                    
                     ResultadoEquipo resultEquipo2 =   new ResultadoEquipo() 
                    {
                        {
                            CodigoEquipo = props[3];
                            Goles = Integer.parseInt(props[4]);
                        }
                    };
                     
                      resultadoEquipo.resultadosPorDia.add(resultEquipo2);
                      
                    clausura.ClausuraId = Integer.parseInt(props[0]);
                    clausura.Resultados.add(resultadoEquipo);
                    partidosTorneo.add(clausura);

        }
        
      

    }
    Clausura clausura = new Clausura();
    ArrayList<Clausura> partidosTorneo;

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        GenerarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        ListadoComboBox = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        GenerarButton.setText("Generar");
        GenerarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GenerarButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Listados");

        ListadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "","Tabla posiciones clausura", "Tabla posiciones del descenso", "Equipo con mejor gol" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(79, 79, 79)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(89, 89, 89)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(GenerarButton)
                    .addComponent(ListadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(206, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(57, 57, 57)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ListadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(GenerarButton)
                .addContainerGap(316, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    ArrayList<Equipo> tablaPosiciones;
    public void OrdenarPuntosAcendente()
    {
        tablaPosiciones = new ArrayList<>();
         String s = "";
         int counter = 0;
         for (var i : partidosTorneo){
             s +=  i.Resultados.get(0).resultadosPorDia.get(0).Goles;
             counter++;
         }
         ResultadoTextArea.setText("Tiene que ser 90 = " + counter);
    }
    
   
    private void GenerarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GenerarButtonActionPerformed
        if(ListadoComboBox.getSelectedIndex() != 1){
                  OrdenarPuntosAcendente();
        }
        
        else  if(ListadoComboBox.getSelectedIndex() != 2){
            OrdenarPuntosAcendente();
 
        }
        
        else if(ListadoComboBox.getSelectedIndex() != 3){
            OrdenarPuntosAcendente();
           
        }else{
            
        }
    }//GEN-LAST:event_GenerarButtonActionPerformed

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(ListadoPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ListadoPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ListadoPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ListadoPrueba.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ListadoPrueba().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton GenerarButton;
    private javax.swing.JComboBox<String> ListadoComboBox;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
