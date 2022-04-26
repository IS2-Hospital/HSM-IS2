package model;

public class Treatment {

	private String start_date;
	private String name;
	private String description;

	public Treatment(String start_date, String name, String description) {
		this.start_date = start_date;
		this.name = name;
		this.description = description;
	}

	public String getStart_date() {
		return start_date;
	}

	public String getName() {
		return name;
	}

	public String getDescription() {
		return description;
	}




}
