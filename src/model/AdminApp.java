package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import model.exceptions.sqlExeptions.SqlConnectionException;

public class AdminApp {

	public ResultSet resultQuery(String SQL) {
		Connection adminConex = null;
		try {
			while( adminConex == null)
				adminConex = DBConnector.connectdb();
		} catch (SqlConnectionException e) {
			JOptionPane.showMessageDialog(null, "Error connecting to the database",
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}

		ResultSet resultSet = null;
		try {
			if(adminConex != null) {
				PreparedStatement st = adminConex.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
				st.execute();
				resultSet = st.getResultSet();
			}
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, "Query error: " + e1.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		return resultSet;
	}

	public List<String> getDoctorDNIList() {
		ResultSet setDNIs = resultQuery("SELECT dni_doctor FROM doctors;");
		List<String> dni = new ArrayList<String>();
		try {
			while(setDNIs.next()) {
				dni.add(setDNIs.getString(1));
			}
			setDNIs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		return dni;
	}

	public List<String> getPatientDNIList() {
		ResultSet setDNIs = resultQuery("SELECT dni_patient FROM patients;");
		List<String> dni = new ArrayList<String>();
		try {
			while(setDNIs.next()) {
				dni.add(setDNIs.getString(1));
			}
			setDNIs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		return dni;
	}

	public List<String> getPatientData(String dni) {
		ResultSet setDNIs = resultQuery("SELECT dni, lastname,name, birthdate, email, phone, gender, blood_type, insurance_type, dni_insurance_taker, bill FROM users JOIN patients ON dni = dni_patient WHERE "+dni+" = dni");
		List<String> dni1 = new ArrayList<String>();
		try {
			setDNIs.first();
			for(int i = 1; i <= 11; i++) {
				dni1.add(setDNIs.getString(i));
			}
			setDNIs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		return dni1;
	}

	public void updatePatient(List<String> colData) throws SQLException {
		Connection con = DBConnector.connectdb();
		String patients;
		if(colData.size() == 12) { //Modificar contraseña
			//TODO Modificar la consulta para que actualica el valor de la contraseña
			// y actualizar el valor de la contraseña en la base de datos
			patients = "UPDATE patients, users SET gender = ? , insurance_type = ? , dni_insurance_taker = ? , blood_type = ? , bill = ?, name = ?, lastname = ?, birthdate = '"+ colData.get(3) +" 00:00:00.000' , email = ?, phone = ? WHERE dni_patient = ? AND dni = dni_patient;";
		}
		else {
			patients = "UPDATE patients, users SET gender = ? , insurance_type = ? , dni_insurance_taker = ? , blood_type = ? , bill = ?, name = ?, lastname = ?, birthdate = '"+ colData.get(3) +" 00:00:00.000' , email = ?, phone = ? WHERE dni_patient = ? AND dni = dni_patient;";
		}
		PreparedStatement st = con.prepareStatement(patients, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, colData.get(6));
		st.setString(2, colData.get(8));
		st.setString(3, colData.get(9));
		st.setString(4, colData.get(7));
		st.setDouble(5, Double.parseDouble(colData.get(10)));
		st.setString(6, colData.get(2));
		st.setString(7, colData.get(1));
		st.setString(8, colData.get(4));
		st.setString(9, colData.get(5));
		st.setString(10, colData.get(0));



		st.execute();
		st.close();
	}

	public List<String> getDoctorData(String dni) {
		ResultSet setDNIs = resultQuery("SELECT dni, lastname,name, birthdate, email, phone, speciality, salary, contract_start_date, contract_end_date FROM users JOIN doctors ON dni = dni_doctor WHERE "+dni+" = dni");
		List<String> dni1 = new ArrayList<String>();
		try {
			setDNIs.first();
			for(int i = 1; i <= 10; i++) {
				dni1.add(setDNIs.getString(i));
			}
			setDNIs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		return dni1;
	}

	public void updateDoctor(List<String> colData) throws SQLException {
		Connection con = DBConnector.connectdb();

		String patients = "UPDATE doctors, users SET speciality = ? , salary = ? , contract_start_date = '"+ colData.get(8)+ " 00:00:00.000', contract_end_date = '"+ colData.get(9)+ " 00:00:00.000', name = ?, lastname = ?, birthdate = '"+ colData.get(3) +" 00:00:00.000' , email = ?, phone = ? WHERE dni_doctor = ? AND dni = dni_doctor;";
		PreparedStatement st = con.prepareStatement(patients, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, colData.get(6));
		st.setString(2, colData.get(7));
		st.setString(3, colData.get(2));
		st.setString(4, colData.get(1));
		st.setString(5, colData.get(4));
		st.setString(6, colData.get(5));
		st.setString(7, colData.get(0));

		st.execute();
		st.close();
		con.close();
	}

	public List<String> getRequestIDList() {
		ResultSet setIDs = resultQuery("SELECT id FROM doctor_change_request");
		List<String> ids = new ArrayList<String>();
		try {
			while(setIDs.next()) {
				ids.add(setIDs.getString(1));
			}
			setIDs.close();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Database Error", JOptionPane.ERROR_MESSAGE);
		}
		return ids;
	}

	public String getUserFullName(String dni) throws SQLException {
		ResultSet setFullName = resultQuery("SELECT name, lastname FROM users WHERE dni = '"+dni+"';");
		ArrayList<String> fullName = new ArrayList<String>();
		setFullName.first();
		fullName.add(setFullName.getString(0));
		fullName.add(setFullName.getString(1));
		setFullName.close();
		return (fullName.get(0) + " " + fullName.get(1));
	}

	public List<String> getDNIFromRequest(String string) throws SQLException {
		ResultSet setDNIs = resultQuery("SELECT dni_patient, treated_by.dni_doctor, doctor_change_request.dni_doctor FROM doctor_change_request JOIN treated_by ON treated_by.dni_patient = doctor_change_request.dni_patient WHERE id = '" + string + "';");
		ArrayList<String> dni = new ArrayList<String>();
		setDNIs.first();
		try {
			dni.add(setDNIs.getString(1));
		}
		catch(SQLException e) {
			dni.add("");
		}
		try {
			dni.add(setDNIs.getString(2));
		}
		catch(SQLException e) {
			dni.add("");
		}
		try {
			dni.add(setDNIs.getString(3));
		}
		catch(SQLException e) {
			dni.add("");
		}
		setDNIs.close();
		return dni;
	}

	public String getReason(String id) throws SQLException {
		ResultSet reason = resultQuery("SELECT reason FROM doctor_change_request WHERE id = '"+ id +"';");
		String reas = reason.getString(1);
		reason.close();
		return reas;
	}

	public void aproveChange(String id) throws SQLException {
		List<String> dni = getDNIFromRequest(id);
		ResultSet devuelto = resultQuery("DELETE FROM doctor_change_request WHERE id = '"+ id +"' ;");
		ResultSet insertar = resultQuery("INSERT INTO treated_by VALUES ( '"+ dni.get(0)+"' , '" +dni.get(2) + "');");
	}

}
