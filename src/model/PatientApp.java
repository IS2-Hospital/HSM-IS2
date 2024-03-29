package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import model.patientDAO.AskForAppointmentDAO;
import model.patientDAO.CancelAppointmentPatientDAO;
import model.patientDAO.GetAppointmentsDAO;
import model.patientDAO.GetDoctorsOfPatientDAO;
import model.patientDAO.GetHistoryDAO;
import model.patientDAO.GetNotDoctorsOfPatientDAO;
import model.patientDAO.GetPatientFullDataDAO;
import model.patientDAO.GetTreatmentsDAO;
import model.patientDAO.GetUnavailableTakenHoursDAO;
import model.patientDAO.RequestDoctorChangeDAO;
import model.patientDAO.UpdatePatientDAO;

public class PatientApp {

	public Vector<Doctor> getDoctorsOf(String dni) throws SQLException {
		return GetDoctorsOfPatientDAO.execute(dni);
	}

	public Vector<Doctor> getNotDoctorsOf(String dni) throws SQLException {
		return GetNotDoctorsOfPatientDAO.execute(dni);
	}

	public Vector<String> getAvailableHours(String doctor_dni, String date) throws SQLException {

		List<String> unavailableHours = GetUnavailableTakenHoursDAO.execute(doctor_dni, date);

		String[] laborableHours = {
				"08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45",
				"11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45",
				"14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45",
				"17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45"};

		Vector<String> availableHours = new Vector<>();

		int i = 0;
		for (String unavailableHour : unavailableHours) {
			while (laborableHours[i].compareTo(unavailableHour) < 0) {
				availableHours.add(laborableHours[i]);
				i++;
			}
			i++; // skips unavailable hour
		}

		// add remaining laborable hours
		while (i < laborableHours.length) {
			availableHours.add(laborableHours[i]);
			i++;
		}

		return availableHours;
	}

	public void askForAppointment(Appointment appo) throws SQLException {
		AskForAppointmentDAO.execute(appo);
	}

	public Vector<Appointment> getAppointments(String dni_patient) throws SQLException {
		return GetAppointmentsDAO.execute(dni_patient);
	}

	public Vector<History> getHistory(String dni_patient) throws SQLException {
		return GetHistoryDAO.execute(dni_patient);
	}

	public Vector<Treatment> getTreatment(String dni_patient) throws SQLException{
		return GetTreatmentsDAO.execute(dni_patient);
	}

	public Patient getPatientFullData(String dni) throws SQLException {
		return GetPatientFullDataDAO.execute(dni);
	}

	public void updatePatient(Patient p) throws SQLException {
		UpdatePatientDAO.execute(p);
	}

	public void requestDoctorChange(DoctorChangeRequest req) throws IllegalArgumentException, SQLException {
		RequestDoctorChangeDAO.execute(req);
	}

	public void cancelAppointment(Appointment p, String dni_patient) throws SQLException {
		CancelAppointmentPatientDAO.execute(p, dni_patient);
	}

}
