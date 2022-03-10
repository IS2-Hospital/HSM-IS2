package userManager;

public class LoginData {
	
	private String dni, password;
	
	public LoginData(String dni, String password) {
		this.dni = dni;
		this.password = password;
	}
	
	// Getters
	public String getDNI() {return this.dni;}
	public String getPassword() {return this.password;}
	
}
