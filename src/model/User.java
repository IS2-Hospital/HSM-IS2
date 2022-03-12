package model;

public abstract class User {
	
	protected String dni;
	protected String fullName;
	
	public User(String dni, String fullName) {
		this.dni = dni;
		this.fullName = fullName;
	}

}
