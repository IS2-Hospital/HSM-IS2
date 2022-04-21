package model;

import java.util.ArrayList;
import java.util.List;

import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.Enums.UserRole;

public class Patient extends User {

	static String[] colNames = {"dni", "lastname","name", "birthdate", "email", "phone", "blood type", "gender", "insurance type", "insurance taker", "bill"};
	Gender _gender;
	BloodType _bloodType;
	HealthInsuranceType _insuranceType;
	String _dniInsuranceTaker;
	private double bill;

	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone, Gender gender, BloodType bloodType, HealthInsuranceType insuranceType, String dniInsuranceTaker, double bill2) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.PATIENT);
		_gender = gender;
		_insuranceType = insuranceType;
		_dniInsuranceTaker = dniInsuranceTaker;
		_bloodType = bloodType;
		this.bill = bill2;
	}

	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone,
			Gender gender, BloodType bloodtype, HealthInsuranceType insuranceType, String dniInsuranceTaker) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.PATIENT);
		_gender = gender;
		_insuranceType = insuranceType;
		_dniInsuranceTaker = dniInsuranceTaker;
		_bloodType = bloodtype;
		bill = 0;
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

	@Override
	public List<String> asStringList() {
		List<String> list = new ArrayList<String>();
		list.add(dni);
		list.add(lastname);
		list.add(name);
		list.add(birthdate);
		list.add(email);
		list.add(phone);
		list.add(_gender.toString());
		list.add(_bloodType.toString());
		list.add(_insuranceType.toString());
		if(_dniInsuranceTaker != null)
			list.add(_dniInsuranceTaker.toString());
		else
			list.add(dni);
		list.add(String.valueOf(bill));

		return list;
	}

	@Override
	public String[] getColName() {
		return colNames;
	}

}
