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
public class Cliente {
   public int IdCliente;
   public String NoCedula;
   public String Nombres;
   public String Apellidos;
   public EstadoCiv EstadoCivil;
   public String Email;
   public String Direccion;
   public String FechaNac;
   public Sexo Sexo;
   
   public String ToString(){
       return String.format("%d;%s;%s;%s;%s;%s;%s;%s;%s;",IdCliente,
                  NoCedula,Nombres,Apellidos,EstadoCivil.Nombre,
                  Sexo.Nombre, FechaNac ,Email , Direccion );
   }
   
   public Cliente(){
       Sexo = new Sexo();
       EstadoCivil = new EstadoCiv();
   }
}
