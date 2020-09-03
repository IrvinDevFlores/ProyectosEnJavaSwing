package DataLayer;

public class SqlUsuarios {

    
    public static String LISTAR = "select * from tbl_user";
    public static String REGISTRAR = "insert into tbl_user(UsuarioId,Username,Password,Estado,Temp) "    
                        + " values(?,?,?,?,?)";
    
    public static String ACTUALIZAR = "update tbl_user set  Username = ?, Password = ?, Estado = ?, Temp = ? where UsuarioId = ?";
          
}
