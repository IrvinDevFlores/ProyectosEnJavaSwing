
public class Proveedor extends Object implements ComboBoxEntity
{
    public int IdProveedor;
    public String NombreProveedor;
    
    public Proveedor(int idProve, String nombre){
        IdProveedor = idProve;
        NombreProveedor = nombre;
    }
    
    public String GetItemName(){
        return NombreProveedor;
    }
    
    public int GetItemId()
    {return IdProveedor;}
}
