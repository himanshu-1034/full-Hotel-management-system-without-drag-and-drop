import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class Customerinfo extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1,b2;
	
	public Customerinfo() {
		
		
		JLabel l1,l2,l3,l4,l5,l6,l7,l8;
		
		l1 = new JLabel("DOC. GIVEN");
		l1.setBounds(20,10,70,20);
		add(l1);
	
		
		l2 = new JLabel("DOC. NUMBER");
		l2.setBounds(140,10,100,20);
		add(l2);
		
		
		l3 = new JLabel("NAME");
		l3.setBounds(280,10,70,20);
		add(l3);
		
		
		l4 = new JLabel("GENDER");
		l4.setBounds(400,10,70,20);
		add(l4);
		
		
		l5 = new JLabel("COUNTRY");
		l5.setBounds(520,10,70,20);
		add(l5);
		
		
		l6 = new JLabel("ROOM");
		l6.setBounds(640,10,70,20);
		add(l6);
		
		
		l7 = new JLabel("CHECK IN STATUS");
		l7.setBounds(760,10,120,20);
		add(l7);
		
		
		l8 = new JLabel("DEPOSIT");
		l8.setBounds(900,10,70,20);
		add(l8);
		
	
		t1 = new JTable();
		t1.setBounds(0,40,1000,500);
		add(t1);
		
		b1 = new JButton("Load Data");
		b1.setBounds(350,550,120,30);
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		add(b1);
		
		
		b2 = new JButton("Back");
		b2.setBounds(500,550,120,30);
		b2.addActionListener(this);

		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		add(b2);
		
		this.setLayout(null);
		this.setResizable(false);
		this.setBounds(340,200,1000,630);
		this.getContentPane().setBackground(Color.white);
		this.setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Customerinfo();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b2) {
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
		}
		else if(e.getSource()==b1) {
			
			conn obj = new conn();
			String sql = "select * from Customer";
			try {
				ResultSet rs = obj.s.executeQuery(sql);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
			
			
			
		}
		
	}

}
