
package Servicios;

import DataLayer.Usuario;
import DataLayer.UsuarioRepositorio;
import java.sql.SQLException;

/**
 *
 * @author Ariel
 */
public class UpdateService implements IUpdateService {

     UsuarioRepositorio repositorio;

    public UpdateService() throws SQLException, ClassNotFoundException {
        this.repositorio = new UsuarioRepositorio();
    }
    @Override
    public boolean Update(Usuario user) throws SQLException, ClassNotFoundException
    {
   
            for(var usuario : repositorio.Select().ObtenerTodos())
            {
                boolean esIgual = user.UserName.equals(usuario.UserName);
                if(esIgual){
                    usuario.Pass = user.Pass;
                    usuario.Estado = user.Estado;
                    usuario.Temp = user.Temp;
                    repositorio.Update(usuario);
                    return true;
                    
                }
            }
            return false;

    }
    

    
}
