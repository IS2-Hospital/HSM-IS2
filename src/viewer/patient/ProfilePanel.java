/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewer.patient;

import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;
import model.Patient;
import model.Enums.BloodType;
import model.Enums.Gender;

/**
 *
 * @author reven
 */
@SuppressWarnings("serial")
public class ProfilePanel extends javax.swing.JPanel {

	private static ProfilePanel instance = null;

	private Controller ctrl;
	private String patient_dni;
	private Patient patient;

	private ProfilePanel(Controller ctrl, String patient_dni) {
		this.ctrl = ctrl;
		this.patient_dni = patient_dni;

		initComponents();
	}

	// Singleton
	public static ProfilePanel getInstance(Controller ctrl, String dni_patient) {
		if (instance == null)
			instance = new ProfilePanel(ctrl, dni_patient);
		instance.open();

		return instance;
	}

	private void open() {
		try {
			patient = ctrl.getPatientFullData(patient_dni);

			nameField.setText(patient.getName());
			lastnameField.setText(patient.getLastname());
			passField.setText(patient.getPass());
			birthSpinner.getModel().setValue(getBirthdate());
			emailField.setText(patient.getEmail());
			phoneField.setText(patient.getPhone());
			selectGenderButton();
			bloodComboBox.setSelectedIndex(patient.getBloodType().ordinal());
			ibanField.setText(patient.getIban());
			addressField.setText(patient.getHomeAddress());
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e.getMessage(), "", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		}

	}

	private Date getBirthdate() {
		int year = Integer.parseInt(patient.getBirthdate().substring(0, 4));
		int month = Integer.parseInt(patient.getBirthdate().substring(5, 7));
		int day = Integer.parseInt(patient.getBirthdate().substring(8));

		Calendar cal = Calendar.getInstance(Locale.FRANCE);
		cal.set(year, month, day);

		return cal.getTime();
	}

	private void selectGenderButton() {
		switch (patient.getGender()) {
		case MALE:
			maleButton.setSelected(true);
			break;
		case FEMALE:
			femaleButton.setSelected(true);
			break;
		}
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		genderButtonGroup = new javax.swing.ButtonGroup();
		topPanel = new javax.swing.JPanel();
		jLabel1 = new javax.swing.JLabel();
		centerPanel = new javax.swing.JPanel();
		centerGridBadPanel = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		nameField = new javax.swing.JTextField();
		lastnameField = new javax.swing.JTextField();
		jLabel4 = new javax.swing.JLabel();
		jLabel5 = new javax.swing.JLabel();
		passField = new javax.swing.JTextField();
		birthPanel = new javax.swing.JPanel();
		birthSpinner = new javax.swing.JSpinner();
		jLabel6 = new javax.swing.JLabel();
		jLabel7 = new javax.swing.JLabel();
		emailField = new javax.swing.JTextField();
		phoneField = new javax.swing.JTextField();
		jLabel8 = new javax.swing.JLabel();
		jLabel9 = new javax.swing.JLabel();
		genderPanel = new javax.swing.JPanel();
		maleButton = new javax.swing.JRadioButton();
		femaleButton = new javax.swing.JRadioButton();
		bloodPanel = new javax.swing.JPanel();
		bloodComboBox = new javax.swing.JComboBox<>(BloodType.values());
		jLabel10 = new javax.swing.JLabel();
		jLabel11 = new javax.swing.JLabel();
		ibanField = new javax.swing.JTextField();
		addressField = new javax.swing.JTextField();
		bottomPanel = new javax.swing.JPanel();
		saveButton = new misc.RSButtonMetro();

		setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
		setLayout(new java.awt.BorderLayout());

		jLabel1.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel1.setForeground(new java.awt.Color(51, 51, 51));
		jLabel1.setText("Modify your profile information");
		topPanel.add(jLabel1);

		add(topPanel, java.awt.BorderLayout.PAGE_START);

		centerGridBadPanel.setLayout(new GridBagLayout());

		centerPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));
		centerPanel.setLayout(new java.awt.GridLayout(10, 2, 10, 10));

		jLabel2.setText("Name");
		jLabel2.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel2);

		jLabel3.setText("Lastname");
		jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel3);

		nameField.setText("name");
		nameField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(nameField);

		lastnameField.setText("lastname");
		lastnameField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(lastnameField);

		jLabel4.setText("Password");
		jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel4);

		jLabel5.setText("Birthdate");
		jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel5);

		passField.setText("pass");
		passField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(passField);

		birthPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		birthPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		birthSpinner.setModel(new javax.swing.SpinnerDateModel());
		birthSpinner.setEditor(new javax.swing.JSpinner.DateEditor(birthSpinner, "yyyy-MM-dd"));
		birthPanel.add(birthSpinner);

		centerPanel.add(birthPanel);

		jLabel6.setText("Email");
		jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel6);

		jLabel7.setText("Phone");
		jLabel7.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel7);

		emailField.setText("email");
		emailField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(emailField);

		phoneField.setText("phone");
		phoneField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(phoneField);

		jLabel8.setText("Gender");
		jLabel8.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel8);

		jLabel9.setText("Blood type");
		jLabel9.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel9);

		genderPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		genderButtonGroup.add(maleButton);
		maleButton.setText("Male");
		genderPanel.add(maleButton);

		genderButtonGroup.add(femaleButton);
		femaleButton.setText("Female");
		genderPanel.add(femaleButton);

		centerPanel.add(genderPanel);

		bloodPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		bloodPanel.setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT));

		bloodPanel.add(bloodComboBox);

		centerPanel.add(bloodPanel);

		jLabel10.setText("IBAN");
		jLabel10.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel10);

		jLabel11.setText("Home address");
		jLabel11.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		centerPanel.add(jLabel11);

		ibanField.setText("iban");
		ibanField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(ibanField);

		addressField.setText("address");
		addressField.setMargin(new java.awt.Insets(2, 7, 2, 6));
		centerPanel.add(addressField);

		centerGridBadPanel.add(centerPanel);

		add(centerGridBadPanel, java.awt.BorderLayout.CENTER);

		saveButton.setText("Save changes");
		saveButton.setColorHover(new java.awt.Color(138, 202, 234));
		saveButton.setColorNormal(new java.awt.Color(8, 72, 135));
		saveButton.setColorPressed(new java.awt.Color(8, 72, 135));
		saveButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		saveButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				saveButtonPressedAction(e);
			}
		});
		bottomPanel.add(saveButton);

		add(bottomPanel, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>

	private void saveButtonPressedAction(ActionEvent e) {
		Patient p = new Patient(
				patient.getDni(),
				nameField.getText(),
				lastnameField.getText(),
				new SimpleDateFormat("yyyy-MM-dd").format(birthSpinner.getValue()),
				emailField.getText(),
				phoneField.getText(),
				getSelectedGender(),
				(BloodType) bloodComboBox.getSelectedItem(),
				null,
				null,
				-1,
				passField.getText(),
				ibanField.getText(),
				addressField.getText());

		try {
			ctrl.updatePatient(p);
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "Changes were successfully saved", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), e1.getMessage(), "Database Error", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e1.printStackTrace();
		}
	}

	private Gender getSelectedGender() {
		if (maleButton.isSelected())
			return Gender.MALE;
		else
			return Gender.FEMALE;
	}

	// Variables declaration - do not modify
	private javax.swing.JTextField addressField;
	private javax.swing.JPanel birthPanel;
	private javax.swing.JSpinner birthSpinner;
	private javax.swing.JComboBox<BloodType> bloodComboBox;
	private javax.swing.JPanel bloodPanel;
	private javax.swing.JPanel bottomPanel;
	private javax.swing.JPanel centerGridBadPanel;
	private javax.swing.JPanel centerPanel;
	private javax.swing.JTextField emailField;
	private javax.swing.JRadioButton femaleButton;
	private javax.swing.ButtonGroup genderButtonGroup;
	private javax.swing.JPanel genderPanel;
	private javax.swing.JTextField ibanField;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JTextField lastnameField;
	private javax.swing.JRadioButton maleButton;
	private javax.swing.JTextField nameField;
	private javax.swing.JTextField passField;
	private javax.swing.JTextField phoneField;
	private misc.RSButtonMetro saveButton;
	private javax.swing.JPanel topPanel;
	// End of variables declaration

}

