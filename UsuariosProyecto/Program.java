import java.sql.*;

public class Program{

    public static void main(String args[]){
        
           Connection con = new Conexion().getConexion();
        if(con == null){
                    
        
            final String[] data = ExtractConfig();

                Config config = GetUserConfig(data);
                
              new DbManagerForm(config).setVisible(true);
            return;
        }
        
        new Form().setVisible(true);

    }
    
    
    
    public static Config GetUserConfig(String[] data){
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


    public static String[] ExtractConfig(){
        final String usersTxt = "Data/config.txt";
            final LectorDeArchivos archivo = new LectorDeArchivos(usersTxt);

            final String usuariosInString = archivo.ToString();

            final String[] data = usuariosInString.split("\n");

            

            return data;
    }
    
}