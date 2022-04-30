package model.patientDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.DBConnector;
import model.Doctor;

public class GetDoctorsOfPatientDAO {

	public static Vector<Doctor> execute(String dni) throws SQLException {
		Connection con = DBConnector.connectdb();
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(String.format("select * "
				+ "from treated_by "
				+ "join doctors using(dni_doctor) "
				+ "join users on (doctors.dni_doctor = users.dni) "
				+ "where dni_patient = '%s'", dni));

		Vector<Doctor> v = new Vector<>(); // DTO

		while (resultSet.next()) {
			String dni_doctor = resultSet.getString("dni_doctor");
			String name = resultSet.getString("name");
			String lastname = resultSet.getString("lastname");

			Doctor d = new Doctor(dni_doctor, name, lastname, null, null, null, null, -1, null, null, null);
			v.add(d);
		}

		con.close();
		return v;
	}
}
