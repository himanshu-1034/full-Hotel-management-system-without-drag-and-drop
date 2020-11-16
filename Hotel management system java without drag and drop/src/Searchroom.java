import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class Searchroom extends JFrame implements ActionListener{
	
	JComboBox c1;
	JCheckBox c2;
	JButton b1,b2;
	JTable t1;
	public Searchroom() {
	
		JLabel l1 = new JLabel("SEARCH FOR ROOM");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.blue);
		l1.setBounds(400,30,200,30);
		add(l1);
		
		JLabel l2 = new JLabel("Room Bed Type");
		l2.setBounds(50,100,100,20);
		add(l2);
		
		c1 = new JComboBox(new String[] {"Single Bed","Double Bed"});
		c1.setBounds(150,100,150,25);
		c1.setBackground(Color.white);
		add(c1);
		
		c2 = new JCheckBox("Only Display Available");
		c2.setBounds(650,100,150,25);
		add(c2);
		c2.setBackground(Color.white);
		
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
		
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(50,160,100,20);
		add(l3);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(240,160,100,20);
		add(l4);
		
		JLabel l5 = new JLabel("Clean Status");
		l5.setBounds(450,160,100,20);
		add(l5);
		
		JLabel l6 = new JLabel("Price(Rs.)");
		l6.setBounds(650,160,100,20);
		add(l6);
		
		JLabel l7 = new JLabel("Bed Type");
		l7.setBounds(850,160,100,20);
		add(l7);
		
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,1000,650);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Searchroom();

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
				String sql1 = "select * from room where bed_type='"+type+"' order by room_number";
				String sql2 = "select * from room where bed_type='"+type+"' and availability='Available' order by room_number";
				conn c = new conn();
				
				if(c2.isSelected()) {
				
					ResultSet rs = c.s.executeQuery(sql2);
					t1.setModel(new DbUtils().resultSetToTableModel(rs));
					
				}else {
					

					ResultSet rs = c.s.executeQuery(sql1);
					t1.setModel(new DbUtils().resultSetToTableModel(rs));
					
				}
				
				
			}catch(Exception ex) {ex.printStackTrace();}
			
		}
		
	}

}
