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
import model.DoctorChangeRequest;
import model.Patient;

public class GetDoctorChangeRequestsDAO {

	public static List<DoctorChangeRequest> execute() throws SQLException {
		Connection adminConex = DBConnector.connectdb();

		ResultSet resultSet = null;

		PreparedStatement st = adminConex.prepareStatement("SELECT req.dni_patient, req.from_dni_doctor, fromD.speciality, req.to_dni_doctor, toD.speciality, req.reason "
				+ "FROM doctor_change_request req "
				+ "JOIN doctors fromD ON (req.from_dni_doctor = fromD.dni_doctor) "
				+ "JOIN doctors toD ON (req.to_dni_doctor = toD.dni_doctor);", Statement.RETURN_GENERATED_KEYS);

		st.execute();
		resultSet = st.getResultSet();

		List<DoctorChangeRequest> reqs = new ArrayList<DoctorChangeRequest>();

		while(resultSet.next()) {
			Patient p = new Patient(resultSet.getString("dni_patient"), null, null, null, null, null, null, null, null, null, -1, null, null, null);
			Doctor fromD = new Doctor(resultSet.getString("from_dni_doctor"), null, null, null, null, null, null, null, resultSet.getString("fromD.speciality"), null, null, null);
			Doctor toD = new Doctor(resultSet.getString("to_dni_doctor"), null, null, null, null, null, null, null, resultSet.getString("toD.speciality"), null, null, null);
			String reason = resultSet.getString("reason");

			reqs.add(new DoctorChangeRequest(p, fromD, toD, reason));
		}
		resultSet.close();

		adminConex.close();

		return reqs;
	}

}
