package model.patientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.Statement;

import model.DBConnector;

public class RequestDoctorChangeDAO {

	public static void execute(String dni_patient, String from_dni_doctor, String to_dni_doctor, String reason) throws IllegalArgumentException, SQLException {
		try {
			Connection con = DBConnector.connectdb();

			String sql = "INSERT INTO doctor_change_request VALUES (?, ?, ?, ?);";
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, dni_patient);
			st.setString(2, from_dni_doctor);
			st.setString(3, to_dni_doctor);
			st.setString(4, reason);

			st.execute();

			con.close();
		} catch (SQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("You have made this request alredy. Wait for it to be acepted or denied");
		}
	}
}
