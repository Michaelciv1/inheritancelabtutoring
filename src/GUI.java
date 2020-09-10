import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	JFrame frame;
	JButton teacherButton;
	JButton policeButton;
	JButton engineerButton;
	JButton bankerButton;
	JPanel panel;
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel(new GridLayout(0, 1));
		
		teacherButton = new JButton("Show Teachers");
		policeButton = new JButton("Show Police Officers");
		engineerButton = new JButton("Show Engineers");
		bankerButton = new JButton("Show Bankers");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		frame.setPreferredSize(new Dimension (600,400));
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Employee List");
		
		panel.add(teacherButton);
		panel.add(policeButton);
		panel.add(engineerButton);
		panel.add(bankerButton);
		
		frame.pack();
		frame.setVisible(true);
		
		teacherButton.addActionListener(this);
		policeButton.addActionListener(this);
		engineerButton.addActionListener(this);
		bankerButton.addActionListener(this);
	}
	
	public void displayAllElements(String x) {
		//for (int i = 0; i < x.size(); i++) {
			JLabel label = new JLabel(x);
			label.setBounds(0, 0, 200, 50);
			panel.add(label);
			frame.pack();
		//}
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == teacherButton) {
			JLabel label = new JLabel("Hello");
			panel.add(label);
			panel.revalidate();
			panel.repaint();
			System.out.println("Hi");
		}
		else if (e.getSource() == policeButton) {
			JLabel label = new JLabel("Bye");
			panel.add(label);
			panel.revalidate();
			panel.repaint();
			System.out.println("Bye");
		}
		else if (e.getSource() == engineerButton) {
			JLabel label = new JLabel("Chai");
			panel.add(label);
			panel.revalidate();
			panel.repaint();
			System.out.println("Chai");
		}
		else if (e.getSource() == bankerButton) {
			JLabel label = new JLabel("BGreatye");
			panel.add(label);
			panel.revalidate();
			panel.repaint();
			System.out.println("Great");
		}
		
	}
}
