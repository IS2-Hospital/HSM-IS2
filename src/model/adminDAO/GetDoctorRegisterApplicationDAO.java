package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnector;
import model.Doctor;
import model.DoctorRegisterApplication;

public class GetDoctorRegisterApplicationDAO {

	public static List<DoctorRegisterApplication> execute() throws SQLException {
		Connection adminConex = DBConnector.connectdb();

		ResultSet resultSet = null;

		PreparedStatement st = adminConex.prepareStatement("SELECT * FROM doctors WHERE regState = 'INPROCESS';", Statement.RETURN_GENERATED_KEYS);

		st.execute();
		resultSet = st.getResultSet();

		List<DoctorRegisterApplication> reqs = new ArrayList<DoctorRegisterApplication>();

		while(resultSet.next()) {
			Doctor doc = new Doctor(resultSet.getString("dni_doctor"), null, null, null, null, null, resultSet.getString("salary").toString(), resultSet.getDate("contract_start_date"), resultSet.getDate("contract_end_date"), resultSet.getString("speciality"), null, resultSet.getString("notes"), null);
			reqs.add(new DoctorRegisterApplication(doc));
		}

		resultSet.close();

		adminConex.close();

		return reqs;
	}
}
