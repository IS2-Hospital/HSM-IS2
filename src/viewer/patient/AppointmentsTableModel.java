package viewer.patient;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import model.Appointment;

public class AppointmentsTableModel extends AbstractTableModel {

	private String dni;
	private Controller ctrl;

	private final String[] colNames = {"DAY", "HOUR", "DOCTOR", "DESCRIPTION"};
	private Vector<Appointment> v;


	public AppointmentsTableModel(String dni, Controller ctrl) {
		this.dni = dni;
		this.ctrl = ctrl;
		try {
			open();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			e.printStackTrace();
		}
	}

	public void open() throws Exception {
		v = ctrl.getAppointments(dni);
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
			return v.get(rowIndex).getDoctor();
		case 3:
			return v.get(rowIndex).getDescription();
		default:
			return null;
		}
	}

}
