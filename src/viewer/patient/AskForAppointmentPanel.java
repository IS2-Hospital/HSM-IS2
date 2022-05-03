/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewer.patient;

import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;
import model.Appointment;
import model.Doctor;

/**
 *
 * @author reven
 */
@SuppressWarnings("serial")
public class AskForAppointmentPanel extends javax.swing.JPanel {

	private static AskForAppointmentPanel instance = null;

	private String dni_patient;
	private Controller ctrl;
	private PatientPanel patientPanel;

	private Vector<Doctor> doctorList;

	/**
	 * Creates new form AskForAppointmentPanel
	 * @param ctrl
	 * @param dni
	 */
	private AskForAppointmentPanel(PatientPanel p) {
		this.ctrl = p.getCtrl();
		this.dni_patient = p.getDniPatient();
		this.patientPanel = p;
		doctorList = new Vector<>();

		initComponents();

		centerScrollPane.getVerticalScrollBar().setUnitIncrement(10);
	}

	// Singleton
	public static AskForAppointmentPanel getInstance(PatientPanel p) {
		if (instance == null)
			instance = new AskForAppointmentPanel(p);
		instance.open();

		return instance;
	}

	private void open() {
		try {
			doctorList = ctrl.getDoctorsOf(dni_patient);
			doctorComboBox.setModel(new DefaultComboBoxModel<>(doctorList));
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "", JOptionPane.ERROR_MESSAGE);

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
		doctorLablePanel = new javax.swing.JPanel();
		doctorLabel = new javax.swing.JLabel();
		doctorCBPanel = new javax.swing.JPanel();
		doctorComboBox = new javax.swing.JComboBox<>();
		centerScrollPane = new javax.swing.JScrollPane();
		centerPanel = new javax.swing.JPanel();
		c1 = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		c2 = new javax.swing.JPanel();
		calendarPanel1 = new viewer.misc.CalendarPanel();
		c3 = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		c4 = new javax.swing.JPanel();
		viewAvailableHoursButton = new misc.RSButtonMetro();
		c5 = new javax.swing.JPanel();
		jScrollPane2 = new javax.swing.JScrollPane();
		hourList = new javax.swing.JList<>();
		c6 = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		c7 = new javax.swing.JPanel();
		jScrollPane1 = new javax.swing.JScrollPane();
		descriptionTextArea = new javax.swing.JTextArea();
		bottomPanel = new javax.swing.JPanel();
		cancelButton = new misc.RSButtonMetro();
		askButton = new misc.RSButtonMetro();

		setLayout(new java.awt.BorderLayout());

		topPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		topPanel.setLayout(new javax.swing.BoxLayout(topPanel, javax.swing.BoxLayout.Y_AXIS));

		doctorLabel.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		doctorLabel.setForeground(new java.awt.Color(51, 51, 51));
		doctorLabel.setText("Select a doctor");
		doctorLablePanel.add(doctorLabel);

		topPanel.add(doctorLablePanel);

		doctorComboBox.setModel(new DefaultComboBoxModel<>(doctorList));
		doctorCBPanel.add(doctorComboBox);

		topPanel.add(doctorCBPanel);

		add(topPanel, java.awt.BorderLayout.PAGE_START);

		centerScrollPane.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		centerScrollPane.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);

		centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		centerPanel.setLayout(new javax.swing.BoxLayout(centerPanel, javax.swing.BoxLayout.Y_AXIS));

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(51, 51, 51));
		jLabel1.setText("jLabel1");
		c1.add(jLabel1);

		centerPanel.add(c1);

		calendarPanel1.setPreferredSize(new java.awt.Dimension(350, 300));
		c2.add(calendarPanel1);

		centerPanel.add(c2);

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel3.setForeground(new java.awt.Color(51, 51, 51));
		jLabel3.setText("Select an available hour");
		c3.add(jLabel3);

		centerPanel.add(c3);

		viewAvailableHoursButton.setText("View available hours");
		viewAvailableHoursButton.setColorHover(new java.awt.Color(138, 202, 234));
		viewAvailableHoursButton.setColorNormal(new java.awt.Color(8, 72, 135));
		viewAvailableHoursButton.setColorPressed(new java.awt.Color(138, 202, 234));
		viewAvailableHoursButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		viewAvailableHoursButton.setFocusPainted(false);
		viewAvailableHoursButton.setPreferredSize(new java.awt.Dimension(170, 35));
		viewAvailableHoursButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				viewAvailableHoursButtonActionPerformed(evt);
			}
		});
		c4.add(viewAvailableHoursButton);

		centerPanel.add(c4);

		jScrollPane2.setViewportView(hourList);

		c5.add(jScrollPane2);

		centerPanel.add(c5);

		jLabel2.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel2.setForeground(new java.awt.Color(51, 51, 51));
		jLabel2.setText("Write a brief description");
		c6.add(jLabel2);

		centerPanel.add(c6);

		descriptionTextArea.setColumns(20);
		descriptionTextArea.setRows(5);
		jScrollPane1.setViewportView(descriptionTextArea);

		c7.add(jScrollPane1);

		centerPanel.add(c7);

		centerScrollPane.setViewportView(centerPanel);

		add(centerScrollPane, java.awt.BorderLayout.CENTER);

		bottomPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

		cancelButton.setText("Cancel");
		cancelButton.setColorHover(new java.awt.Color(138, 202, 234));
		cancelButton.setColorNormal(new java.awt.Color(8, 72, 135));
		cancelButton.setColorPressed(new java.awt.Color(138, 202, 234));
		cancelButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		cancelButton.setFocusPainted(false);
		cancelButton.setPreferredSize(new java.awt.Dimension(170, 35));
		cancelButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cancelButtonActionPerformed(evt);
			}
		});
		bottomPanel.add(cancelButton);

		askButton.setText("Ask for appointment");
		askButton.setColorHover(new java.awt.Color(138, 202, 234));
		askButton.setColorNormal(new java.awt.Color(8, 72, 135));
		askButton.setColorPressed(new java.awt.Color(138, 202, 234));
		askButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		askButton.setFocusPainted(false);
		askButton.setPreferredSize(new java.awt.Dimension(170, 35));
		askButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				askButtonActionPerformed(evt);
			}
		});
		bottomPanel.add(askButton);

		add(bottomPanel, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>

	private void cancelButtonActionPerformed(java.awt.event.ActionEvent evt) {
		patientPanel.setCenterPanel(PatientHomePanel.getInstance(null));
	}

	private void askButtonActionPerformed(java.awt.event.ActionEvent evt) {

		try {
			String day = calendarPanel1.getSelectedDate();
			if (day.compareTo(calendarPanel1.getTodaysDate()) <= 0)
				throw new NullPointerException("You can't select a past day");

			String hour = hourList.getSelectedValue();
			if (hour == null)
				throw new NullPointerException("You have to select an hour before asking for the appointment");

			String dni_doctor = ((Doctor) doctorComboBox.getSelectedItem()).getDni();
			String desc = descriptionTextArea.getText();

			ctrl.askForAppointment(new Appointment(day, hour, dni_doctor, desc, dni_patient));
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Your appointment has been registered successfully", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		} catch (NullPointerException e) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void viewAvailableHoursButtonActionPerformed(java.awt.event.ActionEvent evt) {

		Vector<String> v = new Vector<>();

		try {
			Doctor doctor = (Doctor) doctorComboBox.getSelectedItem();
			String date = calendarPanel1.getSelectedDate();

			if (date.compareTo(calendarPanel1.getTodaysDate()) <= 0)
				throw new NullPointerException("You can't select a past day");

			v = ctrl.getAvailableHours(doctor.getDni(), date);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (NullPointerException e) { // there is not a day selected
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}

		DefaultListModel<String> m = new DefaultListModel<>();

		for(int i = 0; i < v.size(); i++)
			m.add(i, v.get(i));

		hourList.setModel(m);
	}


	// Variables declaration - do not modify
	private misc.RSButtonMetro askButton;
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JPanel c1;
	private javax.swing.JPanel c2;
	private javax.swing.JPanel c3;
	private javax.swing.JPanel c4;
	private javax.swing.JPanel c5;
	private javax.swing.JPanel c6;
	private javax.swing.JPanel c7;
	private viewer.misc.CalendarPanel calendarPanel1;
	private misc.RSButtonMetro cancelButton;
	private javax.swing.JPanel centerPanel;
	private javax.swing.JScrollPane centerScrollPane;
	private javax.swing.JPanel doctorCBPanel;
	private javax.swing.JComboBox<Doctor> doctorComboBox;
	private javax.swing.JLabel doctorLabel;
	private javax.swing.JPanel doctorLablePanel;
	private javax.swing.JList<String> hourList;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JTextArea descriptionTextArea;
	private javax.swing.JPanel topPanel;
	private misc.RSButtonMetro viewAvailableHoursButton;
	// End of variables declaration
}
