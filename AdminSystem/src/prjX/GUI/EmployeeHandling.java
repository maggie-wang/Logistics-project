package prjX.GUI;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.*;
import java.util.*;
import java.sql.*;

import javax.swing.table.TableColumn;

import prjX.database.DBMethods;
import prjX.tablemodels.EmployeeTable;

import javax.swing.table.AbstractTableModel;


public class EmployeeHandling extends JInternalFrame{
		EmployeeHandling() throws SQLException{
			JTable table;
			EmployeeTable dtm;
   		    
   			
   			ResultSet rs;
   			//JPanel pane =  new JPanel(new GridLayout());
   			JPanel pane =  new JPanel();
   			JFrame frame = null;
   			JButton search_btn = null, add_btn = null, delete_btn = null;
   			frame = new JFrame("Employee Management");
   			pane = new JPanel();
   			search_btn = new JButton("Search a Employee");
   			search_btn.addActionListener(new ActionListener() {
   		   public void actionPerformed(ActionEvent e) {
   		    //removeData();
   		   }
   		  });
   		  add_btn = new JButton("Add a Employee");
   		  add_btn.addActionListener(new ActionListener() {
   		   public void actionPerformed(ActionEvent e) {
   		    //addData();
   		   }
   		  });
   		  delete_btn = new JButton("Delete a Employee");
   		  delete_btn.addActionListener(new ActionListener() {
   		   public void actionPerformed(ActionEvent e) {
   		    //saveData();
   		   }
   		  });
   		  	DBMethods methods = new DBMethods();
   			rs = methods.getAllPeps();
   			
   			if(rs == null){
   				System.out.println("null is rs");
   			}
   			dtm = new EmployeeTable(rs);
   			table = new JTable(dtm);
   			
   			String[] status ={"100%","50%", "Sjuk", "VAB", "Studier", "Semester"}; 
   			String[] schedule = {"MF", "LS", "S"};
   			String[] license = {"A", "AA", "B", "BB","C", "CC", "CCC", "K"};
   			
   			JComboBox comboStatus = new JComboBox (status);
   			//comboStatus.setEditable(true);
   			JComboBox comboSchedule = new JComboBox (schedule);
   			//comboSchedule.setEditable(true);
   			JComboBox comboLicense = new JComboBox (license);
   			//comboLicense.setEditable(true);
   			
   			table.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(comboLicense));    
   			table.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(comboStatus));    
   			table.getColumnModel().getColumn(5).setCellEditor(new DefaultCellEditor(comboSchedule));   
   			
   			
   			table.setBounds(100, 100, 580, 260);
   			pane.add((new JScrollPane(dtm.getWholeTable(rs))), BorderLayout.AFTER_LINE_ENDS);
   			pane.add(add_btn, BorderLayout.BEFORE_FIRST_LINE);
	   		pane.add(delete_btn, BorderLayout.BEFORE_FIRST_LINE);
	   		  
	   		pane.add(search_btn, BorderLayout.BEFORE_FIRST_LINE);
	   		
			frame.add(pane);
   			frame.setSize(800,600);
   			frame.pack();
   	        frame.setVisible(true);
   	        rs.close();
   	     setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   		}
}