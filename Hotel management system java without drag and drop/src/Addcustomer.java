import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Addcustomer extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t5;
	JComboBox c1,c3;
	JButton b1,b2;
	Choice c2;
	JRadioButton r1,r2;
	ButtonGroup bg1;

	public Addcustomer() {
		
		
		JLabel l1 = new JLabel("NEW CUSTOMER FORM");
		l1.setFont(new Font("Tahoma",Font.BOLD,18));
		l1.setForeground(Color.blue);
		l1.setBounds(100,20,300,30);
		add(l1);
		
		JLabel l2 = new JLabel("ID");
		l2.setBounds(35,80,100,20);
		add(l2);
		
		c1 = new JComboBox(new String[] {"Passport","Voter ID","Driving Lisence","Aadhar Card"});
		c1.setBounds(200,80,150,25);
		c1.setBackground(Color.white);
		add(c1);
	
		JLabel l3 = new JLabel("No. on Selected ID");
		l3.setBounds(35,120,150,20);
		add(l3);
		
		t1 = new JTextField();
		t1.setBounds(200,120,150,25);
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
		
		JLabel l4 = new JLabel("Name");
		l4.setBounds(35,160,100,20);
		add(l4);
		
		t2 = new JTextField();
		t2.setBounds(200,160,150,25);
		add(t2);
		
		JLabel l5 = new JLabel("Gender");
		l5.setBounds(35,200,100,20);
		add(l5);
		
		
		r1 = new JRadioButton("Male");
		r1.setBounds(200,200,60,25);
		r1.setBackground(Color.white);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setBounds(270,200,70,25);
		r2.setBackground(Color.white);
		add(r2);
		
		bg1  =new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		
		JLabel l6 = new JLabel("Country");
		l6.setBounds(35,240,100,20);
		add(l6);
		
		t3 = new JTextField();
		t3.setBounds(200,240,150,25);
		add(t3);
		
		JLabel l7 = new JLabel("Room Number Allocated");
		l7.setBounds(35,280,150,20);
		add(l7);
		
		c2 = new Choice();
		
		try {
			conn c= new conn();
			String sql = "select * from room where availability='Available' order by room_number";
			ResultSet rs = c.s.executeQuery(sql);
			while(rs.next()) {
				c2.add(rs.getObject(1).toString());
			}
		}catch(Exception e) {}
		
		
		c2.setBackground(Color.white);
		c2.setBounds(200,280,150,25);
		add(c2);
		
		JLabel l8 = new JLabel("CheckedIn Status");
		l8.setBounds(35,320,150,20);
		add(l8);
		
		c3 = new JComboBox(new String[] {"Yes","No"});
		c3.setBounds(200,320,150,25);
		add(c3);
		
		
		JLabel l9 = new JLabel("Deposit");
		l9.setBounds(35,360,100,20);
		add(l9);
		
		t5 = new JTextField();
		t5.setBounds(200,360,150,25);
		t5.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = t5.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	t5.setEditable(true);
	               
	            } else {
	            	t5.setEditable(false);
	               }
	         }
	      });
		add(t5);
		
		
		b1 = new JButton("Add Customer");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(50,410,120,25);
		b1.addActionListener(this);
		add(b1);
		
		
		b2 = new JButton("Back");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(200,410,120,25);
		b2.addActionListener(this);
		add(b2);
		
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/fifth.png"));
		Image i = img1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
		img1 = new ImageIcon(i);
		JLabel icon = new JLabel(img1);
		icon.setBounds(400,50,300,400);
		add(icon);
		
		
		this.setLayout(null);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(350,200,800,550);
		this.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Addcustomer();
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b2) {
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
		}else if(e.getSource()==b1) {
			
			String id = c1.getSelectedItem().toString();
			String id_number = t1.getText();
			String name = t2.getText();
			String gender = "";
			if(r1.isSelected()) {gender=r1.getText();}
			else if(r2.isSelected()) {gender=r2.getText();}
			String country = t3.getText();
			String room = c2.getSelectedItem();
			String status = c3.getSelectedItem().toString();
			String deposit = t5.getText();
			
			String sql = "insert into customer values ('"+id+"','"+id_number+"','"+name+"','"+gender+"','"+country+"','"+room+"','"+status+"','"+deposit+"')";
			String sql1 = "update room set availability='Occupied' where room_number='"+room+"'";
			conn c= new conn();
			try {
				c.s.executeUpdate(sql);
				c.s.executeUpdate(sql1);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "New Customer Added");
			this.setVisible(false);
			new Receptiondesk().setVisible(true);
		}
		
	}

}
