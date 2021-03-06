
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperPrintManager;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JRViewer;
import net.sf.jasperreports.view.JasperViewer;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperCompileManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.KeyStroke;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.HashMap;
import java.net.URL;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

class Visor_Reportes extends JDialog
{

    
    public static void main(String... args){
        
    }
    
    public Visor_Reportes(JRViewer jrv, String str)
    {
        super(new JFrame(), str, true);
        con = new Container();
        java.awt.Image icon = Toolkit.getDefaultToolkit().getImage("Images/food.gif");
        setIconImage(icon);
        getContentPane().setLayout(null);
        getContentPane().setBackground(Color.white);
        setModal(true);

        Dimension pantalla = Toolkit.getDefaultToolkit().getScreenSize();
        jrv.setPreferredSize(new Dimension(pantalla.width - 120, pantalla.height - 150));
        JScrollPane reportScroll = new JScrollPane(jrv);
        JPanel viewer = new JPanel();
        
        viewer.add(jrv);
        addWindowListener(new WindowAdapter() {

                public void windowOpened(WindowEvent windowevent)
                {
                }

                public void windowClosing(WindowEvent e)
                {
                    dispose();
                }
            }
        );
        viewer.setBounds(10, 10, pantalla.width - 100, pantalla.height);
        getContentPane().add(viewer);
        setSize(new Dimension(pantalla.width - 50, pantalla.height - 50));
        setJMenuBar(menu());
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JMenuBar menu()
    {
        JMenu menuArchivo = new JMenu("ARCHIVO");
        menuArchivo.setMnemonic('A');
        menuArchivo.setBackground(Color.WHITE);
        JMenuItem exit = new JMenuItem("Salir", new ImageIcon("Imagenes/exit.jpg"));
        exit.setMnemonic('S');
        exit.setAccelerator(KeyStroke.getKeyStroke(115, 8));
        exit.setAccelerator(KeyStroke.getKeyStroke(27, 0));
        exit.setBackground(Color.WHITE);
        exit.addActionListener(new ActionListener() {

                public void actionPerformed(ActionEvent e)
                {
                    dispose();
                }
            }
        );
        menuArchivo.add(exit);
        JMenuBar barra = new JMenuBar();
        barra.setBackground(Color.WHITE);
        barra.add(menuArchivo);
        return barra;
    }

    JLabel muestra;
    JButton Ok;
    Dimension cuadro;
    Container con;
}