package prjX.tablemodels;
import javax.swing.table.AbstractTableModel;
import java.text.SimpleDateFormat;
import java.util.*;



public class BookingTable extends AbstractTableModel {

    String defaultStatus = "available";
    String bookedStatus = "booked";
    
    Object[][] p = {
    		{now(), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(1), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(2), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(3), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(4), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(5), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(6), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(7), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(8), defaultStatus, defaultStatus, defaultStatus},
    		{oneDayFrom(9), defaultStatus, defaultStatus, defaultStatus}
    		
    		// date('now','start of month','+1 month','-1 day');
    		//DATETIME('NOW', '-1 dayss');
    		};
    
    String[] columnNames = {"Date", "00-07", "08-16", "17-24"};
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return columnNames.length;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
        return p[row][col];
    }
   
 public Class getColumnClass(int c) {
         return getValueAt(0, c).getClass();
    }
 
 public boolean isCellEditable(int rowIndex, int columnIndex) {
	 if(columnIndex == 0) return false;
  return true;
    }
   
 public void setValueAt(Object value, int row, int col) {
         p[row][col] = value;
         fireTableCellUpdated(row, col);
    }
   
    public void mySetValueAt(Object value, int row, int col) {
     p[row][col] = value;
    }
    
	public static String now() {
		final String DATE_FORMAT_NOW = "yyyy-MM-dd";
	
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		return sdf.format(cal.getTime());
	}
	public static String oneDayFrom(int day){
		final String DATE_FORMAT_NOW = "yyyy-MM-dd";
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT_NOW);
		cal.add(Calendar.DATE, day);
		return sdf.format(cal.getTime());
	}
	
	
}