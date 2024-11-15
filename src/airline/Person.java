package airline;

public abstract class Person {
	protected String name;
	protected String surname;

	public Person(String name, String surname) {
		super();
		this.setName(name);
		this.setSurname(surname);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
}
