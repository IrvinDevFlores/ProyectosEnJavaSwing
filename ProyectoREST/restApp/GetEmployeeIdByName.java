/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ariel
 */
public class GetEmployeeIdByName {
    
    public String Query(String input){
        
        String identityKey = "";
        final String sql = new QueryBuilder.Builder()
                .Select()
                .WithColumn("EmployeeId")
                .WithColumn("FirstName")
                .From("employees")
                .WhereMatchString("FirstName", input)
                .Build().MakeQuery();

        try {
            final Connection con = new Conexion().getConexion();
            final Statement s1 = con.createStatement();
            final ResultSet rs = s1.executeQuery(sql);
            while (rs.next()) {

                identityKey = rs.getString("EmployeeId");
            }
            con.close();
        } catch (final SQLException exp) {
            JOptionPane.showMessageDialog(null, "" + exp, "", 0);
            System.exit(0);
        }
        
        return identityKey;
    }
    
}
