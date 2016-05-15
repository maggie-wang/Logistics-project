package prjX.GUI;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import prjX.database.DBMethods;
import prjX.tablemodels.DisplayTable;

public class BookingReport extends JInternalFrame {

	JLabel lb_print = new JLabel("Print Booking Report");
   	//Container con = getContentPane();
   	JPanel p = new JPanel();	
   	Container contentPane;
   	public BookingReport(){
   		setTitle("Print booking report");	
   		p.add(lb_print);
   		BookingReportPanel panel = new BookingReportPanel();
   		Container contentPane = getContentPane();
   	    contentPane.add(p,"North");
   	    contentPane.add(panel,"Center");

   	    setBounds(100, 100, 280, 260);
   	    this.setClosable(true);
   	    setVisible(true);
   	   // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   	}
   
}  	
class BookingReportPanel extends JPanel{

	JLabel lb_FromDate = new JLabel("From: ");
	JLabel lb_ToDate = new JLabel("To: ");	
		
		
	   	JTextField TF_FromDate = new JTextField(20);
	   	JTextField TF_ToDate = new JTextField(20);
	  
	   	JButton printBtn=new JButton("Print report");
	   	public BookingReportPanel(){
	
		add(lb_FromDate);
		lb_FromDate.setBounds(16,80,80,25);
		add(TF_FromDate);
   	    TF_FromDate.setBounds(100,80,120,25);
   	    add(lb_ToDate);   	    
		lb_ToDate.setBounds(16,115,80,25);
		add(TF_ToDate);		
		TF_ToDate.setBounds(100,115,120,25);
		add(printBtn);
   	    printBtn.setBounds(130,160,120,30);   	    
   	 
   	    setLayout(null);
		
		printBtn.addActionListener(new ActionListener(){
	   		public void actionPerformed(ActionEvent event){
	   			ResultSet rs;
	   			
	   			DBMethods method = new DBMethods();
	   			rs = method.getRep(TF_FromDate.getText(), TF_ToDate.getText());
	   			
	   			if(rs == null){
	   				System.out.println("null is rs");
	   			}
				
				
	   			DisplayTable frame = new DisplayTable();
	   			frame.setSize(800,600);
	   			try {
					frame.showWholeTable(rs);
					rs.close();
					
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	   	        frame.setVisible(true);
	   	        
	   		}
	   		});
	
		
	   	}

	
}