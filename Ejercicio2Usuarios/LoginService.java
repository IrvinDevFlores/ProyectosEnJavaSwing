
import java.sql.SQLException;


public class LoginService  {
    
    ServicioVerificacion _servicio;
    public LoginService(ServicioVerificacion servicio) 
    {
        _servicio = servicio;
    }
    
    public LoginService(){}


    public boolean Login(Empleado user)throws SQLException,
            ClassNotFoundException  {
        
         return _servicio.ValidarCredenciales(user);
       
    }
    
}
