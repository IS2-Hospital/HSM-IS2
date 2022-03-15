package model.userManagment.registerData;

import model.Doctor;

public class DoctorRegisterData {
	private Doctor doctor;
	private String password;

	public DoctorRegisterData(Doctor doctor, String password) {
		this.doctor = doctor;
		this.password = password;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	public String getPassword() {
		return password;
	}
}
