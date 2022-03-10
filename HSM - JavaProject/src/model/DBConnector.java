
package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
	
	private static final String CONNECTOR = "jdbc:mysql://ur25xg6ptzghqury:ftnvW1TJPASvzhr0b75N@brz5mz6k0tlnwem7e62c-mysql.services.clever-cloud.com:3306/brz5mz6k0tlnwem7e62c";
	private static final String USER = "ur25xg6ptzghqury";
	private static final String PASS = "ftnvW1TJPASvzhr0b75N";
	
	public static Connection connectdb() {
		Connection connex = null;
		
		try {
			connex = DriverManager.getConnection(CONNECTOR, USER, PASS);
			System.out.println("Connected to database successfully");
		} catch (SQLException e) {
			System.err.println("[ERROR] Connection failed");
			e.printStackTrace();
		}
		
		return connex;
	}
	/*
	public static void main(String[] args) {
		Connection connex = DBConnector.connectdb();

		// Hacemos una consulta de prueba
		Statement query;
		ResultSet result;		  
		 
		try {
			query = connex.createStatement();
			result = query.executeQuery("SELECT * FROM Doctors");
			
			while (result.next()) {
				System.out.println(String.format("%s %s %s %s %s", 
						result.getString("dni"), 
						result.getString("name"), 
						result.getString("first lastname"), 
						result.getString("second lastname"), 
						result.getString("birthdate")));
			}
			
			// Insertar en la base de datos
			Statement insertar = connex.createStatement();
			insertar.executeUpdate("INSERT INTO brz5mz6k0tlnwem7e62c.Doctors "
							   + "VALUES ('0003C', 'Pablito', 'Regidor', 'Garcia', '2002-12-12');"
					);
			
		} catch (SQLException e) {
			System.err.println("[ERROR] SQL error");
			e.printStackTrace();
		}
	
	}
	*/
}

