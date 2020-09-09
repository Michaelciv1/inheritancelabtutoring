import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class GUI implements ActionListener{
	
	public GUI() {
		JFrame frame = new JFrame();
		JButton button = new JButton();
		JPanel panel = new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(300,300,100,100));
		panel.setLayout(new GridLayout(0, 1));
		panel.add(button);
		button.addActionListener(this);
		
		frame.add(panel,BorderLayout.CENTER);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Employee List");
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
