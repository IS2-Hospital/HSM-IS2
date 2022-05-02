package model.adminDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.Doctor;

public class GetDoctorDataDAO {

	public static Doctor execute(String dni) throws SQLException {
		Connection adminConex = DBConnector.connectdb();

		ResultSet resultSet = null;


		PreparedStatement st = adminConex.prepareStatement("SELECT * FROM users JOIN doctors ON dni = dni_doctor WHERE "+dni+" = dni", Statement.RETURN_GENERATED_KEYS);
		st.execute();
		resultSet = st.getResultSet();


		Doctor docs = null;

		while(resultSet.next()) {
			String name = resultSet.getString("name");
			String lastName = resultSet.getString("lastname");
			String birthDate = resultSet.getString("birthdate");
			String email = resultSet.getString("email");
			String phone = resultSet.getString("phone");
			String speciality = resultSet.getString("speciality");
			float salary = resultSet.getFloat("salary");
			Date start = resultSet.getDate("contract_start_date");
			Date end = resultSet.getDate("contract_end_date");
			String pass = resultSet.getString("password");
			docs = new Doctor(dni, name, lastName, birthDate, email, phone, speciality, salary, start, end, pass);
		}
		resultSet.close();

		adminConex.close();

		return docs;

	}
}

