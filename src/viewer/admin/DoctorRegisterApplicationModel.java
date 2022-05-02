package viewer.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.DoctorRegisterApplication;

public class DoctorRegisterApplicationModel extends AbstractTableModel {
	private final String[] COL_NAMES = {"DOCTOR", "SPECIALITY", "SALARY", "START CONTRACT", "END CONTRACT", "NOTES"};
	private List<DoctorRegisterApplication> requests;

	private Controller ctrl;

	public DoctorRegisterApplicationModel(Controller ctrl) {
		this.ctrl = ctrl;
	}

	public void open() throws SQLException {
		requests = ctrl.getDoctorRegisterApplication();
		fireTableDataChanged();
	}

	public DoctorRegisterApplication getRequest(int i) {
		return requests.get(i);
	}

	@Override
	public int getRowCount() {
		return requests.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return requests.get(rowIndex).getDoctor().getDni();
		case 1:
			return requests.get(rowIndex).getDoctor().getSpeciality();
		case 2:
			return requests.get(rowIndex).getDoctor().getSalary();
		case 3:
			return requests.get(rowIndex).getDoctor().getContractStartDate();
		case 4:
			return requests.get(rowIndex).getDoctor().getContractEndDate();
		case 5:
			return requests.get(rowIndex).getDoctor().getNotes();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int column) {
		return COL_NAMES[column];
	}
}
