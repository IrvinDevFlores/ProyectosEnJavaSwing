
 

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

/**
 *
 * @author Ariel
 */
public class EmpleadoRepositorio {
    

    private final Connection _dbConecction;
    private Statement _sentencia = null;
    
    public EmpleadoRepositorio() throws SQLException, ClassNotFoundException{
        _dbConecction = new Conexion().getConexion();
    }
    
    public int Insert(Empleado user) throws SQLException
    {
        final String SQL = SqlEmpleados.REGISTRAR;
        PreparedStatement ps = _dbConecction.prepareStatement(SQL);
        ps.setInt(1, user.EmpleadoId);
        ps.setString(2, user.Nombre);
        ps.setString(3, user.Apellido);
        ps.setString(4, user.Username);
        ps.setString(5, user.Clave);
        ps.setBoolean(6, user.Estado);
        return ps.executeUpdate();
                
    }
    
    public int Update(Empleado user) throws SQLException
    {
        final String SQL = SqlEmpleados.ACTUALIZAR;
        PreparedStatement ps = _dbConecction.prepareStatement(SQL);
        ps.setString(1, user.Nombre);
        ps.setString(2, user.Apellido);
        
        ps.setString(3, user.Username);
        ps.setString(4,  user.Clave);
        ps.setBoolean(5, user.Estado);
        ps.setInt(6,user.EmpleadoId);
       
        return ps.executeUpdate();
    }
    
    public int UpdateEstado(Empleado user) throws SQLException
    {
        final String SQL = SqlEmpleados.ACTUALIZAR_ESTADO;
        PreparedStatement ps = _dbConecction.prepareStatement(SQL);

        ps.setBoolean(1, user.Estado);
        ps.setInt(2,user.EmpleadoId);
       
        return ps.executeUpdate();
    }
    
    
   
    public ArregloEmpleados Select() throws SQLException, 
            ClassNotFoundException
    {
        final String SQL = SqlEmpleados.LISTAR;
        ArregloEmpleados usuariosEnMemoria = new ArregloEmpleados();
       
        _sentencia = _dbConecction.createStatement();
        ResultSet result = _sentencia.executeQuery(SQL);

        while(result.next())
        {
           usuariosEnMemoria.Insertar(new Empleado(){
                {
                   EmpleadoId = result.getInt("EmpleadoId");
                   Nombre = result.getString("Nombre");
                   Apellido = result.getString("Apellido");
                   Username = result.getString("Usuario");
                   Clave = result.getString("Clave");
                   Estado = result.getBoolean("Estado");
                }
            });
            
        }
       
        
        return usuariosEnMemoria;
    }
    
    
    public ArregloEmpleados Select(String tipo) throws SQLException, 
            ClassNotFoundException
    {
        Empleado[] emp = Select().ObtenerTodos();

        ArregloEmpleados activos = new ArregloEmpleados();
        if("Activos".equals(tipo)){
            for(Empleado e : emp)
            {
                if(e.Estado == true)
                {
                    activos = new ArregloEmpleados();
                    activos.Insertar(e);
                }
            }
        }
        
        if("Inactivos".equals(tipo)){
            for(Empleado e : emp)
            {
                if(e.Estado == false)
                {
                    activos = new ArregloEmpleados();
                    activos.Insertar(e);
                }
            }
        }
        return activos;
    }
    
    public static void main(String... args) throws SQLException, ClassNotFoundException{
        EmpleadoRepositorio repo =  new EmpleadoRepositorio();
        repo.Insert(new Empleado(){
                {
                   EmpleadoId = 0;
                   Nombre = "Arne";
                   Apellido = "Ramirez";
                   Username = "cor";
                   Clave = "12";
                   Estado = true;
                }
            });
        System.out.print(repo.Select().ToString());
    }
    
}
