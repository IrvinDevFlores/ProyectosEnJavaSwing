/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlDatabase;

import Modelos.Usuario;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.*;

public class SqlUsuarios {

    Conexion _conexion;

    public SqlUsuarios() {

        _conexion = new Conexion();
    }

    public boolean Login(Usuario user) throws Exception {
        PreparedStatement sentencia = null;
        ResultSet resultSet = null;
        Connection con = _conexion.getConexion();

        String query = "select u.IdUsuario, u.Usuario, u.Password, u.Estado, u.IdTipoUsuario, t.Descripcicn"
                + "  from usuarios as u inner join tipousuario as t on u.IdTipoUsuario = t.IdTipoUsuario where Usuario = ?";

        sentencia = con.prepareStatement(query);
        sentencia.setString(1, user.UserName);

        resultSet = sentencia.executeQuery();
        String pass = resultSet.getString(3);
        if (!user.Pass.trim().equals(pass)) {
            return false;
        }
        
            user.IdUsuario = resultSet.getInt(1);
            user.UserName = resultSet.getString(2);
            return true;
    }

}
