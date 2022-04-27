package model.doctorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.DBConnector;
import model.Treatment;

public class SaveTreatmentDao {

	public static void execute(Treatment t, String patient_dni) throws MySQLIntegrityConstraintViolationException, SQLException {
		Connection con = DBConnector.connectdb();

		String sql = "INSERT INTO treatments VALUES (?, STR_TO_DATE(?, '%Y-%m-%d'), STR_TO_DATE(?, '%Y-%m-%d'), ?, ?)";
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setInt(1, t.getId());
		st.setString(2, t.getStartDate());
		st.setString(3, t.getEndDate());
		st.setString(4, t.getName());
		st.setString(5, t.getDescription());

		st.execute();

		String sql2 = "INSERT INTO recieves_treatment VALUES (?, ?)";
		PreparedStatement st2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
		st2.setInt(1, t.getId());
		st2.setString(2, patient_dni);

		st2.execute();

		con.close();
	}
}
