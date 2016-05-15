package prjX.tablemodels;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableColumnModel;

public class Test {

	
	
}

class MyTableModel extends AbstractTableModel {
    String[] columnNames = {"Date", "00-07", "08-16", "17-24"};
	 //String[] columns={"Id","Name","Last Name","License","E-mail"};
	ArrayList<ArrayList<Object>> data=new ArrayList<ArrayList<Object>>();
	  public MyTableModel(ResultSet rs) {  
	    try {
	      
	      while (rs.next()) {
	        ArrayList<Object> row=new ArrayList<Object>(); //save all col
	        row.add(rs.getObject("Date"));
	        row.add(rs.getObject("Gender"));
	        row.add(rs.getObject("Age"));
	        row.add(rs.getObject("Vegetarian"));
	        row.add(rs.getObject("E-mail"));
	        data.add(row);
	        }
	      rs.close();
	      rs=null;
	      }
	    catch (Exception e) {System.out.println(e);}
	    }
	  public int getColumnCount() {return columnNames.length;}
	  public int getRowCount() {return data.size();} //nr of Col = ArrayList size
	  public Object getValueAt(int row, int col) {
	    ArrayList<Object> rowdata=data.get(row); //get col 
	    return rowdata.get(col);  //return content of cell 
	    }
	  public String getColumnName(int col) {return columnNames[col];}
	  public Class getColumnClass(int col) {
	    return getValueAt(0,col).getClass();
	    }
	  public boolean isCellEditable(int row,int col) {return true;} //editable
	  public void setValueAt(Object value,int row,int col) { //make editable valid
	    ArrayList<Object> rowdata=data.get(row);  //get col content
	    rowdata.set(col,value);  //make editable update to cell
	    fireTableCellUpdated(row,col); //update table display
	    }
	  }