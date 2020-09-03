
import java.sql.SQLException;

/**
 *
 * @author Ariel
 */
public class RegisterService 
{


    public boolean RegistrarSiNoExiste(Empleado user) throws SQLException,
            ClassNotFoundException 
    {
       EmpleadoRepositorio repositorio = new EmpleadoRepositorio();
       boolean sePuedoRegistrar = repositorio.Insert(user) == 1 ;
       return sePuedoRegistrar ;
    }
    
}
