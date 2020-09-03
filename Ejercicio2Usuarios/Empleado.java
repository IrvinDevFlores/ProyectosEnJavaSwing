
 

public class Empleado {
    public int EmpleadoId;
    public String Nombre;
    public String Apellido;
    public String Username;
    public String Clave;
    public boolean Estado;

    public Empleado(){}
    
    public String ToString()
    {
       return String.format("%s;%s;%s;%s;%s;%s;",EmpleadoId,
                Nombre,Apellido, Username,Clave,Estado);
    }
}
