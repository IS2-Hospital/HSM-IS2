package model;

import java.sql.SQLException;
import java.util.List;

import model.adminDAO.DeleteRequestDAO;
import model.adminDAO.GetAllPatientsDAO;
import model.adminDAO.GetAllPatientsFromDAO;
import model.adminDAO.GetDNIListFromRequestDAO;
import model.adminDAO.GetDoctorDataDAO;
import model.adminDAO.GetDoctorListDAO;
import model.adminDAO.GetPatientDataDAO;
import model.adminDAO.GetRequestIDListDAO;
import model.adminDAO.GetRequestReasonDAO;
import model.adminDAO.InsertRelationPatientDoctorDAO;
import model.adminDAO.UpdateDoctorDAO;
import model.adminDAO.UpdatePatientDataDAO;

public class AdminApp {

	public List<Doctor> getDoctorList() {
		return GetDoctorListDAO.execute();
	}

	public Patient getPatientData(String dni) {
		return GetPatientDataDAO.execute(dni);
	}

	public void updatePatient(List<String> colData) throws SQLException {
		UpdatePatientDataDAO.execute(colData);
	}

	public Doctor getDoctorData(String dni) {
		return GetDoctorDataDAO.execute(dni);
	}

	public void updateDoctor(List<String> colData) throws SQLException {
		UpdateDoctorDAO.execute(colData);
	}

	public List<String> getRequestIDList() {
		return GetRequestIDListDAO.execute();
	}

	public List<String> getDNIFromRequest(String string) throws SQLException {
		return GetDNIListFromRequestDAO.execute(string);
	}

	public String getReason(String id) throws SQLException {
		return GetRequestReasonDAO.execute(id);
	}

	public void aproveChange(String id) throws SQLException {
		List<String> dni = getDNIFromRequest(id);
		DeleteRequestDAO.execute(id);
		InsertRelationPatientDoctorDAO.execute(dni.get(0), dni.get(2));
	}

	public List<Patient> getAllPatients() {
		return GetAllPatientsDAO.execute();
	}

	public List<Patient> resultAllPatientsFrom(String dniDoctor) throws SQLException {
		return GetAllPatientsFromDAO.execute(dniDoctor);
	}

	public void assignPatientDoctor(String dniDoc, String dniPat) {
		InsertRelationPatientDoctorDAO.execute(dniDoc, dniPat);
	}

}
