import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.plaf.basic.*; 
public class Llenado

{
    public void insertar(String sql)
    {
        try
        {
            Connection con=new Conexion().getConexion();
            Statement s1=con.createStatement();
            s1.execute(sql);
            con.close();
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null,""+exp,"Error Al Insertar en BD",0);System.exit(0);
        }
    }
    
    public JComboBox FillCombobox(String sql)
    {
        
         Vector model = new Vector();
        
        model.addElement("");
        
   
        JComboBox cmb = null;
        try
        {
            Connection con=new Conexion().getConexion();
            Statement s1=con.createStatement();
            ResultSet rs=s1.executeQuery(sql);
            while(rs.next())
            {
                
                model.addElement(new Proveedor(rs.getInt(1),rs.getString(2)));
                
            }
            
        
        cmb.setRenderer(new ItemRenderer());
            con.close();
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null,""+exp,"Error Llenando ComboBox",0);System.exit(0);
        }
        cmb.setSelectedIndex(0);
        
        return cmb;
    }
    
    public void llenar_combo(String sql, JComboBox cmb, JComboBox cmbi)
    {
        cmb.removeAllItems();
        cmbi.removeAllItems();
        
        cmb.addItem("");
        cmbi.addItem("");
        try
        {
            Connection con=new Conexion().getConexion();
            Statement s1=con.createStatement();
            ResultSet rs=s1.executeQuery(sql);
            while(rs.next())
            {
                cmbi.addItem(rs.getInt(1));
                cmb.addItem(rs.getString(2));
            }
            con.close();
            cmb.setSelectedIndex(0);
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null,""+exp,"Error Llenando ComboBox",0);System.exit(0);
        }
        cmb.setSelectedIndex(0);
    }
}