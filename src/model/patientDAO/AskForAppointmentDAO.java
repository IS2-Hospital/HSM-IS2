package model.patientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.Appointment;
import model.DBConnector;

public class AskForAppointmentDAO {

	public static void execute(Appointment appo) throws SQLException {
		Connection con = DBConnector.connectdb();

		String select = "INSERT INTO appointments VALUES (STR_TO_DATE(?, '%Y-%m-%d'), STR_TO_DATE(?, '%H:%i'), ?, ?, ?)";
		PreparedStatement st = con.prepareStatement(select, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, appo.getDay());
		st.setString(2, appo.getHour());
		st.setString(3, appo.getPerson());
		st.setString(4, appo.getDni_patient());
		st.setString(5, appo.getDescription());

		st.execute();
		con.close();
	}
}
