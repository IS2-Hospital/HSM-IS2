package model;

public class Appointment {

	private String day;
	private String hour;
	private String person;
	private String description;

	public Appointment(String day, String hour, String person, String description) {
		this.day = day;
		this.hour = hour;
		this.person = person;
		this.description = description;
	}

	public String getDay() {
		return day;
	}

	public String getHour() {
		return hour;
	}

	public String getPerson() {
		return person;
	}

	public String getDescription() {
		return description;
	}

}
