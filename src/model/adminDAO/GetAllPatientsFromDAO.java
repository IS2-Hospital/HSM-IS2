package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.DBConnector;
import model.Patient;
import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;
import model.exceptions.sqlExeptions.SqlConnectionException;

public class GetAllPatientsFromDAO {

	public static Vector<Patient> execute(String dniDoctor) throws SQLException{
		Connection adminConex = null;
		try {
			while( adminConex == null)
				adminConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			throw new SQLException("Database Error");
		}

		ResultSet resultSet = null;
		try {
			if(adminConex != null) {
				PreparedStatement st = adminConex.prepareStatement("SELECT * FROM patients JOIN users ON dni = dni_patient JOIN treated_by ON treated_by.dni_patient = patients.dni_patient AND dni_doctor = "+dniDoctor+" order by dni;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			throw new SQLException("Database Error");
		}

		Vector<Patient> docs = new Vector<Patient>();
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
				Double bill = resultSet.getDouble("bill");
				docs.add(new Patient(dni, name, lastName, birthDate, email, phone, gen, salary, start, end, bill));
			}
			resultSet.close();
		} catch (SQLException e) {
			throw new SQLException("Database Error");
		}

		adminConex.close();

		return docs;
	}

}
