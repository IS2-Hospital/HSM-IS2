package viewer.admin;

import java.awt.Color;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;

@SuppressWarnings("serial")
public class DoctorListPanel extends JPanel{

	private static DoctorListPanel instance = null;

	Controller ctrl;

	private DoctorListPanel(Controller ctrl) {
		this.ctrl = ctrl;
		initComponents();
	}

	public static DoctorListPanel getInstace(Controller ctrl) {
		if (instance == null)
			instance = new DoctorListPanel(ctrl);
		instance.open();

		return instance;
	}

	private void open() {
		try {
			tableModel.open();
		} catch (Exception e) {
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

		tableModel = new DoctorTableModel(ctrl);
		jTable1 = new javax.swing.JTable(tableModel);
		jScrollPane2.setViewportView(jTable1);

		centerPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);
		centerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK,5), "Doctors",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

		add(centerPanel, java.awt.BorderLayout.CENTER);
	}// </editor-fold>


	// Variables declaration - do not modify
	private javax.swing.JPanel centerPanel;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private DoctorTableModel tableModel;
	// End of variables declaration


}
