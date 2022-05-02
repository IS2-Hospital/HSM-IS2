package viewer.patient;

import java.awt.Color;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;

@SuppressWarnings("serial")
public class HistoryPanel extends JPanel{

	private static HistoryPanel instance = null;

	Controller ctrl;
	String dni_patient;

	private HistoryPanel(Controller ctrl, String dni_patient) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;
		initComponents();
	}

	// Singleton
	public static HistoryPanel getInstance(Controller ctrl, String dni_patient) {
		if (instance == null)
			instance = new HistoryPanel(ctrl, dni_patient);
		instance.open();

		return instance;
	}

	private void open() {
		try {
			tableModel.open();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		}
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


}
