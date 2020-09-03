package futbolprueba;

/**
 *
 * @author Ariel
 */
import java.io.*;
import javax.swing.JOptionPane;

public class Archivo {

    String nombre;

    public Archivo(String nombArch)//Constructor
    {
        try {
            File app = new File(nombArch);
            nombre = app.getCanonicalPath();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "No se Encuentra Archivo de Fallas");
        }

    }

    public void guardarStringPorID(int index, String lineaForChange) {
        try {
            String filas[] = toString().split("\n");
            PrintWriter file = new PrintWriter(nombre);
            file.flush();
            for (int i = 0; i < filas.length; i++) {
                if (index == i) {
                    file.write(lineaForChange);
                    file.println();
                    return;
                }

                file.write(filas[i]);
                file.println();
            }
        } catch (FileNotFoundException e) {
        }
    }

    public String ToString()//Retorna todo el archivo en una sola cadena
    {
        String cadena = "";
        FileReader entrada = null;
        StringBuilder str = new StringBuilder();
        try {
            entrada = new FileReader(nombre);
            int c;
            while ((c = entrada.read()) != -1) {
                cadena += (char) c;
            }
        } catch (IOException ex) {
            System.out.println("Error al Cargar");
        }

        return cadena;
    }

    public void guardarstring(String ultima) throws IOException {//Guarda una nueva linea
        String lineas[] = ToString().split("\n");
        PrintWriter g = new PrintWriter(nombre);
        g.flush();
        for (int i = 0; i <= lineas.length - 1; i++) {
            //System.out.println(lineas[i]);
            g.write(lineas[i]);
            g.println();
        }
        g.write(ultima);
        g.println();
        g.close();
    }

    public void guardararreglo(String lineas[]) throws IOException {//Guarda un nuevo arreglo
        //String lineas[]=TraeLineas();
        PrintWriter g = new PrintWriter(nombre);
        g.flush();
        for (int i = 0; i <= lineas.length - 1; i++) {
            //System.out.println(lineas[i]);
            g.write(lineas[i]);
            g.println();
        }
        //g.write(ultima);
        //g.println();
        g.close();
    }
}
