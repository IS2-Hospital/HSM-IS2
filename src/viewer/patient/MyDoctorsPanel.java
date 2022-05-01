/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewer.patient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;
import model.Doctor;

/**
 *
 * @author reven
 */
public class MyDoctorsPanel extends javax.swing.JPanel {

	private Controller ctrl;
	private String dni_patient;

	private MyDoctorsTableModel doctorsTableModel;

	/**
	 * Creates new form MyDoctorsPanel
	 */
	public MyDoctorsPanel(Controller ctrl, String dni_patient) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;

		initComponents();
	}

	public void open() {
		try {
			doctorsTableModel.open();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		jPanel1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		jPanel2 = new javax.swing.JPanel();
		requestButton = new misc.RSButtonMetro();
		jScrollPane1 = new javax.swing.JScrollPane();
		doctorsTable = new javax.swing.JTable();

		doctorsTableModel = new MyDoctorsTableModel(ctrl, dni_patient);

		setLayout(new java.awt.BorderLayout());
		setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jLabel1.setText("My doctors");
		jPanel1.add(jLabel1);

		add(jPanel1, java.awt.BorderLayout.PAGE_START);

		requestButton.setText("Request doctor change");
		requestButton.setColorHover(new java.awt.Color(138, 202, 234));
		requestButton.setColorNormal(new java.awt.Color(8, 72, 135));
		requestButton.setColorPressed(new java.awt.Color(8, 72, 135));
		requestButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		requestButton.setPreferredSize(new java.awt.Dimension(200, 35));
		requestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				requestButtonactionPerformed(e);
			}
		});

		jPanel2.add(requestButton);

		add(jPanel2, java.awt.BorderLayout.PAGE_END);

		doctorsTable.setModel(doctorsTableModel);
		jScrollPane1.setViewportView(doctorsTable);

		add(jScrollPane1, java.awt.BorderLayout.CENTER);
	}// </editor-fold>

	private void requestButtonactionPerformed(ActionEvent e) {
		try {
			int row = doctorsTable.getSelectedRow();
			Doctor d = doctorsTableModel.getDoctor(row);

			DoctorChangeDialog dcd = new DoctorChangeDialog(ctrl, dni_patient, d.getDni(), this);

		} catch (ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(MyDoctorsPanel.this), "You have to select a doctor first", "", JOptionPane.ERROR_MESSAGE);
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JLabel jLabel1;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JTable doctorsTable;
	private misc.RSButtonMetro requestButton;
	// End of variables declaration
}

