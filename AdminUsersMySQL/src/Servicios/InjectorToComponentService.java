/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DataLayer.Usuario;
import DataLayer.UsuarioRepositorio;
import java.sql.SQLException;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JTextField;

/**
 *
 * @author Ariel
 */
public class InjectorToComponentService implements DataInjectorToComponentsService {

    UsuarioRepositorio repositorio;

    public InjectorToComponentService() throws SQLException, ClassNotFoundException {
        this.repositorio = new UsuarioRepositorio();
    }

    @Override
    public Usuario[] FillComboBox(JComboBox component) throws SQLException,
            ClassNotFoundException {
        component.removeAllItems();

        for (Usuario data : repositorio.Select().ObtenerTodos()) {
            component.addItem(data.UserName);
        }
        return repositorio.Select().ObtenerTodos();
    }

    public Usuario FillTxtFiel(JTextField field, Usuario us)
            throws SQLException, ClassNotFoundException {

        for (Usuario usuario : repositorio.Select().ObtenerTodos()) 
        {

            boolean esIgual = usuario.UserName.equals(us.UserName);

            for (Usuario data : repositorio.Select().ObtenerTodos())
            {
                if (esIgual) {
                    field.setText(usuario.Pass);
                        
                    return usuario;
                }

            }

        }
        field.setText("");
        return null;
    }

}
