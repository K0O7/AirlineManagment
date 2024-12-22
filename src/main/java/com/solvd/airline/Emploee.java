package main.java.com.solvd.airline;

public class Emploee extends Person {
	private Role role;

	public Emploee(String name, String surname, Role role) {
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public enum Role {
        PILOT("Responsible for flying the plane"),
        COPILOT("Assists the pilot and handles navigation"),
        FLIGHT_ATTENDANT("Ensures passenger safety and comfort"),
        MECHANIC("Maintains and repairs aircraft"),
        GROUND_STAFF("Handles ground operations and passenger assistance");

        private final String description;

        Role(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }

        @Override
        public String toString() {
            return name() + " - " + description;
        }
    }
}
