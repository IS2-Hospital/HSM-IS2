package viewer.admin;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import launcher.Main;
import model.Doctor;

@SuppressWarnings("serial")
public class DoctorTableModel extends AbstractTableModel {

	private Controller ctrl;

	private List<Doctor> doctorList;
	private final String[] COL_NAMES = {"DNI", "LASTNAME", "NAME", "BIRTHDATE", "EMAIL", "PHONE", "SPECIALITY", "SALARY", "CONTRACT START DATE", "CONTRACT END DATE"};


	public DoctorTableModel(Controller ctrl) {
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
		doctorList = ctrl.getDoctorList();
		fireTableDataChanged();
	}

	@Override
	public String getColumnName(int col) {
		return COL_NAMES[col];
	}


	@Override
	public int getRowCount() {
		return doctorList.size();
	}

	@Override
	public int getColumnCount() {
		return COL_NAMES.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return doctorList.get(rowIndex).getDni();
		case 1:
			return doctorList.get(rowIndex).getLastname();
		case 2:
			return doctorList.get(rowIndex).getName();
		case 3:
			return doctorList.get(rowIndex).getBirthdate();
		case 4:
			return doctorList.get(rowIndex).getEmail();
		case 5:
			return doctorList.get(rowIndex).getPhone();
		case 6:
			return doctorList.get(rowIndex).getSpeciality();
		case 7:
			return doctorList.get(rowIndex).getSalary();
		case 8:
			return doctorList.get(rowIndex).getContractStartDate();
		case 9:
			return doctorList.get(rowIndex).getContractEndDate();
		default:
			return null;
		}
	}
}
