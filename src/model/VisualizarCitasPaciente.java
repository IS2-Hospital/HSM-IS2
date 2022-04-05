package model;

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
		String SQL = "SELECT date, hour, name, lastname FROM appointments join users WHERE dni = dni";

		Statement st = con.createStatement();

		ResultSet resultSet = st.executeQuery(SQL);



	}



}
