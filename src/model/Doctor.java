package model;

import java.sql.Date;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import model.Enums.RegState;
import model.Enums.UserRole;

public class Doctor extends User {

	static String[] colNames = {"dni", "lastname","name", "birthdate", "email", "phone", "speciality","salary","Contract Start Date", "Contract End Date" };
	private String speciality;
	private String salary;
	private Date contractStartDate;
	private Date contractEndDate;
	private RegState regState;
	private String notes;

	public Doctor(String dni, String name, String lastname, String birthdate, String email, String phone, String salary, String contractExpiration, String speciality, String regState, String notes, String pass) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.DOCTOR, pass);
		this.speciality = speciality;
		this.salary = salary;
		this.regState = RegState.valueOf(regState);
		this.notes = notes;

		LocalDateTime ldt = LocalDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		this.contractEndDate = Date.valueOf(contractExpiration);
		this.contractStartDate = Date.valueOf(dtf.format(ldt));
	}

	public Doctor(String dni, String name, String lastname, String birthdate, String email, String phone, String salary, Date contractStart, Date contractExpiration, String speciality, String regState, String notes, String pass) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.DOCTOR, pass);
		this.speciality = speciality;
		this.salary = salary;
		this.regState = RegState.valueOf(regState);
		this.notes = notes;
		this.contractEndDate = contractExpiration;
		this.contractStartDate = contractStart;
	}

	@Override
	public String toString() {
		return name + " " + lastname;
	}

	@Override
	public String[] getColName() {
		return colNames;
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

	public String getSalary() {
		return salary;
	}

	public String getSpeciality() {
		return speciality;
	}

	public Date getContractStartDate() {
		return contractStartDate;
	}

	public Date getContractEndDate() {
		return contractEndDate;
	}

	public RegState getRegState() {
		return this.regState;
	}

	public String getNotes() {
		return notes;
	}

}
