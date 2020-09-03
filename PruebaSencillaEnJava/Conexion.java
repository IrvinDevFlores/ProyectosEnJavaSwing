import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

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
    db="inventario";
    localizacion="localhost";
    url = "jdbc:mysql://"+localizacion+":3306/"+db;
    user = "root";
    pass = "$programmer31416";
    
    
}

public boolean ExistConnection(){
    return getConexion() != null ? true: false;
}

public Connection getConexion()
{
    try
    {
        Connection conexion = null;
        try
        {
            //Establecimos la zona horaria del servidor a la de honduras SET GLOBAL time_zone = '-6:00';
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection( url , user , pass );
        
            return conexion;
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null,"Ocurrio algo"+e+"\n");
            
        }
    }
    catch(Exception e)
    {
        JOptionPane.showMessageDialog(null,"ERROR EN CONEXION DE RED A BASE DE DATOS\n" 
        + e.getMessage(),
        "Conexion a Base de Datos Incorrecta",0);
        System.exit(0);
    }
    return null;
}
}