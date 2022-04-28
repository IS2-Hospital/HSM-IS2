package model.patientDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Vector;

import model.DBConnector;
import model.Treatment;

public class GetTreatmentsDAO {
	public static Vector<Treatment> execute(String dni_patient) throws SQLException{

		Calendar c = new GregorianCalendar();

		String dia = Integer.toString(c.get(Calendar.DATE));
		if(Integer.valueOf(dia) < 10) { dia = '0' + dia; }
		String mes = Integer.toString(c.get(Calendar.MONTH));
		if(Integer.valueOf(mes) < 10) { mes = '0' + mes; }
		String anio = Integer.toString(c.get(Calendar.YEAR));

		String hoy = anio +'-' + mes + '-' + dia;

		Connection con = DBConnector.connectdb();

		String SQL = "SELECT * "
				+ "FROM treatments "
				+ "join recieves_treatment using(id_treatment) "
				+ "WHERE dni_patient = " + dni_patient
				+ " ORDER BY start_date, end_date, name;";

		Statement st = con.createStatement();
		ResultSet resultSet = st.executeQuery(SQL);

		Vector<Treatment> v = new Vector<>(); // DTO
		while(resultSet.next()) {
			String start_date = resultSet.getString("start_date");
			String end_date = resultSet.getString("end_date");
			String name = resultSet.getString("name");
			String description = resultSet.getString("description");
			if(compareDates(hoy, end_date)) {
				Treatment tr = new Treatment(-1, name, description, start_date, end_date);
				v.add(tr);
			}
		}

		resultSet.close();
		st.close();
		con.close();

		return v;
	}

	private static boolean compareDates(String hoy, String end_date) {
		int hoyAux, end_dateAux;

		hoyAux = (hoy.charAt(0) - 48) * 1000 + (hoy.charAt(1) - 48) * 100 + (hoy.charAt(2) - 48) * 10 + (hoy.charAt(3) - 48);
		end_dateAux = (end_date.charAt(0) - 48) * 1000 + (end_date.charAt(1) - 48) * 100 + (end_date.charAt(2) - 48) * 10 + (end_date.charAt(3) - 48);
		//Comparar año
		if(hoyAux < end_dateAux) { return true; }
		else if(hoyAux > end_dateAux) { return false; }

		hoyAux = (hoy.charAt(5) - 48) * 10 + (hoy.charAt(6) - 48);
		end_dateAux = (end_date.charAt(5) - 48) * 10 + (end_date.charAt(6) - 48);
		//Comparar mes
		if(hoyAux < end_dateAux) { return true; }
		else if(hoyAux > end_dateAux) { return false; }

		hoyAux = (hoy.charAt(8) - 48) * 10 + (hoy.charAt(9) - 48);
		end_dateAux = (end_date.charAt(8) - 48) * 10 + (end_date.charAt(9) - 48);
		//Comparar dia
		if(hoyAux < end_dateAux) { return true; }
		else if(hoyAux > end_dateAux) { return false; }

		return false;
	}

}
