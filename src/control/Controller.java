package control;

import java.sql.SQLException;

import org.json.JSONObject;

import model.exceptions.LoginException;
import model.userManagment.UserManager;

public class Controller {

	UserManager _userManager;

	public Controller(UserManager userManager) {
		_userManager = userManager;
	}

	public void login(String dni, String password) throws LoginException, SQLException {
		_userManager.get_loginAuthenticator().login(dni, password);
	}

	public void registerUsers(JSONObject usersToRegister) {
		_userManager.get_patientRegisterer().registerUsers(usersToRegister);
	}

	public void run() {

		//		PRUEBA DE REGISTER
		//		Patient p1 = new Patient("003", "Diego", "Revenga", "2002-10-01", "reven@gmail.com", null, Gender.MALE, HealthInsuranceType.SINGLE, null);
		//		RegisterData rd = new RegisterData(p1, "12345");
		//		List<RegisterData> l = new ArrayList<>();
		//		l.add(rd);
		//
		//		PatientRegisterer registerer = new PatientRegisterer();
		//		try {
		//			registerer.registerPatients(l);
		//			System.out.println("BIEN");
		//		} catch (IllegalArgumentException e) {
		//			System.out.println(e.getMessage());
		//		} catch (SqlConnectionException e) {
		//			System.out.println(e.getMessage());
		//		} catch (SQLException e) {
		//			System.out.println(e.getMessage());
		//		}
	}
}
