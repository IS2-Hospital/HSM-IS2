package model;

public abstract class User {

	protected String dni;
	protected String name;
	protected String lastname;
	protected String birthdate;
	protected String email;
	protected String phone;
	protected UserRole role;

	public User(String dni, String name, String lastname, String birthdate, String email, String phone, UserRole role) {
		this.dni = dni;
		this.name = name;
		this.lastname = lastname;
		this.birthdate = birthdate;
		this.email = email;
		this.phone = phone;
		this.role = role;
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

}
