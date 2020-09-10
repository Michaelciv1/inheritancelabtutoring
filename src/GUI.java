import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GUI implements ActionListener{
	
	private JFrame frame;
	private JFrame addEmployeeFrame;
	private JPanel panel;
	private JPanel addEmployeePanel;
	private JPanel textPanel;
	private JButton newEmployeeButton;
	private JButton teacherButton;
	private JButton policeButton;
	private JButton engineerButton;
	private JButton bankerButton;
	private JButton addEmployeeButton;
	private JTextField nameTextField;
	private JTextField jobTextField;
	private JTextField cityCompanyTextField;
	private JLabel name;
	private JLabel job;
	private JLabel cityCompany;
	private JComboBox<String> sectorSelection;
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel(new GridLayout(0, 1));
		textPanel = new JPanel(new GridLayout(0,1));
		
		teacherButton = new JButton("Show Teachers");
		policeButton = new JButton("Show Police Officers");
		engineerButton = new JButton("Show Engineers");
		bankerButton = new JButton("Show Bankers");
		addEmployeeButton = new JButton("Add a new employee");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		frame.setPreferredSize(new Dimension (600,400));
		frame.add(panel,BorderLayout.CENTER);
		frame.add(textPanel,BorderLayout.AFTER_LAST_LINE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Employee List");
		
		panel.add(teacherButton);
		panel.add(policeButton);
		panel.add(engineerButton);
		panel.add(bankerButton);
		panel.add(addEmployeeButton);
		
		frame.pack();
		frame.setVisible(true);
		
		teacherButton.addActionListener(this);
		policeButton.addActionListener(this);
		engineerButton.addActionListener(this);
		bankerButton.addActionListener(this);
		addEmployeeButton.addActionListener(this);
	}
	
	public void setEmployeeList(ArrayList<Employee> x) {
		this.employeeList = x;
	}
	
	public void displayAllNames() {
		
		for (int i = 0; i < employeeList.size(); i++) {
			Employee y = employeeList.get(i);
			JLabel label = new JLabel(y.getName());
			label.setBounds(0, 0, 200, 50);
			textPanel.add(label);
			frame.pack();
		}
	}
	
	public void displayJobType(String job) {
		textPanel.removeAll();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee y = employeeList.get(i);
			if (y.getJobTitle() == job) {
				JLabel label = new JLabel(y.toString());
				label.setBounds(0, 0, 200, 50);
				textPanel.add(label);
				frame.pack();
			}
		}
	}
	
	public void addEmployee() {
		String[] sector = {"Public Sector", "Private Sector"};
		
		addEmployeeFrame = new JFrame("New Employee");
		addEmployeePanel = new JPanel();
		newEmployeeButton = new JButton("Submit");
		newEmployeeButton.addActionListener(this);
		addEmployeeFrame.setSize(400,400);
		
		nameTextField = new JTextField(20);
		name = new JLabel("Name");
		jobTextField = new JTextField(20);
		job = new JLabel("Job");
		cityCompanyTextField = new JTextField(20);
		cityCompany = new JLabel("City/Company");
		
		sectorSelection = new JComboBox<String>(sector);
		
		
		name.setBounds(10, 20, 80, 25);
		nameTextField.setBounds(100, 20, 165, 25);
		job.setBounds(10, 50, 80, 25);
		jobTextField.setBounds(100, 50, 165, 25);
		cityCompany.setBounds(10, 80, 80, 25);
		cityCompanyTextField.setBounds(100, 80, 165, 25);
		sectorSelection.setBounds(10, 110, 80, 25);
		newEmployeeButton.setBounds(10, 140, 40, 25);
		
		addEmployeePanel.add(name);
		addEmployeePanel.add(nameTextField);
		addEmployeePanel.add(job);
		addEmployeePanel.add(jobTextField);
		addEmployeePanel.add(cityCompany);
		addEmployeePanel.add(cityCompanyTextField);
		addEmployeePanel.add(sectorSelection);
		addEmployeePanel.add(newEmployeeButton);
		addEmployeeFrame.add(addEmployeePanel,BorderLayout.CENTER);
		addEmployeeFrame.pack();
		addEmployeeFrame.setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == teacherButton) {
			displayJobType("Teacher");
		}
		else if (e.getSource() == policeButton) {
			displayJobType("Police Officer");
		}
		else if (e.getSource() == engineerButton) {
			displayJobType("Engineer");
		}
		else if (e.getSource() == bankerButton) {
			displayJobType("Banker");
		}
		else if (e.getSource() == addEmployeeButton) {
			addEmployee();
		}
		else if (e.getSource() == newEmployeeButton) {
			String name = nameTextField.getText();
			String job = jobTextField.getText();
			String cityCompany = cityCompanyTextField.getText();
			String sector = (String) sectorSelection.getSelectedItem();
		}
	}
}
