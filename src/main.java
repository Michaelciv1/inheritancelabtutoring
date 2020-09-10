import java.util.*;

public class main {

	public static void main(String[] args) {
		GUI gui = new GUI();
		ArrayList<Employee> employeeList = new ArrayList<Employee>();
		
		Government policeman1 = new Government("John Newman", "Police Officer", "Public Sector", "Mountain View");
		Government policeman2 = new Government("Jimmy Butler", "Police Officer", "Public Sector", "Sunnyvale");
		Company engineer1 = new Company("Christine Yang", "Engineer", "Private Sector", "Apple");
		Company engineer2 = new Company("Aaron Paul", "Engineer", "Private Sector", "Google");
		Government teacher1 = new Government("Majorie Walker", "Teacher", "Public Sector", "Palo Alto"); 
		Government teacher2 = new Government("Drake Paul", "Teacher", "Public Sector", "Menlo Park");
		Company banker1 = new Company("Kraus Bratwurst", "Banker", "Private Sector", "Goldman Sachs");
		Company banker2 = new Company("Leonard Fournette", "Banker", "Private Sector", "Wells Fargo");
		
		employeeList.add(policeman1);
		employeeList.add(policeman2);
		employeeList.add(engineer1);
		employeeList.add(engineer2);
		employeeList.add(teacher1);
		employeeList.add(teacher2);
		employeeList.add(banker1);
		employeeList.add(banker2);
		
		gui.setEmployeeList(employeeList);
		gui.displayAllNames();
	


		
		
		
	}

}
