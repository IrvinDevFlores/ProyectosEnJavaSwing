
package DataLayer;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Ariel
 */
public class UsuarioRepositorio {
    

    private final Connection _dbConecction;
    private Statement _sentencia = null;
    
    public UsuarioRepositorio() throws SQLException, ClassNotFoundException{
        _dbConecction = new Conexion().getConexion();
    }
    
    public int Insert(Usuario user) throws SQLException
    {
        final String SQL = SqlUsuarios.REGISTRAR;
        PreparedStatement ps = _dbConecction.prepareStatement(SQL);
        ps.setInt(1, user.IdUsuario);
        ps.setString(2, user.UserName);
        ps.setString(3, user.Pass);
        ps.setBoolean(4, user.Estado);
        ps.setBoolean(5, user.Temp);
        
        return ps.executeUpdate();
                
    }
    
    public int Update(Usuario user) throws SQLException
    {
        final String SQL = SqlUsuarios.ACTUALIZAR;
        PreparedStatement ps = _dbConecction.prepareStatement(SQL);
        ps.setString(1, user.UserName);
        ps.setString(2, user.Pass);
        ps.setBoolean(3, user.Estado);
        ps.setBoolean(4,  user.Temp);
        ps.setInt(5,user.IdUsuario);
       
        return ps.executeUpdate();
    }
   
    public ArregloUsuario Select() throws SQLException, 
            ClassNotFoundException
    {
        final String SQL = SqlUsuarios.LISTAR;
        ArregloUsuario usuariosEnMemoria = new ArregloUsuario();
       
        _sentencia = _dbConecction.createStatement();
        ResultSet result = _sentencia.executeQuery(SQL);

        while(result.next())
        {
           usuariosEnMemoria.Insertar(new Usuario(){
                {
                   IdUsuario = result.getInt("UsuarioId");
                   UserName = result.getString("Username");
                   Pass = result.getString("Password");
                   Estado = result.getBoolean("Estado");
                   Temp = result.getBoolean("Temp");
                }
            });
            
        }
       
        
        return usuariosEnMemoria;
    }
    
    public static void main(String... args) throws SQLException, ClassNotFoundException{
        UsuarioRepositorio repo =  new UsuarioRepositorio();
        repo.Update(new Usuario(){
                {
                   IdUsuario = 3;
                   UserName = "piter";
                   Pass = "user22";
                   Estado = true;
                   Temp = false;
                }
            });
        System.out.print(repo.Select().ToString());
    }
    
}
