import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;
public class Addemployee extends JFrame implements ActionListener{

	JTextField t1,t2,t3,t4,t5,t6;
	JRadioButton r1,r2;
	ButtonGroup bg1;
	JComboBox c1;
	JButton b1,b2;
	
	public Addemployee() {
		JLabel name = new JLabel("Name");
		name.setFont(new Font("Tahoma",Font.PLAIN,17));
		name.setBounds(60,30,120,30);
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,30,150,30);
		add(t1);
		
		
		JLabel age = new JLabel("Age");
		age.setFont(new Font("Tahoma",Font.PLAIN,17));
		age.setBounds(60,80,120,30);
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,80,150,30);
		t2.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = t2.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	t2.setEditable(true);
	               
	            } else {
	            	t2.setEditable(false);
	               }
	         }
	      });
		add(t2);
		
		JLabel gender = new JLabel("Gender");
		gender.setFont(new Font("Tahoma",Font.PLAIN,17));
		gender.setBounds(60,130,120,30);
		add(gender);
		
		r1 = new JRadioButton("Male");
		r1.setFont(new Font("Tahoma",Font.PLAIN,14));
		r1.setBounds(200,130,70,30);
		r1.setBackground(Color.white);
		add(r1);
		
		r2 = new JRadioButton("Female");
		r2.setFont(new Font("Tahoma",Font.PLAIN,14));
		
		r2.setBackground(Color.white);
		r2.setBounds(270,130,70,30);
		add(r2);
		
		bg1 = new ButtonGroup();
		bg1.add(r1);
		bg1.add(r2);
		
		
		JLabel job = new JLabel("Job");
		job.setFont(new Font("Tahoma",Font.PLAIN,17));
		job.setBounds(60,180,120,30);
		add(job);
		
		String str[] = {"Front Desk Clerk","Porters","Housekeeping","Kitchen Staff","Room Service","Waiter/Waitress","Manager","Accountant","Chef"};
		c1 = new JComboBox(str);
		c1.setBounds(200,180,150,30);
		c1.setBackground(Color.white);
		add(c1);
		
		
		
		JLabel salary = new JLabel("Salary");
		salary.setFont(new Font("Tahoma",Font.PLAIN,17));
		salary.setBounds(60,230,120,30);
		add(salary);
		
		t3 = new JTextField();
		t3.setBounds(200,230,150,30);
		t3.addKeyListener(new KeyAdapter() {
	         public void keyPressed(KeyEvent ke) {
	            String value = t3.getText();
	            int l = value.length();
	            if ((ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9')|| (ke.getKeyCode()==8)) {
	            	t3.setEditable(true);
	               
	            } else {
	            	t3.setEditable(false);
	               }
	         }
	      });
		add(t3);
		
		

		JLabel phone = new JLabel("Phone No.");
		phone.setFont(new Font("Tahoma",Font.PLAIN,17));
		phone.setBounds(60,280,120,30);
		add(phone);
		
		t4 = new JTextField();
		t4.setBounds(200,280,150,30);
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
		
		
		

		JLabel aadhar = new JLabel("Aadhar");
		aadhar.setFont(new Font("Tahoma",Font.PLAIN,17));
		aadhar.setBounds(60,330,120,30);
		add(aadhar);
		
		t5 = new JTextField();
		t5.setBounds(200,330,150,30);
		add(t5);
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
		
		

		JLabel email = new JLabel("E-Mail");
		email.setFont(new Font("Tahoma",Font.PLAIN,17));
		email.setBounds(60,380,120,30);
		add(email);
		
		t6 = new JTextField();
		t6.setBounds(200,380,150,30);
		add(t6);
		
		
		b1 = new JButton("Submit");
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.setBounds(220,430,130,30);
		b1.addActionListener(this);
		add(b1);
		
		
		b2 = new JButton("Cancel");
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.setBounds(60,430,130,30);
		b2.addActionListener(this);
		add(b2);
		
		
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/tenth.jpg"));
		Image i1 = img1.getImage().getScaledInstance(390,480, Image.SCALE_DEFAULT);
		
		img1 = new ImageIcon(i1);
		JLabel l1 = new JLabel(img1);
		l1.setBounds(400,70,390,400);
		add(l1);
		
		
		JLabel l2 = new JLabel("Add Employee Details");
		l2.setForeground(Color.blue);
		l2.setFont(new Font("Tahoma",Font.BOLD,26));
		l2.setBounds(420,30,400,30);
		add(l2);
		
		getContentPane().setBackground(Color.white);
		
		
		this.setLayout(null);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setBounds(400,200,800,550);
		this.setVisible(true);
		
		// TODO Auto-generated constructor stub
	}
	
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == b1){
			
			String name = t1.getText();
			String age = t2.getText();
			String salary = t3.getText();
			String phone = t4.getText();
			String aadhar = t5.getText();
			String email = t6.getText();
			String gender ="";
			if(r1.isSelected()) {
				gender = r1.getText();
			}else if(r2.isSelected()) {
				gender = r2.getText();
			}
			
			String job = c1.getSelectedItem().toString();
			
			conn c = new conn();
			String sql = "insert into employee values ('"+name+"','"+age+"','"+gender+"','"+job+"','"+salary+"','"+phone+"','"+aadhar+"','"+email+"')";
			try {
				c.s.executeUpdate(sql);
				JOptionPane.showMessageDialog(null, "Employee Added Successfully");
				this.setVisible(false);
				
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				
			}
		}
		else if(e.getSource()==b2) {
			this.setVisible(false);
			
		}
		
		// TODO Auto-generated method stub
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Addemployee();

	}



}
