/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataLayer;

/**
 *
 * @author Ariel
 */
public class ArregloUsuario
{
    public Usuario[] usuarios;

    public void setArreglo(Usuario... usuario)
    {
        this.usuarios = usuario;
    }

    public ArregloUsuario(){
       usuarios  = new Usuario[0];
    }

    public void Insertar(Usuario usuario)
    {
        int nuevaDimension = usuarios.length + 1;
        Usuario[] temp = new Usuario[nuevaDimension];

        System.arraycopy(usuarios, 0, temp, 0, usuarios.length);

        int ultimaPosicion = temp.length - 1;
        temp[ultimaPosicion] = usuario;

        usuarios = temp;
        
    }

    public Usuario[] Borrar(Usuario usuarios[], int index)
    {
        if (usuarios == null
                || index < 0
                || index >= usuarios.length) {

            return usuarios;
        }

        Usuario[] anotherArray = new Usuario[usuarios.length - 1];

        for (int i = 0, k = 0; i < usuarios.length; i++) {

            if (i == index) { continue; }
            anotherArray[k++] = usuarios[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public Usuario[] ObtenerTodos()
    {
        return usuarios;
    }

    public String ToString()
    {
        String filaEmpleados  = "";

        for (Usuario usuario : usuarios) {
            filaEmpleados += String.format("%20s %20s %20s %40s  %20s", 
                    usuario.IdUsuario, usuario.UserName, usuario.Pass, usuario.Estado, usuario.Temp) + "\n";
        }
        return filaEmpleados;
    }

    public void OrdenarAscendente(Usuario[] arreglo)
    {
        Usuario temp = null;

        /*for(int i = 0; i < arreglo.length -1; i++)
        {
            for(int j = 0; j < arreglo.length  - 1; j++)
            {
                double primero = arreglo[j].CalcularISR();
                double segundo = arreglo[j +1].CalcularISR();
                if(primero<segundo){
                    temp = arreglo[j + 1];
                    arreglo[j + 1]  = arreglo[j];
                    arreglo[j]  = temp;
                    usuarios = arreglo;
                }
            }
        }*/

    }

    public boolean EstaVacio()
    {
        return usuarios.length == 0;
    }

    public Usuario[] Redefinir(Usuario... list)
    {
        Usuario temp[] = new Usuario[list.length + 1];
        System.arraycopy(list, 0, temp, 0, list.length);
        return temp;
    }
}
