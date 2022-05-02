package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.DoctorChangeRequest;

public class AceptDoctorChangeRequestDAO {

	public static void execute(DoctorChangeRequest req) throws SQLException {
		Connection con = DBConnector.connectdb();

		// borrar antiguo doctor
		String sql = "DELETE FROM treated_by WHERE dni_patient = ? AND dni_doctor = ?;";
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, req.getPatient().getDni());
		st.setString(2, req.getFromDoctor().getDni());

		st.execute();

		// poner nuevo doctor
		String sql2 = "INSERT INTO treated_by VALUES (?, ?);";
		PreparedStatement st2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
		st2.setString(1, req.getPatient().getDni());
		st2.setString(2, req.getToDoctor().getDni());

		st2.execute();

		// borrar request
		String sql3 = "DELETE FROM doctor_change_request "
				+ "WHERE dni_patient = ? "
				+ "AND from_dni_doctor = ? "
				+ "AND to_dni_doctor = ?;";
		PreparedStatement st3 = con.prepareStatement(sql3, Statement.RETURN_GENERATED_KEYS);
		st3.setString(1, req.getPatient().getDni());
		st3.setString(2, req.getFromDoctor().getDni());
		st3.setString(3, req.getToDoctor().getDni());

		st3.execute();

		con.close();
	}
}
