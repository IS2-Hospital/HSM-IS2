package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Random;

import com.mysql.jdbc.exceptions.MySQLIntegrityConstraintViolationException;

import model.adminDAO.GetAllPatientsFromDAO;
import model.doctorDAO.SaveTreatmentDao;

public class DoctorApp {

	public List<Patient> getPatientsOfDoctor(String doctor_dni) {
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

}
