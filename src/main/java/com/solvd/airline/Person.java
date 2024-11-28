package main.java.com.solvd.airline;

import java.util.Objects;

public abstract class Person {
	protected String name;
	protected String surname;

	public Person(String name, String surname) {
		super();
		this.setName(name);
		this.setSurname(surname);
	}

	public abstract String getName();

	public abstract void setName(String name);
	
	public abstract String getSurname();

	public abstract void setSurname(String surname);

	@Override
	public int hashCode() {
		return Objects.hash(name, surname);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return Objects.equals(name, other.name) && Objects.equals(surname, other.surname);
	}
	
}
