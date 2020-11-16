import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;


public class Checkout extends JFrame implements ActionListener{
	
	Choice c1;
	JTextField t1;
	JButton b1,b2,b3;
	
	
	public Checkout() {
	
		JLabel l1 = new JLabel("Check Out");
		l1.setBounds(30,20,110,30);
		l1.setFont(new Font("Tahoma",Font.BOLD,20));
		l1.setForeground(Color.blue);
		add(l1);
		
		
		JLabel l2 = new JLabel("Customer ID");
		l2.setBounds(30,80,100,30);
		add(l2);
		
		c1 = new Choice();
		try {
			conn c = new conn();
			ResultSet rs  =c.s.executeQuery("select * from customer");
			while(rs.next()) {
				c1.add(rs.getString(2));
				
			}
			
		}catch(Exception es) {}
		c1.setBounds(150,80,150,30);
		add(c1);
		
		
		JLabel l3 = new JLabel("Room Number");
		l3.setBounds(30,130,100,30);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(150,130,150,30);
		add(t1);
		t1.setEditable(false);
		
		b1 =new JButton("CheckOut");
		b1.addActionListener(this);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(30,200,120,30);
		add(b1);
		
		b2 =new JButton("Back");
		b2.addActionListener(this);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(180,200,120,30);
		add(b2);
		
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/tick.png"));
		Image i = img1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
		img1 = new ImageIcon(i);
		
		b3 = new JButton(img1);
		b3.setBounds(310,80,20,20);
		b3.addActionListener(this);
		add(b3);
		
		ImageIcon img2 = new ImageIcon(this.getClass().getResource("/sixth.jpg"));
		Image i2 = img2.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
		img2 = new ImageIcon(i2);
		JLabel l4 = new JLabel(img2);
		l4.setBounds(350,10,400,250);
		add(l4);
		

		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,780,320);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		new Checkout();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b2) {
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
		}else if(e.getSource()==b1) {
			
			String id = c1.getSelectedItem();
			String room = t1.getText();
			String sql  ="delete from customer where id_number='"+id+"'";
			String sql1 = "update room set availability='Available' where room_number='"+room+"'";
			
			try {
				
				conn c = new conn();
				c.s.executeUpdate(sql);
				c.s.executeUpdate(sql1);
				JOptionPane.showMessageDialog(null, "Data Updated Successfully");
				this.setVisible(false);
				new Receptiondesk().setVisible(true);
				
				
			}catch(Exception es) {es.printStackTrace();}
			
			
		}else if(e.getSource()==b3) {
			
			String id = c1.getSelectedItem();
			String sql = "select * from customer where id_number='"+id+"'";
			try {
				conn c = new conn();
				ResultSet rs = c.s.executeQuery(sql);
				while(rs.next()) {
					t1.setText(rs.getString(6));
				}
				
			}catch(Exception ex) {ex.printStackTrace();}
			
		}
		
	}

}
