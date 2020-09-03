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

class Reporte2
{
    public Reporte2(String reportName){
        
        con = new Conexion().getConexion();
        try
        {
            File app=new File(reportName);
            String fileName=app.getCanonicalPath();
            URL urlMaestro = getClass().getResource(reportName);
            
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(fileName);
            JasperPrint jasperPrint = null;
            jasperPrint= JasperFillManager.fillReport(masterReport,null, con);
            
            JRViewer jrv = new JRViewer(jasperPrint);

            if(jasperPrint.getPages().isEmpty()==false)
            {
                new Visor_Reportes(jrv,"... Vista de Reporte");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No hay datos");
            }
        }
        catch (Exception j) 
        {
            JOptionPane.showMessageDialog(null,"Mensaje de Error:"+j,"Error en Reporte2",0);
            j.printStackTrace();
        }
    }
    
    Reporte2(String n,Map parameters, boolean b)
    {
        
        con = new Conexion().getConexion();
        try{ 
            File app=new File(n);
            String fileName=app.getCanonicalPath();         
            URL urlMaestro = getClass().getResource(n);
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);

            JasperPrint jasperPrint = null;
            jasperPrint= JasperFillManager.fillReport(masterReport,parameters,con);
            JasperViewer jviewer = new JasperViewer(jasperPrint,false); 
            if(jasperPrint.getPages().isEmpty()==false){
                //estado=true;
                // JasperPrintManager p = new JasperPrintManager(jasperPrint);
                // p.printReport(jasperPrint,b);
            }
            else {
                JOptionPane.showMessageDialog(null,"Reporte en Blanco, Revise su Consulta","Consulta Invalida",0);
                //estado=false;
            }

        } 
        catch (Exception j) { 
            JOptionPane.showMessageDialog(null,"Mensaje de Error:"+j.getMessage(),"Error en Reporte",0);
            j.printStackTrace(); 
        }
    }
    Connection con;
    public Reporte2(String Reporte2, Map parametros)
    {
        
        con = new Conexion().getConexion();
        try
        {
            URL urlMaestro = getClass().getResource(Reporte2);
            JasperReport masterReport = (JasperReport) JRLoader.loadObject(urlMaestro);
            JasperPrint jasperPrint = null;
            jasperPrint= JasperFillManager.fillReport(masterReport,parametros, con);
            JRViewer jrv = new JRViewer(jasperPrint);

            if(jasperPrint.getPages().isEmpty()==false)
            {
                new Visor_Reportes(jrv,"... Vista de Reporte");
            }
            else
            {
                JOptionPane.showMessageDialog(null,"No hay datos");
            }
        }
        catch (Exception j) 
        {
            JOptionPane.showMessageDialog(null,"Mensaje de Error:"+j,"Error en Reporte2",0);
            j.printStackTrace();
        }
    }

    public Reporte2(String fac,int i)
    {
        try{
                 Map parametros = new HashMap();
            
                parametros.put("sql","call trans("+fac+")");
               
                new Reporte2("reportesPrueba.jasper",parametros);
            //new Reporte2("rep_tabla_posicion.jasper",parametros);
        }
        catch(Exception exp){}
    }   
}


