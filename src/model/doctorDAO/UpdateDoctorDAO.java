package model.doctorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.Doctor;

public class UpdateDoctorDAO {

	public static void execute(Doctor d) throws SQLException {
		Connection con = DBConnector.connectdb();

		String sql = "UPDATE users SET "
				+ "name = ?, "
				+ "lastname = ?, "
				+ "password = ?, "
				+ "birthdate = STR_TO_DATE(?, '%Y-%m-%d'), "
				+ "email = ?, "
				+ "phone = ? "
				+ "WHERE (dni = ?);";

		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, d.getName());
		st.setString(2, d.getLastname());
		st.setString(3, d.getPass());
		st.setString(4, d.getBirthdate());
		st.setString(5, d.getEmail());
		st.setString(6, d.getPhone());
		st.setString(7, d.getDni());

		st.execute();
		st.close();

		con.close();
	}
}
