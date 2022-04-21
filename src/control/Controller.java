package control;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.json.JSONObject;

import model.AdminApp;
import model.Appointment;
import model.Doctor;
import model.PatientApp;
import model.exceptions.LoginException;
import model.userManagment.UserManager;

public class Controller {

	UserManager _userManager;
	PatientApp patientApp;
	AdminApp adminApp;

	public Controller(UserManager userManager) {
		_userManager = userManager;
		this.patientApp = new PatientApp();
		adminApp = new AdminApp();
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

	public Vector<String> getAvailableHours(Doctor doctor, String date) throws SQLException {
		return patientApp.getAvailableHours(doctor, date);
	}

	public void askForAppointment(Appointment appointment, String dni_patient) throws SQLException {
		patientApp.askForAppointment(appointment, dni_patient);
	}

	public ResultSet resultAllPatients() {
		return resultAdminQuery("SELECT dni, lastname, name, birthdate, email, phone, gender, insurance_type, dni_insurance_taker FROM users JOIN patients ON dni = dni_patient order by lastname;");
	}

	public ResultSet resultAllDoctors() {
		return resultAdminQuery("SELECT dni, lastname, name, birthdate, email, phone, speciality, salary, contract_start_date, contract_end_date FROM doctors JOIN users ON dni = dni_doctor  order by lastname;");
	}

	private ResultSet resultAdminQuery( String SQL ) {

		return adminApp.resultQuery(SQL);
	}

	public List<String> getDoctorDNIList() {
		return adminApp.getDoctorDNIList();
	}

	public ResultSet resultAllPatientsFrom(String dniDoctor) {
		return resultAdminQuery("SELECT dni, lastname, name, birthdate, email, phone, gender, insurance_type, dni_insurance_taker FROM patients JOIN users ON dni = dni_patient JOIN treated_by ON treated_by.dni_patient = patients.dni_patient AND dni_doctor = "+dniDoctor+" order by dni;");
	}

	public List<String> getPatientDNIList() {
		return adminApp.getPatientDNIList();
	}

	public List<String> getPatientData(String dni) {
		return adminApp.getPatientData(dni);
	}

	public void updatePatient(List<String> colData) throws SQLException {
		adminApp.updatePatient(colData);

	}

	public List<String> getDoctorData(String dni) {
		return adminApp.getDoctorData(dni);
	}

	public void updateDoctor(List<String> colData) throws SQLException {
		adminApp.updateDoctor(colData);

	}

	public List<String> getRequestIDList() {
		return adminApp.getRequestIDList();
	}

	public String getUserFullName(String dni) throws SQLException {
		return adminApp.getUserFullName(dni);
	}

	public List<String> getDNIFromRequest(String string) throws SQLException {
		return adminApp.getDNIFromRequest(string);
	}

	public String getReason(String id) {
		try {
			return adminApp.getReason(id);
		} catch (SQLException e) {
			return "No reason given";
		}
	}

	public void aproveChange(String string) throws SQLException {
		adminApp.aproveChange(string);
	}

	public void assignPatientDoctor(String dniDoc, String dniPat) throws SQLException {
		adminApp.resultQuery("INSERT INTO treated_by VALUES ( '"+dniPat +"' , '"+dniDoc +"');");
	}

}
