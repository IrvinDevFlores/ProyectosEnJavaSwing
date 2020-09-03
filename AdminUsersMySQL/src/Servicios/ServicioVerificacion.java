package Servicios;

import DataLayer.ArregloUsuario;
import DataLayer.Usuario;
import DataLayer.UsuarioRepositorio;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class ServicioVerificacion implements IServicioVerificacion {

    @Override
    public boolean ValidarCredenciales(Usuario user) throws SQLException, ClassNotFoundException 
    {

        UsuarioRepositorio repositorioUsuariosDb = new UsuarioRepositorio();

        ArregloUsuario usuariosEnMemoria = repositorioUsuariosDb.Select();
        boolean logOutput = false;
        boolean credenciales = false;
        for (Usuario usuario : usuariosEnMemoria.ObtenerTodos())
        {

             boolean seEncontro = usuario.Pass.equals(user.Pass) && usuario.UserName.equals(user.UserName) ;
            if(seEncontro)
            {
                user.IdUsuario = usuario.IdUsuario;
                 user.Estado = usuario.Estado;
                user.Temp = usuario.Temp;
                JOptionPane.showMessageDialog(null, "Credenciales encontradas");
                credenciales = true;
            }

        }
         if(credenciales)
         {
              if (user.Estado == false) {
                    JOptionPane.showMessageDialog(null, "Usted ha sido removido");
                   return false;
                }

                if (user.Temp == true && user.Estado == true) {
                    String nuevo = JOptionPane.showInputDialog(null, "Ingrese nueva contra");
                    String confirmar = JOptionPane.showInputDialog(null, "Confirme nueva contra");

                    if (!nuevo.equals(confirmar)) {
                        JOptionPane.showMessageDialog(null, "No conindice");
                        return false;
                    }
                    user.Pass = confirmar;
                    user.Temp = false;
                    repositorioUsuariosDb.Update(user);

                    JOptionPane.showMessageDialog(null, "Actualizado");
                    //logOutput = true;
                   
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
