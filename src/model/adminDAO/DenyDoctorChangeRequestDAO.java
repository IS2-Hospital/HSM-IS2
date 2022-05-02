package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.DoctorChangeRequest;

public class DenyDoctorChangeRequestDAO {

	public static void execute(DoctorChangeRequest req) throws SQLException {
		Connection con = DBConnector.connectdb();

		// borrar request
		String sql = "DELETE FROM doctor_change_request "
				+ "WHERE dni_patient = ? "
				+ "AND from_dni_doctor = ? "
				+ "AND to_dni_doctor = ?;";
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, req.getPatient().getDni());
		st.setString(2, req.getFromDoctor().getDni());
		st.setString(3, req.getToDoctor().getDni());

		st.execute();

		con.close();
	}

}
