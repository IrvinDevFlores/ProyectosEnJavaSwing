/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;

import DataLayer.Usuario;
import java.sql.SQLException;

/**
 *
 * @author Ariel
 */
public interface IRegisterService 
{
    public boolean RegistrarSiNoExiste(Usuario user)throws SQLException,
            ClassNotFoundException ;
    
}
