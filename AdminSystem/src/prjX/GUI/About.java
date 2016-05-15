package prjX.GUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class About extends JInternalFrame {


 		JLabel label = new JLabel("Run in Windows");
		JLabel labe2 = new JLabel("JAVA");
		JLabel labe3 = new JLabel("DB: Sqlite");
		JLabel labe4 = new JLabel("Development Team");
		
		public About(){
	        setTitle("About");
	 	    Container con=getContentPane();
            con.setLayout(new GridLayout(4,1));
            con.add(label);
            con.add(labe2);
            con.add(labe3);
            con.add(labe4);
            con.setBackground(Color.gray);


	 	    setResizable(false);
	 	    setSize(380,220);
	 	    setVisible(true);
	 	    setClosable(true);
			}

	}
