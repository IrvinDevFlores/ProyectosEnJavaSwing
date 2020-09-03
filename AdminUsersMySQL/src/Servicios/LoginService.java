/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DataLayer.Usuario;
import java.sql.SQLException;


public class LoginService implements ILoginService {
    
    IServicioVerificacion _servicio;
    public LoginService(ServicioVerificacion servicio) 
    {
        _servicio = servicio;
    }
    
    public LoginService(){}

    @Override
    public boolean Login(Usuario user)throws SQLException,
            ClassNotFoundException  {
        
         return _servicio.ValidarCredenciales(user);
       
    }
    
}
