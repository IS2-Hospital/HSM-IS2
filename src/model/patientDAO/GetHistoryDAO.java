package model.patientDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.DBConnector;
import model.History;

public class GetHistoryDAO {

	public static Vector<History> execute(String dni_patient) throws SQLException{
		Connection con = DBConnector.connectdb();
		String SQL = "SELECT * "
				+ "FROM treatments "
				+ "join recieves_treatment using(id_treatment) "
				+ "WHERE dni_patient = " + dni_patient + " and end_date IS NOT NULL"
				+ " ORDER BY start_date, end_date, name;";

		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(SQL);

		Vector<History> v = new Vector<>(); // DTO
		while(resultSet.next()) {
			String start_date = resultSet.getString("start_date");
			String end_date = resultSet.getString("end_date");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");

			History tr = new History(start_date, end_date, name, description);
			v.add(tr);
		}

		resultSet.close();
		st.close();
		con.close();

		return v;
	}


}
