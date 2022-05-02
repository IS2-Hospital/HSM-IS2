package viewer.admin;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.DoctorChangeRequest;

@SuppressWarnings("serial")
public class DoctorChangeRequestTableModel extends AbstractTableModel {

	private final String[] COL_NAMES = {"PATIENT", "FROM DOCTOR", "SPECIALITY", "TO DOCTOR", "SPECIALITY"};
	private List<DoctorChangeRequest> requests;

	private Controller ctrl;

	public DoctorChangeRequestTableModel(Controller ctrl) {
		this.ctrl = ctrl;
	}

	public void open() throws SQLException {
		requests = ctrl.getDoctorChangeRequests();
		fireTableDataChanged();
	}

	public DoctorChangeRequest getRequest(int i) {
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
			return requests.get(rowIndex).getPatient().getDni();
		case 1:
			return requests.get(rowIndex).getFromDoctor().getDni();
		case 2:
			return requests.get(rowIndex).getFromDoctor().getSpeciality();
		case 3:
			return requests.get(rowIndex).getToDoctor().getDni();
		case 4:
			return requests.get(rowIndex).getToDoctor().getSpeciality();
		case 5:
			return requests.get(rowIndex).getReason();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int column) {
		return COL_NAMES[column];
	}

}
