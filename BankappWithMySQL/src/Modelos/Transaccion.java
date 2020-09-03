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
public class Transaccion {
    public int IdTransacion;
    public String   CuentaAfectada;
    public String FechaOperacion;
    public TipoOperacion tipoOperacion;
    public String Descripcion;
    public String CodigoOperacion;
    public String NombreCliente;
    public double  SaldoAnterior;
    public double Importe;
    public double SaldoNuevo;
    public Agencia agencia;
    public String NombreBanco;
    
    
      public String ToString(){
       return String.format("%d;%s;%s;%s;%s;%s;%s;%.1f;%.1f;%.1f;%s;%s;",
               IdTransacion, CuentaAfectada,FechaOperacion,tipoOperacion.Nombre,Descripcion,CodigoOperacion,
                  NombreCliente, SaldoAnterior ,Importe , SaldoNuevo,agencia.Nombre, NombreBanco );
   }
    
    public Transaccion(){
         tipoOperacion = new TipoOperacion();
        agencia = new Agencia();
    }
}
