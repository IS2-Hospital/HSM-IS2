package viewer.doctor;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Patient;

@SuppressWarnings("serial")
public class MyPatientsTableModel extends AbstractTableModel {

	private String doctor_dni;
	private Controller ctrl;

	private static final String[] COL_NAMES = {"DNI", "Name", "Lastname", "Gender", "Blood type", "Email", "Phone"};
	private List<Patient> patients;

	public MyPatientsTableModel(Controller ctrl, String doctor_dni) {
		this.ctrl = ctrl;
		this.doctor_dni = doctor_dni;
	}

	public void open() {
		patients = ctrl.getPatientsOfDoctor(doctor_dni);
		fireTableDataChanged();
	}

	public Patient getSelectedPatient(int index) {
		return patients.get(index);
	}

	@Override
	public int getRowCount() {
		return patients.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			return patients.get(rowIndex).getDni();
		case 1:
			return patients.get(rowIndex).getName();
		case 2:
			return patients.get(rowIndex).getLastname();
		case 3:
			return patients.get(rowIndex).getGender().toString();
		case 4:
			return patients.get(rowIndex).getBloodType().toString();
		case 5:
			return patients.get(rowIndex).getEmail();
		case 6:
			return patients.get(rowIndex).getPhone();
		default:
			return "";
		}
	}

	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}



}
