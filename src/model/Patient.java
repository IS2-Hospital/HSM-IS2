package model;

import java.util.ArrayList;
import java.util.List;

import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.Enums.UserRole;

public class Patient extends User {

	static String[] colNames = {"dni", "lastname","name", "birthdate", "email", "phone", "blood type", "gender", "insurance type", "insurance taker", "bill"};
	private Gender _gender;
	private BloodType _bloodType;
	private HealthInsuranceType _insuranceType;
	private String _dniInsuranceTaker;
	private double bill;
	private String iban;
	private String homeAddress;


	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone, Gender gender, BloodType bloodType,
			HealthInsuranceType insuranceType, String dniInsuranceTaker, double bill2, String pass, String iban, String homeAddress) {

		super (dni, name, lastname, birthdate, email, phone, UserRole.PATIENT, pass);
		_gender = gender;
		_insuranceType = insuranceType;
		_dniInsuranceTaker = dniInsuranceTaker;
		_bloodType = bloodType;
		this.bill = bill2;
		this.iban = iban;
		this.homeAddress = homeAddress;
	}

	// Constructor without password
	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone,
			Gender gender, BloodType bloodType, HealthInsuranceType insuranceType, String dniInsuranceTaker, double bill2) {

		this(dni, name, lastname, birthdate, email, phone, gender, bloodType, insuranceType, dniInsuranceTaker, bill2, null, null, null);
	}

	// Constructor without password and bill
	public Patient(String dni, String name, String lastname, String birthdate, String email, String phone,
			Gender gender, BloodType bloodType, HealthInsuranceType insuranceType, String dniInsuranceTaker) {

		this(dni, name, lastname, birthdate, email, phone, gender, bloodType, insuranceType, dniInsuranceTaker, 0, null, null, null);
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

	public String getIban() {
		return iban == null ? "" : iban;
	}

	public String getHomeAddress() {
		return homeAddress == null ? "" : homeAddress;
	}

	public double getBill() {
		return bill;
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

	@Override
	public String toString() {
		return getFullName();
	}



}
