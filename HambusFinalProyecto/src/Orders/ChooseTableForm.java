/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

import AppTools.Interfaces.IView;
import FormTools.Views;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.ButtonGroup;
import javax.swing.event.ListSelectionEvent;


/**
 *
 * @author Ariel
 */
public class ChooseTableForm extends IView {

    public ChooseTableForm(Views name) {
        super(name);
        initComponents();

        setFormView(MesasPanel);

        AddMesas();

        ShowMesas();

    }

    public static void main(String... args) {
        new ChooseTableForm(Views.ELEGIR_MESA).setVisible(true);
    }

    ArrayList<MesaComponent> components;

    public void AddMesas() 
    {
        components = new ArrayList<>();

        components.add(new MesaComponent("1"));
        components.add(new MesaComponent("2"));

        components.add(new MesaComponent("3"));
    }
    
  public MesaComponent FindView(String route) {
        MesaComponent view = components.stream()
                .filter(v -> v.ViewName.equals(route))
                .findAny()
                .orElse(null);

        return view;

    }

    public void ShowMesas() {

        MesaComponent m = FindView("1");
        int width = m.GetWidth();
        
        int x = 20;
        int y = 30;
        for (MesaComponent c : components) {
        
                c.SetPos(x,y);
                MesasPanel.add(c.GetView());
                x += (width + 10);
            
        }

    }


    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ActionButtons = new javax.swing.ButtonGroup();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        MesasPanel = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

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

        MesasPanel.setBackground(new java.awt.Color(204, 255, 204));
        MesasPanel.setBorder(javax.swing.BorderFactory.createTitledBorder("Mesas"));

        javax.swing.GroupLayout MesasPanelLayout = new javax.swing.GroupLayout(MesasPanel);
        MesasPanel.setLayout(MesasPanelLayout);
        MesasPanelLayout.setHorizontalGroup(
            MesasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 731, Short.MAX_VALUE)
        );
        MesasPanelLayout.setVerticalGroup(
            MesasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 513, Short.MAX_VALUE)
        );

        jLabel2.setFont(new java.awt.Font("Fira Code", 1, 24)); // NOI18N
        jLabel2.setText("MESAS");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(370, 370, 370)
                        .addComponent(jLabel2))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(MesasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(MesasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup ActionButtons;
    private javax.swing.JPanel MesasPanel;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLayeredPane jLayeredPane1;
    // End of variables declaration//GEN-END:variables

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
    public void InitMoreComponents() {
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
