
import java.util.*;
import javax.swing.*;  
public class QueryBuilder
{
    private String _query;
    private QueryBuilder(Builder builder)
    {
        _query = builder.GetQuery();

    }
    

    public String MakeQuery(){
        return _query;
    }


    
    public static class Builder{
        
        private StringBuilder _query;
        public String GetQuery(){
            return _query.toString();
        }

        public Builder(){

            _query = new StringBuilder();
            
        }
        
        public Builder Select(){
            _query.append("select ");
            return this;
        }
        
        
        public Builder UpdateTable(String table)
        {

            _query.append("update "+table+" set ");
            return this;
        }
        
        
        public Builder Set(String column, String data){
            _query.append(column + "='" + data+"',");
            return this;
        }
        public Builder Set(String column, int data){
            _query.append(column + "='" +""+data+"',");
            return this;
        }
        public Builder Set(String column, double data){
            _query.append(column + "='" +""+data+"',");
            return this;
        }
        
        
        public Builder WhereMatchString(String column, String value){
            int last = _query.toString().length()-1;
            
            char ch = _query.toString().charAt(last);
           
            if(ch == ','){
                 _query.deleteCharAt(last);
                  _query.append(" where "+column+" = '"+value+"'");
            }else{
                  _query.append(" where "+column+" = '"+value+"'");
            }
            
          
            return this;
        }
        
           
        public Builder WhereMatchInt(String column, int value){
            _query.deleteCharAt(_query.toString().length() - 1);
            _query.append(" where "+column+" = "+value+"");
            return this;
        }
        
        
        public Builder WithColumn(String table)
        {
            _query.append(table+" ,");
            return this;
        }
        
        public Builder From(String source){
        
            _query.deleteCharAt(_query.toString().length() -1 );
            
            _query.append(" from "+source);
            
            return this;
        }
        
        public Builder Insert(String table){
     
                _query.append("insert into "+table+"(");

            return this;
        }
        
        
        Hashtable<String, String> values = new Hashtable<String,String>();
        
        ArrayList<String> list = new ArrayList<>();
        public Builder Column(String column,String value)
        {

            _query.append(column+",");
            list.add(value);
            return this;
        }

        public Builder Column(String column,double value)
        {

            _query.append(column+",");
            list.add(value+"");
            return this;
        }
        
        public Builder Execute(){
                String vals = " values('%s','%s','%s')";
                              _query.deleteCharAt(_query.toString().length() - 1);
                _query.append(") values(");
                
                for(String val : list){
                    _query.append("'"+val+"'"+",");
                }

                _query.deleteCharAt(_query.toString().length() - 1);
              _query.append(")");
             
            return this;
        }
        


        public QueryBuilder Build(){
            return new QueryBuilder(this);
        }
    }
}


//khelpix inc original reserved ARF.