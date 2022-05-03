package model;

public class Appointment {

	private String day;
	private String hour;
	private String person;
	private String description;
	private String dni_patient;

	public Appointment(String day, String hour, String person, String description, String dni_patient) {
		this.day = day;
		this.hour = hour;
		this.person = person;
		this.description = description;
		this.dni_patient = dni_patient;
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

	public String getDni_patient() {
		return dni_patient;
	}

}
