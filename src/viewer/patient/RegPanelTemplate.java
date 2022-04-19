package viewer.patient;

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
import javax.swing.ButtonGroup;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerDateModel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import org.json.JSONArray;
import org.json.JSONObject;

import model.Enums.BloodType;
import model.Enums.UserRole;

@SuppressWarnings("serial")
public class RegPanelTemplate extends JPanel {

	private static final String TITLE = "User registration";
	private static final Border JTEXTFIELDBORDER = new JTextField().getBorder();

	private JTextField _dniTF, _nameTF, _lastnameTF, _emailTF, _phoneTF, _homeAdressTF;
	JPasswordField _passTF;
	private JSpinner _birthdateSelector;
	private JRadioButton _maleRB, _femaleRB;
	private JComboBox<BloodType> _bloodType;
	private ButtonGroup _genderGroup;
	private ArrayList<JTextField> _wrongList = new ArrayList<JTextField>();
	private String _name = "", _insuranceGroup;
	private JPanel _parentPanel;

	public RegPanelTemplate(JPanel parentPanel) {
		_parentPanel = parentPanel;
		_insuranceGroup = "SINGLE";
		initGUI();
	}

	public RegPanelTemplate(JPanel parentPanel, String name) {
		_parentPanel = parentPanel;
		_insuranceGroup = "FAMILIAR";
		_name = name;
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

		_genderGroup = new ButtonGroup();
		_genderGroup.add(_maleRB);
		_genderGroup.add(_femaleRB);


		// JLabel Blood type
		c.gridx = 0; c.gridy = 7;
		JLabel blood = new JLabel("Blood type: ");
		centerPanel.add(blood, c);

		// JComboBox Blood type
		c.gridx = 1;
		_bloodType = new JComboBox<>(BloodType.values());
		centerPanel.add(_bloodType, c);


		// Home Adress JLabel
		c.gridx = 0; c.gridy = 8;
		JLabel homeAdressLabel = new JLabel("Home adress: ");
		centerPanel.add(homeAdressLabel, c);

		// Home Adress JTextField
		_homeAdressTF = new JTextField("", 20);
		_homeAdressTF.setFont(new Font("Arial", Font.PLAIN, 13));
		c.gridx = 1;
		centerPanel.add(_homeAdressTF, c);

		// Home Adress JLabel
		c.gridy = 9;
		JLabel infoHomeAdress = new JLabel("<html> We need this information for facturation<br>and for checking data in Cohabitant's plan.");
		infoHomeAdress.setFont(new Font("Arial", Font.PLAIN, 10));
		centerPanel.add(infoHomeAdress, c);

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

	private boolean isSelection(ButtonGroup buttonGroup) {
		return (buttonGroup.getSelection() != null);
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
		if(_homeAdressTF.getText().equals("")) _wrongList.add(_homeAdressTF);

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
				if(!_phoneTF.getText().equals("")) Integer.parseInt(_phoneTF.getText());
				// Parseo género
				if(!isSelection(_genderGroup)) throw new Exception("Please, select your gender.");
				// Parseo fecha
				String introducedDate = new SimpleDateFormat("yyyy-MM-dd").format(_birthdateSelector.getValue());
				LocalDateTime ldt = LocalDateTime.now();
				DateTimeFormatter formmat1 = DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH);
				int compare = formmat1.format(ldt).compareTo(introducedDate);
				if(compare == 0) JOptionPane.showMessageDialog(_parentPanel,  "Congratulations to the newborn " +_nameTF.getText()+ " and to you, parents.", "Happy birthday", JOptionPane.PLAIN_MESSAGE);
				else if(compare < 0) throw new Exception("According to our calculations, you haven´t born yet. Congratulations, you have surpass the matrix's Laws of Physics.");
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
		roleData.put("gender", _genderGroup.getSelection().getActionCommand());
		roleData.put("bloodType", _bloodType.getSelectedItem().toString());
		roleData.put("insuranceType", _insuranceGroup);
		roleData.put("dniInsuranceTaker", "");
		patientJO.put("roleData", roleData);

		registerList.put(patientJO);
		jo.put("registerList", registerList);

		return jo;
	}

	public JSONObject getJSONObject() {
		if(validateIntroducedData()) return createRegistrationJO();
		else return null;
	}

	public boolean validateReg() {
		return validateIntroducedData();
	}

}
