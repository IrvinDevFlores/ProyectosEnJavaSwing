
import java.sql.SQLException;

/**
 *
 * @author Ariel
 */
public class UpdateService  {

     EmpleadoRepositorio repositorio;

    public UpdateService() throws SQLException, ClassNotFoundException {
        this.repositorio = new EmpleadoRepositorio();
    }
   
    public boolean Update(Empleado user, String username) throws SQLException, ClassNotFoundException
    {
   
            boolean seEncontro = false;
            for(Empleado usuario : repositorio.Select().ObtenerTodos())
            {
                boolean esIgual = username.equals(usuario.Username);
                if(esIgual){
                    usuario.Nombre = user.Nombre;
                    usuario.Apellido = user.Apellido;
                    usuario.Username = user.Username;
                    usuario.Clave = user.Clave;
                    usuario.Estado = user.Estado;
                    repositorio.Update(usuario);
                    seEncontro = true;
                    break;
                    
                }
            }
            return seEncontro;

    }
    
     public boolean UpdateEstado(String username, boolean estado) throws SQLException, ClassNotFoundException
    {
   
            boolean seEncontro = false;
            for(Empleado usuario : repositorio.Select().ObtenerTodos())
            {
                boolean esIgual = username.equals(usuario.Username);
                if(esIgual){
                    usuario.Estado = estado;
                    repositorio.UpdateEstado(usuario);
                    seEncontro = true;
                    break;
                    
                }
            }
            return seEncontro;

    }
    

    
}
