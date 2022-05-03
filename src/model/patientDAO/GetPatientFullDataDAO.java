package model.patientDAO;

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

public class GetPatientFullDataDAO {

	public static Patient execute(String dni) throws SQLException {
		Connection adminConex = DBConnector.connectdb();

		ResultSet resultSet = null;

		if(adminConex != null) {
			PreparedStatement st = adminConex.prepareStatement("SELECT * FROM users JOIN patients ON dni = dni_patient WHERE '"+dni+"' = dni", Statement.RETURN_GENERATED_KEYS);
			st.execute();
			resultSet = st.getResultSet();
		}


		Patient docs = null;

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
			String pass = resultSet.getString("password");
			String iban = resultSet.getString("iban");
			String homeAddress = resultSet.getString("home_address");
			docs = new Patient(dni1, name, lastName, birthDate, email, phone, gen, bloodType, insuranceType, insuranceTaker, bill, pass, iban, homeAddress);
		}
		resultSet.close();

		adminConex.close();

		return docs;
	}

}
