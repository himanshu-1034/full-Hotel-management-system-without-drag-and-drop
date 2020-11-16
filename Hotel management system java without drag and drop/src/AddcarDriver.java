import java.awt.event.*;
import java.awt.*;
import java.sql.*;
import javax.swing.*;

public class AddcarDriver extends JFrame implements ActionListener{
	
	JTextField t1,t2,t3,t4,t5;
	JComboBox c1,c2;
	JButton b1,b2;
	
	public AddcarDriver() {
		JLabel title = new JLabel("Add Car Drivers");
		title.setBounds(130,10,150,30);
		title.setFont(new Font("Tahoma",Font.BOLD,18));
		add(title);
		
		JLabel name = new JLabel("Name");
		name.setBounds(60,70,100,30);
		name.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(name);
		
		t1 = new JTextField();
		t1.setBounds(200,70,150,30);
		add(t1);
		
		
		JLabel age = new JLabel("Age");
		age.setBounds(60,120,100,30);
		age.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(age);
		
		t2 = new JTextField();
		t2.setBounds(200,120,150,30);
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
		gender.setBounds(60,170,100,30);
		gender.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(gender);
		
		c1 = new JComboBox(new String[] {"Male","Female"});
		c1.setBounds(200,170,150,30);
		c1.setBackground(Color.white);
		add(c1);
		
		
		
		JLabel car = new JLabel("Car Company");
		car.setBounds(60,220,100,30);
		car.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(car);
		
		t3 = new JTextField();
		t3.setBounds(200,220,150,30);
		add(t3);
		
		
		JLabel model = new JLabel("Car Model");
		model.setBounds(60,270,100,30);
		model.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(model);
		
		t4 = new JTextField();
		t4.setBounds(200,270,150,30);
		add(t4);
		
		
		
		JLabel available = new JLabel("Availability");
		available.setBounds(60,320,100,30);
		available.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(available);
		
		
		c2 = new JComboBox(new String[] {"Available","Not Available"});
		c2.setBounds(200,320,150,30);
		c2.setBackground(Color.white);
		add(c2);
		
		
		JLabel location = new JLabel("Location");
		location.setBounds(60,370,100,30);
		location.setFont(new Font("Tahoma",Font.PLAIN,14));
		add(location);
		
		t5 = new JTextField();
		t5.setBounds(200,370,150,30);
		add(t5);
		
		
		b1 = new JButton("Add Driver");
		b1.setBounds(60,420,130,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		
		
		b2 = new JButton("Cancel");
		b2.setBounds(220,420,130,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/eleven.jpg"));
		
		Image i1 = img1.getImage().getScaledInstance(550, 450, Image.SCALE_DEFAULT);
		img1  =new ImageIcon(i1);
		JLabel image = new JLabel(img1);
		image.setBounds(400,10,550,450);
		add(image);
	
	
		this.setBounds(350,200,980,520);
		this.getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setLayout(null);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new AddcarDriver();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			
			String name = t1.getText();
			String age = t2.getText();
			String gender = c1.getSelectedItem().toString();
			String company = t3.getText();
			String model = t4.getText();
			String available  =c2.getSelectedItem().toString();
			String location = t5.getText();
			
			conn obj = new conn();
			
			String sql = "insert into driver values('"+name+"','"+age+"','"+gender+"','"+company+"','"+model+"','"+available+"','"+location+"')";
			
			try {
				obj.s.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "New Car Driver Added !");
			this.setVisible(false);
			
			
		}else if(e.getSource()==b2) {
			this.setVisible(false);
		}
		
	}

}
