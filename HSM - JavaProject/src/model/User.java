package model;

public abstract class User {
	
	private String dni;
	private String fullName;
	
	public User(String dni, String fullName) {
		this.dni = dni;
		this.fullName = fullName;
	}

}
