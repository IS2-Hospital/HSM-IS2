package model;

import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.Enums.UserRole;

public class Patient extends User {

	Gender _gender;
	BloodType _bloodType;
	HealthInsuranceType _insuranceType;
	String _dniInsuranceTaker;

	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone, Gender gender, BloodType bloodType, HealthInsuranceType insuranceType, String dniInsuranceTaker) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.PATIENT);
		_gender = gender;
		_insuranceType = insuranceType;
		_dniInsuranceTaker = dniInsuranceTaker;
		_bloodType = bloodType;
	}

	public Gender getGender() {
		return _gender;
	}

	public HealthInsuranceType getInsuranceType() {
		return _insuranceType;
	}

	public String getDniInsuranceTaker() {
		return _dniInsuranceTaker;
	}

	public BloodType getBloodType() {
		return _bloodType;
	}

}
