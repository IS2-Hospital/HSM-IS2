package model;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import model.adminDAO.AceptDoctorApplicationDAO;
import model.adminDAO.AceptDoctorChangeRequestDAO;
import model.adminDAO.ChangeBillPlanDAO;
import model.adminDAO.DeletePatientDAO;
import model.adminDAO.DeleteRequestDAO;
import model.adminDAO.DenyDoctorApplicationDAO;
import model.adminDAO.DenyDoctorChangeRequestDAO;
import model.adminDAO.GetAllPatientsDAO;
import model.adminDAO.GetAllPatientsFromDAO;
import model.adminDAO.GetDNIListFromRequestDAO;
import model.adminDAO.GetDoctorChangeRequestsDAO;
import model.adminDAO.GetDoctorDataDAO;
import model.adminDAO.GetDoctorListDAO;
import model.adminDAO.GetDoctorRegisterApplicationDAO;
import model.adminDAO.GetInsurancePricesDAO;
import model.adminDAO.GetPatientDataDAO;
import model.adminDAO.GetPlanListDAO;
import model.adminDAO.GetRequestReasonDAO;
import model.adminDAO.InsertRelationPatientDoctorDAO;
import model.adminDAO.UpdateDoctorDAO;
import model.adminDAO.UpdatePatientDataDAO;

public class AdminApp {

	public Vector<Doctor> getDoctorList() {
		return GetDoctorListDAO.execute();
	}

	public Patient getPatientData(String dni) {
		return GetPatientDataDAO.execute(dni);
	}

	public void updatePatient(List<String> colData) throws SQLException {
		UpdatePatientDataDAO.execute(colData);
	}

	public Doctor getDoctorData(String dni) throws SQLException {
		return GetDoctorDataDAO.execute(dni);
	}

	public void updateDoctor(List<String> colData) throws SQLException {
		UpdateDoctorDAO.execute(colData);
	}

	public List<DoctorChangeRequest> getDoctorChangeRequests() throws SQLException {
		return GetDoctorChangeRequestsDAO.execute();
	}

	public List<DoctorRegisterApplication> getDoctorRegisterApplication() throws SQLException {
		return GetDoctorRegisterApplicationDAO.execute();
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

	public Vector<Patient> getAllPatients() {
		return GetAllPatientsDAO.execute();
	}

	public List<Patient> resultAllPatientsFrom(String dniDoctor) throws SQLException {
		return GetAllPatientsFromDAO.execute(dniDoctor);
	}

	public void assignPatientDoctor(String dniDoc, String dniPat) throws SQLException, IllegalArgumentException {
		InsertRelationPatientDoctorDAO.execute(dniDoc, dniPat);
	}

	public void deletePatient(String patientDni) throws SQLException {
		DeletePatientDAO.execute(patientDni);
	}

	public List<String> getPlanList() {
		return GetPlanListDAO.execute();
	}

	public void changeBillPlan(String typeName, double newBill) throws SQLException {
		ChangeBillPlanDAO.execute(typeName, newBill);
	}

	public void aceptDoctorChangeRequest(DoctorChangeRequest req) throws SQLException {
		AceptDoctorChangeRequestDAO.execute(req);
	}

	public void denyDoctorChangeRequest(DoctorChangeRequest req) throws SQLException {
		DenyDoctorChangeRequestDAO.execute(req);
	}

	public void aceptDoctorApplication(DoctorRegisterApplication req) throws SQLException {
		AceptDoctorApplicationDAO.execute(req);
	}

	public void denyDoctorApplication(DoctorRegisterApplication req) throws SQLException {
		DenyDoctorApplicationDAO.execute(req);
	}


	public double[] getInsurancePrices() throws SQLException {
		return GetInsurancePricesDAO.execute();
	}

}
