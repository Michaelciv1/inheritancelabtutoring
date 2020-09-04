
public abstract class Employee {
	String name;
	String jobTitle;
	String sector;
	
	public Employee(String name, String jobTitle, String sector) {
		this.name = name;
		this.jobTitle = jobTitle;
		this.sector = sector;
	}
	
	public abstract String getEmployer(); 
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		String result = name + " " + jobTitle + " " + sector + " " + getEmployer(); 
		return result;
	}
	
}
