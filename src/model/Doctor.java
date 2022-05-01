package model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import model.Enums.UserRole;

public class Doctor extends User {

	static String[] colNames = {"dni", "lastname","name", "birthdate", "email", "phone", "speciality","salary","Contract Start Date", "Contract End Date" };
	private String speciality;
	private float salary;
	private Date contractStartDate;
	private Date contractEndDate;

	public Doctor(String dni, String name, String lastname, String birthdate, String email, String phone, String speciality, float salary, Date contractStartDate, Date contractEndDate) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.DOCTOR, null);
		this.speciality = speciality;
		this.salary = salary;
		this.contractStartDate = contractStartDate;
		this.contractEndDate = contractEndDate;
	}

	@Override
	public String toString() {
		return name + " " + lastname;
	}

	@Override
	public String[] getColName() {
		return colNames;
	}

	public String getSpeciality() {
		return speciality;
	}

	public float getSalary() {
		return salary;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
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
		list.add(speciality.toString());
		list.add(String.valueOf(salary));
		list.add(contractStartDate.toString());
		if(contractEndDate != null)
			list.add(contractEndDate.toString());
		else
			list.add("Undefinded Contract");

		return list;
	}

}
