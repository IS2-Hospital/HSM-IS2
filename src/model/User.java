package model;

import java.util.List;

import model.Enums.UserRole;

public abstract class User {

	protected String dni;
	protected String name;
	protected String lastname;
	protected String birthdate;
	protected String email;
	protected String phone;
	protected UserRole role;
	protected String pass;

	public User(String dni, String name, String lastname, String birthdate, String email, String phone, UserRole role, String pass) {
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
		this.role = role;
		this.pass = pass;
	}

	public String getDni() {
		return dni;
	}

	public String getName() {
		return name;
	}

	public String getLastname() {
		return lastname;
	}

	public String getBirthdate() {
		return birthdate;
	}

	public String getEmail() {
		return email;
	}

	public String getPhone() {
		return phone;
	}

	public UserRole getRole() {
		return role;
	}

	public String getPass() {
		return pass == null ? "" : pass;
	}

	public String getFullName() {
		return name +" "+ lastname;
	}
	public abstract String[] getColName();
	public abstract List<String> asStringList();


}
