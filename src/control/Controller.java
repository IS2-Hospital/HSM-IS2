package control;

import java.sql.SQLException;
import java.util.Vector;

import org.json.JSONObject;

import model.Doctor;
import model.PatientApp;
import model.exceptions.LoginException;
import model.userManagment.UserManager;

public class Controller {

	UserManager _userManager;
	PatientApp patientApp;

	public Controller(UserManager userManager) {
		_userManager = userManager;
		this.patientApp = new PatientApp();
	}

	public void login(String dni, String password) throws LoginException, SQLException {
		_userManager.get_loginAuthenticator().login(dni, password);
	}

	public void registerUsers(JSONObject usersToRegister) {
		_userManager.get_patientRegisterer().registerUsers(usersToRegister);
	}

	public Vector<Doctor> getDoctorsOf(String dni) throws SQLException {
		return patientApp.getDoctorsOf(dni);
	}

	public Vector<String> getAvailableHours(String dni_doctor, String date) throws SQLException {
		return patientApp.getAvailableHours(dni_doctor, date);
	}

	public void askForAppointment(String day, String hour, String dni_doctor, String dni_patient, String desc) throws SQLException {
		patientApp.askForAppointment(day, hour, dni_doctor, dni_patient, desc);
	}
}
