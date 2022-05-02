/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package viewer.patient;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;
import model.Doctor;
import model.DoctorChangeRequest;
import model.Patient;

/**
 *
 * @author reven
 */
@SuppressWarnings("serial")
public class DoctorChangeDialog extends javax.swing.JDialog {

	private Controller ctrl;
	private String dni_patient;
	private String fromDni_doctor;

	private NotMyDoctorsTableModel notMyDoctorsTableModel;

	/**
	 * Creates new form doctorChangeDialog
	 */
	public DoctorChangeDialog(Controller ctrl, String dni_patient, String dni_doctor, JComponent parent) {
		this.ctrl = ctrl;
		this.dni_patient = dni_patient;
		this.fromDni_doctor = dni_doctor;

		initComponents();
		open();

		setVisible(true);
		setLocationRelativeTo(SwingUtilities.getWindowAncestor(parent));
	}

	public void open() {
		try {
			notMyDoctorsTableModel.open();
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

		topPanel = new javax.swing.JPanel();
		titleLabel = new javax.swing.JLabel();
		botomPanel = new javax.swing.JPanel();
		cancelButton = new misc.RSButtonMetro();
		requestButton = new misc.RSButtonMetro();
		centerScroll = new javax.swing.JScrollPane();
		centerPanel = new javax.swing.JPanel();
		jPanel2 = new javax.swing.JPanel();
		tableScrollPane = new javax.swing.JScrollPane();
		doctorsTable = new javax.swing.JTable();
		reasonPanel = new javax.swing.JPanel();
		reasonLabel = new javax.swing.JLabel();
		textAreaScrollPane = new javax.swing.JScrollPane();
		reasonTextArea = new javax.swing.JTextArea();

		notMyDoctorsTableModel = new NotMyDoctorsTableModel(ctrl, dni_patient);

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		titleLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		titleLabel.setText("Select the doctor you want");
		topPanel.add(titleLabel);

		getContentPane().add(topPanel, java.awt.BorderLayout.PAGE_START);

		cancelButton.setText("Cancel");
		cancelButton.setColorHover(new java.awt.Color(138, 202, 234));
		cancelButton.setColorNormal(new java.awt.Color(8, 72, 135));
		cancelButton.setColorPressed(new java.awt.Color(8, 72, 135));
		cancelButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		cancelButton.setPreferredSize(new java.awt.Dimension(200, 35));
		cancelButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				cancelButtonActionPerformed(e);
			}
		});
		botomPanel.add(cancelButton);

		requestButton.setText("Request doctor change");
		requestButton.setColorHover(new java.awt.Color(138, 202, 234));
		requestButton.setColorNormal(new java.awt.Color(8, 72, 135));
		requestButton.setColorPressed(new java.awt.Color(8, 72, 135));
		requestButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		requestButton.setPreferredSize(new java.awt.Dimension(200, 35));
		requestButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				requestButtonActionPerformed(e);
			}
		});
		botomPanel.add(requestButton);

		getContentPane().add(botomPanel, java.awt.BorderLayout.PAGE_END);

		centerPanel.setLayout(new java.awt.GridBagLayout());

		jPanel2.setLayout(new javax.swing.BoxLayout(jPanel2, javax.swing.BoxLayout.Y_AXIS));

		doctorsTable.setModel(notMyDoctorsTableModel);
		tableScrollPane.setViewportView(doctorsTable);

		jPanel2.add(tableScrollPane);

		reasonLabel.setText("Write a brief reason why you want the change");
		reasonPanel.add(reasonLabel);

		jPanel2.add(reasonPanel);

		reasonTextArea.setColumns(20);
		reasonTextArea.setRows(5);
		textAreaScrollPane.setViewportView(reasonTextArea);

		jPanel2.add(textAreaScrollPane);

		centerPanel.add(jPanel2, new java.awt.GridBagConstraints());

		centerScroll.setViewportView(centerPanel);

		getContentPane().add(centerScroll, java.awt.BorderLayout.CENTER);

		pack();
	}// </editor-fold>

	private void cancelButtonActionPerformed(ActionEvent e) {
		dispose();
	}

	private void requestButtonActionPerformed(ActionEvent e) {
		try {
			int row = doctorsTable.getSelectedRow();
			Doctor toDoctor = notMyDoctorsTableModel.getDoctor(row);

			DoctorChangeRequest req = new DoctorChangeRequest(
					new Patient(dni_patient, null, null, null, null, null, null, null, null, null),
					new Doctor(fromDni_doctor, null, null, null, null, null, null, null, null, null, null, null),
					toDoctor,
					reasonTextArea.getText());
			ctrl.requestDoctorChange(req);
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "The request has been registered sucessfully", "", JOptionPane.INFORMATION_MESSAGE);
			dispose();

		} catch (ArrayIndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "You have to select a doctor first", "", JOptionPane.ERROR_MESSAGE);
		} catch (IllegalArgumentException e1) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e1.getMessage(), "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(),"Database Error", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e1.printStackTrace();
		}
	}

	// Variables declaration - do not modify
	private javax.swing.JPanel botomPanel;
	private misc.RSButtonMetro cancelButton;
	private javax.swing.JPanel centerPanel;
	private javax.swing.JScrollPane centerScroll;
	private javax.swing.JTable doctorsTable;
	private javax.swing.JPanel jPanel2;
	private javax.swing.JLabel reasonLabel;
	private javax.swing.JPanel reasonPanel;
	private javax.swing.JTextArea reasonTextArea;
	private misc.RSButtonMetro requestButton;
	private javax.swing.JScrollPane tableScrollPane;
	private javax.swing.JScrollPane textAreaScrollPane;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JPanel topPanel;
	// End of variables declaration
}
