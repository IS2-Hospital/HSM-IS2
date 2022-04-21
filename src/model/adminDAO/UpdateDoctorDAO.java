package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.DBConnector;

public class UpdateDoctorDAO {

	public static void execute(List<String> colData) throws SQLException {
		Connection con = DBConnector.connectdb();

		String patients = "UPDATE doctors, users SET speciality = ? , salary = ? , contract_start_date = '"+ colData.get(8)+ " 00:00:00.000', contract_end_date = '"+ colData.get(9)+ " 00:00:00.000', name = ?, lastname = ?, birthdate = '"+ colData.get(3) +" 00:00:00.000' , email = ?, phone = ? WHERE dni_doctor = ? AND dni = dni_doctor;";
		PreparedStatement st = con.prepareStatement(patients, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, colData.get(6));
		st.setString(2, colData.get(7));
		st.setString(3, colData.get(2));
		st.setString(4, colData.get(1));
		st.setString(5, colData.get(4));
		st.setString(6, colData.get(5));
		st.setString(7, colData.get(0));

		st.execute();
		st.close();
		con.close();
	}

}
