
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JCalendar;
import java.util.GregorianCalendar;

public class EjemploJCalendar extends JDialog implements ActionListener {

    JDateChooser chooser = new JDateChooser();
    JCalendar calendario = new JCalendar();
    JButton btnmostrar, showDateButton;

    public static void main(String args[]) {
        new EjemploJCalendar();
    }
    
    public void Disable(boolean f){
        chooser.setEnabled(f);
    }

    public EjemploJCalendar() {
        setTitle("Ejemplo de JCalendar");
        setFrame();
        //setSize(600, 600);
        //setVisible(true);
    }

    public void setFrame() {
        getContentPane().setLayout(null);
        Calendar c = Calendar.getInstance();
        int dia = (c.get(Calendar.DATE));
        int mes = (c.get(Calendar.MONTH));
        int anio = (c.get(Calendar.YEAR));


        chooser.setDate(new Date(anio - 1900, mes, dia));

        //chooser = new JDateChooser(null, null, null,
                    //new JSpinnerDateEditor());
    }
    
    public void Hide(boolean isHide){
        chooser.setVisible(isHide);
    }
    
    public void ChangeDate(Fecha fecha)
    {
        Calendar calendario = new GregorianCalendar(fecha.Year,fecha.Mes,fecha.Dia);
        chooser.setDate(calendario.getTime());

    }
    
    public void SetPosition(int x, int y)
    {
         chooser.setBounds(x,y, 140, 25);
    }
    
    public String GetDate(){
         String fecha = "";//calendario.getDate().toString();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sf.format(chooser.getDate());
            return fecha;
    }
    
    public JDateChooser GetDateTimePicker(){
        return chooser;
    }

    public void actionPerformed(ActionEvent evt) {
     
        if (evt.getSource() == showDateButton) {
            String fecha = "";//calendario.getDate().toString();
            SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            fecha = sf.format(chooser.getDate());
            JOptionPane.showMessageDialog(null, "Click " + fecha);
        }
    }
}
