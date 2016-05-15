package prjX.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;

import prjX.database.DBMethods;
import prjX.tablemodels.BookingTable;

import java.util.*;
import java.util.List;
import java.sql.*;
import java.text.SimpleDateFormat;

public class TruckSearch extends JInternalFrame{

	JLabel lb1 = new JLabel("Get Trucks");
   	JLabel lb2 = new JLabel("Shipment Volumn: ");
   	JTextField TF_Shipment = new JTextField(10);

   	JButton searchBtn = new JButton("Search");
   	Container con = getContentPane();
   	JTable table;
   	AbstractTableModel dtm;
   	public TruckSearch(){
   		initGUI();
   	}
	public void initGUI(){
		//DBUtils db = DBUtils.getInstance();
		setTitle("Search for shipment");	
		
		dtm = new BookingTable();
		table = new JTable(dtm);

        JScrollPane sl = new JScrollPane(table);

		getContentPane().setLayout(null);
		lb1.setBounds(200,10,300,30);
		lb1.setFont(new Font("italic",Font.BOLD,24));
		getContentPane().add(lb1);

		//table.setPreferredScrollableViewportSize(new Dimension(180, 60));

		Font f=new Font("italic",Font.PLAIN,12);
		lb2.setBounds(10,60,80,25);
		lb2.setFont(f);
		getContentPane().add(lb2);
		TF_Shipment.setBounds(80,60,80,23);
		TF_Shipment.setFont(f);
		getContentPane().add(TF_Shipment);
		
   	    searchBtn.setBounds(90,130,60,25);
   	    searchBtn.setFont(f);
   	    getContentPane().add(searchBtn);
   	    
		sl.setBounds(180,60,425,290);
		
		getContentPane().add(sl);


		TF_Shipment.setBorder(BorderFactory.createLineBorder(Color.black));
   	    searchBtn.setBorder(BorderFactory.createRaisedBevelBorder());
		sl.setBorder(BorderFactory.createLineBorder(Color.black));
		
		
		searchBtn.addActionListener(new ActionListener(){
	   		public void actionPerformed(ActionEvent event){
        		
	   			System.out.println("Shipment is " + TF_Shipment.getText());
        		List<String> fetched_ships = null;
        		String fetched_kaj = null;
	   		
	   				DBMethods methods = new DBMethods();
	   				fetched_ships = methods.getShip(TF_Shipment.getText());
	   		
	   			lb1.setText("KAJ " + fetched_kaj);
	   		}});
	
		
		table.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
		     
			@Override
			public void valueChanged(ListSelectionEvent e) {
			    if (e.getSource() == table.getSelectionModel() && table.getRowSelectionAllowed()) {
			    	
			    	DBMethods methods = new DBMethods();
			    	int row = table.getSelectedRow();
			    	int col = table.getSelectedColumn();
			    	System.out.println(TF_Shipment.getText());
			    	methods.getShip(TF_Shipment.getText());			    			
			    	}
			    	
			      } 

	    });
		
		setSize(630,400);
		this.setClosable(true);
		setVisible(true);
	}
}
		