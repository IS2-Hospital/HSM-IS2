package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.DoctorRegisterApplication;

public class DenyDoctorApplicationDAO {
	public static void execute(DoctorRegisterApplication req) throws SQLException {
		Connection con = DBConnector.connectdb();

		// Actualizamos el valor
		String sql = "UPDATE doctors SET regState = 'DENEGATED' WHERE dni_doctor = ?;";
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, req.getDoctor().getDni());
		st.execute();

		con.close();
	}
}
