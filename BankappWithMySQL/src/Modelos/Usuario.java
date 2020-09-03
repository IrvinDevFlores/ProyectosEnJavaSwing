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
public class Usuario {
    public int IdUsuario;
    public String UserName;
    public String Pass;
    public String Estado;
    
    public Usuario(){
        
    }
    
       public String ToString(){
       return String.format("%s;%s;%s;%s;",IdUsuario,
                  UserName,Pass,Estado );
   }
}
