
import java.io.*;
import javax.swing.JOptionPane;

public class LectorDeArchivos {
    String nombre;

    public LectorDeArchivos(String nombArch)// Constructor
    {
        try {
            File app = new File(nombArch);
            nombre = app.getCanonicalPath();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "No se Encuentra Archivo de Fallas");
        }

    }

    public static void RemplaceLine(Config config) {

        try {

            FileWriter fileOut = new FileWriter(usersTxt);
            fileOut.write("");
            fileOut.close();

            LectorDeArchivos lector = new LectorDeArchivos(usersTxt);
            String full = config.GetString();

            lector.guardarstring(full);

            JOptionPane.showMessageDialog(null, "Cambios guardados");

        } catch (Exception e) {
                  
              JOptionPane.showMessageDialog(null,"No se pudo guardar");
        }
    }

    public static Config GetUserConfig(String[] data) {
        Config config = new Config();
        for (int i = 0; i < data.length; i++) {
            final String usersData[] = data[i].split(";");

            config.DbLocation = usersData[0];
            config.DbName = usersData[1];
            config.Usuario = usersData[2];
            config.Pass = usersData[3];

        }
        return config;
    }

    private static String usersTxt = "dbconfig/db.txt";

    public static String[] ExtractConfig() {

        final LectorDeArchivos archivo = new LectorDeArchivos(usersTxt);

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
        } catch (Exception ex) {
            System.out.println("Error al Cargar");
        }

        return cadena;
    }

    public void guardarstring(String ultima) throws IOException {// Guarda una nueva linea
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
        // String lineas[]=TraeLineas();
        PrintWriter g = new PrintWriter(nombre);
        g.flush();
        for (int i = 0; i <= lineas.length - 1; i++) {
            // System.out.println(lineas[i]);
            g.write(lineas[i]);
            g.println();
        }
        // g.write(ultima);
        // g.println();
        g.close();
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