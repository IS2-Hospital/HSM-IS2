package viewer.patient;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import launcher.Main;
import model.History;

public class HistoryTableModel extends AbstractTableModel{


	private Controller ctrl;
	private String dni;

	private Vector<History> v;
	private final String[] colNames = {"NAME", "START", "END", "DESCRIPTION" };


	public HistoryTableModel(String dni, Controller ctrl) {
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



	void open() throws SQLException {
		v = ctrl.getHistory(dni);
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
			return v.get(rowIndex).getStart_date();
		case 2:
			return v.get(rowIndex).getEnd_date();
		case 3:
			return v.get(rowIndex).getDescription();
		default:
			return null;
		}
	}
}
