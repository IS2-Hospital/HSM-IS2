package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;

public class AceptDoctorChangeRequestDAO {

	public static void execute(String dni_patient, String fromDni_doctor, String toDni_doctor) throws SQLException {
		Connection con = DBConnector.connectdb();

		// borrar antiguo doctor
		String sql = "DELETE FROM treated_by WHERE dni_patient = ? AND dni_doctor = ?;";
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, dni_patient);
		st.setString(2, fromDni_doctor);

		st.execute();

		// poner nuevo doctor
		String sql2 = "INSERT INTO treated_by VALUES (?, ?);";
		PreparedStatement st2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
		st2.setString(1, dni_patient);
		st2.setString(2, toDni_doctor);

		st2.execute();

		// TODO borrar request
		String sql3 = "";

		con.close();
	}
}
