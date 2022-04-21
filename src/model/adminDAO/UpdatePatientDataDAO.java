package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import model.DBConnector;

public class UpdatePatientDataDAO {

	public static void execute(List<String> colData) throws SQLException {
		Connection con = DBConnector.connectdb();
		String patients;
		if(colData.size() == 12) { //Modificar contraseña
			patients = "UPDATE patients, users SET gender = ? , insurance_type = ? , dni_insurance_taker = ? , blood_type = ? , bill = ?, name = ?, lastname = ?, birthdate = '"+ colData.get(3) +" 00:00:00.000' , password = '" + colData.get(11) + "', email = ?, phone = ? WHERE dni_patient = ? AND dni = dni_patient;";
		}
		else {
			patients = "UPDATE patients, users SET gender = ? , insurance_type = ? , dni_insurance_taker = ? , blood_type = ? , bill = ?, name = ?, lastname = ?, birthdate = '"+ colData.get(3) +" 00:00:00.000' , email = ?, phone = ? WHERE dni_patient = ? AND dni = dni_patient;";
		}
		PreparedStatement st = con.prepareStatement(patients, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, colData.get(6));
		st.setString(2, colData.get(8));
		st.setString(3, colData.get(9));
		st.setString(4, colData.get(7));
		st.setDouble(5, Double.parseDouble(colData.get(10)));
		st.setString(6, colData.get(2));
		st.setString(7, colData.get(1));
		st.setString(8, colData.get(4));
		st.setString(9, colData.get(5));
		st.setString(10, colData.get(0));



		st.execute();
		st.close();
		con.close();
	}

}
