import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class Department extends JFrame implements ActionListener{
	
	
	JButton b1,b2;
	JTable t1;
	public Department() {
	
//		JLabel l1 = new JLabel("DEPARTMENT");
//		l1.setFont(new Font("Tahoma",Font.BOLD,20));
//		l1.setForeground(Color.blue);
//		l1.setBounds(400,30,200,30);
//		add(l1);
//		
		
		
		
		
		
		
		t1 = new JTable();
		t1.setBounds(0,50,700,350);
		add(t1);
		
		
		b1 = new JButton("Submit");
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(180,400,120,30);
		add(b1);
		
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(380,400,120,30);
		add(b2);
		
		
		JLabel l3 = new JLabel("Department");
		l3.setBounds(150,10,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Budget");
		l4.setBounds(500,10,100,20);
		add(l4);
		
		
		
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,700,480);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Department();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b2) {
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
			
		}
		else if(e.getSource()==b1) {
			
		
			try {
				String sql1 = "select * from department";
				
				// ADD ROWS INTO DEPARTMENT TABLE YOURSELF
				// department column ["Marketing","Managing"......]
				// budget column ["1100000","1200000"..........]
				conn c = new conn();
				
				

					ResultSet rs = c.s.executeQuery(sql1);
					t1.setModel(new DbUtils().resultSetToTableModel(rs));
					
				
				
				
			}catch(Exception ex) {ex.printStackTrace();}
			
		}
		
	}

}
