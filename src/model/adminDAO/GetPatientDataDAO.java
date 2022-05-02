package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.Patient;
import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.ErrorHandler;

public class GetPatientDataDAO {

	public static Patient execute(String dni) {

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
				PreparedStatement st = adminConex.prepareStatement("SELECT * FROM users JOIN patients ON dni = dni_patient WHERE dni = '" + dni + "';", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}

		Patient docs = null;
		try {
			while(resultSet.next()) {
				String dni1 = resultSet.getString("dni");
				String name = resultSet.getString("name");
				String lastName = resultSet.getString("lastname");
				String birthDate = resultSet.getString("birthdate");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				Gender gen = Gender.valueOf(resultSet.getString("gender"));
				BloodType bloodType = BloodType.getEnum(resultSet.getString("blood_type"));
				HealthInsuranceType insuranceType = HealthInsuranceType.valueOf(resultSet.getString("insurance_type"));
				String insuranceTaker = resultSet.getString("dni_insurance_taker");
				Double bill = resultSet.getDouble("bill");
				docs = new Patient(dni1, name, lastName, birthDate, email, phone, gen, bloodType, insuranceType, insuranceTaker, bill);
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
