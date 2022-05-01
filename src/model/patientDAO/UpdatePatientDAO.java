package model.patientDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.Patient;

public class UpdatePatientDAO {

	public static void execute(Patient p) throws SQLException {
		Connection con = DBConnector.connectdb();

		String sql = "UPDATE users SET "
				+ "name = ?, "
				+ "lastname = ?, "
				+ "password = ?, "
				+ "birthdate = STR_TO_DATE(?, '%Y-%m-%d'), "
				+ "email = ?, "
				+ "phone = ? "
				+ "WHERE dni = ?;";

		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, p.getName());
		st.setString(2, p.getLastname());
		st.setString(3, p.getPass());
		st.setString(4, p.getBirthdate());
		st.setString(5, p.getEmail());
		st.setString(6, p.getPhone());
		st.setString(7, p.getDni());

		st.execute();


		String sql2 = "UPDATE patients SET "
				+ "gender = ?, "
				+ "blood_type = ?, "
				+ "iban = ?, "
				+ "home_address = ? "
				+ "WHERE dni_patient = ?;";

		PreparedStatement st2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
		st2.setString(1, p.getGender().toString());
		st2.setString(2, p.getBloodType().toString());
		st2.setString(3, p.getIban());
		st2.setString(4, p.getHomeAddress());
		st2.setString(5, p.getDni());

		st2.execute();

		con.close();
	}
}
