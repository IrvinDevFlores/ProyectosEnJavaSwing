/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SqlDatabase;


import javax.swing.JOptionPane;

import java.sql.*;
public class main
{
    
    //Version 6 del workbench
   public static void main(String[] args) throws  Exception{
        
       Conexion con = new Conexion();
       if(con.ExistConnection()){
            JOptionPane.showMessageDialog(null,"Conexion establecida");
              ResultSet rs =   new SentenciasSql().Select("empleado");
            
            while(rs.next()) 
            {   
                int IdEmpleado = rs.getInt(1);
                String Cedula = rs.getString(2);
                String Nombre = rs.getString(3);
                String Apellido = rs.getString(4);
                String FechaNac = rs.getString(5);
                String NombreDeUsuario = rs.getString(6);
                System.out.println(IdEmpleado+" "+Cedula+" "
                +Nombre+" "+NombreDeUsuario);
            }
            
          
        }else{
            System.out.print("NO existe conexion");
        }
    }

}