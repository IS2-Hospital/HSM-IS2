package control;

import java.sql.SQLException;

import model.exceptions.LoginException;
import model.userManagment.LoginAuthenticator;

public class Controller {


	public Controller() {

	}

	public void login(int dni, String password) throws LoginException, SQLException {
		LoginAuthenticator loginAuth = new LoginAuthenticator();
		loginAuth.login(dni, password);
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
