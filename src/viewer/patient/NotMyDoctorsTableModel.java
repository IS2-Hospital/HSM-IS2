package viewer.patient;

import java.sql.SQLException;
import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Doctor;

@SuppressWarnings("serial")
public class NotMyDoctorsTableModel extends AbstractTableModel {

	private Controller ctrl;
	private String dni_patient;

	private static final String[] COL_NAMES = {"NAME", "LASTNAME", "SPECIALITY"};
	private List<Doctor> notMyDoctors;

	public NotMyDoctorsTableModel(Controller ctrl, String dni_patient) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;
		this.notMyDoctors = new Vector<>();
	}

	public void open() throws SQLException {
		notMyDoctors = ctrl.getNotDoctorsOf(dni_patient);
		fireTableDataChanged();
	}

	public Doctor getDoctor(int i) {
		return notMyDoctors.get(i);
	}

	@Override
	public int getRowCount() {
		return notMyDoctors.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return notMyDoctors.get(rowIndex).getName();
		case 1:
			return notMyDoctors.get(rowIndex).getLastname();
		case 2:
			return notMyDoctors.get(rowIndex).getSpeciality();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}

}
