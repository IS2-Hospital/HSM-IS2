package model.userManagment;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.Enums.UserRole;
import model.exceptions.InvalidPasswordException;
import model.exceptions.LoginException;
import model.exceptions.UserNotFoundException;

public class LoginAuthenticator {

	public UserRole login(String dni, String pass) throws SQLException, LoginException{
		return LoginAuthenticator.authenticateUser(dni, pass);
	}

	private static UserRole authenticateUser(String dni, String pass) throws SQLException, LoginException {


		Connection con = DBConnector.connectdb();
		Statement statement = con.createStatement();

		ResultSet resultSet = statement.executeQuery(String.format("select password, role from users where dni = '%s'", dni));

		// In case query is empty, user doesn't exists
		if (!resultSet.next()) {
			con.close();
			throw new UserNotFoundException();
		}

		// In case password is invalid
		if (!pass.equals(resultSet.getString("password"))) {
			con.close();
			throw new InvalidPasswordException();
		}

		String role = resultSet.getString("role");
		con.close();
		return UserRole.valueOf(role);
	}
}
