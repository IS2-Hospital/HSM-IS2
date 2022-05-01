package viewer.patient;

import java.sql.SQLException;
import java.util.List;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Doctor;

@SuppressWarnings("serial")
public class MyDoctorsTableModel extends AbstractTableModel {

	private Controller ctrl;
	private String dni_patient;

	private static final String[] COL_NAMES = {"NAME", "LASTNAME", "SPECIALITY"};
	private List<Doctor> doctors;

	public MyDoctorsTableModel(Controller ctrl, String dni_patient) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;
	}

	public void open() throws SQLException {
		doctors = ctrl.getDoctorsOf(dni_patient);
		fireTableDataChanged();
	}

	public Doctor getDoctor(int i) {
		return doctors.get(i);
	}

	@Override
	public int getRowCount() {
		return doctors.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return doctors.get(rowIndex).getName();
		case 1:
			return doctors.get(rowIndex).getLastname();
		case 2:
			return doctors.get(rowIndex).getSpeciality();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}

}
