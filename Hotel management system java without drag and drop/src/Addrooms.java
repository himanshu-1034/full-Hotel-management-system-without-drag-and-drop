import javax.swing.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;

public class Addrooms extends JFrame implements ActionListener{
	
	
	JTextField t1,t2;
	JComboBox c1,c2,c3;
	JButton b1,b2;
	public Addrooms() {
	
		JLabel l1 = new JLabel("ADD ROOMS");
		l1.setBounds(140,20,120,20);
		l1.setFont(new Font("Tahoma",Font.BOLD,17));		
		add(l1);
		
		
		JLabel room = new JLabel("Room Number");
		room.setFont(new Font("Tahome", Font.PLAIN, 16));
		room.setBounds(60,80,120,30);
		add(room);
		
		t1 = new JTextField();
		t1.setBounds(200,80,150,30);
		add(t1);
		
		JLabel available = new JLabel("Availability ");
		available.setFont(new Font("Tahome", Font.PLAIN, 16));
		available.setBounds(60,130,120,30);
		add(available);
		
		c1 = new JComboBox(new String[] {"Available","Occupied"});
		c1.setBounds(200,130,150,30);
		c1.setBackground(Color.white);
		add(c1);
		
		
		JLabel clean = new JLabel("Cleaning Status");
		clean.setFont(new Font("Tahome", Font.PLAIN, 16));
		clean.setBounds(60,180,120,30);
		add(clean);
		
		c2 = new JComboBox(new String[] {"Cleaned","Dirty"});
		c2.setBounds(200,180,150,30);
		c2.setBackground(Color.white);
		add(c2);
		
		JLabel price = new JLabel("Price");
		price.setFont(new Font("Tahome", Font.PLAIN, 16));
		price.setBounds(60,230,120,30);
		
		add(price);
		
		t2 = new JTextField();
		t2.setBounds(200,230,150,30);
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
		
		
		JLabel bed = new JLabel("Bed Type");
		bed.setFont(new Font("Tahome", Font.PLAIN, 16));
		bed.setBounds(60,280,120,30);
		add(bed);
		
		c3 = new JComboBox(new String[] {"Single Bed","Double Bed"});
		c3.setBounds(200,280,150,30);
		c3.setBackground(Color.white);
		add(c3);
		
		b1= new JButton("Add Room");
		b1.setBounds(60,350,130,30);
		b1.setBackground(Color.black);
		b1.setForeground(Color.white);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(220,350,130,30);
		b2.setBackground(Color.black);
		b2.setForeground(Color.white);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/twelve.jpg"));
		JLabel l2 = new JLabel(img1);
		l2.setBounds(390,30,500,350);
		add(l2);
		
		
		
		
		
		getContentPane().setBackground(Color.white);
		this.setResizable(false);
		this.setBounds(320,200,920,500);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);	
		this.setLayout(null);
		this.setVisible(true);
	}
	
	

	public static void main(String[] args) {
		new Addrooms();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		if(e.getSource()==b1) {
			
			String room = t1.getText();
			String available = c1.getSelectedItem().toString();
			String clean = c2.getSelectedItem().toString();
			String price = t2.getText();
			String bed = c3.getSelectedItem().toString();
			
			
			String sql = "insert into room values('"+room+"','"+available+"','"+clean+"','"+price+"','"+bed+"')";
			conn ob = new conn();
			
			try {
				ob.s.executeUpdate(sql);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			JOptionPane.showMessageDialog(null, "Room Added Successfully.");
			this.setVisible(false);
			
			
			
			
		}else if(e.getSource()==b2) {
			this.setVisible((false));
		}
		
	}

}
