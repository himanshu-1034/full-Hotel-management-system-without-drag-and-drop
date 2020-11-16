import javax.swing.*;
import java.sql.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.*;



public class Dashboard extends JFrame implements ActionListener{

	JMenuBar mb;
	JMenu m1,m2;
	JMenuItem i1,i2,i3,i4;
	
	public Dashboard() {
	
		mb = new JMenuBar();
		add(mb);
		
		m1 = new JMenu("HOTEL MANAGEMENT");
		m1.setForeground(Color.RED);
		mb.add(m1);
		
		m2 = new JMenu("ADMIN");
		m2.setForeground(Color.blue);
		mb.add(m2);
		
		i1 = new JMenuItem("Reception");
		i1.addActionListener(this);
		m1.add(i1);
		
		i2 = new JMenuItem("Add Employee");
		i2.addActionListener(this);
		m2.add(i2);

		i3 = new JMenuItem("Add Rooms");
		i3.addActionListener(this);
		m2.add(i3);
		
		i4 = new JMenuItem("Add Car Drivers");
		i4.addActionListener(this);
		m2.add(i4);
		
		
		mb.setBounds(0,0,1880,30);
		
		ImageIcon img1 = new ImageIcon(this.getClass().getResource("/third.jpg"));
		Image  i2 = img1.getImage().getScaledInstance(1880, 970, Image.SCALE_DEFAULT);
		img1 = new ImageIcon(i2);
		JLabel l1 = new JLabel(img1);
		l1.setBounds(0,30,1880,970);
		add(l1);
		
		JLabel l2 = new JLabel("THE TAJ HOTEL WELCOMES YOU");
		l2.setBounds(500,50,600,70);
		l2.setForeground(Color.white);
		l2.setFont(new Font("Tahoma",Font.PLAIN,40));
		l1.add(l2);
		
		setLayout(null);
		setBounds(0,0,1880,1000);
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Dashboard();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getActionCommand().equals("Add Employee")) {
			new Addemployee().setVisible(true);
		}
		else if(e.getActionCommand().equals("Reception")) {
			
			new Receptiondesk().setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Add Rooms")) {
			
			new Addrooms().setVisible(true);
			
		}
		else if(e.getActionCommand().equals("Add Car Drivers")) {
			
			new AddcarDriver().setVisible(true);
			
		}
		
	}

}
