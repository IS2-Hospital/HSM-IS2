package viewer.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import control.Controller;
import launcher.Main;
import model.Enums.BloodType;
import model.Enums.Gender;
import model.Enums.HealthInsuranceType;


public class PatientModWindow extends JFrame {

	private Controller _ctrl;
	private String _dni;
	protected List<String> _dataList;
	private JComboBox<HealthInsuranceType> healthText;
	private JTextField takerText;
	private JTextField textDNI;
	private JTextField textLastName;
	private JTextField textName;
	private JTextField textBDay;
	private JTextField textemail;
	private JComboBox<Gender> textGender;
	private JTextField textPhone;
	private JComboBox<BloodType> bloodText;
	private JTextField billText;

	public PatientModWindow(Controller _ctrl, String dni) {
		super(dni);
		this._ctrl = _ctrl;
		this._dni = dni;
		// dni, lastname,name, birthdate, email, phone, gender, blood_type, insurance_type, dni_insurance_taker, bill
		_dataList = _ctrl.getPatientData(dni).asStringList();
		add(initGUI(), BorderLayout.CENTER);
	}

	protected JPanel initGUI() {
		setLayout(new BorderLayout());
		setVisible(true);
		setSize(new Dimension(280,400));
		setLocationRelativeTo(null);

		JPanel panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());

		JPanel dniPanel = new JPanel();
		dniPanel.setLayout(new FlowLayout());
		dniPanel.add(new JLabel ("DNI: "));
		textDNI = new JTextField();
		textDNI.setPreferredSize(new Dimension(80,20));
		textDNI.setText(_dataList.get(0));
		textDNI.setEditable(false);
		dniPanel.add(textDNI);

		panel1.add(dniPanel, BorderLayout.NORTH);

		JPanel lastNamePanel1 = new JPanel();
		lastNamePanel1.setLayout(new FlowLayout());
		lastNamePanel1.add(new JLabel ("Last Name: "));
		textLastName = new JTextField();
		textLastName.setPreferredSize(new Dimension(80,20));
		textLastName.setText(_dataList.get(1));
		lastNamePanel1.add(textLastName);

		panel1.add(lastNamePanel1, BorderLayout.CENTER);

		JPanel NamePanel = new JPanel();
		NamePanel.setLayout(new FlowLayout());
		NamePanel.add(new JLabel ("Name: "));
		textName = new JTextField();
		textName.setPreferredSize(new Dimension(80,20));
		textName.setText(_dataList.get(2));
		NamePanel.add(textName);

		panel1.add(NamePanel, BorderLayout.SOUTH);

		JPanel panel2 = new JPanel();

		panel2.setLayout(new BorderLayout());

		JPanel birthDatePanel = new JPanel();
		birthDatePanel.setLayout(new FlowLayout());
		birthDatePanel.add(new JLabel ("Birth Date: "));
		textBDay = new JTextField();
		textBDay.setPreferredSize(new Dimension(80,20));
		textBDay.setText(_dataList.get(3));
		birthDatePanel.add(textBDay);

		panel2.add(birthDatePanel, BorderLayout.NORTH);

		JPanel emailPanel = new JPanel();
		emailPanel.setLayout(new FlowLayout());
		emailPanel.add(new JLabel ("Email: "));
		textemail = new JTextField();
		textemail.setPreferredSize(new Dimension(140,20));
		textemail.setText(_dataList.get(4));
		emailPanel.add(textemail);

		panel2.add(emailPanel, BorderLayout.CENTER);

		JPanel PhonePanel = new JPanel();
		PhonePanel.setLayout(new FlowLayout());
		PhonePanel.add(new JLabel ("Phone: "));
		textPhone = new JTextField();
		textPhone.setPreferredSize(new Dimension(80,20));
		textPhone.setText(_dataList.get(5));
		PhonePanel.add(textPhone);

		panel2.add(PhonePanel, BorderLayout.SOUTH);

		JPanel panel3 = new JPanel();

		panel3.setLayout(new BorderLayout());

		JPanel GenderPanel = new JPanel();
		GenderPanel.setLayout(new FlowLayout());
		GenderPanel.add(new JLabel ("Gender: "));
		DefaultComboBoxModel<Gender> model1 = new DefaultComboBoxModel<Gender>();
		for (Gender i : Gender.values()) {
			model1.addElement(i);
		}
		textGender = new JComboBox<Gender>(model1);
		textGender.setPreferredSize(new Dimension (80, 20));
		textGender.setSelectedItem(Gender.valueOf(_dataList.get(6)));
		GenderPanel.add(textGender);

		panel3.add(GenderPanel, BorderLayout.NORTH);

		JPanel BloodPanel = new JPanel();
		BloodPanel.setLayout(new FlowLayout());
		BloodPanel.add(new JLabel ("BloodType: "));
		DefaultComboBoxModel<BloodType> model = new DefaultComboBoxModel<BloodType>();
		for (BloodType i : BloodType.values()) {
			model.addElement(i);
		}
		bloodText = new JComboBox<BloodType>(model);
		bloodText.setPreferredSize(new Dimension (50, 20));
		bloodText.setSelectedItem(BloodType.getEnum(_dataList.get(7)));
		BloodPanel.add(bloodText);

		panel3.add(BloodPanel, BorderLayout.CENTER);

		JPanel insurancePanel = new JPanel();
		insurancePanel.setLayout(new FlowLayout());
		insurancePanel.add(new JLabel ("Insurance Type: "));
		DefaultComboBoxModel<HealthInsuranceType> model2 = new DefaultComboBoxModel<HealthInsuranceType>();
		for (HealthInsuranceType i : HealthInsuranceType.values()) {
			model2.addElement(i);
		}
		healthText = new JComboBox<HealthInsuranceType>(model2);
		healthText.setPreferredSize(new Dimension (100, 20));
		healthText.setSelectedItem(HealthInsuranceType.valueOf(_dataList.get(8)));
		insurancePanel.add(healthText);

		panel3.add(insurancePanel, BorderLayout.SOUTH);

		JPanel panel4 = new JPanel();


		panel4.setLayout(new BorderLayout());

		JPanel takerPanel = new JPanel();
		takerPanel.setLayout(new FlowLayout());
		takerPanel.add(new JLabel ("Insurance Taker: "));
		takerText = new JTextField();
		takerText.setPreferredSize(new Dimension(80,20));
		takerText.setText(_dataList.get(9) == null ? _dni : _dataList.get(9));
		takerPanel.add(takerText);

		panel4.add(takerPanel, BorderLayout.CENTER);


		JPanel billPanel = new JPanel();
		billPanel.setLayout(new FlowLayout());
		billPanel.add(new JLabel ("Bill: "));
		billText = new JTextField();
		billText.setPreferredSize(new Dimension(80,20));
		billText.setText(_dataList.get(10) == null ? "0.000" : _dataList.get(10));
		billPanel.add(billText);

		panel4.add(billPanel, BorderLayout.SOUTH);

		JPanel panel5 = new JPanel();
		panel5.setLayout(new BorderLayout());
		panel5.add(panel1, BorderLayout.NORTH);
		panel5.add(panel2, BorderLayout.CENTER);
		panel5.add(panel3, BorderLayout.SOUTH);
		panel4.add(panel5, BorderLayout.NORTH);



		JPanel buttonPanel = new JPanel();

		buttonPanel.setLayout(new BorderLayout(20, 10));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(100,30));
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				PatientModWindow.this.dispose();
			}

		});
		buttonPanel.add(cancelButton, BorderLayout.WEST);

		JButton okButton = new JButton("Commit");
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				commit();
			}

		});

		buttonPanel.add(okButton, BorderLayout.EAST);

		add(buttonPanel, BorderLayout.SOUTH);

		return panel4;
	}

	protected void commit() {
		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor (PatientModWindow.this),
				"Are you sure you want to commit the data?", "Commit", JOptionPane.YES_NO_OPTION )){
			List<String> colData = getIntroducedData();
			if (colData.size() != 11) {
				JOptionPane.showMessageDialog(null, "Not enough arguments",
						"Error on data collection", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					_ctrl.updatePatient(colData);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error on Query", JOptionPane.ERROR_MESSAGE);

					if (Main.SHOW_EXCEPTIONS_TRACE)
						e1.printStackTrace();
				}
				PatientModWindow.this.dispose();
			}
		}
	}

	public List<String> getIntroducedData(){
		ArrayList<String> data = new ArrayList<String>();
		try {
			data.add(textDNI.getText());
			data.add(textLastName.getText());
			data.add(textName.getText());
			data.add(textBDay.getText());
			data.add(textemail.getText());
			data.add(textPhone.getText());
			data.add(textGender.getSelectedItem().toString());
			data.add(bloodText.getSelectedItem().toString());
			data.add(healthText.getSelectedItem().toString());
			try {
				data.add(takerText.getText());
			}
			catch (NullPointerException e1) {
				data.add(_dni);
			}
			try {
				data.add(billText.getText());
			}
			catch (NullPointerException e1) {
				data.add("0");
			}
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Error on data collection", JOptionPane.ERROR_MESSAGE);

			if (Main.SHOW_EXCEPTIONS_TRACE)
				e.printStackTrace();
		}
		finally{
			return data;
		}
	}

}
