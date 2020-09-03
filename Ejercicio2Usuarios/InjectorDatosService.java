
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Ariel
 */
public class InjectorDatosService {

    EmpleadoRepositorio repositorio;

    public InjectorDatosService() throws SQLException, ClassNotFoundException {
        this.repositorio = new EmpleadoRepositorio();
    }

    
    public Empleado[] FillComboBox(JComboBox component) throws SQLException,
            ClassNotFoundException {
        component.removeAllItems();
        component.addItem("");
        for (Empleado data : repositorio.Select().ObtenerTodos()) {
            component.addItem(data.Username);
        }
        return repositorio.Select().ObtenerTodos();
    }
    
    public Empleado[] FillComboBox(JComboBox component, Empleado[] emp) throws SQLException,
            ClassNotFoundException {
        component.removeAllItems();
        component.addItem("");
        for (Empleado data : emp) {
            component.addItem(data.Username);
        }
        return repositorio.Select().ObtenerTodos();
    }

    public Empleado FillTxtFiel( Empleado us)
            throws SQLException, ClassNotFoundException {

        for (Empleado usuario : repositorio.Select().ObtenerTodos()) 
        {

            boolean esIgual = usuario.Username.equals(us.Username);

            for (Empleado data : repositorio.Select().ObtenerTodos())
            {
                if (esIgual) {
                    //field.setText(usuario.Clave);
                        
                    return usuario;
                }

            }

        }
        //field.setText("");
        return null;
    }

}
