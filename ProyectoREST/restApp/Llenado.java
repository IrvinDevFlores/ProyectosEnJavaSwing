package restApp;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class Llenado {

    public void llenar_combo(final String sql,
            final JComboBox cmb, final JComboBox cmbi) {
        cmb.removeAllItems();
        cmbi.removeAllItems();

        cmb.addItem("");
        cmbi.addItem("");
        int primerCombo = 2;
        int segundoCombo = 1;
        try {
            Connection con = new Conexion().getConexion();
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) {
                cmbi.addItem(rs.getString(primerCombo));
                cmb.addItem(rs.getString(segundoCombo));
            }
            con.close();
            cmb.setSelectedIndex(0);
        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "Error al llenar", 0);
            System.exit(0);
        }
        cmb.setSelectedIndex(0);
    }
}
