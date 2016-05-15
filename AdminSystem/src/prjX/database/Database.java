package prjX.database;
//risk condition, multi-thread

import java.sql.*;

public class Database {
    public static Connection con;
    public static Statement stm;
    public static ResultSet rs;

      final String DB_CONN_STR = "jdbc:sqlite:projectX";
    // final String DB_CONN_STR = "C:\\Users\\cathrine\\Desktop\\ProjectX\\AdminSystem\\projectX";
  	static{
    	try{
    	Class.forName("org.sqlite.JDBC");
    	}catch(ClassNotFoundException cnfe){
    	System.err.println("Could not load driver: "+cnfe.getMessage());
    	}
    }
  	
    public Database(){
    	getConnection();
    }
    
    private void getConnection(){
    	try{
    		con = DriverManager.getConnection(DB_CONN_STR);
    	}catch(Exception e){
    	System.err.println("Error getting connection to " + DB_CONN_STR);
    	}
    }
    
    public boolean hasConnection(){
    	return con != null;
   	}
    
    public void executeQuery(String sql){
    	if(hasConnection()){
    	Statement stm = null;
    	ResultSet rs = null;
    	try{
    		
    		stm = con.createStatement();
    		rs = stm.executeQuery(sql);
    		System.out.println("rs  " + rs.getString(0));
    		while(rs.next()){
    			System.out.println(rs.getString("Name") + " " +rs.getString("Name"));
    		}
    		}catch(SQLException sqle){
    			System.err.println(sqle.getMessage());
    		}finally{
    			try{
    				rs.close();
    				stm.close();
    		}catch(Exception e){}
    	}
     }
   }

    private void closeBoth(AutoCloseable a1, AutoCloseable a2){
        try{
            closeIt(a1);          
            closeIt(a2);
        }catch(Exception e){
            System.err.println("Exception closing: "+e.getMessage());
        }
    }
    
    private void closeIt(AutoCloseable it){     
        try{
            it.close();
        }catch(Exception e){
            System.err.println("Exception closing: "+e.getMessage());
        }
    }
    
}
