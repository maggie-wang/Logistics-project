package prjX.GUI;

import java.awt.*;
import javax.swing.*;

import prjX.database.DBMethods;

import java.awt.event.*;
import java.sql.*;

public class EmployeeSearch extends JInternalFrame{
	JInternalFrame jif;

    private JButton save_bt;
    private JButton rm_bt;
    private JButton lm_bt;
    private JButton right_bt;
    private JButton left_bt;
    private JButton exit_bt;
    private JButton append_bt;
    private JButton delet_bt;
    private JButton amend_bt;

    private JLabel lb1;
    private JLabel lb2;
    private JLabel lb3;
    private JLabel lb4;
    private JLabel lb5;
    private JLabel lb6;
    private JLabel lb7;
    private JTextField tf_number;
    private JTextField tf_name;
    private JTextField tf_surname;
    private JComboBox tf_license;
    private JComboBox tf_status;
    private JComboBox tf_schema;


    public EmployeeSearch() {
    	jif=this;
        initComponents();
    }

    private void initComponents() {

    	setTitle("Search en employee");
    	
    	String schema[]={"MF", "LS", "S"};
    	String status[]={"100%", "50%", "Sjuk", "VAB", "Studier", "Semester"};
    	String license[]={"A" ,"AA", "B", "BB", "C", "CC", "CCC", "K"};

        Font f=new Font("italic",Font.PLAIN,12);

        lb1 = new JLabel("Employee Basic Info");
        lb2 = new JLabel("ID: ");
        lb3 = new JLabel("Name: ");
        lb4 = new JLabel("Surname: ");
        lb5 = new JLabel("License: ");
        lb6 = new JLabel("Schedule: ");
        lb7 = new JLabel("Status: ");
        
        tf_number = new JTextField();
        tf_name = new JTextField();
        tf_surname = new JTextField();
        tf_license = new JComboBox(license);
        tf_schema = new JComboBox(schema);
        tf_status = new JComboBox(status);
        append_bt = new JButton("add");
        delet_bt= new JButton("delete");
        amend_bt = new JButton("change");

        getContentPane().setLayout(null);

        lb1.setBackground(new Color(0, 0, 0));
        lb1.setForeground(new Color(0, 0, 255));
        getContentPane().add(lb1);
        lb1.setBounds(140, 10, 210, 40);

        lb2.setFont(f);
        getContentPane().add(lb2);
        lb2.setBounds(20, 80, 60, 20);
        
        lb3.setFont(f);
        getContentPane().add(lb3);
        lb3.setBounds(20, 120, 80, 20);

        lb4.setFont(f);
        getContentPane().add(lb4);
        lb4.setBounds(20, 160, 80, 20);

        lb5.setFont(f);
        getContentPane().add(lb5);
        lb5.setBounds(20, 200, 60, 20);

        lb6.setFont(f);
        getContentPane().add(lb6);
        lb6.setBounds(20, 240, 60, 20);

        lb7.setFont(f);
        getContentPane().add(lb7);
        lb7.setBounds(20, 280, 60, 20);

        getContentPane().add(tf_number);
        tf_number.setBounds(80, 80, 80, 21);

        getContentPane().add(tf_name);
        tf_name.setBounds(80,120, 80, 20);

        getContentPane().add(tf_surname);
        tf_surname.setBounds(80, 160, 80, 20);

        getContentPane().add(tf_license);
        tf_license.setBounds(80, 200, 100, 20);
        
        getContentPane().add(tf_schema);
        tf_schema.setFont(f);
        tf_schema.setBounds(80, 240, 100, 23);

        getContentPane().add(tf_status);
        tf_status.setFont(f);
        tf_status.setBounds(80, 280, 100, 23);
        
        save_bt.setFont(f);
        getContentPane().add(save_bt);
        save_bt.setBounds(20, 390, 70, 25);
        //save_bt.setEnabled(false);

        rm_bt.setFont(f);
        getContentPane().add(rm_bt);
        rm_bt.setBounds(260, 350, 70, 25);

        lm_bt.setFont(f);
        getContentPane().add(lm_bt);
        lm_bt.setBounds(150, 350, 70, 25);

        right_bt.setFont(f);
        getContentPane().add(right_bt);
        right_bt.setBounds(370, 350, 70, 25);

        left_bt.setFont(f);
        getContentPane().add(left_bt);
        left_bt.setBounds(50, 350, 70, 25);

        exit_bt.setFont(f);

        getContentPane().add(exit_bt);
        exit_bt.setBounds(410, 390, 70,25);

        append_bt.setFont(f);

        getContentPane().add(append_bt);
        append_bt.setBounds(110, 390, 70, 25);

        delet_bt.setFont(f);

        getContentPane().add(delet_bt);
        delet_bt.setBounds(310, 390, 70, 25);

        amend_bt.setFont(f);
        getContentPane().add(amend_bt);
        amend_bt.setBounds(210, 390, 70, 25);
        
        DBMethods methods = new DBMethods();
        //methods.getAllEmployees(tf_number.getText(), tf_name.getText(), tf_surname.getText());
/*
      
        String csql="select * from EmployeeInformation";
        try{
            if(Database.query(csql)){
            	Database.rs.next();


            	txt_number.setText("" + Database.rs.getInt("E_Number"));
            	txt_name.setText(Database.rs.getString("E_Name"));
            	if(Database.rs.getString("E_Sex").equals("male")){
            		sex_cb.setSelectedIndex(0);
            		}
            	else{
            		sex_cb.setSelectedIndex(1);
            		}
            		//System.out.println(""+sex_cb.getSelectedItem());
            	txt_borndate.setText(Database.rs.getString("E_BornDate"));
            	tdepartment.setText(Database.rs.getString("E_Department"));

           	if(Database.rs.getString("E_Marriage").equals("unmarriage")){
            		marriage_cb.setSelectedIndex(0);
            		}
            	else if(Database.rs.getString("E_Marriage").equals("married")){
            		marriage_cb.setSelectedIndex(1);
            		}
            	else{
            		marriage_cb.setSelectedIndex(2);
            		}
            		//System.out.println(""+marriage_cb.getSelectedItem());
            	theadship.setText(Database.rs.getString("E_Headship"));
            	txt_InDueFormDate.setText(Database.rs.getString("E_InDueFormDate"));
            	if(Database.rs.getString("E_PoliticsVisage").equals("party member")){
            		politicsVisage_cb.setSelectedIndex(0);
            		}
            	else{
            		politicsVisage_cb.setSelectedIndex(1);
            		}

            	tschoolage.setText(Database.rs.getString("E_SchoolAge"));
            	txt_enterdate.setText(Database.rs.getString("E_EnterDate"));
            	if(Database.rs.getString("E_Estate").equals(" working")){
            		estate_cb.setSelectedIndex(0);
            		}
            	else if(Database.rs.getString("E_Estate").equals("stopping working")){
            		estate_cb.setSelectedIndex(1);
            		}
            	else{
            		estate_cb.setSelectedIndex(2);
            		}
            	remark_ta.setText(Database.rs.getString("E_Remark"));
            	}
            	//System.out.println("ok");
        	}
        catch(Exception e){System.out.println(e);};

//--------------------------------------------------------------------------------------------


         rm_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try{
            		if(Database.rs.next()){
		            	txt_number.setText("" + Database.rs.getInt("E_Number"));
		            	txt_name.setText(Database.rs.getString("E_Name"));
		            	if(Database.rs.getString("E_Sex").equals("male")){
		            		sex_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		sex_cb.setSelectedIndex(1);
		            		}
		            		//System.out.println(""+sex_cb.getSelectedItem());
		            	txt_borndate.setText(Database.rs.getString("E_BornDate"));
		            	tdepartment.setText(Database.rs.getString("E_Department"));

		           	if(Database.rs.getString("E_Marriage").equals("unmarried")){
		            		marriage_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Marriage").equals("married")){
		            		marriage_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		marriage_cb.setSelectedIndex(2);
		            		}
		            		//System.out.println(""+marriage_cb.getSelectedItem());
		            	theadship.setText(Database.rs.getString("E_Headship"));
		            	txt_InDueFormDate.setText(Database.rs.getString("E_InDueFormDate"));
		            	if(Database.rs.getString("E_PoliticsVisage").equals("party member")){
		            		politicsVisage_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		politicsVisage_cb.setSelectedIndex(1);
		            		}

		            	tschoolage.setText(Database.rs.getString("E_SchoolAge"));
		            	txt_enterdate.setText(Database.rs.getString("E_EnterDate"));
		            	if(Database.rs.getString("E_Estate").equals("work")){
		            		estate_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Estate").equals("stop working")){
		            		estate_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		estate_cb.setSelectedIndex(2);
		            		}
		            	remark_ta.setText(Database.rs.getString("E_Remark"));
            			}
            		}
            	catch(Exception erm){
            		System.out.println(erm);
            		}
            	}
         	});


         lm_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try{
            		if(Database.rs.previous()){
		            	txt_number.setText("" + Database.rs.getInt("E_Number"));
		            	txt_name.setText(Database.rs.getString("E_Name"));
		            	if(Database.rs.getString("E_Sex").equals("male")){
		            		sex_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		sex_cb.setSelectedIndex(1);
		            		}
		            		//System.out.println(""+sex_cb.getSelectedItem());
		            	txt_borndate.setText(Database.rs.getString("E_BornDate"));
		            	tdepartment.setText(Database.rs.getString("E_Department"));

		           	if(Database.rs.getString("E_Marriage").equals("unmarried")){
		            		marriage_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Marriage").equals("married")){
		            		marriage_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		marriage_cb.setSelectedIndex(2);
		            		}
		            		//System.out.println(""+marriage_cb.getSelectedItem());
		            	theadship.setText(Database.rs.getString("E_Headship"));
		            	txt_InDueFormDate.setText(Database.rs.getString("E_InDueFormDate"));
		            	if(Database.rs.getString("E_PoliticsVisage").equals("party member")){
		            		politicsVisage_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		politicsVisage_cb.setSelectedIndex(1);
		            		}

		            	tschoolage.setText(Database.rs.getString("E_SchoolAge"));
		            	txt_enterdate.setText(Database.rs.getString("E_EnterDate"));
		            	if(Database.rs.getString("E_Estate").equals("working")){
		            		estate_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Estate").equals("stop working")){
		            		estate_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		estate_cb.setSelectedIndex(2);
		            		}
		            	remark_ta.setText(Database.rs.getString("E_Remark"));
            			}
            		}
            	catch(Exception erm){
            		System.out.println(erm);
            		}
            	}
         	});

         left_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try{
            		if(Database.rs.first()){
		            	txt_number.setText("" + Database.rs.getInt("E_Number"));
		            	txt_name.setText(Database.rs.getString("E_Name"));
		            	if(Database.rs.getString("E_Sex").equals("male")){
		            		sex_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		sex_cb.setSelectedIndex(1);
		            		}
		            		//System.out.println(""+sex_cb.getSelectedItem());
		            	txt_borndate.setText(Database.rs.getString("E_BornDate"));
		            	tdepartment.setText(Database.rs.getString("E_Department"));

		           	if(Database.rs.getString("E_Marriage").equals("unmarried")){
		            		marriage_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Marriage").equals("married")){
		            		marriage_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		marriage_cb.setSelectedIndex(2);
		            		}
		            		//System.out.println(""+marriage_cb.getSelectedItem());
		            	theadship.setText(Database.rs.getString("E_Headship"));
		            	txt_InDueFormDate.setText(Database.rs.getString("E_InDueFormDate"));
		            	if(Database.rs.getString("E_PoliticsVisage").equals("party member")){
		            		politicsVisage_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		politicsVisage_cb.setSelectedIndex(1);
		            		}

		            	tschoolage.setText(Database.rs.getString("E_SchoolAge"));
		            	txt_enterdate.setText(Database.rs.getString("E_EnterDate"));
		            	if(Database.rs.getString("E_Estate").equals("working")){
		            		estate_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Estate").equals("stop working")){
		            		estate_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		estate_cb.setSelectedIndex(2);
		            		}
		            	remark_ta.setText(Database.rs.getString("E_Remark"));
            			}
            		}
            	catch(Exception erm){
            		System.out.println(erm);
            		}
            	}
         	});

         right_bt.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
            	try{
            		if(Database.rs.last()){
		            	txt_number.setText("" + Database.rs.getInt("E_Number"));
		            	txt_name.setText(Database.rs.getString("E_Name"));
		            	if(Database.rs.getString("E_Sex").equals("unmarried")){
		            		sex_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		sex_cb.setSelectedIndex(1);
		            		}
		            		//System.out.println(""+sex_cb.getSelectedItem());
		            	txt_borndate.setText(Database.rs.getString("E_BornDate"));
		            	tdepartment.setText(Database.rs.getString("E_Department"));

		           	if(Database.rs.getString("E_Marriage").equals("unmarried")){
		            		marriage_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Marriage").equals("marriage")){
		            		marriage_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		marriage_cb.setSelectedIndex(2);
		            		}
		            		//System.out.println(""+marriage_cb.getSelectedItem());
		            	theadship.setText(Database.rs.getString("E_Headship"));
		            	txt_InDueFormDate.setText(Database.rs.getString("E_InDueFormDate"));
		            	if(Database.rs.getString("E_PoliticsVisage").equals("party")){
		            		politicsVisage_cb.setSelectedIndex(0);
		            		}
		            	else{
		            		politicsVisage_cb.setSelectedIndex(1);
		            		}

		            	tschoolage.setText(Database.rs.getString("E_SchoolAge"));
		            	txt_enterdate.setText(Database.rs.getString("E_EnterDate"));
		            	if(Database.rs.getString("E_Estate").equals("working")){
		            		estate_cb.setSelectedIndex(0);
		            		}
		            	else if(Database.rs.getString("E_Estate").equals("stop working")){
		            		estate_cb.setSelectedIndex(1);
		            		}
		            	else{
		            		estate_cb.setSelectedIndex(2);
		            		}
		            	remark_ta.setText(Database.rs.getString("E_Remark"));
            			}
            		}
            	catch(Exception erm){
            		System.out.println(erm);
            		}
            	}
         	});

//---------------------------------------------------------------------

    append_bt.addActionListener(new ActionListener(){
       public void actionPerformed(ActionEvent e){
       	        save_bt.setEnabled(true);
                txt_number.setText("");
                txt_number.setEditable(false);
            	txt_name.setText("");
            	sex_cb.setSelectedIndex(0);
            	txt_borndate.setText("");
            	tdepartment.setText("");
            	marriage_cb.setSelectedIndex(0);
            	theadship.setText("");
            	txt_InDueFormDate.setText("");
            	politicsVisage_cb.setSelectedIndex(0);
            	tschoolage.setText("");
            	txt_enterdate.setText("");
            	estate_cb.setSelectedIndex(0);
            	remark_ta.setText("");
     		}
     	});

     	save_bt.addActionListener(new ActionListener(){
     		public void actionPerformed(ActionEvent e){
     			if(txt_name.getText().equals("")||txt_borndate.getText().equals("")||tdepartment.getText().equals("")
     			    ||theadship.getText().equals("")||txt_InDueFormDate.getText().equals("")||tschoolage.getText().equals("")
                    ||txt_enterdate.getText().equals("")){
                    	new JOptionPane().showMessageDialog(null,"null is not allowd");
                    	}
                else{
                	String name=txt_name.getText();
                	String borndate=txt_borndate.getText();
                	String department=tdepartment.getText();
                	String headship=theadship.getText();
                	String indueformdate=txt_InDueFormDate.getText();
                	String schoolage=tschoolage.getText();
                	String enterdate=txt_enterdate.getText();
                	String remark=remark_ta.getText();

                	String sex=("" + sex_cb.getSelectedItem());
                	String marriage=(""+marriage_cb.getSelectedItem());
                	String estate=("" + estate_cb.getSelectedItem());
                	String politicsVisage=("" + politicsVisage_cb.getSelectedItem());

                	String sInsert="insert EmployeeInformation values('"+ name +"','"+ sex +"','"+  borndate+"',"+
                	               "'"+ marriage +"','"+ politicsVisage +"','"+ schoolage +"','"+ enterdate +"','"+ indueformdate +"',"+
                	               "'"+ department +"','"+ headship +"','"+  estate +"','"+ remark +"')";
                	//System.out.println(sInsert);

                	try{
                		if(Database.executeSQL(sInsert)){
                			txt_number.setEditable(true);
                			save_bt.setEnabled(false);
                			new JOptionPane().showMessageDialog(null,"add ok");

                			Database.joinDB();
                			String sql="select * from EmployeeInformation";
                			Database.query(sql);
                			Database.rs.last();
                			txt_number.setText("" + Database.rs.getInt("E_Number"));
                			}
                		}
                	catch(Exception einsert){
                		System.out.println(einsert);
                		}
                	}
     			}
     		});
//------------------------------------------------------------------------

     amend_bt.addActionListener(new ActionListener(){
     	public void actionPerformed(ActionEvent e){

           	String name=txt_name.getText();
        	String borndate=txt_borndate.getText();
        	String department=tdepartment.getText();
        	String headship=theadship.getText();
        	String indueformdate=txt_InDueFormDate.getText();
        	String schoolage=tschoolage.getText();
        	String enterdate=txt_enterdate.getText();
        	String remark=remark_ta.getText();

        	String sex=("" + sex_cb.getSelectedItem());
        	String marriage=(""+marriage_cb.getSelectedItem());
        	String estate=("" + estate_cb.getSelectedItem());
        	String politicsVisage=("" + politicsVisage_cb.getSelectedItem());

     		String supdate="update EmployeeInformation set E_Name ='"+ name +"',E_Sex='"+ sex +"'," +
     		               "E_BornDate='"+ borndate +"',E_Marriage='"+ marriage +"',E_PoliticsVisage='"+ politicsVisage +"'," +
     		               "E_SchoolAge='"+ schoolage+"',E_EnterDate='"+ enterdate +"',E_InDueFormDate='"+ indueformdate +"',"+
     		               "E_Department='"+ department +"',E_Headship='"+ headship +"',E_Estate='"+ estate +"'," +
     		               "E_Remark='"+ remark +"' where E_Number='"+ txt_number.getText() +"'";

     		System.out.println(supdate);
     		try{
     	     	if(Database.executeSQL(supdate)){
   					new JOptionPane().showMessageDialog(null,"change ok");
                        //System.out.println("supdate");
   					Database.joinDB();
   	  				String sqll="select * from EmployeeInformation";
  	  				Database.query(sqll);
   				    }
     			}
     		catch(Exception eupdate){}
     		}
     	});

     delet_bt.addActionListener(new ActionListener(){
     	public void actionPerformed(ActionEvent e){
     		String sdelete = "delete from EmployeeInformation where E_Number ='"+ txt_number.getText()+"'";
     		try{
     			if(Database.executeSQL(sdelete)){
     				new JOptionPane().showMessageDialog(null,"delete ok!");

	     		    String sql="select * from EmployeeInformation";
	     		    Database.query(sql);
	     		    Database.rs.next();


	            	txt_number.setText("" + Database.rs.getInt("E_Number"));
	            	txt_name.setText(Database.rs.getString("E_Name"));
	            	if(Database.rs.getString("E_Sex").equals("male")){
	            		sex_cb.setSelectedIndex(0);
	            		}
	            	else{
	            		sex_cb.setSelectedIndex(1);
	            		}
	            		//System.out.println(""+sex_cb.getSelectedItem());
	            	txt_borndate.setText(Database.rs.getString("E_BornDate"));
	            	tdepartment.setText(Database.rs.getString("E_Department"));

	           	if(Database.rs.getString("E_Marriage").equals("unmarried")){
	            		marriage_cb.setSelectedIndex(0);
	            		}
	            	else if(Database.rs.getString("E_Marriage").equals("married")){
	            		marriage_cb.setSelectedIndex(1);
	            		}
	            	else{
	            		marriage_cb.setSelectedIndex(2);
	            		}
	            		//System.out.println(""+marriage_cb.getSelectedItem());
	            	theadship.setText(Database.rs.getString("E_Headship"));
	            	txt_InDueFormDate.setText(Database.rs.getString("E_InDueFormDate"));
	            	if(Database.rs.getString("E_PoliticsVisage").equals("party")){
	            		politicsVisage_cb.setSelectedIndex(0);
	            		}
	            	else{
	            		politicsVisage_cb.setSelectedIndex(1);
	            		}

	            	tschoolage.setText(Database.rs.getString("E_SchoolAge"));
	            	txt_enterdate.setText(Database.rs.getString("E_EnterDate"));
	            	if(Database.rs.getString("E_Estate").equals("working")){
	            		estate_cb.setSelectedIndex(0);
	            		}
	            	else if(Database.rs.getString("E_Estate").equals("stop working")){
	            		estate_cb.setSelectedIndex(1);
	            		}
	            	else{
	            		estate_cb.setSelectedIndex(2);
	            		}
	            	remark_ta.setText(Database.rs.getString("E_Remark"));
	     				}
     			}
     		catch(Exception er){
     			System.out.println(er);
     			}
     		}
     	});

     exit_bt.addActionListener(new ActionListener(){
     	public void actionPerformed(ActionEvent e){
     		jif.setVisible(false);
     		}
     	});
//--------------------------------------------------------------------------------------------

        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-558)/2, (screenSize.height-477)/2, 558, 455);
        this.setClosable(true);
        this.setMaximizable(true);
        setVisible(true);
        */
        
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-558)/2, (screenSize.height-477)/2, 558, 455);
        this.setClosable(true);
        this.setMaximizable(true);
        setVisible(true);

    }
}
