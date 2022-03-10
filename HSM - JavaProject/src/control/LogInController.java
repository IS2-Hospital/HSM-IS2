package control;

import java.sql.SQLException;

import model.UserRole;
import model.exceptions.LogInException;
import userManager.LoginAuthenticator;
import userManager.LoginData;

public class LogInController {

	public LogInController() {}

	protected void doPost(String dni, String pass) throws SQLException, LogInException{

		LoginData loginData = new LoginData(dni, pass);
		LoginAuthenticator loginAuthenticator = new LoginAuthenticator();

		try {
			UserRole userValidate = loginAuthenticator.authenticateUser(loginData);

			switch(userValidate) {
			case PATIENT:
				System.out.println("Patient's Home"); break;
			case DOCTOR:
				System.out.println("Doctor's Home"); break;
			case ADMIN:
				System.out.println("Admin's Home"); break;
			}
		}

		catch (SQLException sql_e) {
			throw sql_e;
		}
		catch (LogInException li_e) {
			throw li_e;
		}
	}
}