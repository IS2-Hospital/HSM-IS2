package viewer;

import java.util.Arrays;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Appointment;
import model.Enums.UserRole;

@SuppressWarnings("serial")
public class AppointmentsTableModel extends AbstractTableModel {

	private String dni;
	private Controller ctrl;
	private UserRole role;

	private String[] colNames;
	private final String [] colDocNames = {"DAY", "HOUR", "PATIENT", "DESCRIPTION"};
	private final String [] colPatNames = {"DAY", "HOUR", "DOCTOR", "DESCRIPTION"};

	private Vector<Appointment> v;

	public AppointmentsTableModel(String dni, Controller ctrl, UserRole role) {
		this.dni = dni;
		this.ctrl = ctrl;
		this.role = role;
		initColNames();
	}

	private void initColNames() {
		if(role == UserRole.PATIENT) {
			colNames = Arrays.copyOf(colPatNames, colDocNames.length);
		}
		else if(role == UserRole.DOCTOR) {
			colNames = Arrays.copyOf(colDocNames, colDocNames.length);
		}
	}

	public void open() throws Exception {
		v = ctrl.getAppointments(dni, role);
		fireTableDataChanged();
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
		switch(columnIndex){
		case 0:
			return v.get(rowIndex).getDay();
		case 1:
			return v.get(rowIndex).getHour();
		case 2:
			return v.get(rowIndex).getPerson();
		case 3:
			return v.get(rowIndex).getDescription();
		default:
			return null;
		}
	}

	public Vector<Appointment> getAppointments() {
		return v;
	}
	public Appointment getAppointment(int rowIndex) {
		return v.get(rowIndex);
	}

}
