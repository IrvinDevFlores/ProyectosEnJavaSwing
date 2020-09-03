
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.ArrayList;

public class Form extends JDialog implements ActionListener {
    InputComponent userText;

    InputComponent passText;

    private JButton _loginButton;

    public Form() {
        getContentPane().setLayout(null);

        userText = new InputComponent.Builder().ConTitulo("User").EstablecerUbicacion(50, 50).Build();

        getContentPane().add(userText.GetInputInstance());
        getContentPane().add(userText.GetTitle());

        passText = new InputComponent.Builder().ConTitulo("Password").EstablecerUbicacion(50, 100).Build();
        getContentPane().add(passText.GetInputInstance());
        getContentPane().add(passText.GetTitle());

        _loginButton = new JButton("Ingresar");
        _loginButton.setBounds(50, 300, 100, 20);
        _loginButton.addActionListener(this);

        getContentPane().add(_loginButton);

        setSize(400, 400);
        setFocusable(true);

        setLocationRelativeTo(null);

    }


    public void Login(){


        try
        {

            Connection con = new Conexion().getConexion();

            ArrayList<Usuario> usuarios = new ArrayList<>();
 
			Statement s1=con.createStatement();
			ResultSet rs=s1.executeQuery(SqlQueries.Get("usuarios"));
	
			while(rs.next()){
			    String cod = rs.getString("UsuarioCodigo");
			    String pass = rs.getString("UsuarioClave");
			    String estado = rs.getString("UsuarioEstado");
			    usuarios.add(new Usuario(cod,pass,estado));
			 }
			 
			   con.close();
            
            for(Usuario u : usuarios)
            {
                
                boolean isNotUser = !( u.Username.equals(userText.GetInnerText().trim())
                                              && u.Passwoord.equals(passText.GetInnerText())
                                                    && u.Estado.equals("Activo")
                    );
                    
                    if (isNotUser) {
                        JOptionPane.showMessageDialog(null, "Contraseña incorreecta o esta inactivo");
                        return;
                    }
               
                       
                new MainForm().setVisible(true);
                this.dispose();
           
          
                return;
           
            }
  
      
        }
        catch(Exception exp)
        {
            JOptionPane.showMessageDialog(null,"Paso..->"+exp,"Error",0);
 
        }

    }


    public void actionPerformed(final ActionEvent evt) {
        if (evt.getSource() == _loginButton) {

          Login();

        }
    }

}
