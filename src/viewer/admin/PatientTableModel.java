package viewer.admin;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

import control.Controller;
import launcher.Main;
import model.Patient;

@SuppressWarnings("serial")
public class PatientTableModel extends AbstractTableModel{

	private final String[] colNames = {"DNI", "LASTNAME", "NAME", "BIRTHDATE", "EMAIL", "PHONE", "BLOOD TYPE", "GENDER", "INSURANCE TYPE", "INSURANCE TAKER", "BILL"};
	private Controller ctrl;
	private List<Patient> patients;

	public PatientTableModel(Controller ctrl) {
		this.ctrl = ctrl;
		try {
			open();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage());
			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		}
	}

	@Override
	public String getColumnName(int col) {
		return colNames[col];
	}

	@Override
	public int getRowCount() {
		return patients.size();
	}

	@Override
	public int getColumnCount() {
		return colNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		switch(columnIndex) {
		case 0:
			return patients.get(rowIndex).getDni();
		case 1:
			return patients.get(rowIndex).getLastname();
		case 2:
			return patients.get(rowIndex).getName();
		case 3:
			return patients.get(rowIndex).getBirthdate();
		case 4:
			return patients.get(rowIndex).getEmail();
		case 5:
			return patients.get(rowIndex).getPhone();
		case 6:
			return patients.get(rowIndex).getBloodType();
		case 7:
			return patients.get(rowIndex).getGender();
		case 8:
			return patients.get(rowIndex).getInsuranceType().toString();
		case 9:
			return patients.get(rowIndex).getDniInsuranceTaker();
		case 10:
			return (double) patients.get(rowIndex).getBill();
		default:
			return null;
		}
	}

	public void open() {
		patients = ctrl.getAllPatients();
		fireTableDataChanged();
	}
}
