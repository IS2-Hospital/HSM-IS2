package model.doctorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnector;

public class DeleteDoctorDAO {
	public static void execute(String dni) throws SQLException {
		// Borramos doctor
		Connection con = DBConnector.connectdb();
		String SQL = "DELETE FROM doctors WHERE dni_doctor = '" + dni + "';";
		PreparedStatement st = con.prepareStatement(SQL);
		st.executeUpdate();
		// Borramos usuario
		String SQL2 = "DELETE FROM users WHERE dni = '" + dni + "';";
		PreparedStatement st2 = con.prepareStatement(SQL2);
		st2.executeUpdate();

		st.close();
		con.close();
	}
}
