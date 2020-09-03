/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package AppTools.Interfaces;

import FormTools.WM;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionListener;

public abstract class IComponent extends JFrame implements ActionListener,
        ListSelectionListener, MouseListener {

    public String ViewName;
    JPanel _appLayout;

    public IComponent(String viewname) {
        ViewName = viewname;
    }

    public int GetX() {
        return _appLayout.getX();
    }

    public int GetY() {
        return _appLayout.getY();
    }

    public int GetWidth() {
        return _appLayout.getSize().width;
    }

    public int GetHeight() {
        return _appLayout.getSize().height;
    }

    public void SetPos(int x, int y) {
        _appLayout.setBounds(x, y, _appLayout.getWidth(), _appLayout.getHeight());
    }

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

    public void setFormView(JPanel panel) {
        _appLayout = panel;
        try {
            setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
            setLocationRelativeTo(this);
        } catch (Exception e) {
            new WM().W(e.toString());
        }
    }

    public JPanel GetView() {
        _appLayout.setVisible(true);
        return _appLayout;
    }

}
