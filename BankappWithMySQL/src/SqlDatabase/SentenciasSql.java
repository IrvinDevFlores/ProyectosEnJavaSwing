/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlDatabase;
import  Modelos.Cliente;
import java.sql.Connection;

import java.sql.*;
import java.util.Calendar;

public class SentenciasSql {

    private final Conexion _conexion;

    public SentenciasSql() {
        _conexion = new Conexion();
    }
    
    public static void main(String... args) throws SQLException
    {
           Cliente cliente = new Cliente() {
                    {
                        IdCliente = 3;
                        NoCedula =  "Usuarios";
                        Nombres = "Usuarios";
                        Apellidos = "Usuarios";

                        EstadoCivil.EstadoId =1;
                        EstadoCivil.Nombre ="Statement";

                        Email = "Reportes";
                        Direccion = "La ceiba";
                        FechaNac = "2019-05-06";
                        Sexo.IdSexo = 1;
                        Sexo.Nombre = "asdfd";

                    }
                };
         int result = new SentenciasSql().InsertCliente(cliente);
         System.out.print(result);
         
    }

    public int InsertCliente(Cliente cliente) throws SQLException{
            Calendar calendar = Calendar.getInstance();
             java.sql.Date startDate = new java.sql.Date(calendar.getTime().getTime());

             String values = String.format(" values('%d','%s','%s','%s','%s','%s','%s','%s','%s')",
              cliente.IdCliente, cliente.NoCedula, cliente.Nombres, cliente.Apellidos, cliente.EstadoCivil.Nombre,
              cliente.Sexo.Nombre, "2019-05-06",cliente.Email, cliente.Direccion);
             
            String script = "INSERT INTO clientes (IdCliente, NoCedula, Nombres, Apellidos,EstadoCivil, Genero, FechaNac, Email, Direccion) "
              + values;


        try {
            Connection con = _conexion.getConexion();         
                Statement st = con.createStatement();
                st.executeUpdate(values);
            return 1;

        } catch (SQLException e) {

            System.out.println(e.getMessage());
            return 0;

        } 
        
        
    }
    
    
    
    public ResultSet Select(String tabla) {
        String script = String.format("select * from %s", tabla);
        Connection con = _conexion.getConexion();

        try {
            Statement s1 = con.createStatement();
            ResultSet rs = s1.executeQuery(script);
            return rs;
        } catch (SQLException e) {
            return null;
        }
    }

}
