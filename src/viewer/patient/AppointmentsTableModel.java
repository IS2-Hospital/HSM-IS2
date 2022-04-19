package viewer.patient;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.Appointment;
import model.DBConnector;

public class AppointmentsTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	private String dni;
	private final String[] colNames = {"DATE", "HOUR", "DOCTOR"};
	private Vector<Appointment> v;


	public AppointmentsTableModel(String dni) {
		this.dni =  dni;
		try {
			initGUI();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	@SuppressWarnings("unchecked")
	private void initGUI() throws Exception {
		Connection con = DBConnector.connectdb();
		String SQL = "SELECT a.day, a.hour, u.name, u.lastname "
				+ "FROM appointments a "
				+ "join users u on a.dni_doctor = u.dni "
				+ "WHERE a.dni_patient =" +  dni;
		//+ " order by a.fecha;"; // XXX Cuando funcione el date

		Statement st = con.createStatement();

		ResultSet resultSet = st.executeQuery(SQL);

		if (resultSet == null)
			throw new Exception("You don´t have appointments");

		v = new Vector<>();
		while(resultSet.next()) {
			String date = resultSet.getString("day");
			String hour = resultSet.getString("hour");
			String name = resultSet.getString("name");
			String lastName = resultSet.getString("lastname");
			String doctor = name + " " + lastName;
			Appointment ap = new Appointment(date, hour, doctor,0, null);
			v.add(ap);
		}
		resultSet.close();
		st.close();
	}
	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return v.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Object obj = null;
		switch(columnIndex){
		case 0:
			obj = v.get(rowIndex).getDate();
			break;
		case 1:
			obj = v.get(rowIndex).getHour();
			break;
		case 2:
			obj = v.get(rowIndex).getDoctor();
			break;
		default:
			break;
		}
		return obj;
	}

}
