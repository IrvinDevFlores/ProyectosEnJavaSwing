
package FormTools;

import AppTools.Interfaces.IWindowMessage;
import javax.swing.JOptionPane;

public class WM implements IWindowMessage
{
    @Override
    public void W(String msj)
    {
        JOptionPane.showMessageDialog(null, msj);
    }
}
