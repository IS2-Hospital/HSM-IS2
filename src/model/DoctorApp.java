package model;

import java.util.List;

import model.adminDAO.GetAllPatientsFromDAO;

public class DoctorApp {

	public List<Patient> getPatientsOfDoctor(String doctor_dni) {
		return GetAllPatientsFromDAO.execute(doctor_dni);
	}

}
