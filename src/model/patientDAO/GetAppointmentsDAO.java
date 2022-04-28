package model.patientDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.Appointment;
import model.DBConnector;

public class GetAppointmentsDAO {

	public static Vector<Appointment> execute(String dni_patient) throws SQLException {
		Connection con = DBConnector.connectdb();
		String SQL = "SELECT a.day, a.hour, u.name, u.lastname, a.description "
				+ "FROM appointments a "
				+ "join users u on a.dni_doctor = u.dni "
				+ "WHERE a.dni_patient =" + dni_patient
				+ " order by a.day, a.hour;";

		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(SQL);

		Vector<Appointment> v = new Vector<>(); // DTO

		while(resultSet.next()) {
			String date = resultSet.getString("day");
			String hour = resultSet.getString("hour").substring(0, 5);
			String name = resultSet.getString("name");
			String lastName = resultSet.getString("lastname");
			String doctor = name + " " + lastName;
			String desc = resultSet.getString("description");

			Appointment ap = new Appointment(date, hour, doctor, desc);
			v.add(ap);
		}

		resultSet.close();
		st.close();
		con.close();

		return v;
	}
}
