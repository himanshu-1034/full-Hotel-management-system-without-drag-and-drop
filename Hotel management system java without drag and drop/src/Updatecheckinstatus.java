import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class Updatecheckinstatus extends JFrame implements ActionListener{
	
	JButton b1,b2,b3;
	Choice c1;
	JTextField t1,t2,t3,t4,t5;
	
	public Updatecheckinstatus() {
		
		JLabel l1 = new JLabel("CHECK IN DETAILS");
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.blue);
		l1.setBounds(80,30,200,30);
		add(l1);
		
		JLabel l2 =new JLabel("Customer ID");
		l2.setBounds(30,80,100,20);
		add(l2);
		
		c1 = new Choice();
		try {
			
			conn o = new conn();
			ResultSet rs = o.s.executeQuery("select * from customer");
			while(rs.next()) {
				c1.add(rs.getString(2));
			}
			
		}catch(Exception ex) {}
		
		
		
		c1.setBounds(200,80,150,25);
		add(c1);
	
		
		JLabel l3 =new JLabel("Room Number");
		l3.setBounds(30,120,100,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
		t1.setEditable(false);
		add(t1);
		
		JLabel l4 =new JLabel("Name");
		l4.setBounds(30,160,100,20);
		
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		t2.setEditable(false);
		add(t2);
		
		JLabel l5 =new JLabel("Check In ");
		l5.setBounds(30,200,110,20);
		add(l5);
		
		
		t3 = new JTextField();
		t3.setBounds(200,200,150,25);
		t3.setEditable(false);
		add(t3);
		
		JLabel l6 =new JLabel("Amount Paid");
		l6.setBounds(30,240,100,20);
		add(l6);
		
		t4 = new JTextField();
		t4.setBounds(200,240,150,25);
		t4.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = t4.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	t4.setEditable(true);
	               
	            } else {
	            	t4.setEditable(false);
	               }
	         }
	      });
		add(t4);
		
		JLabel l7 =new JLabel("Pending Amount");
		l7.setBounds(30,280,100,20);
		add(l7);
		
		
		t5 = new JTextField();
		t5.setBounds(200,280,150,25);
		t5.setEditable(false);
		add(t5);
		
		b1 = new JButton("Check");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		b1.setBounds(30,340,100,30);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		b2.setBounds(140,340,100,30);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.addActionListener(this);
		b3.setBounds(250,340,100,30);
		add(b3);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/nine.jpg"));
		JLabel l = new JLabel(img1);
		l.setBounds(400,50,500,400);
		add(l);
		
		
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,980,500);
		this.setVisible(true);
	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Updatecheckinstatus();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			
			try {
				
				 conn c = new conn();
				 String id=  c1.getSelectedItem();
				 String sql = "select * from customer where id_number='"+id+"'";
				 
				 ResultSet rs = c.s.executeQuery(sql);
				 while(rs.next()) {
					 
					 t1.setText(rs.getString(6));
					 t2.setText(rs.getString(3));
					 t3.setText(rs.getString(7));
					 t4.setText(rs.getString(8));
					 int deposit = Integer.parseInt(rs.getString(8));
					 ResultSet rs2 = c.s.executeQuery("select * from room where room_number='"+rs.getString(6)+"'");
					 while(rs2.next()) {
						 int total = Integer.parseInt(rs2.getString(4));
						 int pending = total- deposit;
						 int zero = 0;
						 if(pending>0) {
							 t5.setText(Integer.toString(pending));
						 }else{
							 t5.setText(Integer.toString(zero));
						 }
					 }
					 
				 }
				
				
				
			}catch(Exception ea) {ea.printStackTrace();}
			
			
			
		}
		else if(e.getSource()==b2) {
			
			try {
				
				 conn c = new conn();
				 String room = t1.getText();
				 String name  =t2.getText();
				 String status = t3.getText();
				 String deposit = t4.getText();
				 String pending = t5.getText();
				 String id = c1.getSelectedItem();
				 String sql = "update customer set status='"+status+"',deposit='"+deposit+"',room_number='"+room+"' where id_number='"+id+"'";
				 c.s.executeUpdate(sql);
				 JOptionPane.showMessageDialog(null, "Data Updated successfully");
				 this.setVisible(false);
				 new Receptiondesk().setVisible(true);
				 
				
				
				
			}catch(Exception ea) {ea.printStackTrace();}
			
			
			
		}
		else if(e.getSource()==b3) {
			
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
			
		}
		
		
	}

}
