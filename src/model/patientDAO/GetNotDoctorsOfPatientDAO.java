package model.patientDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.DBConnector;
import model.Doctor;

public class GetNotDoctorsOfPatientDAO {

	public static Vector<Doctor> execute(String dni) throws SQLException {
		Connection con = DBConnector.connectdb();
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(String.format("SELECT * "
				+ "FROM doctors "
				+ "JOIN users ON (doctors.dni_doctor = users.dni) "
				+ "where dni not in(SELECT dni_doctor FROM treated_by WHERE dni_patient = %s);", dni));

		Vector<Doctor> v = new Vector<>(); // DTO

		while (resultSet.next()) {
			String dni_doctor = resultSet.getString("dni_doctor");
			String name = resultSet.getString("name");
			String lastname = resultSet.getString("lastname");
			String speciality = resultSet.getString("speciality");
			String contractEndDate = resultSet.getString("contract_end_date");

			Doctor d = new Doctor(dni_doctor, name, lastname, null, null, null, null, contractEndDate, speciality, null, null, null);
			v.add(d);
		}

		con.close();
		return v;
	}
}
