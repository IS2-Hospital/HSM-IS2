package control;

import java.sql.SQLException;

import model.exceptions.LoginException;
import model.userManager.LoginAuthenticator;

public class Controller {


	public Controller() {

	}

	public void logIn(int dni, String password) throws LoginException, SQLException{
		LoginAuthenticator loginAuth = new LoginAuthenticator();
		loginAuth.login(dni, password);
	}
}
