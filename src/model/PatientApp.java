package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

public class PatientApp {

	public Vector<Doctor> getDoctorsOf(String dni) throws SQLException {

		Connection con = DBConnector.connectdb();
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(String.format("select * "
				+ "from treated_by "
				+ "join doctors using(dni_doctor) "
				+ "join users on (doctors.dni_doctor = users.dni) "
				+ "where dni_patient = '%s'", dni));

		Vector<Doctor> v = new Vector<>();
		while (resultSet.next()) {
			String dni_doctor = resultSet.getString("dni_doctor");
			String name = resultSet.getString("name");
			String lastname = resultSet.getString("lastname");

			Doctor d = new Doctor(dni_doctor, name, lastname, null, null, null, null, -1, null, null);
			v.add(d);
		}

		con.close();
		return v;
	}

	public Vector<String> getAvailableHours(String dni_doctor, String date) throws SQLException {

		Connection con = DBConnector.connectdb();

		String select = "select * "
				+ "from appointments "
				+ "where dni_doctor = ? "
				+ "and day = STR_TO_DATE(?, '%Y-%m-%d') "
				+ "order by hour;";
		PreparedStatement st = con.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, dni_doctor);
		st.setString(2, date);

		st.execute();
		ResultSet resultSet = st.getResultSet();

		Vector<String> v = new Vector<>();

		String[] laborableHours = {
				"08:00", "08:15", "08:30", "08:45", "09:00", "09:15", "09:30", "09:45", "10:00", "10:15", "10:30", "10:45",
				"11:00", "11:15", "11:30", "11:45", "12:00", "12:15", "12:30", "12:45", "13:00", "13:15", "13:30", "13:45",
				"14:00", "14:15", "14:30", "14:45", "15:00", "15:15", "15:30", "15:45", "16:00", "16:15", "16:30", "16:45",
				"17:00", "17:15", "17:30", "17:45", "18:00", "18:15", "18:30", "18:45", "19:00", "19:15", "19:30", "19:45"};

		String notAvailHour;
		int i = 0;
		while (resultSet.next()) {
			notAvailHour = resultSet.getTime("hour").toString().substring(0, 5);
			while (laborableHours[i].compareTo(notAvailHour) < 0) {
				v.add(laborableHours[i]);
				i++;
			}
			i++;
		}

		while(i < laborableHours.length) {
			v.add(laborableHours[i]);
			i++;
		}

		con.close();
		return v;
	}

	public void askForAppointment(String day, String hour, String dni_doctor, String dni_patient, String desc) throws SQLException {

		Connection con = DBConnector.connectdb();

		String select = "INSERT INTO appointments VALUES (STR_TO_DATE(?, '%Y-%m-%d'), STR_TO_DATE(?, '%H:%i'), ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, day);
		st.setString(2, hour);
		st.setString(3, dni_doctor);
		st.setString(4, dni_patient);
		st.setString(5, desc);

		st.execute();
	}

}
