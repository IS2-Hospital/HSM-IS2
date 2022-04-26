package model.patientDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;

import model.DBConnector;
import model.Treatment;

public class GetTreatmentsDAO {
	public static Vector<Treatment> execute(String dni_patient) throws SQLException{
		Connection con = DBConnector.connectdb();

		String SQL = "SELECT * "
				+ "FROM treatments "
				+ "join recieves_treatment using(id_treatment) "
				+ "WHERE dni_patient = " + dni_patient
				+ " ORDER BY start_date, end_date, name;";

		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(SQL);

		Vector<Treatment> v = new Vector<>(); // DTO
		while(resultSet.next()) {
			String start_date = resultSet.getString("start_date");
			String end_date = resultSet.getString("end_date");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");

			Treatment tr = new Treatment(-1, name, description, start_date, end_date);
			v.add(tr);
		}

		resultSet.close();
		st.close();
		con.close();

		return v;
	}
}
