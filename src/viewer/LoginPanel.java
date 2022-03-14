package viewer;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import control.Controller;
import model.exceptions.LoginException;

class LoginPanel extends JPanel{

	private final String TITLE = "Login Form";

	private JLabel _name, _password;
	private JTextField _userNameTF;
	private JPasswordField _passwordTF;
	private JButton _loginButton, _closeButton;
	private JButton _regButton;

	private Controller _ctrl;


	LoginPanel(Controller ctrl){
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {

		// Panel principal para el login
		JPanel mainPanel = new JPanel(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 2),
				TITLE, TitledBorder.LEFT, TitledBorder.TOP));
		this.add(mainPanel);

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
				String pw  = String.valueOf(_passwordTF.getPassword());
				try {
					int dni = Integer.parseInt(_userNameTF.getText());
					_ctrl.login(dni, pw);
				}
				catch (SQLException e1) {
					String title = "Something went wrong:";
					JOptionPane.showMessageDialog(mainPanel, e1.getMessage(), title, JOptionPane.ERROR_MESSAGE);
				}
				catch (LoginException e2) {
					String title = "Login Error:";
					JOptionPane.showMessageDialog(mainPanel, e2.getMessage(), title, JOptionPane.INFORMATION_MESSAGE);
				}
				catch(NumberFormatException e3) {
					String title = "Login Error:";
					JOptionPane.showMessageDialog(mainPanel, "Invalid DNI. The ID consist only in the numbers", title, JOptionPane.INFORMATION_MESSAGE);
				}


			}
		});
		loginResetPanel.add(_loginButton);
		// Close button
		_closeButton = new JButton("Clear");
		_closeButton.setActionCommand("Clear");
		_closeButton.setToolTipText("Click for clear dni and password");
		_closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_userNameTF.setText("");
				_passwordTF.setText("");
			}
		});
		loginResetPanel.add(_closeButton);

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

			}
		});
		regPanel.add(_regButton);
	}

}