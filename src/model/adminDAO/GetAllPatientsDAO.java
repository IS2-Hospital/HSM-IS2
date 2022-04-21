package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnector;
import model.Patient;
import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.ErrorHandler;

public class GetAllPatientsDAO {

	public static List<Patient> execute() {
		Connection adminConex = null;
		try {
			while( adminConex == null)
				adminConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet resultSet = null;
		try {
			if(adminConex != null) {
				PreparedStatement st = adminConex.prepareStatement("SELECT * FROM patients JOIN users on dni_patient = dni;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}

		List<Patient> docs = new ArrayList<Patient>();
		try {
			while(resultSet.next()) {
				String dni = resultSet.getString("dni");
				String name = resultSet.getString("name");
				String lastName = resultSet.getString("lastname");
				String birthDate = resultSet.getString("birthdate");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				Gender gen = Gender.valueOf(resultSet.getString("gender"));
				BloodType salary = BloodType.getEnum(resultSet.getString("blood_type"));
				HealthInsuranceType start = HealthInsuranceType.valueOf(resultSet.getString("insurance_type"));
				String end = resultSet.getString("dni_insurance_taker");
				double bill = resultSet.getDouble("bill");
				docs.add(new Patient(dni, name, lastName, birthDate, email, phone, gen, salary, start, end, bill));
			}
			resultSet.close();
		} catch (SQLException e) {
			ErrorHandler.showError(e.getMessage(),"Database Error");
		}
		try {
			adminConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}
		return docs;
	}

}
