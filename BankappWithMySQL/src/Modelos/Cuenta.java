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
public class Cuenta {
    public int IdCuenta;
    public String NoCuenta;
    public String NombreCliente;
    public TipoCuenta TipoCuenta;
    public String FechaCreacion;
    public double SaldoApertura;
    public double SaldoActual;
    
    
    public String ToString(){
        return  String.format("%d;%s;%s;%s;%s;%.2f;%.2f;",IdCuenta,NoCuenta,NombreCliente,TipoCuenta.Nombre,FechaCreacion,
                  SaldoApertura,SaldoActual);
    }
    public Cuenta(){
        TipoCuenta = new TipoCuenta();
    }
}
