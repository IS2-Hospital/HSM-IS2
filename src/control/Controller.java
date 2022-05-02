package control;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import org.json.JSONObject;

import model.AdminApp;
import model.Appointment;
import model.Doctor;
import model.DoctorApp;
import model.History;
import model.Patient;
import model.PatientApp;
import model.Treatment;
import model.Enums.UserRole;
import model.exceptions.LoginException;
import model.userManagment.UserManager;

public class Controller {

	UserManager _userManager;
	PatientApp patientApp;
	AdminApp adminApp;
	DoctorApp doctorApp;

	public Controller(UserManager userManager) {
		_userManager = userManager;
		this.patientApp = new PatientApp();
		this.adminApp = new AdminApp();
		this.doctorApp = new DoctorApp();
	}


	//Login Ma�ade
	public UserRole login(String dni, String password) throws LoginException, SQLException {
		return _userManager.get_loginAuthenticator().login(dni, password);
	}

	public void registerUsers(JSONObject usersToRegister) {
		_userManager.get_patientRegisterer().registerUsers(usersToRegister);
	}

	//Patient facade

	public Vector<Doctor> getDoctorsOf(String dni) throws SQLException {
		return patientApp.getDoctorsOf(dni);
	}

	public Vector<Doctor> getNotDoctorsOf(String dni) throws SQLException {
		return patientApp.getNotDoctorsOf(dni);
	}

	public Vector<String> getAvailableHours(String doctor_dni, String date) throws SQLException {
		return patientApp.getAvailableHours(doctor_dni, date);
	}

	public void askForAppointment(Appointment appointment, String dni_patient) throws SQLException {
		patientApp.askForAppointment(appointment, dni_patient);
	}

	public Vector<Appointment> getAppointments(String dni, UserRole role) throws SQLException {
		if(role == UserRole.PATIENT)
			return patientApp.getAppointments(dni);
		else
			return doctorApp.getAppointments(dni);
	}

	public Vector<History> getHistory(String dni_patient)throws SQLException{
		return patientApp.getHistory(dni_patient);
	}
	public Vector<Treatment> getTreatment(String dni_patient) throws SQLException{
		return patientApp.getTreatment(dni_patient);
	}

	public Patient getPatientFullData(String dni) throws SQLException {
		return patientApp.getPatientFullData(dni);
	}

	public void updatePatient(Patient p) throws SQLException {
		patientApp.updatePatient(p);
	}

	//Admin facade

	public Vector<Patient> getAllPatients() {
		return adminApp.getAllPatients();
	}

	public Vector<Doctor> getDoctorList() {
		return adminApp.getDoctorList();
	}

	public List<Patient> resultAllPatientsFrom(String dniDoctor) throws SQLException {
		return adminApp.resultAllPatientsFrom(dniDoctor);
	}

	public Patient getPatientData(String dni) {
		return adminApp.getPatientData(dni);
	}

	public void updatePatient(List<String> colData) throws SQLException {
		adminApp.updatePatient(colData);
	}

	public Doctor getDoctorData(String dni) throws SQLException {
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

	public void assignPatientDoctor(String dniDoc, String dniPat) throws SQLException, IllegalArgumentException{
		adminApp.assignPatientDoctor(dniDoc,dniPat);
	}

	public void deletePatient(String patientDni) throws SQLException {
		adminApp.deletePatient(patientDni);
	}

	public List<String> getPlanList() {
		return adminApp.getPlanList();
	}

	public void changeBillPlan(String typeName, String newBill) {
		adminApp.changeBillPlan(typeName,newBill);
	}

	public void aceptDoctorChangeRequest(String dni_patient, String from_dni_doctor, String to_dni_doctor) throws SQLException {
		patientApp.aceptDoctorChangeRequest(dni_patient, from_dni_doctor, to_dni_doctor);
	}

	public void requestDoctorChange(String dni_patient, String from_dni_doctor, String to_dni_doctor, String reason) throws IllegalArgumentException, SQLException {
		patientApp.requestDoctorChange(dni_patient, from_dni_doctor, to_dni_doctor, reason);
	}

	//Doctor Facade

	public void updateDoctor(Doctor d) throws SQLException {
		doctorApp.updateDoctor(d);
	}

	public Vector<Patient> getPatientsOfDoctor(String doctor_dni) throws SQLException {
		return doctorApp.getPatientsOfDoctor(doctor_dni);
	}

	public void saveTreatment(Treatment t, String patient_dni) throws SQLException {
		doctorApp.saveTreatment(t, patient_dni);
	}



}
