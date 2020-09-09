import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	JFrame frame;
	JButton button;
	JButton button2;
	JButton button3;
	JButton button4;
	JPanel panel;
	
	public GUI() {
		frame = new JFrame();
		button = new JButton("Show Teachers");
		button2 = new JButton("Show Police Officers");
		button3 = new JButton("Show Engineers");
		button4 = new JButton("Show Bankers");
		
		panel = new JPanel(new GridLayout(0, 1));
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Employee List");
		frame.pack();
		frame.setVisible(true);
		
		panel.add(button);
		panel.add(button2);
		panel.add(button3);
		panel.add(button4);
		
		button.addActionListener(this);
		button2.addActionListener(this);
	}
	
	public void displayElement(String x) {
		JLabel label = new JLabel(x);
		label.setBounds(0, 0, 200, 50);
		panel.add(label);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JLabel label = new JLabel("Hello");
		panel.add(label);
		panel.revalidate();
		panel.repaint();
		System.out.println("Hi");
		
	}
}
