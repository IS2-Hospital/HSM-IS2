package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.ErrorHandler;

public class GetRequestReasonDAO {

	public static String execute(String id) {
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
				PreparedStatement st = adminConex.prepareStatement("SELECT reason FROM doctor_change_request WHERE id = '"+ id +"';", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}

		String ids = "No reason";
		try {
			while(resultSet.next()) {
				ids = resultSet.getString(1);
			}
			resultSet.close();
		} catch (SQLException e) {
			ErrorHandler.showError(e.getMessage(),"Database Error");
		}
		try {
			adminConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}
		return ids;
	}

}
