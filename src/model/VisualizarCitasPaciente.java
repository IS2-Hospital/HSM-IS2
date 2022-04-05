package model;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class VisualizarCitasPaciente {
	String dni;
	public VisualizarCitasPaciente(String dni) {
		this.dni =  dni;
	}

	private void visualizar() throws SQLException {
		Connection con = DBConnector.connectdb();
		String SQL = "SELECT date, hour, name || ' ' || lastname AS doctor FROM appointments join users WHERE dni = dni order by date";

		Statement st = con.createStatement();

		ResultSet resultSet = st.executeQuery(SQL);

		if (!resultSet.next()) {
			// Lista vacia, informamos al usuario de ello
		}
		else {
			Array c1 = resultSet.getArray("date");
			Array c2 = resultSet.getArray("hour");
			Array c3 = resultSet.getArray("doctor");

		}



	}



}
