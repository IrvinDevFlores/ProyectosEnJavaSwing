import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class SqlCommandWritter
{

    public static final boolean WriteCommand(String sql)
    {
     try
     {
     Connection conectar= new Conexion().getConexion();
     try
     {
     Statement s1=conectar.createStatement();
     conectar.setAutoCommit(false);
     s1.execute(sql);
     conectar.commit();
     conectar.close();
     return true;
     }
     catch(Exception x)
     {
     conectar.rollback();
     conectar.close();
     JOptionPane.showMessageDialog(null,"Error Primer Catch "+x,"ERROR",0);
     return false;
     }
     }
     catch(Exception exp)
     {
     JOptionPane.showMessageDialog(null,exp);System.exit(0);
     return false;
     }
    }
    
 
}
