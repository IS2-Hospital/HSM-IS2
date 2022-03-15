package model;

import model.Enums.UserRole;

public class Admin extends User{

	public Admin(String dni, String name, String lastname, String birthdate, String email, String phone) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.ADMIN);
	}

}
