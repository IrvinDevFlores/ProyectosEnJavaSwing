package examenbasesdedatos;

import DataLayer.Usuario;
import Servicios.InjectorToComponentService;
import Servicios.RegisterService;
import Servicios.UpdateService;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel
 */
public class AdministradorUsuarios extends javax.swing.JFrame implements ActionListener {

    InjectorToComponentService service = new InjectorToComponentService();

    public AdministradorUsuarios() throws SQLException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);

        service.FillComboBox(Edit_UserCombo);

        boxes = new JCheckBox[2];
        boxes[0] = Edit_ReiniciarCheckBox;
        boxes[1] = Edit_ActivoCheckBox;
    }

    JCheckBox boxes[];
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ContenedorDeFunciones = new javax.swing.JTabbedPane();
        CrearUsuarioPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Add_UserText = new javax.swing.JTextField();
        Add_PasswordText = new javax.swing.JPasswordField();
        GuardarButton = new javax.swing.JButton();
        EditarUsuarioPanel = new javax.swing.JPanel();
        Edit_ReiniciarCheckBox = new javax.swing.JCheckBox();
        Edit_ActivoCheckBox = new javax.swing.JCheckBox();
        jLabel3 = new javax.swing.JLabel();
        Edit_PasswordText = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        Edit_UserCombo = new javax.swing.JComboBox<>();
        ModificarButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Usuario");

        jLabel2.setText("Password");

        GuardarButton.setBackground(new java.awt.Color(0, 255, 102));
        GuardarButton.setText("Guardar");
        GuardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout CrearUsuarioPanelLayout = new javax.swing.GroupLayout(CrearUsuarioPanel);
        CrearUsuarioPanel.setLayout(CrearUsuarioPanelLayout);
        CrearUsuarioPanelLayout.setHorizontalGroup(
            CrearUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuarioPanelLayout.createSequentialGroup()
                .addGap(81, 81, 81)
                .addGroup(CrearUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(25, 25, 25)
                .addGroup(CrearUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Add_PasswordText, javax.swing.GroupLayout.DEFAULT_SIZE, 137, Short.MAX_VALUE)
                    .addComponent(Add_UserText))
                .addContainerGap(176, Short.MAX_VALUE))
        );
        CrearUsuarioPanelLayout.setVerticalGroup(
            CrearUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CrearUsuarioPanelLayout.createSequentialGroup()
                .addGap(83, 83, 83)
                .addGroup(CrearUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Add_UserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(CrearUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(Add_PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(44, 44, 44)
                .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("CREAR USUARIO", CrearUsuarioPanel);

        Edit_ReiniciarCheckBox.setText("Reiniciar");

        Edit_ActivoCheckBox.setText("Activo");

        jLabel3.setText("Password");

        jLabel4.setText("Usuario");

        Edit_UserCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
        Edit_UserCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Edit_UserComboItemStateChanged(evt);
            }
        });

        ModificarButton.setBackground(new java.awt.Color(255, 0, 51));
        ModificarButton.setForeground(new java.awt.Color(255, 255, 255));
        ModificarButton.setText("Modificar");
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout EditarUsuarioPanelLayout = new javax.swing.GroupLayout(EditarUsuarioPanel);
        EditarUsuarioPanel.setLayout(EditarUsuarioPanelLayout);
        EditarUsuarioPanelLayout.setHorizontalGroup(
            EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(EditarUsuarioPanelLayout.createSequentialGroup()
                .addGap(123, 123, 123)
                .addGroup(EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addGroup(EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ModificarButton)
                    .addGroup(EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(Edit_ActivoCheckBox)
                        .addComponent(Edit_PasswordText)
                        .addComponent(Edit_ReiniciarCheckBox)
                        .addComponent(Edit_UserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        EditarUsuarioPanelLayout.setVerticalGroup(
            EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, EditarUsuarioPanelLayout.createSequentialGroup()
                .addGap(37, 37, 37)
                .addGroup(EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(Edit_UserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(EditarUsuarioPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(Edit_PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(Edit_ReiniciarCheckBox)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Edit_ActivoCheckBox)
                .addGap(31, 31, 31)
                .addComponent(ModificarButton)
                .addContainerGap(22, Short.MAX_VALUE))
        );

        ContenedorDeFunciones.addTab("EDITAR USUARIO", EditarUsuarioPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorDeFunciones, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(ContenedorDeFunciones)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GuardarButtonActionPerformed

        Usuario usuarioEnVista = new Usuario()
        {
            {
                UserName = Add_UserText.getText();
                Pass = new String(Add_PasswordText.getPassword());
                Estado = true;
                Temp = true;
            }
        };

        try {
            RegisterService registerService = new RegisterService();
            boolean seRegistro = registerService.RegistrarSiNoExiste(usuarioEnVista);
            if (seRegistro) {
                JOptionPane.showMessageDialog(null, "Registrado correctamente");
                service.FillComboBox(Edit_UserCombo);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Dato no corrupto");
        }
    }//GEN-LAST:event_GuardarButtonActionPerformed

    private void Edit_UserComboItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_Edit_UserComboItemStateChanged
        try {
            Usuario us = new Usuario() {
                {
                    UserName = (String) Edit_UserCombo.getSelectedItem();
                }
            };

            Usuario buscado = service.FillTxtFiel(Edit_PasswordText, us);
            
            
            if (buscado == null) {
                Edit_ReiniciarCheckBox.setSelected(false);
               Edit_ActivoCheckBox.setSelected(false);
            } else {
 
               Edit_ReiniciarCheckBox.setSelected(buscado.Temp);
                Edit_ActivoCheckBox.setSelected(buscado.Estado);
            }

        } catch (SQLException | ClassNotFoundException ex) {

        }
    }//GEN-LAST:event_Edit_UserComboItemStateChanged

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ModificarButtonActionPerformed
        Usuario usuarioEnVista = new Usuario() {
            {
                UserName = (String) Edit_UserCombo.getSelectedItem();
                Pass = Edit_PasswordText.getText();

                boolean estado = Edit_ActivoCheckBox.isSelected();
                Estado = estado;
                estado = Edit_ReiniciarCheckBox.isSelected();
                Temp = estado;
            }
        };

        try {
            UpdateService updateService = new UpdateService();
            boolean seRegistro = updateService.Update(usuarioEnVista);

            if (seRegistro) {
                JOptionPane.showMessageDialog(null, "Se modifico");
                //service.FillComboBox(Edit_UserCombo);
            }

        } catch (SQLException | ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Dato no corrupto");
        }
    }//GEN-LAST:event_ModificarButtonActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdministradorUsuarios().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {

                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField Add_PasswordText;
    private javax.swing.JTextField Add_UserText;
    private javax.swing.JTabbedPane ContenedorDeFunciones;
    private javax.swing.JPanel CrearUsuarioPanel;
    private javax.swing.JCheckBox Edit_ActivoCheckBox;
    private javax.swing.JTextField Edit_PasswordText;
    private javax.swing.JCheckBox Edit_ReiniciarCheckBox;
    private javax.swing.JComboBox<String> Edit_UserCombo;
    private javax.swing.JPanel EditarUsuarioPanel;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    // End of variables declaration//GEN-END:variables

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}
