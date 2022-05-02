package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.exceptions.jdbc4.MySQLIntegrityConstraintViolationException;

import model.DBConnector;

public class InsertRelationPatientDoctorDAO {

	public static void execute( String dniDoc, String dniPat) throws SQLException, IllegalArgumentException{

		try {
			Connection adminConex = DBConnector.connectdb();
			PreparedStatement st =  adminConex.prepareStatement("INSERT INTO treated_by VALUES ( '"+ dniPat +"' , '" + dniDoc + "');", Statement.RETURN_GENERATED_KEYS);
			st.execute();
			adminConex.close();
		} catch (MySQLIntegrityConstraintViolationException e) {
			throw new IllegalArgumentException("This patient is already treated by this doctor");
		}
	}

}
