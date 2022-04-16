package model;

public class Appointment {

	private String date;
	private String hour;
	private String doctor;
	private int room;
	private String description;

	public Appointment(String date, String hour, String doctor, int room, String description) {
		this.date = date;
		this.hour = hour;
		this.doctor = doctor;
		this.room = room;
		this.description = description;
	}

	public String getDate() {
		return date;
	}

	public String getHour() {
		return hour;
	}

	public String getDoctor() {
		return doctor;
	}

	public int getRoom() {
		return room;
	}

	public String getDescription() {
		return description;
	}

}
