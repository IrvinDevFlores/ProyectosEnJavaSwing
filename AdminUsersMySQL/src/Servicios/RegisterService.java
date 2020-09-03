/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servicios;


import DataLayer.Usuario;
import DataLayer.UsuarioRepositorio;
import java.sql.SQLException;

/**
 *
 * @author Ariel
 */
public class RegisterService implements IRegisterService
{

    @Override
    public boolean RegistrarSiNoExiste(Usuario user) throws SQLException,
            ClassNotFoundException 
    {
       UsuarioRepositorio repositorio = new UsuarioRepositorio();
       boolean sePuedoRegistrar = repositorio.Insert(user) == 1 ;
       return sePuedoRegistrar ;
    }
    
}
