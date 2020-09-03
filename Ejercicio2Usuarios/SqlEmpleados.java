 

public class SqlEmpleados {

    
    public static String LISTAR = "select * from tbl_empleado";
    public static String REGISTRAR = "insert into tbl_empleado(EmpleadoId,Nombre,Apellido,Usuario,Clave,Estado) "    
                        + " values(?,?,?,?,?,?)";
    
    public static String ACTUALIZAR = "update tbl_empleado set  Nombre = ?, Apellido = ?, Usuario = ?, Clave = ?, Estado = ? where EmpleadoId = ?";
    
    public static String ACTUALIZAR_ESTADO = "update tbl_empleado set Estado = ? where EmpleadoId = ?";
    
    public static String LISTAR_ACTIVOS = "select * tbl_empleado  where Estado = ?";
}
