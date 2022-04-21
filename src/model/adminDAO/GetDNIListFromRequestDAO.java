package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.DBConnector;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.ErrorHandler;

public class GetDNIListFromRequestDAO {

	public static List<String> execute(String string) {
		Connection adminConex = null;
		try {
			while( adminConex == null)
				adminConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet resultSet = null;
		try {
			if(adminConex != null) {
				PreparedStatement st = adminConex.prepareStatement("SELECT dni_patient, treated_by.dni_doctor, doctor_change_request.dni_doctor FROM doctor_change_request JOIN treated_by ON treated_by.dni_patient = doctor_change_request.dni_patient WHERE id = '" + string + "';", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}

		List<String> dni = new ArrayList<String>();
		try {
			resultSet.first();
			try {
				dni.add(resultSet.getString(1));
			}
			catch(SQLException e) {
				dni.add("");
			}
			try {
				dni.add(resultSet.getString(2));
			}
			catch(SQLException e) {
				dni.add("");
			}
			try {
				dni.add(resultSet.getString(3));
			}
			catch(SQLException e) {
				dni.add("");
			}
			resultSet.close();
			resultSet.close();
		} catch (SQLException e) {
			ErrorHandler.showError(e.getMessage(),"Database Error");
		}
		try {
			adminConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}
		return dni;
	}

}
