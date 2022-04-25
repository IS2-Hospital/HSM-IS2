package control;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.json.JSONObject;

import model.AdminApp;
import model.Appointment;
import model.Doctor;
import model.Patient;
import model.PatientApp;
import model.Enums.UserRole;
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

	public UserRole login(String dni, String password) throws LoginException, SQLException {
		return _userManager.get_loginAuthenticator().login(dni, password);
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

	public Vector<Appointment> getAppointments(String dni_patient) throws SQLException {
		return patientApp.getAppointments(dni_patient);
	}

	public List<Patient> getAllPatients() {
		return adminApp.getAllPatients();
	}

	public List<Doctor> getDoctorList() {
		return adminApp.getDoctorList();
	}

	public List<Patient> resultAllPatientsFrom(String dniDoctor) {
		return adminApp.resultAllPatientsFrom(dniDoctor);
	}

	public Patient getPatientData(String dni) {
		return adminApp.getPatientData(dni);
	}

	public Patient getPatientFullData(String dni) {
		return patientApp.getPatientFullData(dni);
	}

	public void updatePatient(List<String> colData) throws SQLException {
		adminApp.updatePatient(colData);
	}

	public void updatePatient(Patient p) throws SQLException {
		patientApp.updatePatient(p);
	}

	public Doctor getDoctorData(String dni) {
		return adminApp.getDoctorData(dni);
	}

	public void updateDoctor(List<String> colData) throws SQLException {
		adminApp.updateDoctor(colData);
	}

	public List<String> getRequestIDList() {
		return adminApp.getRequestIDList();
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
		adminApp.assignPatientDoctor(dniDoc,dniPat);
	}

}
