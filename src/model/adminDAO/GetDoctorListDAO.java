package model.adminDAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnector;
import model.Doctor;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.ErrorHandler;

public class GetDoctorListDAO {

	public static List<Doctor> execute(){
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
				PreparedStatement st = adminConex.prepareStatement("SELECT * FROM doctors JOIN users on dni_doctor = dni;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}

		List<Doctor> docs = new ArrayList<Doctor>();
		try {
			while(resultSet.next()) {
				String dni = resultSet.getString("dni");
				String name = resultSet.getString("name");
				String lastName = resultSet.getString("lastname");
				String birthDate = resultSet.getString("birthdate");
				String email = resultSet.getString("email");
				String phone = resultSet.getString("phone");
				String speciality = resultSet.getString("speciality");
				float salary = resultSet.getFloat("salary");
				Date start = resultSet.getDate("contract_start_date");
				Date end = resultSet.getDate("contract_end_date");
				docs.add(new Doctor(dni, name, lastName, birthDate, email, phone, speciality, salary, start, end, null));
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
