package Persistence;

import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JComboBox;
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

public class ValorDeducciones extends JDialog implements ActionListener,
 MouseListener {

    DefaultTableModel model;
    JTable tabla;
    JLabel lbltotal;
    JButton btnagregar;
    DecimalFormat decimalFormat = new DecimalFormat("0.00");
    
 
        private javax.swing.JButton AgregarButton;
    private javax.swing.JComboBox<String> DeduccionIdCombobox;
    private javax.swing.JComboBox<String> DeduccionesCombobox;
    private javax.swing.JComboBox<String> EmpleadoIdCombobox;
    private javax.swing.JComboBox<String> EmpleadosCombobox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    
    String columnas[] = { "Cedula","Empleado","Salario", "Deduccion", "Valor" };

    public static void main(String args[]) {
        ValorDeducciones valorDeducciones = new ValorDeducciones();
    }

    
    
    Llenado llenadorDeCombobox;
    public ValorDeducciones() {
        setTitle("Valor de deducciones");
        setFrame();
        setSize(800, 700);
        
        setVisible(true);
        
        llenadorDeCombobox = new Llenado();
        
        String getEmpleadosQuery = new QueryBuilder.Builder()
                    .Select()
                        .WithColumn("emp_identidad")
                           .WithColumn("emp_pnombre")
                               .From("tbl_empleado")
                                        .Build()
                                            .MakeQuery();
        
        llenadorDeCombobox.llenar_combo(getEmpleadosQuery, 
                    EmpleadoIdCombobox ,  EmpleadosCombobox);
        
        QueryBuilder queryBuilder = new QueryBuilder.Builder()
                                    .Select()
                                         .WithColumn("ded_codigo")
                                        .WithColumn("ded_nombre")
                                            .From("tbl_deduccion")
                                                .Build();
                    
        String getDeduccionesQuery = queryBuilder.MakeQuery();
        
        llenadorDeCombobox.llenar_combo(getDeduccionesQuery, 
                    DeduccionIdCombobox ,  DeduccionesCombobox);            
        
    }

    public void setFrame() {
        getContentPane().setLayout(null);
      
             jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        EmpleadosCombobox = new javax.swing.JComboBox<>();
        DeduccionesCombobox = new javax.swing.JComboBox<>();
        AgregarButton = new javax.swing.JButton();
        EmpleadoIdCombobox = new javax.swing.JComboBox<>();
        DeduccionIdCombobox = new javax.swing.JComboBox<>();

        jLabel1.setText("Empleado");

        jLabel2.setText("Deduccion");

        AgregarButton.setText("Agregar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(DeduccionesCombobox, 0, 135, Short.MAX_VALUE)
                    .addComponent(EmpleadosCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(EmpleadoIdCombobox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(DeduccionIdCombobox, javax.swing.GroupLayout.Alignment.TRAILING, 0, 135, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addComponent(AgregarButton)
                .addContainerGap(103, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(EmpleadoIdCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(EmpleadosCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(14, 14, 14)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(DeduccionesCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addComponent(AgregarButton)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeduccionIdCombobox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(272, Short.MAX_VALUE))
        );
       
        DeduccionIdCombobox.setVisible(false);
        EmpleadoIdCombobox.setVisible(false);
        
        setFocusable(true);
        

        EmpleadosCombobox.addActionListener(this);
        DeduccionesCombobox.addActionListener(this);
        AgregarButton.addActionListener(this);

        
        
        InitTable();
         pack();
    }
    
    
    public void InitTable()
    {
        
        tabla = new JTable();
        
       getContentPane().add(tabla);
        model = new DefaultTableModel() {
            public boolean isCellEditable(int row, int column) 
            {
                return false;
            }
        };

        // Agregar las columnas al Model
        for (int i = 0; i < columnas.length; i++)
            model.addColumn(columnas[i]);

        tabla.setModel(model);

        tabla.addMouseListener(this);

        // Redimensionar las columnas del Model
        TableColumnModel columnModel = tabla.getColumnModel();
        columnModel.getColumn(0).setPreferredWidth(150);
        columnModel.getColumn(1).setPreferredWidth(210);
        columnModel.getColumn(2).setPreferredWidth(150);
        columnModel.getColumn(3).setPreferredWidth(210);
        columnModel.getColumn(4).setPreferredWidth(150);
        JScrollPane scr = new JScrollPane(tabla);
        scr.setBounds(60, 200, 600, 500);
        getContentPane().add(scr);



        FillTable();
      
    }
    public void mouseClicked(MouseEvent evt) {

        if (evt.getSource() == tabla) 
        {
            ChangeSalary();
        }
    }

    public void ChangeSalary()
    {
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


    public void FillTable(){


        String sql = "select e.emp_identidad identidad, ";
        sql += "concat(e.emp_pnombre, ' ', e.emp_snombre,' ', e.emp_papellido,' ', e.emp_sapellido) as nombre, ";
        sql += "es.emp_salario as salario, ";
        sql += "d.ded_nombre as deduccion, ";
        sql += "case d.ded_forma ";
        sql += "when 'MON' then ed.valor ";
       sql += "when 'POR' then round(es.emp_salario * (ed.valor/100),2) ";
        sql += "end as valor ";
        sql += "from tbl_deduccion_empleado ed ";
        sql += "join tbl_empleado e on e.emp_identidad = ed.identidadEmpleado ";
       sql += "join tbl_deduccion d on d.ded_codigo = ed.codigoDeduccion ";
        sql += "join tbl_emp_salarios es on es.emp_identidad = e.emp_identidad ";
        sql += "where e.emp_estado in ('activo') ";
        sql += "order by ed.identidadEmpleado, d.ded_codigo ";

              try {
                  final Connection con = new Conexion().getConexion();
                  final Statement s1 = con.createStatement();
                  final ResultSet rs = s1.executeQuery(sql);
                  while (rs.next()) 
                  { 
                            model.addRow(new String[] 
                            {    rs.getString("identidad"),
                                rs.getString("nombre"),
                                rs.getString("salario"),
                                rs.getString("deduccion")+"",
                                rs.getString("valor")
                             }); 
        
                  }
                  con.close();
        
        
              } catch (final Exception exp) {
                  JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
                  System.exit(0);
              }
    }


    static int id;
    public void AddComboboxAction(ActionEvent evt, JComboBox comboData, 
                                     JComboBox comboId)
    {
        if (evt.getSource() == comboData) {
                
            boolean isNotFirst = comboData.getSelectedIndex() != 0;
            
            if (isNotFirst) {
                int indexEmpleado = comboData.getSelectedIndex();
                comboId.setSelectedIndex(indexEmpleado);
              // JOptionPane.showMessageDialog(null,comboId.getSelectedItem().toString());

            }
        }
    }

    public void AddButtonAction(ActionEvent evt, JButton button)
    {
            
        if(evt.getSource() == button)
        {

            
            Deduccion empleado = GetInputData();
            String select = "select ded_codigo,ded_forma from tbl_deduccion ";
            select += "where ded_codigo = "+empleado.DeduccionId+"";


            String deducType = "";
            
            try
             {
                final Connection con = new Conexion().getConexion();
                final Statement s1 = con.createStatement();
                final ResultSet rs = s1.executeQuery(select);
                while (rs.next()) {
                    deducType = rs.getString("ded_forma");
                }
                con.close();
    
                
                } catch (final Exception exp) {
                    JOptionPane.showMessageDialog(null, "" + exp, "Error Llenando ComboBox", 0);
                    System.exit(0);
                }



            QueryBuilder queryBuilder = null;

            double v = 0;
            if(deducType.equals("POR")){
               
            int input = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el porcentaje(%) de deduccion: "));
                v = input / 100.0;
             
            }
           

            if(deducType.equals("MON")){
                 
            int input = Integer.parseInt(JOptionPane.showInputDialog(null,"Ingrese el monto de deduccion: "));
                v = input ;
            }
           
            
            queryBuilder = new QueryBuilder.Builder()
                            .Insert("tbl_deduccion_empleado")
                            .Column("identidadEmpleado", empleado.EmpleadoId)
                            .Column("codigoDeduccion", empleado.DeduccionId)
                            .Column("valor",""+ v )
                            .Execute()
                            .Build();
            

         String joinQuery = queryBuilder.MakeQuery();
 
         boolean joinQueryFailed = !SqlCommandWritter.WriteCommand(joinQuery);
        
            if (joinQueryFailed) 
            {
                JOptionPane.showMessageDialog(null, "fallo insertar");
                return;
            }

            InitTable();
        }
        
    }
    
    public Deduccion GetInputData()
    {
        
        String empleadoId = EmpleadoIdCombobox.getSelectedItem().toString();
        int codigoDeduccion = Integer.parseInt( DeduccionIdCombobox.getSelectedItem().toString());

        Deduccion deduccion = new Deduccion(){
            {
                EmpleadoId = empleadoId;
                DeduccionId = codigoDeduccion;
            }
        };
        return deduccion;
    }

    public void actionPerformed(ActionEvent evt) 
    {

            AddButtonAction(evt, AgregarButton);
            AddComboboxAction(evt, DeduccionesCombobox, DeduccionIdCombobox);
            AddComboboxAction(evt, EmpleadosCombobox, EmpleadoIdCombobox);
    }

    public void totalizar() 
    {
        double total = 0;
        for (int i = 0; i < model.getRowCount(); i++) {
            String pt = model.getValueAt(i, 2) + "";
            total += Double.parseDouble(pt);
        }
       

    }
}