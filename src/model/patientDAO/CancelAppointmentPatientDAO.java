package model.patientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Appointment;
import model.DBConnector;

public class CancelAppointmentPatientDAO {
	public static void execute(Appointment appo, String dni) throws SQLException {
		Connection con = DBConnector.connectdb();

		String SQL = "DELETE FROM appointments WHERE dni_patient = '" + dni + "' and day = STR_TO_DATE('" + appo.getDay() + "', '%Y-%m-%d') and +  hour = STR_TO_DATE('" + appo.getHour() + "', '%H:%i')";
		PreparedStatement st = con.prepareStatement(SQL);
		st.executeUpdate();

		st.close();
		con.close();
	}
}
