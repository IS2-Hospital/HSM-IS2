package model;

import java.sql.SQLException;
import java.util.Random;
import java.util.Vector;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.adminDAO.GetAllPatientsFromDAO;
import model.doctorDAO.DeleteDoctorDAO;
import model.doctorDAO.DeleteTreatmentOfDAO;
import model.doctorDAO.GetAppointmentsDoctorDAO;
import model.doctorDAO.SaveTreatmentDao;
import model.doctorDAO.UpdateDoctorDAO;

public class DoctorApp {

	public Vector<Patient> getPatientsOfDoctor(String doctor_dni) throws SQLException {
		return GetAllPatientsFromDAO.execute(doctor_dni);
	}

	public void saveTreatment(Treatment t, String patient_dni) throws SQLException {
		Random random = new Random();
		while (true) {
			t.setId(Math.abs(random.nextInt()));
			try {
				SaveTreatmentDao.execute(t, patient_dni);
				break;
			} catch (MySQLIntegrityConstraintViolationException e) {
				// alredy existing id, try again generating another random value
			}
		}
	}

	public Vector<Appointment> getAppointments(String dni_doctor) throws SQLException {
		return GetAppointmentsDoctorDAO.execute(dni_doctor);
	}

	public void updateDoctor(Doctor d) throws SQLException {
		UpdateDoctorDAO.execute(d);
	}

	public void deleteTreatment(Treatment t, String dni_patient) throws SQLException {
		DeleteTreatmentOfDAO.execute(t, dni_patient);
	}

	public void deleteDoctor(String dni) throws Exception{
		DeleteDoctorDAO.execute(dni);
	}


}
