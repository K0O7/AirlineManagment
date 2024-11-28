package main.java.com.solvd.airline;

public class Airport implements IIdentifiable {
	private String name;
	private String location;

	public Airport(String name, String location) {
		super();
		this.setName(name);
		this.setLocation(location);
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getUniqueId() {
		return this.name + "-" + this.location;
	}
}
