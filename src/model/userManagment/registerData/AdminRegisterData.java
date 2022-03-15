package model.userManagment.registerData;

import model.Admin;

public class AdminRegisterData {
	private Admin admin;
	private String password;

	public AdminRegisterData(Admin admin, String password) {
		this.admin = admin;
		this.password = password;
	}

	public Admin getAdmin() {
		return admin;
	}

	public String getPassword() {
		return password;
	}
}
