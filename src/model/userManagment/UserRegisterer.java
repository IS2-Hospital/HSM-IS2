package model.userManagment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.DBConnector;
import model.Doctor;
import model.Patient;
import model.User;
import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.Enums.RegState;
import model.Enums.UserRole;
import model.exceptions.sqlExeptions.SqlConnectionException;
import model.userManagment.registerData.DoctorRegisterData;
import model.userManagment.registerData.PacientRegisterData;

public class UserRegisterer {

	public void registerUsers(JSONObject usersToRegister) throws Exception {

		UserRole role = UserRole.valueOf(usersToRegister.getString("role"));

		switch (role) {
		case PATIENT:
			List<PacientRegisterData> patients = parsePatientJSON(usersToRegister);
			try {
				registerPatients(patients);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception(e);
			} catch (SqlConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("Something went wrong when connecting to de DataBase");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("We already have one person with that DNI.");
			}
			break;
		case DOCTOR:
			List<DoctorRegisterData> doctors = parseDoctorJSON(usersToRegister);
			try {
				registerDoctors(doctors);
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception(e);
			} catch (SqlConnectionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("Something went wrong when connecting to de DataBase");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				throw new Exception("We already have one person with that DNI.");
			}
			break;
		case ADMIN:
			break;
		}


	}

	/* Recieves a List of registerData wich contains a Patient and its password.
	 * It begins registering into the database the first Patient in the list, and then, if there are more, it registers them.
	 * 
	 * The first Patient in the list is the only one who has to pay, becouse the rest are his familiars.
	 * 
	 * If the patient just wants to register itself with the Single insurance, the list will contain only 1 element.
	 * */
	private void registerPatients(List<PacientRegisterData> patients) throws IllegalArgumentException, SqlConnectionException, SQLException {
		Connection connex = DBConnector.connectdb();

		float insurancePrice = getinsurancePrice(connex, patients.get(0).getPatient().getInsuranceType());
		float bill = insurancePrice * patients.size();

		// register first patient of the list
		// (if there are several patients registered with the familiar plan, the first one will be the only who pays)

		try {
			registerUser(connex, patients.get(0).getPatient(), patients.get(0).getPassword(), UserRole.PATIENT);
			registerPatient(connex, patients.get(0).getPatient(), bill);

			// register the rest of the patients
			final float NOT_PAYS = 0;
			if (patients.size() >= 2)
				for (PacientRegisterData p : patients.subList(1, patients.size())) {
					registerUser(connex, p.getPatient(), p.getPassword(), UserRole.PATIENT);
					registerPatient(connex, patients.get(0).getPatient(), NOT_PAYS);
				}

			connex.close();
		} catch (IllegalArgumentException e) {
			connex.close();
			throw e;
		} catch (SqlConnectionException e) {
			connex.close();
			throw e;
		} catch (SQLException e) {
			connex.close();
			throw e;
		}
	}

	private void registerDoctors(List<DoctorRegisterData> doctors) throws IllegalArgumentException, SqlConnectionException, SQLException {
		Connection connex = DBConnector.connectdb();

		try {
			registerUser(connex, doctors.get(0).getDoctor(), doctors.get(0).getPassword(), UserRole.DOCTOR);
			registerDoctor(connex, doctors.get(0).getDoctor());
			connex.close();

		} catch (IllegalArgumentException e) {
			connex.close();
			throw e;
		} catch (SqlConnectionException e) {
			connex.close();
			throw e;
		} catch (SQLException e) {
			connex.close();
			throw e;
		}
	}

	private float getinsurancePrice(Connection connex, HealthInsuranceType type) throws SQLException {
		Statement query = connex.createStatement();
		ResultSet result = query.executeQuery(String.format("SELECT price FROM health_insurances WHERE insurance_type = '%s'", type.toString()));

		result.next();
		return result.getFloat("price");
	}

	private void registerUser(Connection connex, User user, String password, UserRole role) throws IllegalArgumentException, SQLException {

		// Insert info in USERS table
		String insertUser = "INSERT INTO users VALUES (?, ?, ?, STR_TO_DATE(?, \"%Y-%m-%d\"), ?, ?, ?, ?);";
		PreparedStatement st = connex.prepareStatement(insertUser, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, user.getDni());
		st.setString(2, user.getName());
		st.setString(3, user.getLastname());
		st.setString(4, user.getBirthdate());
		st.setString(5, password);
		st.setString(6, user.getEmail());
		st.setString(7, user.getPhone());
		st.setString(8, role.toString());

		st.execute();
	}

	private void registerPatient(Connection connex, Patient patient, double bill ) throws IllegalArgumentException, SQLException  {

		// If a patient is registered with the familiar insurace plan, he needs to be asociated with the person who paid;
		if (patient.getInsuranceType() == HealthInsuranceType.FAMILIAR && patient.getDniInsuranceTaker() == "") {
			connex.close();
			throw new IllegalArgumentException("dniInsuranceTaker can't be empty if familiar plan is selected");
		}

		// Insert info in PATIENTS table
		String insertPatient = "INSERT INTO patients (dni_patient, gender, blood_type, insurance_type, dni_insurance_taker, bill, iban, home_address) VALUES (?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement st = connex.prepareStatement(insertPatient, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, patient.getDni());
		st.setString(2, patient.getGender().toString());
		st.setString(3, patient.getBloodType().toString());
		st.setString(4, patient.getInsuranceType().toString());
		st.setString(5, patient.getDniInsuranceTaker());
		st.setDouble(6, bill);
		st.setString(7, patient.getIban());
		st.setString(8, patient.getHomeAddress());

		st.execute();
	}

	private void registerDoctor(Connection connex, Doctor doctor) throws IllegalArgumentException, SQLException  {

		// Insert info in Doctors table
		String insertDoctor = "INSERT INTO doctors (dni_doctor, speciality, salary, contract_start_date, contract_end_date, regState, notes) VALUES (?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement st = connex.prepareStatement(insertDoctor, Statement.RETURN_GENERATED_KEYS);

		st.setString(1, doctor.getDni());
		st.setString(2, doctor.getSpeciality());
		st.setFloat(3, Float.parseFloat(doctor.getSalary()));
		st.setDate(4, doctor.getContractStartDate());
		st.setDate(5, doctor.getContractEndDate());
		st.setString(6, RegState.INPROCESS.name());
		st.setString(7, doctor.getNotes());

		st.execute();
	}

	private List<PacientRegisterData> parsePatientJSON(JSONObject usersToRegister) {
		List<PacientRegisterData> patients = new ArrayList<>();

		JSONArray reg = usersToRegister.getJSONArray("registerList");
		for (Object p : reg) {
			JSONObject jo = (JSONObject) p;
			String dni = jo.getJSONObject("userData").getString("dni");
			String name = jo.getJSONObject("userData").getString("name");
			String lastname = jo.getJSONObject("userData").getString("lastname");
			String birthdate = jo.getJSONObject("userData").getString("birthdate");
			String email = jo.getJSONObject("userData").getString("email");
			String phone = jo.getJSONObject("userData").getString("phone");

			Gender gender = Gender.valueOf(jo.getJSONObject("roleData").getString("gender"));
			BloodType bloodtype = BloodType.getEnum(jo.getJSONObject("roleData").getString("bloodType"));
			HealthInsuranceType insuranceType = HealthInsuranceType.valueOf(jo.getJSONObject("roleData").getString("insuranceType"));
			String home = jo.getJSONObject("roleData").getString("home");
			String iban = jo.getJSONObject("roleData").getString("iban");

			String dniInsuranceTaker = jo.getJSONObject("roleData").getString("dniInsuranceTaker");
			if (dniInsuranceTaker == "")
				dniInsuranceTaker = null;

			String pass = jo.getString("password");
			int bill;
			if(insuranceType == HealthInsuranceType.SINGLE) bill = 50;
			else bill = 30;
			Patient patient = new Patient(dni, name, lastname, birthdate, email, phone, gender, bloodtype, insuranceType, dniInsuranceTaker, bill, pass, iban, home);

			patients.add(new PacientRegisterData(patient, pass));
		}

		return patients;
	}

	private List<DoctorRegisterData> parseDoctorJSON(JSONObject usersToRegister) {
		List<DoctorRegisterData> doctors = new ArrayList<>();

		JSONArray reg = usersToRegister.getJSONArray("registerList");
		for (Object p : reg) {
			JSONObject jo = (JSONObject) p;
			String dni = jo.getJSONObject("userData").getString("dni");
			String name = jo.getJSONObject("userData").getString("name");
			String lastname = jo.getJSONObject("userData").getString("lastname");
			String birthdate = jo.getJSONObject("userData").getString("birthdate");
			String email = jo.getJSONObject("userData").getString("email");
			String phone = jo.getJSONObject("userData").getString("phone");

			String salary = jo.getJSONObject("roleData").getString("salary");
			String contractExpiration = jo.getJSONObject("roleData").getString("contractExpiration");
			String speciality = jo.getJSONObject("roleData").getString("speciality");
			String regState = jo.getJSONObject("roleData").getString("regState");
			String notes = jo.getJSONObject("roleData").getString("notes");

			String pass = jo.getString("password");

			Doctor doctor = new Doctor(dni, name, lastname, birthdate, email, phone, salary, contractExpiration, speciality, regState, notes, pass);

			doctors.add(new DoctorRegisterData(doctor, pass));
		}

		return doctors;
	}

}
