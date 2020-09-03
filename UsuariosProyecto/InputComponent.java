
import javax.swing.*;  
public class InputComponent
{

    private JLabel _title;
    private JTextField _inputText;


    private InputComponent(Builder builder)
    {
        this._title = builder._title;
        this._inputText = builder._inputText;
 
    }

    public JComponent GetTitle(){
        return this._title;
    }

    
    public String GetInnerText () {
        return _inputText.getText();
    }

    public JComponent GetInputInstance(){
        return _inputText;
    }
    
    public static class Builder{
        
        private JLabel _title;
        private JTextField _inputText;

        private int _XPosition;
        private int _YPosition;
    
        private int _Width;
        public int _Height;
    

        public Builder(){

            _XPosition = 0;
            _YPosition = 0;
            _Width = 200;
            _Height = 20;  
        }


        public Builder EstablecerUbicacion(int x, int y)
        {
          
            _title.setBounds(x, y, _Width, _Height);
            _inputText.setBounds(x,y+20, _Width, _Height);
            return this;
        }

        public Builder ConTitulo(String title){
            _title = new JLabel(title);
            _inputText = new JTextField();
            return this;
        }

        public InputComponent Build(){
            return new InputComponent(this);
        }
    }
}