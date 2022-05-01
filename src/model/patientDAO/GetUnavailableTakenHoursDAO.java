package model.patientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnector;

public class GetUnavailableTakenHoursDAO {

	public static List<String> execute(String doctor_dni, String date) throws SQLException {
		Connection con = DBConnector.connectdb();

		String select = "select hour "
				+ "from appointments "
				+ "where dni_doctor = ? "
				+ "and day = STR_TO_DATE(?, '%Y-%m-%d') "
				+ "order by hour;";
		PreparedStatement st = con.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, doctor_dni);
		st.setString(2, date);

		st.execute();
		ResultSet resultSet = st.getResultSet();

		List<String> l = new ArrayList<>(); // DTO

		while (resultSet.next()) {
			l.add(resultSet.getString("hour").substring(0, 5));
		}

		con.close();
		return l;
	}
}
