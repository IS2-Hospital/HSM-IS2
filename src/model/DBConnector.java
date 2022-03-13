package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnector {

	private static final String HOST = "brz5mz6k0tlnwem7e62c-mysql.services.clever-cloud.com";
	private static final int 	PORT = 3306;
	private static final String DB_NAME = "brz5mz6k0tlnwem7e62c";
	private static final String URL = String.format("jdbc:mysql://%s:%d/%s?useSSL=false", HOST, PORT, DB_NAME);

	private static final String USER = "ur25xg6ptzghqury";
	private static final String PASS = "ftnvW1TJPASvzhr0b75N";

	public static Connection connectdb() throws SQLException {

		try {
			Connection connex = DriverManager.getConnection(URL, USER, PASS);
			return connex;
		} catch (SQLException e) {
			throw new SQLException("[ERROR] Connection failed");
		}
	}
}

