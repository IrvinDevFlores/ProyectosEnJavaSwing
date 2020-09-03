/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class Conexion {

    static String url;
    static String user;
    static String pass;
    static String db;
    static String localizacion;

    public Conexion() {
        db = "usuarioexamen";
        localizacion = "localhost";
        url = "jdbc:mysql://" + localizacion + ":3306/" + db;
        user = "root";
        pass = "$programmer31416";

    }

    public static void main(String... args) throws SQLException, ClassNotFoundException {
        Conexion con = new Conexion();
        JOptionPane.showMessageDialog(null, "Exist conection: " + con.ExistConnection());
    }

    public boolean ExistConnection() throws SQLException, ClassNotFoundException {
        return getConexion() != null;
    }

    public void CloseConnection() throws SQLException {
        conexion.close();
    }

    private Connection conexion = null;

    public Connection getConexion() throws SQLException, ClassNotFoundException {

        //Establecimos la zona horaria del servidor a la de honduras SET GLOBAL time_zone = '-6:00';
        Class.forName("com.mysql.cj.jdbc.Driver");
        conexion = DriverManager.getConnection(url, user, pass);
        return conexion;

    }
}
