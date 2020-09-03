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
   

    final String[] data = ExtractConfig();

    Config config = GetUserConfig(data);
    
   db=  config.DbName;
    localizacion="localhost";
    url = "jdbc:mysql://"+localizacion+":3306/"+db;
    
    user = config.Usuario;
    pass = config.Pass;

    //ValidateCredentials(config);
    
    
}

public Config GetUserConfig(String[] data){
    Config config = new Config();
    for (int i = 0; i < data.length; i++) {
        final String usersData[] = data[i].split(";");
        
        config.DbLocation = usersData[0];
        config.DbName = usersData[1];
        config.Usuario = usersData[2];
        config.Pass = usersData[3];

    }
    return config;
}

public String[] ExtractConfig(){
    final String usersTxt = "Data/config.txt";
        final LectorDeArchivos archivo = new LectorDeArchivos(usersTxt);

        final String usuariosInString = archivo.ToString();

        final String[] data = usuariosInString.split("\n");
  

        return data;
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
            Class.forName("com.mysql.cj.jdbc.Driver");
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