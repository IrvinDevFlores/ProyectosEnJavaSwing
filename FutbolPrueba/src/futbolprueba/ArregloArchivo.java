/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package futbolprueba;

public class ArregloArchivo {

    String arr[];

    public ArregloArchivo() {
        arr = new String[0];
    }

    public void agregar(String n) {
        String tmp[] = new String[arr.length + 1];
        for (int i = 0; i < arr.length; i++) {
            tmp[i] = arr[i];
        }
        arr = tmp;
    }

    public String ret_info_S(String arch, int busindice, int retindice, String bus) {
        arr = new Archivo(arch).ToString().split("\n");
        for (String arr1 : arr) {
            String[] inter = arr1.split(";");
            if (inter[busindice].equalsIgnoreCase(bus)) {
                return inter[retindice];
            }
        }
        return "";
    }

    public boolean bus_linea(String arch, String buslinea) {
        arr = new Archivo(arch).ToString().split("\n");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].trim().equals(buslinea)) {
                return true;
            }
        }
        return false;
    }
}
