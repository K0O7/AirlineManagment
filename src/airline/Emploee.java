package airline;

public class Emploee extends Person {
	private String role;

	public Emploee(String name, String surname, String role) {
		super(name, surname);
		this.role = role;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
