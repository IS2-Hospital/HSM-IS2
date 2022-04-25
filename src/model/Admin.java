package model;

import java.util.List;

import model.Enums.UserRole;

public class Admin extends User{

	public Admin(String dni, String name, String lastname, String birthdate, String email, String phone) {
		super (dni, name, lastname, birthdate, email, phone, UserRole.ADMIN, null);
	}

	@Override
	public String[] getColName() {
		return null;
	}

	@Override
	public List<String> asStringList() {
		return null;
	}

}
