package model.userManagment;

import model.Patient;

public class RegisterData {

	private Patient patient;
	private String password;

	public RegisterData(Patient patient, String password) {
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
