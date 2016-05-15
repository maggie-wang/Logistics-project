package prjX.tablemodels;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class DisplayTable extends JFrame{

	JTable getWholeTable(ResultSet rs) throws SQLException{
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
	
	public void showWholeTable(ResultSet rest) throws SQLException{
		
		JScrollPane scrollPane = new JScrollPane(getWholeTable(rest));
		scrollPane.setBounds(180,60,425,290);
		
        //scrollPane.setSize(new Dimension(400, 200));
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
   	    getContentPane().add(scrollPane);

   	    JPanel buttonPanel = new JPanel();
   	    getContentPane().add( buttonPanel, BorderLayout.SOUTH );
	}
	
	public void resultSetToTableModel(ResultSet rs, JTable table) throws SQLException{
        //Create new table model
        DefaultTableModel tableModel = new DefaultTableModel();

        //Retrieve meta data from ResultSet
        ResultSetMetaData metaData = rs.getMetaData();

        //Get number of columns from meta data
        int columnCount = metaData.getColumnCount();

        //Get all column names from meta data and add columns to table model
        for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++){
            tableModel.addColumn(metaData.getColumnLabel(columnIndex));
        }

        //Create array of Objects with size of column count from meta data
        Object[] row = new Object[columnCount];

        //Scroll through result set
        while (rs.next()){
            //Get object from column with specific index of result set to array of objects
            for (int i = 0; i < columnCount; i++){
                row[i] = rs.getObject(i+1);
            }
            //Now add row to table model with that array of objects as an argument
            tableModel.addRow(row);
        }

        //Now add that table model to your table and you are done :D
        table.setModel(tableModel);
    }	
}