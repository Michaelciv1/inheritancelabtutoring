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
	JPanel panel;
	
	public GUI() {
		frame = new JFrame();
		button = new JButton();
		panel = new JPanel();
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		panel.setLayout(new GridLayout(0, 1));
		//panel.add(button);
		//button.addActionListener(this);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Employee List");
		frame.pack();
		frame.setVisible(true);
	}
	
	public void displayElement(String x) {
		JLabel label = new JLabel(x);
		panel.add(label);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
