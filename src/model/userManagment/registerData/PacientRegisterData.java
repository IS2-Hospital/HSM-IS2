package model.userManagment.registerData;

import model.Patient;

public class PacientRegisterData {

	private Patient patient;
	private String password;

	public PacientRegisterData(Patient patient, String password) {
		this.patient = patient;
		this.password = password;
	}

	public Patient getPatient() {
		return patient;
	}

	public String getPassword() {
		return password;
	}
}
