package model.userManagment;

public class UserManager {
	LoginAuthenticator _loginAuthenticator;
	UserRegisterer _patientRegisterer;

	public UserManager(LoginAuthenticator loginAuthenticator, UserRegisterer patientRegisterer) {
		_loginAuthenticator = loginAuthenticator;
		_patientRegisterer = patientRegisterer;
	}

	public LoginAuthenticator get_loginAuthenticator() {
		return _loginAuthenticator;
	}

	public UserRegisterer get_patientRegisterer() {
		return _patientRegisterer;
	}

}
