package viewer.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.swing.table.AbstractTableModel;

public class DoctorListTableModel extends AbstractTableModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String[] colNames = {"dni", "lastname","name", "birthdate", "email", "phone", "speciality","salary","Contract Start Date", "Contract End Date" };

	private List<List<String>> array;

	public DoctorListTableModel(ResultSet resultSet) throws Exception {

		if (resultSet == null)
			throw new Exception("There are no doctors in the system");

		array = new ArrayList<List<String>>();
		while(resultSet.next()) {
			List<String> aux = new ArrayList<String>();
			for (int j = 1; j <= colNames.length; j++) {
				aux.add(resultSet.getString(j));
			}
			array.add(aux);
		}

		resultSet.close();
	}

	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return array.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		return array.get(rowIndex).get(columnIndex);
	}

}
