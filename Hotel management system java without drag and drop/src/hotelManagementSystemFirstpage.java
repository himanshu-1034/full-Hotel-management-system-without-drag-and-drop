import java.awt.*;

import javax.swing.*;
import java.awt.event.*;

public class hotelManagementSystemFirstpage extends JFrame implements ActionListener{
	
	
	public hotelManagementSystemFirstpage() {
			setSize(1366,565);
			setLocation(100, 100);
			setResizable(false);
			
			ImageIcon img1 = new ImageIcon(this.getClass().getResource("/first.jpg"));
			
			JLabel l1 = new JLabel(img1);
			l1.setBounds(0, 0, 1366, 565);
			add(l1);
			JLabel l2 = new JLabel("WELCOME TO OUR HOTEL");
			l2.setBounds(20,390,1000,100);
			l2.setForeground(Color.white);
			l2.setFont(new Font(
				"serif" , Font.PLAIN , 60	
					));
			l1.add(l2);
			
			JButton b1 = new JButton("NEXT");
			b1.setBackground(Color.white);
			b1.setForeground(Color.black);
			b1.setBounds(1230,460,90,40);
			b1.addActionListener(this);
			l1.add(b1);
			
			
			
			setLayout(null);
		
			setVisible(true);
			while(true) {
				l2.setVisible(false);
				try {
					Thread.sleep(500);
				}catch(Exception e) {
					e.printStackTrace();
				}
				l2.setVisible(true);
				try {
				Thread.sleep(500);
			}catch(Exception e) {
				e.printStackTrace();
			}
			}
			
			
			
			
		
			
			
	}
	



	@Override
	public void actionPerformed(ActionEvent e) {
		
		new login().setVisible(true);
		this.setVisible(false);
	}

	
	

	public static void main(String[] args) {
		
		new hotelManagementSystemFirstpage();
		
	}
}
