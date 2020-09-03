
package restApp;

import restApp.IComponent;

import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import javax.swing.event.ListSelectionEvent;
/**
 *
 * @author Ariel
 */
public final class MesaComponent extends IComponent {

    private String _noMesa;
    private String _noClientes;
    private String _estado;



    public MesaComponent(String name) {
        super(name);
        initComponents();
        
        InitMoreComponents();

        SetText();
        
    }
    

    public void SetText() {
        NoMesa.setText("Mesa ->" + ViewName);
        NoClientes.setText("Clientes ->" + _noClientes);
        Estado.setText("Estado ->" + _estado);
    }

    public static void main(String[] args) {
        new MesaComponent("Fsys").setVisible(true);
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        ActionButtons = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        Mesa = new javax.swing.JPanel();
        ActionButton = new javax.swing.JButton();
        Estado = new javax.swing.JLabel();
        NoClientes = new javax.swing.JLabel();
        NoMesa = new javax.swing.JLabel();

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

        Mesa.setBackground(new java.awt.Color(204, 255, 204));
        Mesa.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesa"));

        ActionButton.setText("Atender");
        ActionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ActionButtonActionPerformed(evt);
            }
        });

        Estado.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        Estado.setText("Estado ->");

        NoClientes.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        NoClientes.setText("Clientes ->");

        NoMesa.setFont(new java.awt.Font("Fira Code", 1, 18)); // NOI18N
        NoMesa.setText("0");

        javax.swing.GroupLayout MesaLayout = new javax.swing.GroupLayout(Mesa);
        Mesa.setLayout(MesaLayout);
        MesaLayout.setHorizontalGroup(
            MesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MesaLayout.createSequentialGroup()
                .addContainerGap(65, Short.MAX_VALUE)
                .addComponent(ActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44))
            .addGroup(MesaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Estado)
                    .addComponent(NoClientes)
                    .addComponent(NoMesa))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MesaLayout.setVerticalGroup(
            MesaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MesaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(NoMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 16, Short.MAX_VALUE)
                .addComponent(NoClientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Estado)
                .addGap(50, 50, 50)
                .addComponent(ActionButton, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Mesa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>                        

    private void ActionButtonActionPerformed(java.awt.event.ActionEvent evt) {                                             
        new MakeOrderView(Views.HACER_ORDEN).setVisible(true);
    }                                            


    // Variables declaration - do not modify                     
    private javax.swing.JButton ActionButton;
    private javax.swing.ButtonGroup ActionButtons;
    private javax.swing.JLabel Estado;
    private javax.swing.JPanel Mesa;
    private javax.swing.JLabel NoClientes;
    private javax.swing.JLabel NoMesa;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration                   

    @Override
    public void InitMoreComponents() {
       
        setFormView(Mesa);

        getContentPane().add(Mesa);
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void valueChanged(ListSelectionEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RestoreData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void DeleteData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EditData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void SaveData() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EnableInput(boolean disable) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void AddListeners() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void Limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RenderInactives() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void RenderActives() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void EnableControl(boolean... control1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseClicked(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
