package viewer.doctor;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;

import control.Controller;
import viewer.patient.TreatmentsTableModel;

public class DoctorTreatmentWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static DoctorTreatmentWindow instance = null;
	private TreatmentsTableModel tableModel;
	private Controller ctrl;
	private DoctorHistoryPanel table;
	private String dni;

	public DoctorTreatmentWindow(Controller ctrl, String dni) {
		this.ctrl = ctrl;
		this.dni = dni;
		initComponents();
	}

	//Singleton
	public static DoctorTreatmentWindow getInstance(Controller ctrl, String dni) {
		if (instance == null)
			instance = new DoctorTreatmentWindow(ctrl, dni);
		else
			instance.refreshTable(dni);
		return instance;
	}

	private void refreshTable(String dni) {
		this.dni = dni;
		table.refreshTable(dni);;
		this.repaint();
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		table = new DoctorHistoryPanel(ctrl, dni);
		this.add(table, BorderLayout.CENTER);
		this.setLocationRelativeTo(null);
		this.setMinimumSize(new Dimension(500, 400));
		this.setPreferredSize(new Dimension(600, 500));
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);
	}

}
