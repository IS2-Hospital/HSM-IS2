package viewer.patient;

import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import launcher.Main;
import model.Treatment;

public class TreatmentsTableModel extends AbstractTableModel {

	private Controller ctrl;
	private String dni;

	private Vector<Treatment> v;
	private final String[] colNames = {"NAME", "DESCRIPTION", "START", "END"};


	public TreatmentsTableModel(String dni, Controller ctrl) {
		this.dni = dni;
		this.ctrl = ctrl;
		try {
			open();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		}
	}



	void open() throws Exception {
		v = ctrl.getTreatment(dni);
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
		switch(columnIndex) {
		case 0:
			return v.get(rowIndex).getName();
		case 1:
			return v.get(rowIndex).getDescription();
		case 2:
			return v.get(rowIndex).getStartDate();
		case 3:
			return v.get(rowIndex).getEndDate();
		default:
			return null;
		}
	}

}
