
/**
 * Write a description of class SqlQueries here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class SqlQueries
{
    
    public static String Registrar(){
        String query = "insert into provedores(NombreProveedor,DireccionProveedor,TelefonoProveedor,PaginaWebProveedor,Estado) "    
                        + " values('Pepsi','La ponce','+50432433494','www.pepsi.com', 'Activo')";
                        
        return query;
    }
    
       public static String Get(String table){
        String query = "select UsuarioCodigo, UsuarioClave, UsuarioEstado from "+table;
                        
        return query;
    }
    
     public static final String ACTUALIZAR = "update provedores set  NombreProveedor = 'Cocacola', DireccionProveedor = 'Sps', TelefonoProveedor = '+50498989565', PaginaWebProveedor = 'Cocacola.com', Estado = 'Activo' where CodigoProveedor = 1";
       
}
