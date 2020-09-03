/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
 

/**
 *
 * @author Ariel
 */
public class ArregloEmpleados
{
    public Empleado[] usuarios;

    public void setArreglo(Empleado... usuario)
    {
        this.usuarios = usuario;
    }

    public ArregloEmpleados(){
       usuarios  = new Empleado[0];
    }

    public void Insertar(Empleado usuario)
    {
        int nuevaDimension = usuarios.length + 1;
        Empleado[] temp = new Empleado[nuevaDimension];

        System.arraycopy(usuarios, 0, temp, 0, usuarios.length);

        int ultimaPosicion = temp.length - 1;
        temp[ultimaPosicion] = usuario;

        usuarios = temp;
        
    }

    public Empleado[] Borrar(Empleado usuarios[], int index)
    {
        if (usuarios == null
                || index < 0
                || index >= usuarios.length) {

            return usuarios;
        }

        Empleado[] anotherArray = new Empleado[usuarios.length - 1];

        for (int i = 0, k = 0; i < usuarios.length; i++) {

            if (i == index) { continue; }
            anotherArray[k++] = usuarios[i];
        }

        // return the resultant array
        return anotherArray;
    }

    public Empleado[] ObtenerTodos()
    {
        return usuarios;
    }

    public String ToString()
    {
        String filaEmpleados  = "";

        for (Empleado usuario : usuarios) {
            filaEmpleados += String.format("%s;%s;%s;%s;%s;%s;", usuario.EmpleadoId,
                usuario.Nombre,usuario.Apellido, usuario.Username,usuario.Clave,usuario.Estado)+"\n";
        }
        return filaEmpleados;
    }

    public void OrdenarAscendente(Empleado[] arreglo)
    {
        Empleado temp = null;

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

    public Empleado[] Redefinir(Empleado... list)
    {
        Empleado temp[] = new Empleado[list.length + 1];
        System.arraycopy(list, 0, temp, 0, list.length);
        return temp;
    }
}
