
package prjX.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class Main extends JFrame implements Runnable{

	Thread t = new Thread(this);
	JDesktopPane deskpane = new JDesktopPane();
	JPanel p = new JPanel();
	Label lp1 = new Label("Logistics West ");

//--------------------------------------------------------------------------
   	ImageIcon icon1 = new ImageIcon("image//tjsc.gif");
	ImageIcon icon2 = new ImageIcon("image//cxdl.gif");
	ImageIcon icon3 = new ImageIcon("image//xgmm.gif");
	ImageIcon icon4 = new ImageIcon("image//tcxt.gif");
	ImageIcon icon6 = new ImageIcon("image//help.gif");
	ImageIcon icon7 = new ImageIcon("image//cx.png");
	ImageIcon icon8 = new ImageIcon("image//driver.png");
	ImageIcon icon9 = new ImageIcon("image//xt.gif");
	ImageIcon icon10 = new ImageIcon("image//xxgl.gif");
	ImageIcon icon11=new ImageIcon("image//cx.gif");
	ImageIcon icon12=new ImageIcon("image//bz.gif");
	ImageIcon icon13=new ImageIcon("image//gy.gif");
	ImageIcon icon14=new ImageIcon("image//driver.png");
	ImageIcon icon15=new ImageIcon("image//7mini.png");
	ImageIcon icon16=new ImageIcon("image//2mini.png");
	
	ImageIcon icon17=new ImageIcon("image//ship.png");
	ImageIcon icon18=new ImageIcon("image//truck.png");
	ImageIcon icon19=new ImageIcon("image//ship32.png");
	ImageIcon icon20=new ImageIcon("image//truck32.png");
//--------------------------------------------------------------------------------

	public Main(){
		setTitle("Personal and Booking management system");
		Container con = getContentPane();
		con.setLayout(new BorderLayout());
		con.add(deskpane,BorderLayout.CENTER);

		Font f =new Font("Serif",Font.PLAIN,12);
		
		JMenuBar mb = new JMenuBar();

		//Initialize menu 
		JMenu systemM = new JMenu("System");
		systemM.setFont(f);
		JMenu personalM = new JMenu("Employee");
		personalM.setFont(f);
		JMenu selectM = new JMenu("Booking");
		selectM.setFont(f);		
		JMenu shipM = new JMenu("Ships");
		shipM.setFont(f);		
		JMenu truckM = new JMenu("Trucks");
		truckM.setFont(f);		
		JMenu aboutM=new JMenu("About");
		
		//initialize system management menu items
		JMenuItem password = new JMenuItem("Password");
		password.setFont(f);
		JMenuItem land = new JMenuItem("Re-login");
		land.setFont(f);
		JMenuItem addDelete = new JMenuItem("Add/Delete");
		addDelete.setFont(f);
		JMenuItem exit = new JMenuItem("Exit system");
		exit.setFont(f);
		systemM.add(password);
		systemM.add(land);
		systemM.add(addDelete);
		systemM.add(exit);
		
		//---------------------------------------------------------------------------

        exit.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		setVisible(false);
        		}
        	});
//--------------------------------------------------------------------------------------------
		
		//Initialize info management menu

		JMenuItem employeeM = new JMenuItem("Employee Handling");
		employeeM.setFont(f);
		
		personalM.add(employeeM);

        employeeM.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		try {
					deskpane.add(new EmployeeHandling());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		}
        	});


		JMenuItem employeeSearch = new JMenuItem("Search Employee");
		employeeSearch.setFont(f);
		
		personalM.add(employeeSearch);

		employeeSearch.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		deskpane.add(new EmployeeSearch());
        		}
        	});

        
//-----------------------------------------------------------------------------------------------
		
		JMenuItem sub_BookingMenuItem = new JMenuItem("Booking");
		sub_BookingMenuItem.setFont(f);
		
		selectM.add(sub_BookingMenuItem);
		
		sub_BookingMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				deskpane.add(new Booking());
				}
			});
		JMenuItem sub_BookingReport = new JMenuItem("Print report");
		sub_BookingReport.setFont(f);
		
		selectM.add(sub_BookingReport);
		
		sub_BookingReport.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				deskpane.add(new BookingReport());
				}
			});
		
		sub_BookingReport.setIcon(icon15);
		
//-----------------------------------------------------------		
		JMenuItem sub_shipHandlingMenuItem = new JMenuItem("Ship Handling");
		sub_shipHandlingMenuItem.setFont(f);
		
		shipM.add(sub_shipHandlingMenuItem);
		
		sub_shipHandlingMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				try {
					deskpane.add(new ShipHandling());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
		
		sub_shipHandlingMenuItem.setIcon(icon17);

		
		JMenuItem sub_searchShipMenuItem = new JMenuItem("Search a ship");
		sub_searchShipMenuItem.setFont(f);
		
		shipM.add(sub_searchShipMenuItem);
		
		sub_searchShipMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				try {
					deskpane.add(new ShipSearch());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
		sub_searchShipMenuItem.setIcon(icon16);

		
//-----------------------------------------------------------
		JMenuItem sub_truckHandlingMenuItem = new JMenuItem("Truck Handling");
		sub_truckHandlingMenuItem.setFont(f);
		
		truckM.add(sub_truckHandlingMenuItem);
		
		sub_truckHandlingMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				try {
					deskpane.add(new TruckHandling());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				}
			});
		
		sub_truckHandlingMenuItem.setIcon(icon18);
		
		
		JMenuItem sub_searchOKTrucksMenuItem = new JMenuItem("Searh an truck");
		sub_searchOKTrucksMenuItem.setFont(f);
		
		truckM.add(sub_searchOKTrucksMenuItem);
		
		sub_searchOKTrucksMenuItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){				
				deskpane.add(new TruckSearch());
				}
			});
		sub_searchOKTrucksMenuItem.setIcon(icon16);
		
//------------------------------------------------
		
		JMenuItem about =new JMenuItem("About");
		about.setFont(f);
		aboutM.add(about);

/*------------------------------------------------------------------------
		about.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				deskpane.add(new About());
				}
			});
-----------------------------------------------------------------------------------------
*/
		mb.add(systemM);
		mb.add(personalM);
		mb.add(selectM);
		mb.add(shipM);
		mb.add(truckM);
		mb.add(aboutM);
	    setJMenuBar(mb);

   
	    Image img=Toolkit.getDefaultToolkit().getImage("image\\main.gif");
	    setIconImage(img);
 
		systemM.setIcon(icon9);
		personalM.setIcon(icon8);
		selectM.setIcon(icon7);
		shipM.setIcon(icon17);
		addDelete.setIcon(icon1);
		land.setIcon(icon2);
		password.setIcon(icon3);
		exit.setIcon(icon4);
		sub_BookingMenuItem.setIcon(icon11);
		shipM.setIcon(icon17);
		truckM.setIcon(icon18);
		aboutM.setIcon(icon13);
		about.setIcon(icon13);

		employeeM.setIcon(icon14);
		employeeSearch.setIcon(icon16);
		
   	    JToolBar jToolBar1 = new JToolBar();//create a tool menu
   	    jToolBar1.setLayout(new GridLayout(9,1));
        JButton TB_EmployeeBasicInfo = new JButton();
        TB_EmployeeBasicInfo.setToolTipText("Employee info management");
        JButton TB_EmployeeBasicInfoSearch = new JButton();
        TB_EmployeeBasicInfoSearch.setToolTipText("Employee info search ");
        JButton TB_ChangePwd = new JButton();
        TB_ChangePwd.setToolTipText("Change password");
        
        JButton TB_ShipInfo = new JButton();
        TB_ShipInfo.setToolTipText("Ship info");
                
        JButton TB_TruckInfo = new JButton();
        TB_TruckInfo.setToolTipText("Truck info");
        
        JButton TB_Booking = new JButton();
        TB_Booking.setToolTipText("Booking");
        
        JButton TB_BookingReport = new JButton();
        TB_BookingReport.setToolTipText("Booking Report");
        
        
        JButton TB_Exit = new JButton();
        TB_Exit.setToolTipText("Exit system");
        

        jToolBar1.setMaximumSize(new java.awt.Dimension(600, 50));//Set menu max value
        jToolBar1.setMinimumSize(new java.awt.Dimension(600, 50));//Min
        
        
        TB_EmployeeBasicInfo.setIcon(new ImageIcon("image//driver33.png"));
        TB_EmployeeBasicInfo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        		try {
					deskpane.add(new EmployeeHandling());
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		}
        	});
        jToolBar1.add(TB_EmployeeBasicInfo);
        
        TB_ShipInfo.setIcon(new ImageIcon("image//ship32.png"));
        TB_ShipInfo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        		try {
					deskpane.add(new ShipHandling());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		}
        	});
        jToolBar1.add(TB_ShipInfo);        
        
        TB_TruckInfo.setIcon(new ImageIcon("image//truck32.png"));
        TB_TruckInfo.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        		try {
					deskpane.add(new TruckHandling());
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        		}
        	});
        jToolBar1.add(TB_TruckInfo);        
        



        TB_Booking.setIcon(new ImageIcon("image//5.jpg"));
        TB_Booking.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
        		
        		deskpane.add(new Booking());
        		}
        	});
        jToolBar1.add(TB_Booking);

        
        TB_Exit.setIcon(new javax.swing.ImageIcon("image//6.png"));
        TB_Exit.addActionListener(new ActionListener(){
        	public void actionPerformed(ActionEvent e){
                System.exit(0);
        		}
        	});        
		jToolBar1.add(TB_Exit);
		
			
		
        jToolBar1.setBounds(0, 0, 30, 600);//tool menu position
        jToolBar1.setEnabled(false);//not allowed change size¡
        con.add(jToolBar1,BorderLayout.WEST);//layout


        p.setLayout(new BorderLayout());
        p.add(lp1,BorderLayout.EAST);
        	t.start();

        con.add(p,BorderLayout.SOUTH);

	    Toolkit t = Toolkit.getDefaultToolkit();
	    int width = t.getScreenSize().width - 200;
	    int height = t.getScreenSize().height - 100;
	    setSize(width,height);
	    setLocation(150,100);
		setVisible(true);
		setResizable(false);
		}

		//Thread method
        	public void run(){
        	  System.out.println("Thread start! ");
        	  Toolkit t = Toolkit.getDefaultToolkit();
        	  int x=t.getScreenSize().width;
        	  System.out.println("x=" + x);


	          lp1.setForeground(Color.red);
		      while(true)
		         {
                     if(x<-600){
                     	x=t.getScreenSize().width;
                     	}
			         lp1.setBounds(x,0,700,20);
			         x-=10;
			         try{Thread.sleep(100);}catch(Exception e){}
		          
	           	 }
              }

	public static void main(String[] args){
		new Main();
		}
	}

/********************************************************************/