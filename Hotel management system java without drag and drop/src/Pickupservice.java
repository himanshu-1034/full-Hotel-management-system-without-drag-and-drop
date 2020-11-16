import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class Pickupservice extends JFrame implements ActionListener{
	
	Choice c1,c2;
	JButton b1,b2;
	JTable t1;
	public Pickupservice() {
	
		JLabel l1 = new JLabel("PICKUP SERVICE");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.blue);
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Type Of Car");
		l2.setBounds(50,100,100,20);
		add(l2);
		
		c1 = new Choice();
		try {
			
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from driver");
			while(rs.next()) {
				c1.add(rs.getString(5));
				
			}
			
			
		}catch(Exception ee) {
			
		}
		
		
		c1.setBounds(150,100,200,25);
		c1.setBackground(Color.white);
		add(c1);
		
		
		
		t1 = new JTable();
		t1.setBounds(0,200,1000,300);
		add(t1);
		
		
		b1 = new JButton("Submit");
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(300,520,120,30);
		add(b1);
		
		
		b2 = new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(500,520,120,30);
		add(b2);
		
		
		JLabel l3 = new JLabel("Name");
		l3.setBounds(30,160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Age");
		l4.setBounds(200,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(330,160,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Company");
		l6.setBounds(470,160,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Brand");
		l7.setBounds(630,160,100,20);
		add(l7);
		
		JLabel l8 = new JLabel("Availability");
		l8.setBounds(750,160,100,20);
		add(l8);
		
		JLabel l9 = new JLabel("Location");
		l9.setBounds(880,160,100,20);
		add(l9);
		
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,1000,650);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Pickupservice();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b2) {
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
			
		}
		else if(e.getSource()==b1) {
			String type = c1.getSelectedItem().toString();
		
			try {
				String sql1 = "select * from driver where brand='"+type+"'";
				conn c = new conn();
				
				

					ResultSet rs = c.s.executeQuery(sql1);
					t1.setModel(new DbUtils().resultSetToTableModel(rs));
					
				
				
				
			}catch(Exception ex) {ex.printStackTrace();}
			
		}
		
	}

}
