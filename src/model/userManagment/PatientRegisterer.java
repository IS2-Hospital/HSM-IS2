package model.userManagment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.DBConnector;
import model.HealthInsuranceType;
import model.Patient;
import model.UserRole;
import model.exceptions.sqlExeptions.SqlConnectionException;

public class PatientRegisterer {

	/* Recieves a List of registerData wich contains a Patient and its password.
	 * It begins registering into the database the first Patient in the list, and then, if there are more, it registers them.
	 * 
	 * The first Patient in the list is the only one who has to pay, becouse the rest are his familiars.
	 * 
	 * If the patient just wants to register itself with the Single insurance, the list will contain only 1 element.
	 * */
	public void registerPatients(List<RegisterData> patients) throws IllegalArgumentException, SqlConnectionException, SQLException {
		Connection connex = DBConnector.connectdb();

		float insurancePrice = getinsurancePrice(connex, patients.get(0).getPatient().getInsuranceType());
		float bill = insurancePrice * patients.size();

		// register first patient of the list
		// (if there are several patients registered with the familiar plan, the first one will be the only who pays)
		register(connex, patients.get(0).getPatient(), patients.get(0).getPassword(), bill);

		// register the rest of the patients
		final float NOT_PAYS = 0;
		if (patients.size() >= 2)
			for (RegisterData p : patients.subList(1, patients.size()))
				register(connex, p.getPatient(), p.getPassword(), NOT_PAYS);

		connex.close();
	}

	private float getinsurancePrice(Connection connex, HealthInsuranceType type) throws SQLException {
		Statement query = connex.createStatement();
		ResultSet result = query.executeQuery(String.format("SELECT price FROM health_insurances WHERE insurance_type = '%s'", type.toString()));

		result.next();
		return result.getFloat("price");
	}

	private void register(Connection connex, Patient patient, String password, float bill) throws IllegalArgumentException, SQLException {

		// If a patient is registered with the familiar insurace plan, he needs to be asociated with the person who paid;
		if (patient.getInsuranceType() == HealthInsuranceType.FAMILIAR && patient.getDniInsuranceTaker() == null)
			throw new IllegalArgumentException("dniInsuranceTaker can't be null if familiar plan is selected");

		// Insert info in USERS table
		String insertUser = "INSERT INTO users VALUES (?, ?, ?, STR_TO_DATE(?, \"%Y-%m-%d\"), ?, ?, ?, ?);";
		PreparedStatement st = connex.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, patient.getDni());
		st.setString(2, patient.getName());
		st.setString(3, patient.getLastname());
		st.setString(4, patient.getBirthdate());
		st.setString(5, password);
		st.setString(6, patient.getEmail());
		st.setString(7, patient.getPhone());
		st.setString(8, UserRole.PATIENT.toString());

		st.execute();

		// Insert info in PATIENTS table
		String insertPatient = "INSERT INTO patients VALUES (?, ?, ?, ?, ?);";
		st = connex.prepareStatement(insertPatient, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, patient.getDni());
		st.setString(2, patient.getGender().toString());
		st.setString(3, patient.getInsuranceType().toString());
		st.setString(4, patient.getDniInsuranceTaker());
		st.setDouble(5, bill);

		st.execute();
	}
}
