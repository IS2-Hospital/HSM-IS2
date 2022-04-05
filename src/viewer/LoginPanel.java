package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import control.Controller;
import model.exceptions.LoginException;

@SuppressWarnings("serial")
class LoginPanel extends JPanel{

	private final String TITLE  = "Login Form";
	private final String TITLE2 = "User Login";


	private JLabel _name, _password;
	private JTextField _userNameTF;
	private JPasswordField _passwordTF;
	private JButton _loginButton, _clearButton;
	private JButton _regButton;

	private Controller _ctrl;
	MainWindow _mainWindow;

	LoginPanel(Controller ctrl, MainWindow mainWindow){
		_ctrl = ctrl;
		_mainWindow = mainWindow;
		initGUI();
	}

	private void initGUI() {

		// Panel principal para el login

		this.setLayout(new GridBagLayout());
		this.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.white, 3), TITLE,
				TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.white));
		JPanel mainPanel = new JPanel(new BorderLayout());

		javax.swing.border.Border innerEmpty = BorderFactory.createEmptyBorder(20, 25, 20, 25);
		javax.swing.border.Border outterTitled = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3), TITLE2,
				TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.black);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(outterTitled, innerEmpty));

		this.add(mainPanel);
		this.setOpaque(false);

		// Etiqueta de ayuda (NORTH) --------------------------------------------

		JLabel help = new JLabel("<html><p>Introduce DNI and correct password to access the platform.</p></html>");
		help.setHorizontalAlignment(JLabel.CENTER);
		mainPanel.add(help, BorderLayout.NORTH);

		// Panel para datos de usuario (CENTER) ---------------------------------------

		JPanel centerPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		// JLabel DNI (User identificator
		c.gridx = 0; c.gridy = 0;
		_name = new JLabel("User DNI:");
		centerPanel.add(_name, c);

		// JTextField DNI
		c.gridx = 1;
		_userNameTF = new JTextField("", 10);
		_userNameTF.setFont(new Font("Arial", Font.PLAIN, 13));
		_userNameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButtonPressed();
				}
			}
		});
		centerPanel.add(_userNameTF, c);

		// JLabel Password
		c.gridx = 0; c.gridy = 1;
		_password = new JLabel("Password:");
		centerPanel.add(_password, c);

		// JPasswordField Password
		c.gridx = 1;
		_passwordTF = new JPasswordField("", 10);
		_passwordTF.setFont(new Font("Arial", Font.PLAIN, 13));
		_passwordTF.setEchoChar('*');
		_passwordTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ENTER) {
					loginButtonPressed();
				}
			}
		});
		centerPanel.add(_passwordTF, c);

		JCheckBox showPassword = new JCheckBox("Show");
		c.gridx = 2;
		showPassword.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (showPassword.isSelected()) _passwordTF.setEchoChar((char) 0);
				else _passwordTF.setEchoChar('*');
			}
		});
		centerPanel.add(showPassword, c);


		// Panel Botones (SOUTH) ----------------------------------------
		JPanel southPanel = new JPanel(new BorderLayout());
		JPanel loginResetPanel = new JPanel(new FlowLayout());
		JPanel regPanel = new JPanel(new FlowLayout());
		southPanel.add(loginResetPanel, BorderLayout.NORTH);
		southPanel.add(regPanel, BorderLayout.SOUTH);
		mainPanel.add(southPanel, BorderLayout.SOUTH);

		// Login Button
		_loginButton = new JButton("Login");
		_loginButton.setActionCommand("Login");
		_loginButton.setToolTipText("Click for Login");
		_loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				loginButtonPressed();
			}
		});
		loginResetPanel.add(_loginButton);
		// Clear button
		_clearButton = new JButton("Clear");
		_clearButton.setActionCommand("Clear");
		_clearButton.setToolTipText("Click for clear dni and password");
		_clearButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_userNameTF.setText("");
				_passwordTF.setText("");
			}
		});
		loginResetPanel.add(_clearButton);

		// Registration option
		JLabel reg = new JLabel("If you don't have a profile, you can registrate here.");
		reg.setHorizontalAlignment(JLabel.CENTER);
		southPanel.add(reg, BorderLayout.CENTER);

		_regButton = new JButton("Register");
		_regButton.setActionCommand("Register");
		_regButton.setToolTipText("Click for register in the aplication");
		_regButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_mainWindow.setContentPane(new RegPanel(_ctrl, _mainWindow));
				_mainWindow.revalidate();
				_mainWindow.repaint();
			}
		});
		regPanel.add(_regButton);
	}

	private void loginButtonPressed() {
		String pw  = String.valueOf(_passwordTF.getPassword());
		String dni = _userNameTF.getText();
		try {
			_ctrl.login(dni, pw);
			//TODO login devuelve enum y se crea un controllador para la vista
			JPanel panel = new PatientPanel();
			panel.setPreferredSize(_mainWindow.getSize());
			JScrollPane scroll = new JScrollPane(panel);
			scroll.setPreferredSize(new Dimension(1000, 700));
			_mainWindow.setContentPane(scroll);
			_mainWindow.revalidate();
			_mainWindow.repaint();
		}
		catch (SQLException e1) {
			String title = "Something went wrong:";
			JOptionPane.showMessageDialog(_mainWindow, e1.getMessage(), title, JOptionPane.ERROR_MESSAGE);
		}
		catch (LoginException e2) {
			String title = "Login Error:";
			JOptionPane.showMessageDialog(_mainWindow, e2.getMessage(), title, JOptionPane.INFORMATION_MESSAGE);
		}
		catch(NumberFormatException e3) {
			String title = "Login Error:";
			JOptionPane.showMessageDialog(_mainWindow, "Invalid DNI. The ID consist only in the numbers", title, JOptionPane.INFORMATION_MESSAGE);
		}

	}

}







