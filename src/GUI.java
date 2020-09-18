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
	private JFrame searchFrame;
	private JPanel panel;
	private JPanel addEmployeePanel;
	private JPanel textPanel;
	private JPanel searchPanel;
	private JButton showAllButton;
	private JButton newEmployeeButton;
	private JButton teacherButton;
	private JButton policeButton;
	private JButton engineerButton;
	private JButton bankerButton;
	private JButton addEmployeeButton;
	private JButton openSearchButton;
	private JButton searchButton;
	private JTextField nameTextField;
	private JTextField cityCompanyTextField;
	private JTextField searchTextField;
	private JLabel name;
	//private JLabel job;
	private JLabel cityCompany;
	private JComboBox<String> sectorSelection;
	private JComboBox<String> jobSelection;
	private ArrayList<Employee> employeeList = new ArrayList<Employee>();
	
	public GUI() {
		frame = new JFrame();
		panel = new JPanel(new GridLayout(0, 1));
		textPanel = new JPanel(new GridLayout(0,1));
		
		showAllButton = new JButton("Show all employees");
		teacherButton = new JButton("Show Teachers");
		policeButton = new JButton("Show Police Officers");
		engineerButton = new JButton("Show Engineers");
		bankerButton = new JButton("Show Bankers");
		addEmployeeButton = new JButton("Add a new employee");
		openSearchButton = new JButton("Search for an employee");
		
		panel.setBorder(BorderFactory.createEmptyBorder(30,30,10,10));
		frame.setPreferredSize(new Dimension (600,400));
		frame.add(panel,BorderLayout.CENTER);
		frame.add(textPanel,BorderLayout.AFTER_LAST_LINE);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Employee List");
		
		panel.add(showAllButton);
		panel.add(teacherButton);
		panel.add(policeButton);
		panel.add(engineerButton);
		panel.add(bankerButton);
		panel.add(addEmployeeButton);
		panel.add(openSearchButton);
		
		frame.pack();
		frame.setVisible(true);
		
		showAllButton.addActionListener(this);
		teacherButton.addActionListener(this);
		policeButton.addActionListener(this);
		engineerButton.addActionListener(this);
		bankerButton.addActionListener(this);
		addEmployeeButton.addActionListener(this);
		openSearchButton.addActionListener(this);
	}
	
	public void setEmployeeList(ArrayList<Employee> x) {
		this.employeeList = x;
	}
	
	public void displayAllNames() {
		textPanel.removeAll();
		for (int i = 0; i < employeeList.size(); i++) {
			Employee temp = employeeList.get(i);
			JLabel label = new JLabel(temp.getName());
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
	
	public String searchName() {
		searchFrame = new JFrame("Search for Employee");
		searchPanel = new JPanel();
		searchButton = new JButton("Search");
		searchButton.addActionListener(this);
		searchFrame.setSize(400,400);
		
		searchTextField = new JTextField(20);		
		
		searchPanel.add(searchTextField);
		searchPanel.add(searchButton);
		searchFrame.add(searchPanel,BorderLayout.CENTER);
		searchFrame.pack();
		searchFrame.setVisible(true);
		return null;
	}
	
	public void addEmployee() {
		String[] sector = {"Public Sector", "Private Sector"};
		String[] job = {"Police Officer", "Engineer", "Teacher", "Banker"};
		
		addEmployeeFrame = new JFrame("New Employee");
		addEmployeePanel = new JPanel();
		newEmployeeButton = new JButton("Submit");
		newEmployeeButton.addActionListener(this);
		addEmployeeFrame.setSize(400,400);
		
		nameTextField = new JTextField(20);
		name = new JLabel("Name");
		jobSelection = new JComboBox<String>(job);
		cityCompanyTextField = new JTextField(20);
		cityCompany = new JLabel("City/Company");
		
		sectorSelection = new JComboBox<String>(sector);
		
		
		name.setBounds(10, 20, 80, 25);
		nameTextField.setBounds(100, 20, 165, 25);
		jobSelection.setBounds(10, 50, 80, 25);
		cityCompany.setBounds(10, 80, 80, 25);
		cityCompanyTextField.setBounds(100, 80, 165, 25);
		sectorSelection.setBounds(10, 110, 80, 25);
		newEmployeeButton.setBounds(10, 140, 40, 25);
		
		addEmployeePanel.add(name);
		addEmployeePanel.add(nameTextField);
		addEmployeePanel.add(jobSelection);
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
		else if (e.getSource() == showAllButton) {
			displayAllNames();
		}
		else if (e.getSource() == newEmployeeButton) {
			String name = nameTextField.getText();
			String job = (String) jobSelection.getSelectedItem();
			String cityCompany = cityCompanyTextField.getText();
			String sector = (String) sectorSelection.getSelectedItem();
			if (sector.equalsIgnoreCase("public sector")) {
				Government employee = new Government(name,job,sector,cityCompany);
				employeeList.add(employee);
			}
			else {
				Company employee = new Company(name,job,sector,cityCompany);
				employeeList.add(employee);
			}
			displayAllNames();
		}
		else if (e.getSource() == openSearchButton) {
			searchName();
		}
		else if (e.getSource() == searchButton) {
			textPanel.removeAll();
			String name = searchTextField.getText();
			for (int i = 0; i < employeeList.size(); i++) {
				Employee temp = employeeList.get(i);
				if (temp.getName().equalsIgnoreCase(name)) {
					JLabel label = new JLabel(temp.toString());
					label.setBounds(0, 0, 200, 50);
					textPanel.add(label);
					frame.pack();
				}
			}
			
		}
	}
}
