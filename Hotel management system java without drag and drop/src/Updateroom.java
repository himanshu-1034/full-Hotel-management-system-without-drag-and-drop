import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Updateroom extends JFrame implements ActionListener{
	
	Choice c1;
	JTextField t1,t2,t3;
	JButton b1,b2,b3;
	
	
	public Updateroom() {
		
		JLabel l1 = new JLabel("UPDATE ROOM STATUS");
		l1.setBounds(30,20,250,30);
		l1.setForeground(Color.blue);
		l1.setFont(new Font("Tahoma",Font.PLAIN,20));
		add(l1);
		
		
		JLabel l2 = new JLabel("Guest ID");
		l2.setBounds(30,80,120,20);
		add(l2);
		
		c1  = new Choice();
		try {
			
			conn c = new conn();
			ResultSet rs = c.s.executeQuery("select * from customer");
			while(rs.next()) {
				c1.add(rs.getObject(2).toString());
			}
			
		}catch(Exception e) {}
		
		c1.setBounds(200,80,150,25);
		add(c1);
		
		
		JLabel l3 = new JLabel("Room No.");
		l3.setBounds(30,130,120,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,130,150,25);
		t1.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = t1.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	t1.setEditable(true);
	               
	            } else {
	            	t1.setEditable(false);
	               }
	         }
	      });
		add(t1);
		
		JLabel l4 = new JLabel("Availability");
		l4.setBounds(30,180,120,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,180,150,25);
		add(t2);
		
		
		JLabel l5 = new JLabel("Clean Status");
		l5.setBounds(30,230,120,20);
		add(l5);
		
		t3 = new JTextField();
		t3.setBounds(200,230,150,25);
		add(t3);
		
		
		b1 = new JButton("Check");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(130,300,120,30);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Update");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(40,350,120,30);
		b2.addActionListener(this);
		add(b2);
		
		b3 = new JButton("Back");
		b3.setBackground(Color.black);
		b3.setForeground(Color.white);
		b3.setBounds(220,350,120,30);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/seventh.jpg"));
		 Image i = img1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
		 img1 = new ImageIcon(i);
		JLabel l = new JLabel(img1);
		l.setBounds(400,20,500,400);
		add(l);
		
	
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,950,450);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Updateroom();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			
			String id= c1.getSelectedItem();
			conn c = new conn();
			try {
				ResultSet rs = c.s.executeQuery("select * from customer where id_number='"+id+"'");
				while(rs.next()) {
					t1.setText(rs.getString(6));
					ResultSet rs2 = c.s.executeQuery("select * from room where room_number='"+rs.getString(6)+"'");
					while(rs2.next()) {
						
						t2.setText(rs2.getString(2));
						t3.setText(rs2.getString(3));
						
					}
					
					
					
					
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}
		else if(e.getSource()==b2) {
			
			try {
				
				conn c = new conn();
				String room = t1.getText().trim();
				String available = t2.getText().trim();
				String status = t3.getText().trim();
				String id = c1.getSelectedItem().trim();
				String sql  = "update room set availability='"+available+"' ,clean_status='"+status+"' where room_number='"+room+"'";
				
				String sql1 = "update customer set room_number='"+room+"' where id_number='"+id+"'";
				c.s.executeUpdate(sql);
				c.s.executeUpdate(sql1);
				
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				new Receptiondesk().setVisible(true);
				this.setVisible(false);
			}catch(Exception ae) {
				ae.printStackTrace();
			}
			
			
		}
		else if(e.getSource()==b3) {
			new Receptiondesk().setVisible(true);
			this.setVisible(false);
		}

		
	}

}
