
public class Company extends Employee{
	
	String companyName;
	
	public Company(String name, String jobTitle, String employer, String companyName) {
		super(name,jobTitle,employer);
		this.companyName = companyName;
	}
	
	@Override
	public String getEmployer() {
		return companyName;
	}
}
