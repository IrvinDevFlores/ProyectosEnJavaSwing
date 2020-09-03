
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
public class AdministradorEmpleados extends javax.swing.JFrame implements ActionListener {

    InjectorDatosService injectorService = new InjectorDatosService();

    public AdministradorEmpleados() throws SQLException, ClassNotFoundException {
        initComponents();
        setLocationRelativeTo(null);

        injectorService.FillComboBox(Edit_UserCombo);

        HabilitarComponentes(false);
        HabilitarCombo(false);
        LimpiarComponentes();
        HabilitarActionButtons(false);
        VisualizarComponentes(false);
    }
    
    
    public void VisualizarComponentes(boolean yes)
    {
         Add_NombreText.setVisible(yes);
        Add_ApellidoText.setVisible(yes);
        Edit_UserText.setVisible(yes);
        Edit_PasswordText.setVisible(yes);
        
        nombre.setVisible(yes);
        apelli.setVisible(yes);
        passwor.setVisible(yes);
        usuario.setVisible(yes);
         usuario1.setVisible(yes);
    }        
           

    public void HabilitarCombo(boolean value) {
        Edit_UserCombo.setVisible(value);
    }

    public void HabilitarComponentes(boolean set) {
        Add_NombreText.setEnabled(set);
        Add_ApellidoText.setEnabled(set);
        Edit_UserText.setEnabled(set);
        Edit_PasswordText.setEnabled(set);

    }
    
    public void HabilitarActionButtons(boolean set)
    {
                GuardarButton.setVisible(set);
        CancelarButton.setVisible(set);
    }

    public void LimpiarComponentes() {
        Add_NombreText.setText("");
        Add_ApellidoText.setText("");
        Edit_UserText.setText("");
        Edit_PasswordText.setText("");
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        Edit_UserCombo = new javax.swing.JComboBox<>();
        ModificarButton = new javax.swing.JButton();
        passwor = new javax.swing.JLabel();
        Edit_PasswordText = new javax.swing.JTextField();
        usuario = new javax.swing.JLabel();
        nombre = new javax.swing.JLabel();
        apelli = new javax.swing.JLabel();
        Add_NombreText = new javax.swing.JTextField();
        GuardarButton = new javax.swing.JButton();
        Edit_UserText = new javax.swing.JTextField();
        CrearButton = new javax.swing.JButton();
        DarAltaButton = new javax.swing.JButton();
        DarBajaButton = new javax.swing.JButton();
        Add_ApellidoText = new javax.swing.JTextField();
        CancelarButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        usuario1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Edit_UserCombo.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        Edit_UserCombo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {""  }));
        Edit_UserCombo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                Edit_UserComboItemStateChanged(evt);
            }
        });

        ModificarButton.setBackground(new java.awt.Color(255, 0, 51));
        ModificarButton.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        ModificarButton.setForeground(new java.awt.Color(255, 255, 255));
        ModificarButton.setText("Modificar");
        ModificarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ModificarButtonActionPerformed(evt);
            }
        });

        passwor.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        passwor.setText("Password");

        Edit_PasswordText.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        usuario.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        usuario.setText("Usuario");

        nombre.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        nombre.setText("Nombre");

        apelli.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        apelli.setText("Apellido");

        Add_NombreText.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        GuardarButton.setBackground(new java.awt.Color(0, 255, 102));
        GuardarButton.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        GuardarButton.setText("Guardar");
        GuardarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GuardarButtonActionPerformed(evt);
            }
        });

        Edit_UserText.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        CrearButton.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        CrearButton.setText("Crear");
        CrearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CrearButtonActionPerformed(evt);
            }
        });

        DarAltaButton.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        DarAltaButton.setText("Dar alta");
        DarAltaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarAltaButtonActionPerformed(evt);
            }
        });

        DarBajaButton.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        DarBajaButton.setText("Dar baja");
        DarBajaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DarBajaButtonActionPerformed(evt);
            }
        });

        Add_ApellidoText.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N

        CancelarButton.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        CancelarButton.setText("Cancelar");
        CancelarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelarButtonActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Cambria Math", 1, 24)); // NOI18N
        jLabel1.setText("EMPLEADOS SYSTEM");

        usuario1.setFont(new java.awt.Font("Cambria Math", 1, 12)); // NOI18N
        usuario1.setText("Usuario");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(usuario)
                    .addComponent(passwor)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(nombre)
                                    .addComponent(apelli))
                                .addGap(50, 50, 50))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(CrearButton, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Edit_PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(Add_ApellidoText, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(Edit_UserText, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(ModificarButton)
                                    .addComponent(Add_NombreText, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(46, 46, 46)
                                        .addComponent(usuario1)
                                        .addGap(28, 28, 28)
                                        .addComponent(Edit_UserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addComponent(DarBajaButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(DarAltaButton))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(CancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(52, 52, 52))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CrearButton)
                    .addComponent(ModificarButton)
                    .addComponent(DarBajaButton)
                    .addComponent(DarAltaButton))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nombre)
                    .addComponent(Add_NombreText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Edit_UserCombo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(usuario1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apelli)
                    .addComponent(Add_ApellidoText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usuario)
                    .addComponent(Edit_UserText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwor)
                    .addComponent(Edit_PasswordText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 41, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(GuardarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CancelarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>                        

    private void GuardarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              

        if (GuardarButton.getText().equals("Modificar")) {
            Empleado usuarioEnVista = new Empleado() {
                {
                     Nombre = Add_NombreText.getText();
                    Apellido = Add_ApellidoText.getText();
                    Username = Edit_UserText.getText();
                    Clave = Edit_PasswordText.getText();
                    Estado = true;
                }
            };

            try {
                UpdateService updateService = new UpdateService();
                boolean seRegistro = updateService.Update(usuarioEnVista, 
                     (String)   Edit_UserCombo.getSelectedItem());

                if (seRegistro) {
                    JOptionPane.showMessageDialog(null, "Se modifico");
                    injectorService.FillComboBox(Edit_UserCombo);
                     LimpiarComponentes();
                     
                     HabilitarActionButtons(false);
                     VisualizarComponentes(false);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Dato no corrupto");
                
            }
        }
        
        
         if (GuardarButton.getText().equals("Guardar")) {
            
            Empleado usuarioEnVista = new Empleado() {
                {
                     Nombre = Add_NombreText.getText();
                    Apellido = Add_ApellidoText.getText();
                    Username = Edit_UserText.getText();
                    Clave = Edit_PasswordText.getText();
                    Estado = true;
                }
            };

            try {
                RegisterService updateService = new RegisterService();
                boolean seRegistro = updateService.RegistrarSiNoExiste(usuarioEnVista);

                if (seRegistro) {
                    JOptionPane.showMessageDialog(null, "Registrado");
                    injectorService.FillComboBox(Edit_UserCombo);
                  
                     LimpiarComponentes();
                     HabilitarActionButtons(false);
                     VisualizarComponentes(false);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Dato no corrupto");
                
            }
        }
         
         
         if(GuardarButton.getText().equals("Dar de baja"))
         {
            try {
                UpdateService updateService = new UpdateService();
                boolean seRegistro = updateService.UpdateEstado((String)Edit_UserCombo.getSelectedItem(),
                        false);

                if (seRegistro) {
                    JOptionPane.showMessageDialog(null, "Dado de baja");
                    injectorService.FillComboBox(Edit_UserCombo);
                    LimpiarComponentes();
                    HabilitarActionButtons(false);
                    VisualizarComponentes(false);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Dato no corrupto");
                
            }
         }
         
          if(GuardarButton.getText().equals("Dar de alta"))
         {
            try {
                UpdateService updateService = new UpdateService();
                boolean seRegistro = updateService.UpdateEstado((String)Edit_UserCombo.getSelectedItem(),
                        true);

                if (seRegistro) {
                    JOptionPane.showMessageDialog(null, "Dado de alta");
                    injectorService.FillComboBox(Edit_UserCombo);
                     LimpiarComponentes();
                     HabilitarActionButtons(false);
                     VisualizarComponentes(false);
                }

            } catch (SQLException | ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Dato no corrupto");
                
            }
         }


        CrearButton.setEnabled(true);
        DarAltaButton.setEnabled(true);
        DarBajaButton.setEnabled(true);
        ModificarButton.setEnabled(true);
        Edit_UserCombo.setVisible(false);
        LimpiarComponentes();
        HabilitarComponentes(false);
    }                                             

    private void Edit_UserComboItemStateChanged(java.awt.event.ItemEvent evt) {                                                
        try {
            Empleado us = new Empleado() {
                {
                    Username = (String) Edit_UserCombo.getSelectedItem();
                }
            };

            Empleado buscado = injectorService.FillTxtFiel(us);

            if (buscado == null) {

                
            } else {

                Add_NombreText.setText(buscado.Nombre);
                Add_ApellidoText.setText(buscado.Apellido);
                Edit_PasswordText.setText(buscado.Clave);
                Edit_UserText.setText(buscado.Username);
            }

        } catch (SQLException | ClassNotFoundException ex) {

        }
    }                                               

    private void ModificarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                                
        HabilitarActionButtons(true);
        VisualizarComponentes(true);
        HabilitarComponentes(true);
        HabilitarCombo(true);
        CrearButton.setEnabled(false);
        DarAltaButton.setEnabled(false);
        DarBajaButton.setEnabled(false);
        ModificarButton.setEnabled(true);

        GuardarButton.setText("Modificar");
    }                                               

    private void CrearButtonActionPerformed(java.awt.event.ActionEvent evt) {                                            
        HabilitarActionButtons(true);
        VisualizarComponentes(true);
        LimpiarComponentes();
        CrearButton.setEnabled(true);
        DarAltaButton.setEnabled(false);
        DarBajaButton.setEnabled(false);
        ModificarButton.setEnabled(false);
        HabilitarComponentes(true);
        GuardarButton.setText("Guardar");
    }                                           

    private void DarBajaButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        HabilitarComponentes(false);
        VisualizarComponentes(true);
        CrearButton.setEnabled(false);
        DarAltaButton.setEnabled(false);
        DarBajaButton.setEnabled(true);
        ModificarButton.setEnabled(false);
        HabilitarCombo(true);
        GuardarButton.setText("Dar de baja");
        HabilitarActionButtons(true);
        EmpleadoRepositorio repo;
        try {
            repo = new EmpleadoRepositorio();
            Empleado[] emp = repo.Select("Activos").ObtenerTodos();
           
            injectorService.FillComboBox(Edit_UserCombo, emp);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }                                             

    private void DarAltaButtonActionPerformed(java.awt.event.ActionEvent evt) {                                              
        VisualizarComponentes(true);
         HabilitarComponentes(false);
        CrearButton.setEnabled(false);
        DarAltaButton.setEnabled(true);
        DarBajaButton.setEnabled(false);
        ModificarButton.setEnabled(false);
        HabilitarCombo(true);
        GuardarButton.setText("Dar de alta");
        HabilitarActionButtons(true);
         EmpleadoRepositorio repo;
        try {
            repo = new EmpleadoRepositorio();
            Empleado[] emp = repo.Select("Inactivos").ObtenerTodos();
           
            injectorService.FillComboBox(Edit_UserCombo, emp);
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(AdministradorEmpleados.class.getName()).log(Level.SEVERE, null, ex);
        }
    }                                             

    private void CancelarButtonActionPerformed(java.awt.event.ActionEvent evt) {                                               
   
        CrearButton.setEnabled(true);
        DarAltaButton.setEnabled(true);
        DarBajaButton.setEnabled(true);
        ModificarButton.setEnabled(true);
        HabilitarCombo(false);
        LimpiarComponentes();
        HabilitarComponentes(false);
        HabilitarActionButtons(false);
        VisualizarComponentes(false);
    }                                              

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new AdministradorEmpleados().setVisible(true);
                } catch (SQLException | ClassNotFoundException ex) {

                }
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JTextField Add_ApellidoText;
    private javax.swing.JTextField Add_NombreText;
    private javax.swing.JButton CancelarButton;
    private javax.swing.JButton CrearButton;
    private javax.swing.JButton DarAltaButton;
    private javax.swing.JButton DarBajaButton;
    private javax.swing.JTextField Edit_PasswordText;
    private javax.swing.JComboBox<String> Edit_UserCombo;
    private javax.swing.JTextField Edit_UserText;
    private javax.swing.JButton GuardarButton;
    private javax.swing.JButton ModificarButton;
    private javax.swing.JLabel apelli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel nombre;
    private javax.swing.JLabel passwor;
    private javax.swing.JLabel usuario;
    private javax.swing.JLabel usuario1;
    // End of variables declaration                   

    @Override
    public void actionPerformed(ActionEvent arg0) {

    }
}
