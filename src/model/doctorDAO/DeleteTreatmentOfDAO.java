package model.doctorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.DBConnector;
import model.Treatment;

public class DeleteTreatmentOfDAO {

	public static void execute(Treatment t, String dni_patient) throws SQLException {
		Connection con = DBConnector.connectdb();

		// borrar en la tabla recieves_treatment
		String SQL = "DELETE FROM recieves_treatment WHERE id_treatment = ? AND dni_patient = ?;";
		PreparedStatement st = con.prepareStatement(SQL);
		st.setInt(1, t.getId());
		st.setString(2, dni_patient);

		st.executeUpdate();

		// borrar en la tabla treatments
		String SQL2 = "DELETE FROM treatments WHERE id_treatment = ?;";
		PreparedStatement st2 = con.prepareStatement(SQL2);
		st2.setInt(1, t.getId());

		st2.executeUpdate();

		con.close();
	}

}
