import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
public class Receptiondesk extends JFrame implements ActionListener{

	
	JButton b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12;
	
	public Receptiondesk() {
		
		b1 = new JButton("New Customer Form");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(10,30,200,30);
		b1.addActionListener(this);
		add(b1);
	
		
		b2 = new JButton("ROOM");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		b2.setBounds(10,70,200,30);
		add(b2);
		
		
		b3 = new JButton("Department");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(10,110,200,30);
		b3.addActionListener(this);
		add(b3);
		
		
		b4 = new JButton("All Employee Info");
		b4.setBackground(Color.black);
		b4.setForeground(Color.white);
		b4.setBounds(10,150,200,30);
		b4.addActionListener(this);
		add(b4);
		
		
		b5 = new JButton("Customer Info");
		b5.setBackground(Color.black);
		b5.setForeground(Color.white);
		b5.setBounds(10,190,200,30);
		b5.addActionListener(this);
		add(b5);
		
		
		b6 = new JButton("Manager Info");
		b6.setBackground(Color.black);
		b6.setForeground(Color.white);
		b6.setBounds(10,230,200,30);
		b6.addActionListener(this);
		add(b6);
		
		
		b7 = new JButton("Check Out");
		b7.setBackground(Color.black);
		b7.setForeground(Color.white);
		b7.setBounds(10,270,200,30);
		b7.addActionListener(this);
		add(b7);
		
		
		b8 = new JButton("Update Check Status");
		b8.setBackground(Color.black);
		b8.setForeground(Color.white);
		b8.setBounds(10,310,200,30);
		b8.addActionListener(this);
		add(b8);
		
		
		b9 = new JButton("Update Room Status");
		b9.setBackground(Color.black);
		b9.setForeground(Color.white);
		b9.setBounds(10,350,200,30);
		b9.addActionListener(this);
		add(b9);
		
		
		b10 = new JButton("Pickup Service");
		b10.setBackground(Color.black);
		b10.setForeground(Color.white);
		b10.setBounds(10,390,200,30);
		b10.addActionListener(this);
		add(b10);
		
		
		b11 = new JButton("Search Room");
		b11.setBackground(Color.black);
		b11.setForeground(Color.white);
		b11.setBounds(10,430,200,30);
		b11.addActionListener(this);
		add(b11);
		
		
		b12 = new JButton("Log Out");
		b12.setBackground(Color.black);
		b12.setForeground(Color.white);
		b12.setBounds(10,470,200,30);
		b12.addActionListener(this);
		add(b12);
		
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/fourth.jpg"));
		JLabel l1 = new JLabel(img1);
		l1.setBounds(250,30,500,470);
		add(l1);
		
		
		
		
		
		this.setBounds(440,200,790,550);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		new Receptiondesk();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			
			this.setVisible(false);
			new Addcustomer().setVisible(true);
			
		}
		else if(e.getSource()==b2) {
			new Roominfo().setVisible(true);
			this.setVisible(false);
			
		}
		else if(e.getSource()==b3) {
			
			this.setVisible(false);
			new Department().setVisible(true);
			
		}
		else if(e.getSource()==b4) {
			
			new Employeeinfo().setVisible(true);
			this.setVisible(false);
			
		}
		else if(e.getSource()==b5) {
			new Customerinfo().setVisible(true);
			this.setVisible(false);
		}
		else if(e.getSource()==b6) {
			
			this.setVisible(false);
			new Managerinfo().setVisible(true);
			
		}
		else if(e.getSource()==b7) {
			
			this.setVisible(false);
			new Checkout().setVisible(true);
		}
		else if(e.getSource()==b8) {
			this.setVisible(false);
			new Updatecheckinstatus().setVisible(true);
			
		}
		else if(e.getSource()==b9) {
			
			this.setVisible(false);
			new Updateroom().setVisible(true);
			
		}
		else if(e.getSource()==b10) {
			
			this.setVisible(false);
			new Pickupservice().setVisible(true);
			
			
		}
		else if(e.getSource()==b11) {
			this.setVisible(false);
			new Searchroom().setVisible(true);
			
		}
		else if(e.getSource()==b12) {
			this.setVisible(false);
			}
		
		
	}

}
