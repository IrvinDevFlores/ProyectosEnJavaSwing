package App;

import FormTools.ViewPresenter;
import FormTools.WM;
import FormTools.FormRouter;
import FormTools.Views;
import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Dashboard extends javax.swing.JFrame {

    ViewPresenter viewManager;
    WM messageWritter;
    
    FormRouter router;

    JScrollPane scroll;
    public Dashboard() {
        initComponents();
       
        setLocationRelativeTo(null);
      
        
        viewManager = new ViewPresenter();

        router = new FormRouter();

        scroll = new JScrollPane();
        scroll.setBounds(AppLayout.getX(), AppLayout.getY(),
                AppLayout.getSize().width, AppLayout.getSize().height);
        
        AppLayout.setLayout(null);
        
        AppLayout.setPreferredSize(new Dimension(800,800));
        
        scroll.setViewportView(AppLayout);
        
        add(scroll);
        
        messageWritter = new WM();
       

    }

    public void ClearPanel() {
        AppLayout.removeAll();
    }

    public void AddView(Views formName) {

        ClearPanel();
        JPanel panel = router.RouteToPage(formName);

        AppLayout.add(panel);
        AppLayout.repaint();
    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTextField5 = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        buttonGroup1 = new javax.swing.ButtonGroup();
        LateralNavbar = new javax.swing.JPanel();
        InicioLink = new javax.swing.JButton();
        PersonalLink = new javax.swing.JButton();
        MenuLink = new javax.swing.JButton();
        OrdenesLink = new javax.swing.JButton();
        ReportesLink = new javax.swing.JButton();
        AppLayout = new javax.swing.JPanel();

        jTextField5.setText("jTextField1");

        jLabel5.setText("Segundo nombre");

        jTextField6.setText("jTextField1");

        jLabel6.setText("Primer nombre");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        LateralNavbar.setBackground(new java.awt.Color(51, 51, 0));

        InicioLink.setText("Inicio");
        InicioLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InicioLinkActionPerformed(evt);
            }
        });

        PersonalLink.setText("Personal");
        PersonalLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PersonalLinkActionPerformed(evt);
            }
        });

        MenuLink.setText("Menu");
        MenuLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuLinkActionPerformed(evt);
            }
        });

        OrdenesLink.setText("Ordenes");
        OrdenesLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                OrdenesLinkActionPerformed(evt);
            }
        });

        ReportesLink.setText("Reportes");
        ReportesLink.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ReportesLinkActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout LateralNavbarLayout = new javax.swing.GroupLayout(LateralNavbar);
        LateralNavbar.setLayout(LateralNavbarLayout);
        LateralNavbarLayout.setHorizontalGroup(
            LateralNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LateralNavbarLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(LateralNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(MenuLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(PersonalLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(InicioLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OrdenesLink, javax.swing.GroupLayout.DEFAULT_SIZE, 89, Short.MAX_VALUE)
                    .addComponent(ReportesLink, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        LateralNavbarLayout.setVerticalGroup(
            LateralNavbarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(LateralNavbarLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(InicioLink, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(PersonalLink, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addComponent(OrdenesLink, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(MenuLink, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ReportesLink, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(210, Short.MAX_VALUE))
        );

        AppLayout.setBackground(new java.awt.Color(255, 255, 255));
        AppLayout.setAutoscrolls(isEnabled());
        AppLayout.setPreferredSize(new java.awt.Dimension(200, 200));

        javax.swing.GroupLayout AppLayoutLayout = new javax.swing.GroupLayout(AppLayout);
        AppLayout.setLayout(AppLayoutLayout);
        AppLayoutLayout.setHorizontalGroup(
            AppLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 878, Short.MAX_VALUE)
        );
        AppLayoutLayout.setVerticalGroup(
            AppLayoutLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(LateralNavbar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(AppLayout, javax.swing.GroupLayout.DEFAULT_SIZE, 878, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(LateralNavbar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(AppLayout, javax.swing.GroupLayout.DEFAULT_SIZE, 569, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void InicioLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InicioLinkActionPerformed

        AddView(Views.INICIO);
    }//GEN-LAST:event_InicioLinkActionPerformed

    private void PersonalLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PersonalLinkActionPerformed

        AddView(Views.ADMIN_EMPLEADOS);
    }//GEN-LAST:event_PersonalLinkActionPerformed

    private void OrdenesLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_OrdenesLinkActionPerformed
        // TODO add your handling code here:
        AddView(Views.ELEGIR_MESA);
    }//GEN-LAST:event_OrdenesLinkActionPerformed

    private void MenuLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuLinkActionPerformed
       AddView(Views.ADMIN_MENU);
    }//GEN-LAST:event_MenuLinkActionPerformed

    private void ReportesLinkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ReportesLinkActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ReportesLinkActionPerformed

    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Dashboard.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Dashboard().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel AppLayout;
    private javax.swing.JButton InicioLink;
    private javax.swing.JPanel LateralNavbar;
    private javax.swing.JButton MenuLink;
    private javax.swing.JButton OrdenesLink;
    private javax.swing.JButton PersonalLink;
    private javax.swing.JButton ReportesLink;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    // End of variables declaration//GEN-END:variables
}
