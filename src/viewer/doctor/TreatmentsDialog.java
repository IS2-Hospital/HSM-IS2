package viewer.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;
import model.Treatment;
import viewer.patient.TreatmentsTableModel;

@SuppressWarnings("serial")
public class TreatmentsDialog extends JDialog {

	private Controller ctrl;
	private String dni_patient;

	public TreatmentsDialog(Controller ctrl, String dni_patient, Window parent) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;

		initComponents();
		open();

		setLocationRelativeTo(parent);
		setVisible(true);
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
		bottomPanel = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTable1 = new javax.swing.JTable();
		deleteButon = new misc.RSButtonMetro();

		setLayout(new java.awt.BorderLayout());
		setMinimumSize(new Dimension(800, 500));

		centerPanel.setLayout(new java.awt.BorderLayout());

		tableModel = new TreatmentsTableModel(dni_patient, ctrl);
		jTable1 = new javax.swing.JTable(tableModel);
		jScrollPane2.setViewportView(jTable1);

		centerPanel.add(jScrollPane2, java.awt.BorderLayout.CENTER);
		centerPanel.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.BLACK,5), "My Treatments",
				javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP));

		add(centerPanel, java.awt.BorderLayout.CENTER);

		deleteButon.setText("Delete treatment");
		deleteButon.setColorHover(new java.awt.Color(138, 202, 234));
		deleteButon.setColorNormal(new java.awt.Color(8, 72, 135));
		deleteButon.setColorPressed(new java.awt.Color(8, 72, 135));
		deleteButon.setColorTextHover(new java.awt.Color(51, 51, 51));
		deleteButon.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				deleteButonActionPerformed(e);
			}
		});

		bottomPanel.add(deleteButon);

		add(bottomPanel, BorderLayout.SOUTH);

	}

	protected void deleteButonActionPerformed(ActionEvent e) {
		try {
			Treatment t = tableModel.getTreatment(jTable1.getSelectedRow());
			ctrl.deleteTreatment(t, dni_patient);

			tableModel.open();

			JOptionPane.showMessageDialog(this, "The treatment has been deleted sucessfully", "", JOptionPane.INFORMATION_MESSAGE);

		} catch (ArrayIndexOutOfBoundsException e2) {
			JOptionPane.showMessageDialog(this, "You have to select a treatment", "", JOptionPane.ERROR_MESSAGE);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Database error", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e1.printStackTrace();
		}
	}

	private javax.swing.JPanel centerPanel;
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTable jTable1;
	private TreatmentsTableModel tableModel;
	private misc.RSButtonMetro deleteButon;
}
