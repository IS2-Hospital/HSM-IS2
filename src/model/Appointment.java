package model;

public class Appointment {

	private String day;
	private String hour;
	private String doctor;
	private String description;

	public Appointment(String day, String hour, String doctor, String description) {
		this.day = day;
		this.hour = hour;
		this.doctor = doctor;
		this.description = description;
	}

	public String getDay() {
		return day;
	}

	public String getHour() {
		return hour;
	}

	public String getDoctor() {
		return doctor;
	}

	public String getDescription() {
		return description;
	}

}
