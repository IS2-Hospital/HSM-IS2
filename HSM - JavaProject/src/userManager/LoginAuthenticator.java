package userManager;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.UserRole;
import model.exceptions.InvalidPasswordException;
import model.exceptions.UserNotFoundException;

public class LoginAuthenticator {

	public UserRole authenticateUser(LoginData loginData) throws SQLException, UserNotFoundException, InvalidPasswordException {
	    String userDNI = loginData.getDNI();
	    String password = loginData.getPassword();
	 
	    Connection con = null;
	    Statement statement = null;
	    ResultSet resultSet = null;
	    	 	 
	    try {
	        con = DBConnector.connectdb();
	        statement = con.createStatement();
	        
	        resultSet = statement.executeQuery("select dni,password,role from users where dni = " + userDNI);
	   
	        // In case query is empty
	        if(!resultSet.next()) throw new UserNotFoundException();
	        	        
            // In case password is invalid
            if(!password.equals(resultSet.getString("password"))) 
            	throw new InvalidPasswordException();
            
            return UserRole.valueOf(resultSet.getString("role"));
	    }
	    
	    catch(SQLException e) {
	        e.printStackTrace();
	        throw e;
	    }
	}
}
