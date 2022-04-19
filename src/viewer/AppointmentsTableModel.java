package viewer;

import java.sql.Array;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import model.DBConnector;

public class AppointmentsTableModel extends AbstractTableModel {
	private String dni;
	private final String[] colNames = {"DAY", "HOUR", "DOCTOR"};
	private List<String> date;
	private List<String> hour;
	private List<String> doctor;


	public AppointmentsTableModel(String dni) {
		this.dni =  dni;
		try {
			initGUI();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	private void initGUI() throws Exception {
		Connection con = DBConnector.connectdb();
		String SQL = "SELECT day, hour, name || ' ' || lastname AS doctor FROM appointments join users WHERE dni = dni order by day";

		Statement st = con.createStatement();

		ResultSet resultSet = st.executeQuery(SQL);

		if (resultSet == null)
			throw new Exception("You don't have appointments");

		Array c1 = resultSet.getArray("day");
		Array c2 = resultSet.getArray("hour");
		Array c3 = resultSet.getArray("doctor");

		date = (List<String>) c1.getArray();
		hour = (List<String>) c2.getArray();
		doctor = (List<String>) c3.getArray();


	}
	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return date.size();
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
			obj = date.get(rowIndex);
			break;
		case 1:
			obj = hour.get(rowIndex);
			break;
		case 2:
			obj = doctor.get(rowIndex);
		default:
			break;
		}
		return obj;
	}

}
