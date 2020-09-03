import java.sql.Connection;
import java.sql.DriverManager;

import javax.swing.JOptionPane;
public class Conexion
{
static String url;
static String user;
static String pass;
static String db;
static String localizacion;

public Conexion()
{
   

    final String[] data = LectorDeArchivos.ExtractConfig();

    Config config = LectorDeArchivos.GetUserConfig(data);
    db =  config.DbName;
    user = config.Usuario;
    pass = config.Pass;


    localizacion="localhost";
    url = "jdbc:mysql://"+localizacion+":3306/"+db;


    
}


public boolean ExistConnection()
{
    return getConexion() != null ? true: false;
}

public Connection getConexion()
{
    try
    {
       try{
            Connection conexion = null;
     
            //Establecimos la zona horaria del servidor a la de honduras SET GLOBAL time_zone = '-6:00';
            String driver = "com.mysql.jdbc.Driver";
                Class.forName( driver );
                conexion = DriverManager.getConnection( url , user , pass );
            return conexion;
        }catch(Exception e){}

    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"ERROR EN CONEXION DE RED A BASE DE DATOS\n" 
        + e.getMessage(),
        "Conexion a Base de Datos Incorrecta",0);
    }
    return null;
}
}