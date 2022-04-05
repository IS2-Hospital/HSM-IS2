package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import control.Controller;
import model.Enums.BloodType;
import model.Enums.UserRole;

@SuppressWarnings("serial")
public class RegPanel extends JPanel {

	private static final String TITLE  = "Register form";
	private static final String TITLE2 = "User registration";
	private JTextField _dniTF, _nameTF, _lastnameTF, _emailTF, _phoneTF;
	JPasswordField _passTF;
	private JSpinner _birthdateSelector;
	private JRadioButton _maleRB, _femaleRB, _singleInsuranceRB, _familiarInsuranceRB;
	private JComboBox<BloodType> _bloodType;

	private Controller _ctrl;
	private MainWindow _mainWindow;

	public RegPanel(Controller ctrl, MainWindow mainWindow) {
		_ctrl = ctrl;
		_mainWindow = mainWindow;
		initGUI();
	}

	public RegPanel() {
		initGUI();
	}

	private void initGUI() {

		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 3), TITLE,
				TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.white));
		JPanel mainPanel = new JPanel(new BorderLayout());

		javax.swing.border.Border innerEmpty = BorderFactory.createEmptyBorder(20, 25, 20, 25);
		javax.swing.border.Border outterTitled = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3), TITLE2,
				TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.black);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(outterTitled, innerEmpty));


		this.add(mainPanel);

		JPanel centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// JLabel DNI
		c.gridx = 0; c.gridy = 0;
		JLabel dni = new JLabel("DNI: ");
		centerPanel.add(dni, c);

		// JTextField DNI
		c.gridx = 1;
		_dniTF = new JTextField("", 20);
		_dniTF.setFont(new Font("Arial", Font.PLAIN, 13));
		centerPanel.add(_dniTF, c);


		// JLabel name
		c.gridx = 0; c.gridy = 1;
		JLabel name = new JLabel("Name: ");
		centerPanel.add(name, c);

		// JTextField name
		c.gridx = 1;
		_nameTF = new JTextField("", 20);
		_nameTF.setFont(new Font("Arial", Font.PLAIN, 13));
		centerPanel.add(_nameTF, c);


		// JLabel lastname
		c.gridx = 0; c.gridy = 2;
		JLabel lastname = new JLabel("Lastname: ");
		centerPanel.add(lastname, c);

		// JTextField lastname
		c.gridx = 1;
		_lastnameTF = new JTextField("", 20);
		_lastnameTF.setFont(new Font("Arial", Font.PLAIN, 13));
		centerPanel.add(_lastnameTF, c);


		// JLabel Birthdate
		c.gridx = 0; c.gridy = 3;
		JLabel birthdate = new JLabel("Birthdate: ");
		centerPanel.add(birthdate, c);

		// JSpinner Birthdate
		c.gridx = 1;
		SimpleDateFormat model = new SimpleDateFormat("yyyy-MM-dd");
		_birthdateSelector = new JSpinner(new SpinnerDateModel());
		_birthdateSelector.setEditor(new JSpinner.DateEditor(_birthdateSelector, model.toPattern()));
		centerPanel.add(_birthdateSelector, c);


		// JLabel email
		c.gridx = 0; c.gridy = 4;
		JLabel email = new JLabel("Email: ");
		centerPanel.add(email, c);

		// JTextField email
		c.gridx = 1;
		_emailTF = new JTextField("", 20);
		_emailTF.setFont(new Font("Arial", Font.PLAIN, 13));
		centerPanel.add(_emailTF, c);


		// JLabel phone
		c.gridx = 0; c.gridy = 5;
		JLabel phone = new JLabel("Phone: ");
		centerPanel.add(phone, c);

		// JTextField phone
		c.gridx = 1;
		_phoneTF = new JTextField("", 20);
		_phoneTF.setFont(new Font("Arial", Font.PLAIN, 13));
		centerPanel.add(_phoneTF, c);


		// JLabel gender
		c.gridx = 0; c.gridy = 6;
		JLabel gender = new JLabel("Gender: ");
		centerPanel.add(gender, c);

		// Gender selection
		JPanel genderPanel = new JPanel();
		_maleRB = new JRadioButton("Male");
		_maleRB.setActionCommand("MALE");
		genderPanel.add(_maleRB);
		_femaleRB = new JRadioButton("Female");
		_femaleRB.setActionCommand("FEMALE");
		genderPanel.add(_femaleRB);

		c.gridx = 1;
		centerPanel.add(genderPanel, c);

		ButtonGroup genderGroup = new ButtonGroup();
		genderGroup.add(_maleRB);
		genderGroup.add(_femaleRB);


		// JLabel Blood type
		c.gridx = 0; c.gridy = 7;
		JLabel blood = new JLabel("Blood type: ");
		centerPanel.add(blood, c);

		// JComboBox Blood type
		c.gridx = 1;
		_bloodType = new JComboBox<>(BloodType.values());
		centerPanel.add(_bloodType, c);


		// JLabel Insurance type
		c.gridx = 0; c.gridy = 8;
		JLabel insurance = new JLabel("Insurance type: ");
		centerPanel.add(insurance, c);

		// Insurance selection
		JPanel insurancePanel = new JPanel();
		_singleInsuranceRB = new JRadioButton("Single");
		_singleInsuranceRB.setActionCommand("SINGLE");
		insurancePanel.add(_singleInsuranceRB);
		_familiarInsuranceRB = new JRadioButton("Familiar");
		_familiarInsuranceRB.setActionCommand("FAMILIAR");
		insurancePanel.add(_familiarInsuranceRB);

		c.gridx = 1;
		centerPanel.add(insurancePanel, c);

		ButtonGroup insuranceGroup = new ButtonGroup();
		insuranceGroup.add(_singleInsuranceRB);
		insuranceGroup.add(_familiarInsuranceRB);


		// JLabel Password
		c.gridx = 0; c.gridy = 9;
		JLabel pass = new JLabel("Password: ");
		centerPanel.add(pass, c);

		// JTextField Password
		c.gridx = 1;
		_passTF = new JPasswordField("", 20);
		_passTF.setFont(new Font("Arial", Font.PLAIN, 13));
		_passTF.setEchoChar('*');
		centerPanel.add(_passTF, c);


		mainPanel.add(centerPanel);


		// Panel login (SOUTH) ----------------------------------------
		JPanel southPanel = new JPanel(new BorderLayout());

		JButton register = new JButton("Register");
		register.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//TODO hacer el JSON del registro
				JSONObject jo = new JSONObject();
				jo.put("role", UserRole.PATIENT.toString());

				JSONArray registerList = new JSONArray();

				JSONObject patientJO = new JSONObject();
				// Password
				patientJO.put("password", String.valueOf(_passTF.getPassword()));

				// User Data
				JSONObject userData = new JSONObject();
				userData.put("dni", _dniTF.getText());
				userData.put("name", _nameTF.getText());
				userData.put("lastname", _lastnameTF.getText());
				userData.put("birthdate", new SimpleDateFormat("yyyy-MM-dd").format(_birthdateSelector.getValue()));
				userData.put("email", _emailTF.getText());
				userData.put("phone", _phoneTF.getText());
				patientJO.put("userData", userData);

				// Role Data
				JSONObject roleData = new JSONObject();
				roleData.put("gender", genderGroup.getSelection().getActionCommand());
				roleData.put("bloodType", _bloodType.getSelectedItem().toString());
				roleData.put("insuranceType", insuranceGroup.getSelection().getActionCommand());
				roleData.put("dniInsuranceTaker", "");
				patientJO.put("roleData", roleData);

				registerList.put(patientJO);
				jo.put("registerList", registerList);

				_ctrl.registerUsers(jo);
			}
		});
		southPanel.add(register, BorderLayout.NORTH);


		// Back to login
		JLabel msg = new JLabel("Alredy have an account?");
		msg.setHorizontalAlignment(JLabel.CENTER);
		southPanel.add(msg);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_mainWindow.setContentPane(new LoginPanel(_ctrl, _mainWindow));
				_mainWindow.revalidate();
				_mainWindow.repaint();
			}
		});
		southPanel.add(loginButton, BorderLayout.SOUTH);

		mainPanel.add(southPanel, BorderLayout.SOUTH);
	}

}
