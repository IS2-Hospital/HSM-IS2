package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.ErrorHandler;

public class DeletePatientDAO {

	public static void execute(String patientDni) throws SQLException {
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
				PreparedStatement st = adminConex.prepareStatement("SELECT * FROM patients WHERE dni_insurance_taker = '"+ patientDni +"'AND dni_insurance_taker != dni_patient;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			if (resultSet.first()) {
				throw new SQLException("There is at least one person paying their bills through this patient. Delete that person first.");
			}
			adminConex.close();
		} catch (SQLException e) {
			if (resultSet.first()) {
				throw new SQLException("There is at least one person paying their bills through this patient. Delete that person first.");
			}
			else {
				ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
			}
		}

		Connection secondConex = null;
		try {
			while( secondConex == null)
				secondConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet secondResultset = null;
		try {
			if(secondConex != null) {
				PreparedStatement st = secondConex.prepareStatement("DELETE FROM recieves_treatment WHERE dni_patient = '"+patientDni+"' ;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				secondResultset = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			secondConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}
		Connection thirdConex = null;
		try {
			while( thirdConex == null)
				thirdConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet thirdResultset1 = null;
		try {
			if(thirdConex != null) {
				PreparedStatement st = thirdConex.prepareStatement("DELETE FROM treated_by WHERE dni_patient = '"+patientDni+"' ;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				thirdResultset1 = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			thirdConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}

		Connection fourthConex = null;
		try {
			while( fourthConex == null)
				fourthConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet fourthResultset = null;
		try {
			if(fourthConex != null) {
				PreparedStatement st = fourthConex.prepareStatement("DELETE FROM doctor_change_request WHERE dni_patient = '"+patientDni+"' ;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				fourthResultset = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			fourthConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}

		Connection fifthConex1 = null;
		try {
			while( fifthConex1 == null)
				fifthConex1 = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet fifthResultset = null;
		try {
			if(fifthConex1 != null) {
				PreparedStatement st = fifthConex1.prepareStatement("DELETE FROM appointments WHERE dni_patient = '"+patientDni+"' ;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				fifthResultset = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			fifthConex1.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}

		Connection sixthConex = null;
		try {
			while( sixthConex == null)
				sixthConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet sixthResultset = null;
		try {
			if(sixthConex != null) {
				PreparedStatement st = sixthConex.prepareStatement("DELETE FROM patients WHERE dni_patient = '"+patientDni+"' ;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				sixthResultset = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			sixthConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}

		Connection seventhConex = null;
		try {
			while( seventhConex == null)
				seventhConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			ErrorHandler.showError("Error connecting to the database","Database Error");
		}

		ResultSet seventhrest = null;
		try {
			if(seventhConex != null) {
				PreparedStatement st = seventhConex.prepareStatement("DELETE FROM users WHERE dni = '"+patientDni+"' ;", Statement.RETURN_GENERATED_KEYS);
				st.execute();
				seventhrest = st.getResultSet();
			}
		} catch (SQLException e1) {
			ErrorHandler.showError("Query error: " + e1.getMessage(),"Database Error");
		}
		try {
			seventhConex.close();
		} catch (SQLException e) {
			ErrorHandler.showError("Error clossing the conexion to the database","Database Error");
		}



	}

}
