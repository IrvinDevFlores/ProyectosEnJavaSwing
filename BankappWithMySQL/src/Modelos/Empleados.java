/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelos;

/**
 *
 * @author Ariel
 */
public class Empleados {
 
    public String IdEmpleado;
    public String Nombre;
    public String Apellidos;
    public String Cedula;
    public String TipoUsuario;
    
    public Empleados()
    {
        
    }
    
       public String ToString(){
       return String.format("%s;%s;%s;%s;%s;%s;",IdEmpleado,
                  Nombre,Apellidos,Apellidos,Cedula,TipoUsuario );
   }
}
