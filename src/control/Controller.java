package control;

import java.sql.SQLException;

import model.exceptions.LoginException;
import model.userManager.LoginAuthenticator;

public class Controller {


	public Controller() {

	}

	public void run() {

		// login
		LoginAuthenticator loginAuth = new LoginAuthenticator();
		try {
			loginAuth.login("001", "12345");
		} catch (LoginException le) {
			System.out.println(le.getMessage());
		} catch (SQLException sqle) {
			System.out.println(sqle.getMessage());
			sqle.printStackTrace();
		}
	}
}
