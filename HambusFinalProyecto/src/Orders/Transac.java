/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Orders;

/**
 *
 * @author Ariel
 */
public class Transac {
    public String TransacId;
    public String Producto;
    public int ProductoId;
    public double Cantidad;
    public double PrecioUnitario;
    public double Descuento;
    public double PrecioTotal;
    
    public void GetTotal(){
        PrecioTotal = Cantidad * PrecioUnitario;
    }
}
