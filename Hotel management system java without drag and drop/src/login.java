import javax.swing.*;


import java.awt.Color;
import java.awt.Image;
import java.awt.event.*;
import java.sql.*;
public class login extends JFrame implements ActionListener{

	JLabel l1,l2;
	JTextField t1;
	JPasswordField t2;
	JButton b1,b2;
	
	
	public login() {
		// TODO Auto-generated constructor stub
		JLabel l0 = new JLabel("Login as Admin/Management");
		l0.setBounds(200,30,170,40);
		add(l0);
		
		
		l1 = new JLabel("UserName :");
		l1.setBounds(40,90,100,30);
		add(l1);
		
		l2 = new JLabel("Password :");
		l2.setBounds(40,170,100,30);
		add(l2);
		
		
		t1 = new JTextField();
		t1.setBounds(150,90,140,30);
		add(t1);
		
		t2 = new JPasswordField();
		t2.setBounds(150,170,140,30);
		add(t2);
		
		b1 = new JButton("LOGIN");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(40,260,100,30);
		b1.addActionListener(this);
		add(b1);
		
		
		b2 = new JButton("CANCEL");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(190,260,100,30);
		b2.addActionListener(this);
		add(b2);
		
		
		ImageIcon img1= new ImageIcon(this.getClass().getResource("/second.jpg"));
		
		Image i1 = img1.getImage().getScaledInstance(250, 250, Image.SCALE_DEFAULT);
		img1 = new ImageIcon(i1);
		JLabel l3 = new JLabel(img1);
		l3.setBounds(320,50,250,250);
		add(l3);
		
		
		
		getContentPane().setBackground(Color.white);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setBounds(450,250,600,400);
		setLayout(null);
		setVisible(true);
		setResizable(false);
	}
	
	public static void main(String[] args) {
		new login();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			
			String username = t1.getText();
			String password = t2.getText();
			conn obj = new conn();
			
			String sql = "select * from login where username='"+username+"' and password='"+password+"'";
			
			try {
				ResultSet rs = obj.s.executeQuery(sql);
				if(rs.next()) {
					this.setVisible(false);
					new Dashboard().setVisible(true);
					
				}else{
					JOptionPane.showMessageDialog(null, "Invalid Credentials");
					this.setVisible(false);
				}
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}else if(e.getSource()==b2) {
			System.exit(0);
		}
		
	}
	
}
