package Persistence;

import java.awt.HeadlessException;
import java.io.*;
import javax.swing.JOptionPane;

public class LectorDeArchivos {
    String nombre;

    public LectorDeArchivos(String nombArch)// Constructor
    {
        File app = new File(nombArch);
        nombre = app.getPath();
            
    }

    public static void RemplaceLine(Config config) {

        try {

            try (FileWriter fileOut = new FileWriter(USER_TXT)) {
                fileOut.write("");
            }

            LectorDeArchivos lector = new LectorDeArchivos(USER_TXT);
            String full = config.GetString();

            lector.guardarstring(full);

            JOptionPane.showMessageDialog(null, "Cambios guardados");

        } catch (HeadlessException | IOException e) {
                  
              JOptionPane.showMessageDialog(null,"No se pudo guardar");
        }
    }

    public static Config GetUserConfig(String[] data) {
        Config config = new Config();
        for (String data1 : data) 
        {
            final String[] usersData = data1.split(";");
            config.DbLocation = usersData[0];
            config.DbName = usersData[1];
            config.Usuario = usersData[2];
            config.Pass = usersData[3];
        }
        return config;
    }

    private static final String USER_TXT = "dbconfig/db.txt";

    public static String[] ExtractConfig() 
    {

        final LectorDeArchivos archivo = new LectorDeArchivos(USER_TXT);

        final String usuariosInString = archivo.ToString();

        final String[] data = usuariosInString.split("\n");

        return data;
    }

    public String ToString()// Retorna todo el archivo en una sola cadena
    {
        String cadena = "";
        FileReader entrada = null;

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

    public void guardarstring(String ultima) throws IOException {
        String lineas[] = ToString().split("\n");
        PrintWriter g = new PrintWriter(nombre);
        g.flush();
        for (int i = 0; i <= lineas.length - 1; i++) {
            // System.out.println(lineas[i]);

            g.write(lineas[i]);

        }
        g.write(ultima);

        g.close();
    }

    public void guardararreglo(String lineas[]) throws IOException {
        try ( // String lineas[]=TraeLineas();
                PrintWriter g = new PrintWriter(nombre)) {
            g.flush();
            for (int i = 0; i <= lineas.length - 1; i++) {
                // System.out.println(lineas[i]);
                g.write(lineas[i]);
                g.println();
            }
            // g.write(ultima);
            // g.println();
        }
    }

    public boolean bus_linea(String arch, String buslinea) {
        String arr[] = new LectorDeArchivos(arch).toString().split("\n");
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].trim().equals(buslinea))
                return true;
        }
        return false;
    }
}