package viewer.doctor;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Enums.RegState;
import model.Enums.UserRole;
import model.userManagment.UserRegisterer;

@SuppressWarnings("serial")
public class RegPanelTemplateDoctor extends JPanel{

	private static final String TITLE = "Doctor registration";
	private static final Border JTEXTFIELDBORDER = new JTextField().getBorder();

	private JTextField _dniTF, _nameTF, _lastnameTF, _emailTF, _phoneTF, _specialityTF, _notes;
	JPasswordField _passTF;
	private JSpinner _birthdateSelector, _contractDuration;
	private JComboBox<Integer> _salarySelection;
	private ArrayList<JTextField> _wrongList = new ArrayList<JTextField>();
	private String _name = "";
	private JPanel _parentPanel;

	private final Integer[] salaryList = new Integer[] {1000, 1250, 1500, 1750, 2000, 2250, 2500, 2750, 3000, 3500, 5000};

	public RegPanelTemplateDoctor(JPanel parentPanel) {
		_parentPanel = parentPanel;
		initGUI();
	}

	private void initGUI() {

		this.setLayout(new GridBagLayout());

		JPanel mainPanel = new JPanel(new BorderLayout());

		javax.swing.border.Border innerEmpty = BorderFactory.createEmptyBorder(20, 25, 20, 25);
		javax.swing.border.Border outterTitled = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3), TITLE,
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
		_nameTF = new JTextField(_name, 20);
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
		//JFormattedTextField tf = ((JSpinner.DefaultEditor) _birthdateSelector.getEditor()).getTextField();
		//tf.setEditable(false);
		//tf.setBackground(Color.white);
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

		// JLabel Salary Selection
		c.gridx = 0; c.gridy = 6;
		JLabel blood = new JLabel("Expected salary: ");
		centerPanel.add(blood, c);

		// JComboBox Salary selection
		c.gridx = 1;
		_salarySelection = new JComboBox<>(salaryList);
		centerPanel.add(_salarySelection, c);

		// Speciality JLabel
		c.gridx = 0; c.gridy = 7;
		JLabel specialityLabel = new JLabel("Speciality: ");
		centerPanel.add(specialityLabel, c);

		// Speciality JTextField
		_specialityTF = new JTextField("", 20);
		_specialityTF.setFont(new Font("Arial", Font.PLAIN, 13));
		c.gridx = 1;
		centerPanel.add(_specialityTF, c);

		// Contract JLabel
		c.gridx = 0; c.gridy = 8;
		JLabel contractDuration = new JLabel("Contract Expiration: ");
		centerPanel.add(contractDuration, c);

		// Contract JSpinner
		c.gridx = 1;
		_contractDuration = new JSpinner(new SpinnerDateModel());
		_contractDuration.setEditor(new JSpinner.DateEditor(_contractDuration, model.toPattern()));
		centerPanel.add(_contractDuration, c);


		// JLabel CV
		c.gridx = 0; c.gridy = 9;
		JLabel CV = new JLabel("Tell us about you: ");
		centerPanel.add(CV, c);

		// JTextField CV
		c.gridx = 1;
		_notes = new JTextField("", 20);
		_notes.setFont(new Font("Arial", Font.PLAIN, 13));
		centerPanel.add(_notes, c);

		// JLabel Password
		c.gridx = 0; c.gridy = 10;
		JLabel pass = new JLabel("Password: ");
		centerPanel.add(pass, c);

		// JTextField Password
		c.gridx = 1;
		_passTF = new JPasswordField("", 20);
		_passTF.setFont(new Font("Arial", Font.PLAIN, 13));
		_passTF.setEchoChar('*');
		centerPanel.add(_passTF, c);

		mainPanel.add(centerPanel);
	}

	private boolean validateIntroducedData() {
		boolean valid = true;
		if(_wrongList.size() != 0) {
			for(JTextField tf: _wrongList) tf.setBorder(JTEXTFIELDBORDER);
		}
		_wrongList.clear();

		if(_dniTF.getText().equals("")) _wrongList.add(_dniTF);
		if(_nameTF.getText().equals("")) _wrongList.add(_nameTF);
		if(_emailTF.getText().equals("")) _wrongList.add(_emailTF);
		if(String.valueOf(_passTF.getPassword()).equals("")) _wrongList.add(_passTF);
		if(_specialityTF.getText().equals("")) _wrongList.add(_specialityTF);

		if(_wrongList.size() != 0) {
			valid = false;
			for(JTextField tf : _wrongList) {
				tf.setBorder(new LineBorder(Color.RED, 1));
			}
			JOptionPane.showMessageDialog(_parentPanel, "Some fields are mandatory");
		}
		else {
			try {
				// Parseo numero telefono
				if(!_phoneTF.getText().equals("")) Long.parseLong(_phoneTF.getText());
				// Parseo correo
				if(_emailTF.getText().indexOf('@') == -1) throw new Exception("Invalid email. Character @ was not found.");
				// Parseo fecha nacimiento
				String introducedDate = new SimpleDateFormat("yyyy-MM-dd").format(_birthdateSelector.getValue());
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
				int compare = formmat1.format(ldt).compareTo(introducedDate);
				if(compare == 0 || compare < 0) throw new Exception("<html>Looks like you forgot about your birthdate.<br> Being serious, introduce a valid date, please.");
				// Parseo expiracion contrato
				introducedDate = new SimpleDateFormat("yyyy-MM-dd").format(_contractDuration.getValue());
				compare = formmat1.format(ldt).compareTo(introducedDate);
				if(compare == 0 || compare > 0) throw new Exception("<html>Please, introduce a valid expiration date for your contract.");
				// Parseo contraseña
				if(String.valueOf(_passTF.getPassword()).length() < 5) throw new Exception("Short password. Introduce at least 5 characters.");
			}
			catch(NumberFormatException ex) {
				_phoneTF.setBorder(new LineBorder(Color.RED, 1));
				_wrongList.add(_phoneTF);
				valid = false;
				JOptionPane.showMessageDialog(_parentPanel, "Invalid phone number.", "Wrong value", JOptionPane.ERROR_MESSAGE);
			}
			catch(Exception ex){
				valid = false;
				JOptionPane.showMessageDialog(_parentPanel,  ex.getMessage(), "Selecting gender", JOptionPane.WARNING_MESSAGE);
			}
		}
		return valid;
	}

	private JSONObject createRegistrationJO() {
		//TODO Incluir el home adress en la base de datos y en la creacion del JSON
		JSONObject jo = new JSONObject();
		jo.put("role", UserRole.DOCTOR.toString());

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
		roleData.put("speciality", _specialityTF.getText());
		roleData.put("contractExpiration", new SimpleDateFormat("yyyy-MM-dd").format(_contractDuration.getValue()));
		roleData.put("salary", _salarySelection.getSelectedItem().toString());
		roleData.put("regState", RegState.INPROCESS.name());
		roleData.put("notes", _notes.getText());
		patientJO.put("roleData", roleData);

		registerList.put(patientJO);
		jo.put("registerList", registerList);

		return jo;
	}

	public boolean validateReg() {
		return validateIntroducedData();
	}

	public boolean registerUser() {
		if(validateIntroducedData()) {
			try {new UserRegisterer().registerUsers(createRegistrationJO()); return true;}
			catch (Exception e) {
				JOptionPane.showMessageDialog(_parentPanel, e.getMessage(), "Error in registration", JOptionPane.ERROR_MESSAGE);
			}
		}
		return false;

	}
}
