package Persistence;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

public class SalariosDeEmpleados extends JDialog implements ActionListener, MouseListener {
   
    DefaultTableModel model;
    JTable tabla;
    JLabel lbltotal;
    JButton btnagregar;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    String columnas[] = { "Identidad","Empleado", "Salario" };

    public static void main(String args[]) {
        
         Connection con = new Conexion().getConexion();
        if(con == null){
                    
        
            final String[] data = LectorDeArchivos.ExtractConfig();

                Config config = LectorDeArchivos.GetUserConfig(data);
                
              new DbManagerForm(config).setVisible(true);
            return;
        }
        
        new  SalariosDeEmpleados().setVisible(true);
    }

    public SalariosDeEmpleados(){
        setTitle("Salarios de empleados");
        setFrame();
        setSize(800, 700);
        setVisible(true);
    }

    public void setFrame() {
        getContentPane().setLayout(null);

        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) 
            {
                return false;
            }
        };

        // Agregar las columnas al Model
        for (int i = 0; i < columnas.length; i++)
            model.addColumn(columnas[i]);

        tabla = new JTable(model);

        tabla.addMouseListener(this);

        // Redimensionar las columnas del Model
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(50);
        columnModel.getColumn(1).setPreferredWidth(150);
        columnModel.getColumn(2).setPreferredWidth(250);

        JScrollPane scr = new JScrollPane(tabla);
        scr.setBounds(10, 80, 700, 500);
        getContentPane().add(scr);

        lbltotal = new JLabel();
        lbltotal.setBounds(400, scr.getY() + scr.getHeight(), 120, 20);
        getContentPane().add(lbltotal);

        FillTable();
        totalizar();

    }

    public void mouseClicked(MouseEvent evt) {

        if (evt.getSource() == tabla) 
        {
            ChangeSalary();
        }
    }

    public void ChangeSalary(){
        int fila = tabla.getSelectedRow();
        int col = tabla.getSelectedColumn();
        if (col == 0) {

            int preferedColumn = 2;

            int nuevoSalario = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la Nueva Cantidad"));
            
            model.setValueAt(decimalFormat.format(nuevoSalario), fila, preferedColumn);
            
            String id =  model.getValueAt(fila, col).toString();

            final String joinQuery = new QueryBuilder.Builder()
                    .UpdateTable("tbl_emp_salarios")
                    .Set("emp_identidad",id)
                    .Set("emp_salario", nuevoSalario)
                    .WhereMatchString("emp_identidad",id )
                        .Build()
                        .MakeQuery();
 
        final boolean joinQueryFailed = !SqlCommandWritter.WriteCommand(joinQuery);
        
        if (joinQueryFailed) 
        {
            JOptionPane.showMessageDialog(null, "fallo insertar");
            return;
        }
        } else {
                model.removeRow(fila);
        }
        
    }

    public void mousePressed(MouseEvent evt) {
    }

    public void mouseReleased(MouseEvent evt) {
    }

    public void mouseEntered(MouseEvent evt) {
    }

    public void mouseExited(MouseEvent evt) {
    }


    private static String identity = "";
    public void FillTable(){
        String sql = "select concat_ws(' ',empleado.emp_pnombre,empleado.emp_snombre, empleado.emp_papellido,empleado.emp_sapellido) as nombre , ";
        sql += " emp.emp_salario salario, emp.emp_identidad from tbl_emp_salarios emp ";
        sql += "join tbl_empleado empleado on empleado.emp_identidad = emp.emp_identidad";

                  try {
                      final Connection con = new Conexion().getConexion();
                      final Statement s1 = con.createStatement();
                      final ResultSet rs = s1.executeQuery(sql);
                      while (rs.next()) 
                      { 
                                model.addRow(new String[] 
                                {   rs.getString("emp_identidad"),
                                    rs.getString("nombre"),
                                    rs.getString("salario")+""
                                 }); 
            
                      }
                      con.close();
            
            
                  } catch (final Exception exp) {
                      JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
                      System.exit(0);
                  }
    }

    public void actionPerformed(ActionEvent evt) {

        if (evt.getSource() == btnagregar) {

        }
    }

    public void totalizar() {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            String pt = model.getValueAt(i, 2) + "";
            total += Double.parseDouble(pt);
        }
        
            JOptionPane.showMessageDialog(null,total);
        lbltotal.setText(decimalFormat.format(total));
    }
}