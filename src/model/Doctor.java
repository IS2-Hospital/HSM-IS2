package model;

import java.sql.Date;

import model.Enums.UserRole;

public class Doctor extends User {

	private String speciality;
	private float salary;
	private Date contractStartDate;
	private Date contractEndDate;

	public Doctor(String dni, String name, String lastname, String birthdate, String email, String phone, String speciality, float salary, Date contractStartDate, Date contractEndDate) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.DOCTOR);
		this.speciality = speciality;
		this.salary = salary;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
	}



}
