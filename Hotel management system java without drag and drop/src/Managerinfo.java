import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import net.proteanit.sql.*;
public class Managerinfo extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1,b2;
	
	public Managerinfo() {
		
		
		JLabel l1,l2,l3,l4,l5,l6,l7,l8;
		
		l1 = new JLabel("NAME");
		l1.setBounds(40,10,70,20);
		add(l1);
	
		
		l2 = new JLabel("AGE");
		l2.setBounds(160,10,70,20);
		add(l2);
		
		
		l3 = new JLabel("GENDER");
		l3.setBounds(280,10,70,20);
		add(l3);
		
		
		l4 = new JLabel("JOB NAME");
		l4.setBounds(400,10,70,20);
		add(l4);
		
		
		l5 = new JLabel("SALARY");
		l5.setBounds(520,10,70,20);
		add(l5);
		
		
		l6 = new JLabel("PHONE NO.");
		l6.setBounds(640,10,70,20);
		add(l6);
		
		
		l7 = new JLabel("AADHAR NO.");
		l7.setBounds(760,10,80,20);
		add(l7);
		
		
		l8 = new JLabel("E-MAIL");
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

		new Managerinfo();
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
			String sql = "select * from employee where job = 'Manager'";
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
