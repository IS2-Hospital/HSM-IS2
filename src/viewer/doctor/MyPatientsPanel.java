/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewer.doctor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import control.Controller;
import model.Patient;

/**
 *
 * @author reven
 */
@SuppressWarnings("serial")
public class MyPatientsPanel extends javax.swing.JPanel {

	private Controller ctrl;
	private String doctor_dni;

	private MyPatientsTableModel tableModel;

	/**
	 * Creates new form MyPatientsPanel
	 */
	public MyPatientsPanel(Controller ctrl, String doctor_dni) {
		this.ctrl = ctrl;
		this.doctor_dni = doctor_dni;
		this.tableModel = new MyPatientsTableModel(ctrl, doctor_dni);

		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		topPanel = new javax.swing.JPanel();
		titleLabel = new javax.swing.JLabel();
		patientsTableScroll = new javax.swing.JScrollPane();
		patientsTable = new javax.swing.JTable(tableModel);
		bottomPanel = new javax.swing.JPanel();
		viewMedicHistoryButton = new misc.RSButtonMetro();

		setLayout(new java.awt.BorderLayout());

		titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		titleLabel.setForeground(new java.awt.Color(51, 51, 51));
		titleLabel.setText("My Patients");
		topPanel.add(titleLabel);

		add(topPanel, java.awt.BorderLayout.PAGE_START);

		patientsTableScroll.setViewportView(patientsTable);
		add(patientsTableScroll, java.awt.BorderLayout.CENTER);

		viewMedicHistoryButton.setText("View medic history");
		viewMedicHistoryButton.setColorHover(new java.awt.Color(138, 202, 234));
		viewMedicHistoryButton.setColorNormal(new java.awt.Color(8, 72, 135));
		viewMedicHistoryButton.setColorPressed(new java.awt.Color(8, 72, 135));
		viewMedicHistoryButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		viewMedicHistoryButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				viewMedicHistoryButtonActionPerformed(e);
			}
		});
		bottomPanel.add(viewMedicHistoryButton);

		add(bottomPanel, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>

	private void viewMedicHistoryButtonActionPerformed(ActionEvent e) {
		Patient p = tableModel.getSelectedPatient(patientsTable.getSelectedRow());
		// TODO panel del historial medico de un paciente p
	}

	// Variables declaration - do not modify
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JTable patientsTable;
	private javax.swing.JScrollPane patientsTableScroll;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JPanel topPanel;
	private misc.RSButtonMetro viewMedicHistoryButton;
	// End of variables declaration

	public void open() {
		tableModel.open();
	}
}
