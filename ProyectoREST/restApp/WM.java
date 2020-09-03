
package restApp;

import restApp.IWindowMessage;
import javax.swing.JOptionPane;

public class WM implements IWindowMessage
{
    @Override
    public void W(String msj)
    {
        JOptionPane.showMessageDialog(null, msj);
    }
}
