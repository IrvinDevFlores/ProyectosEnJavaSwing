/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author Ariel
 */
public abstract class IView extends JFrame implements ActionListener,
        ListSelectionListener , MouseListener{

    public Views ViewName;

    public IView(Views viewname) {
        ViewName = viewname;
       
     
    }

    @Override
    public abstract void actionPerformed(ActionEvent arg0);

    @Override
    public abstract void valueChanged(ListSelectionEvent arg0);

    public abstract void RestoreData();
    
    public abstract void InitMoreComponents();

    public abstract void DeleteData();

    public abstract void EditData();

    public abstract void SaveData();

    public abstract void EnableInput(boolean disable);

    public abstract void AddListeners();


    public abstract void Limpiar();

    public abstract void RenderInactives();

    public abstract void RenderActives();

    public abstract void EnableControl(boolean... control1);

    JPanel formPanel;

    public void setFormView(JPanel panel) {
        formPanel = panel;
        try {
            setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            setLocationRelativeTo(this);
        } catch (Exception e) {
            new WM().W(e.toString());
        }
    }

    public JPanel GetView() {
        formPanel.setVisible(true);
        return formPanel;
    }

}
