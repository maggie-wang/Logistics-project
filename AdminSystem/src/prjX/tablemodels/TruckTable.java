package prjX.tablemodels;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;

import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.*;

public class TruckTable extends AbstractTableModel {
	private ResultSet rs;  
    private ResultSetMetaData rsmd;  
    String[] columnNames = {"Truck ID", "Truck Type", "Truck Status"};  

      
    public TruckTable(ResultSet result){  
            rs = result;  
            try{  
                    rsmd = result.getMetaData();  
            }catch(SQLException sqle){  
                    sqle.printStackTrace();  
            }  
    }  
    public int getRowCount(){  
        try{  
                rs.last();  
                return rs.getRow();  
        }catch(SQLException sqle){  
                sqle.printStackTrace();  
                return 0;  
        }  
    }  
    public String getColumnName(int c){  
        try{  
                return rsmd.getColumnName(c+1);  
        }catch(SQLException sqle){  
                sqle.printStackTrace();  
                return "";  
        }  
    }  
	public int getColumnCount(){  
	        try{  
	                return rsmd.getColumnCount();  
	        }catch(SQLException sqle){  
	                sqle.printStackTrace();  
	                return 0;  
	        }  
	} 
	public Object getValueAt(int r, int c){  
	    try{  
	            rs.absolute(r+1);  
	            return rs.getObject(c+1);  
	    }catch(SQLException sqle){  
	            sqle.printStackTrace();  
	            return null;  
	    }  
	}  
	 public Class getColumnClass(int c) {
	         return getValueAt(0, c).getClass();
	    }
	 
	 public boolean isCellEditable(int rowIndex, int columnIndex) {
		 if(columnIndex == 0) return false;
	  return true;
	    }
	
	   
	 public void setValueAt(Object v, int r, int c){  
	     try{  
	             rs.absolute(r+1);  
	             rs.updateObject(c+1, v);  
	             rs.updateRow();  
	             fireTableCellUpdated(r, c);  
	     }catch(SQLException sqle){  
	             sqle.printStackTrace();  
	     }  
	}  

	public JTable getWholeTable(ResultSet rs) throws SQLException{
	      // Create Vectors and copy over elements from ArrayLists to them
	      // better solution is to create a custom defined class which inherits from the AbstractTableModel class
		   
	  ArrayList columnNames = new ArrayList();
	  ArrayList data = new ArrayList();
	  JTable table = null;
	  
	  ResultSetMetaData md = rs.getMetaData();
	  int columns = md.getColumnCount();

     //  Get column names
     for (int i = 1; i <= columns; i++){
         columnNames.add( md.getColumnName(i) );
     }

     //  Get row data
     while (rs.next()){
         ArrayList row = new ArrayList(columns);

         for (int i = 1; i <= columns; i++){
             row.add( rs.getObject(i) );
         }
         data.add(row);

         Vector columnNamesVector = new Vector();
         Vector dataVector = new Vector();

         for (int i = 0; i < data.size(); i++)
         {
             ArrayList subArray = (ArrayList)data.get(i);
             Vector subVector = new Vector();
             for (int j = 0; j < subArray.size(); j++)
             {
                 subVector.add(subArray.get(j));
             }
             dataVector.add(subVector);
         }

         for (int i = 0; i < columnNames.size(); i++ )
             columnNamesVector.add(columnNames.get(i));

         //  Create table with database data    
         table = new JTable(dataVector, columnNamesVector){
             public Class getColumnClass(int column){
                 for (int row = 0; row < getRowCount(); row++){
                     Object o = getValueAt(row, column);

                     if (o != null){
                         return o.getClass();
                     }
                 }

                 return Object.class;
             }
         };

    table.setSize(new Dimension(400,200));        

     }
     return table;
	}   
}