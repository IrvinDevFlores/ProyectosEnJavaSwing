package restApp;

public class Config
{
    public String DbLocation;
    public String DbName;
    public String Usuario;
    public String Pass;

    public String GetString(){
        return DbLocation+DbName+Usuario+Pass;
    }
}
