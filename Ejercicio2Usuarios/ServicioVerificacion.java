 
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServicioVerificacion  {
    public boolean ValidarCredenciales(Empleado user) throws SQLException, ClassNotFoundException 
    {

        EmpleadoRepositorio repositorioUsuariosDb = new EmpleadoRepositorio();

        ArregloEmpleados usuariosEnMemoria = repositorioUsuariosDb.Select();
        boolean logOutput = false;
        boolean credenciales = false;
        for (Empleado usuario : usuariosEnMemoria.ObtenerTodos())
        {

             boolean seEncontro = usuario.Clave.equals(user.Clave) && usuario.Username.equals(user.Username) ;
            if(seEncontro)
            {
                user.EmpleadoId = usuario.EmpleadoId;
                 user.Estado = usuario.Estado;
                JOptionPane.showMessageDialog(null, "Credenciales encontradas");
                credenciales = true;
            }

        }
         if(credenciales)
         {
              if (user.Estado == false) {
                    JOptionPane.showMessageDialog(null, "Usted ha sido removido y esta inabilitado contacte a su admin para ser renovado");
                   return false;
                }

                JOptionPane.showMessageDialog(null, "Bienvenido");
                logOutput = true; 
         }
         else
         {
              JOptionPane.showMessageDialog(null, "Credenciales incorrectas");
         }
        
        return logOutput;

    }

}
