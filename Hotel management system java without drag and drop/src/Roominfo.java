import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import net.proteanit.sql.*;
public class Roominfo extends JFrame implements ActionListener{
	
	JTable t1;
	JButton b1,b2;
	

	public Roominfo() {
	t1 = new JTable();
	t1.setBounds(0,40,500,400);
	add(t1);
	
	b1 = new JButton("Load Data");
	b1.setBounds(100,460,120,30);

	b1.setBackground(Color.black);
	b1.setForeground(Color.white);
	b1.addActionListener(this);
	add(b1);
	
	
	b2 = new JButton("Back");
	b2.setBounds(240,460,120,30);
	b2.setBackground(Color.black);
	b2.setForeground(Color.white);
	b2.addActionListener(this);
	add(b2);
	
	ImageIcon img1 = new ImageIcon(this.getClass().getResource("/eight.jpg"));
	Image i = img1.getImage().getScaledInstance(450, 480, Image.SCALE_DEFAULT);
	img1 = new ImageIcon(i);
	JLabel l = new JLabel(img1);
	l.setBounds(520,10,450,480);
	add(l);
	
	
	JLabel l1 = new JLabel("Room number");
	l1.setBounds(10,10,100,20);
	add(l1);
	
	JLabel l2 = new JLabel("Availability");
	l2.setBounds(120,10,80,20);
	add(l2);
	
	JLabel l3 = new JLabel("Status");
	l3.setBounds(220,10,100,20);
	add(l3);
	
	JLabel l4= new JLabel("Price");
	l4.setBounds(320,10,60,20);
	add(l4);
	
	JLabel l5 = new JLabel("Bed Type");
	l5.setBounds(410,10,100,20);
	add(l5);
	
	this.setLayout(null);
	this.getContentPane().setBackground(Color.white);
	this.setResizable(false);
	this.setBounds(350,200,1000,550);
	this.setVisible(true);
		
	}
	
	
	public static void main(String[] args) {
		
		new Roominfo();
		// TODO Auto-generated method stub

	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b2) {
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
		}else if(e.getSource()==b1) {
			
			conn c = new conn();
			String sql = "select * from room";
			
			try {
				ResultSet rs = c.s.executeQuery(sql);
				t1.setModel(DbUtils.resultSetToTableModel(rs));
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			
		}
	}

}
