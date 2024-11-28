package main.java.com.solvd.airline;

public class Emploee extends Person {
	private String role;

	public Emploee(String name, String surname, String role) {
		super(name, surname);
		this.setRole(role);
	}
	
	@Override
	public String getName() {
		return name;
	}

	@Override
	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String getSurname() {
		return surname;
	}

	@Override
	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
