package viewer.doctor;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import control.Controller;
import launcher.Main;
import viewer.patient.HistoryTableModel;

@SuppressWarnings("serial")
public class DoctorHistoryPanel extends JPanel{

	Controller ctrl;
	String dni_patient;

	public DoctorHistoryPanel(Controller ctrl, String dni_patient) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;
		initComponents();
	}

	private void initComponents() {
		centerPanel = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();

		setLayout(new java.awt.BorderLayout());

		centerPanel.setLayout(new java.awt.BorderLayout());

		tableModel = new HistoryTableModel(dni_patient, ctrl);
		jTable1 = new javax.swing.JTable(tableModel);
		jScrollPane2.setViewportView(jTable1);

		centerPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);
		centerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK,5), "My History",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

		add(centerPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>


	// Variables declaration - do not modify
	private javax.swing.JPanel centerPanel;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private HistoryTableModel tableModel;
	// End of variables declaration

	public void refreshTable(String dni) {
		try {
			((HistoryTableModel)jTable1.getModel()).open(dni);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(null, e.getMessage());

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();

		}
	}


}
