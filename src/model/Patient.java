package model;

public class Patient extends User {

	Gender gender;
	HealthInsuranceType insuranceType;
	String dniInsuranceTaker;

	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone, Gender gender, HealthInsuranceType insuranceType, String dniInsuranceTaker) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.PATIENT);
		this.gender = gender;
		this.insuranceType = insuranceType;
		this.dniInsuranceTaker = dniInsuranceTaker;
	}

	public Gender getGender() {
		return gender;
	}

	public HealthInsuranceType getInsuranceType() {
		return insuranceType;
	}

	public String getDniInsuranceTaker() {
		return dniInsuranceTaker;
	}

}
