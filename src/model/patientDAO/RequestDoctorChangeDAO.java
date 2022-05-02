package model.patientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import model.DBConnector;
import model.DoctorChangeRequest;

public class RequestDoctorChangeDAO {

	public static void execute(DoctorChangeRequest req) throws IllegalArgumentException, SQLException {
		try {
			Connection con = DBConnector.connectdb();

			String sql = "INSERT INTO doctor_change_request VALUES (?, ?, ?, ?);";
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, req.getPatient().getDni());
			st.setString(2, req.getFromDoctor().getDni());
			st.setString(3, req.getToDoctor().getDni());
			st.setString(4, req.getReason());

			st.execute();

			con.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("You have made this request alredy. Wait for it to be acepted or denied");
		}
	}
}
