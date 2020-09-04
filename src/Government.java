
public class Government extends Employee{
	
	String cityName;

	public Government(String name, String jobTitle, String employer, String cityName) {
		super(name,jobTitle,employer);
		this.cityName = cityName;
	}

	@Override
	public String getEmployer() {
		return cityName;
	}
	
}
