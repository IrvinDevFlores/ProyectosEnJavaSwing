
package DataLayer;

public class Usuario {
    public int IdUsuario;
    public String UserName;
    public String Pass;
    public boolean Estado;
    public boolean Temp;
    
    public Usuario(){}
    
    public String ToString()
    {
       return String.format("%s;%s;%s;%s;",IdUsuario,
                  UserName,Pass,Estado);
    }
}
