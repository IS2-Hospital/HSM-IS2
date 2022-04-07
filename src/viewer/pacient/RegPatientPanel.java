package viewer.pacient;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import control.Controller;
import viewer.LoginPanel;
import viewer.MainWindow;
import viewer.RegisterPlanPanel;

public class RegPatientPanel extends JPanel{

	private Controller _ctrl;
	private MainWindow _mainWindow;

	public RegPatientPanel(Controller ctrl, MainWindow mainWindow, boolean plan) {
		_ctrl = ctrl;
		_mainWindow = mainWindow;
		initGUI(plan);
	}

	private void initGUI(boolean plan) {

		this.setLayout(new GridBagLayout());

		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		javax.swing.border.Border innerEmpty = BorderFactory.createEmptyBorder(20, 25, 20, 25);
		javax.swing.border.Border outterTitled = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3), "",
				TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.black);
		mainPanel.setBorder(BorderFactory.createCompoundBorder(outterTitled, innerEmpty));

		JPanel regPanel; c.gridx = 0; c.gridy = 0;

		if(plan) { // Plan individual
			regPanel = new RegPanelTemplate(mainPanel);
		}
		else { // Plan cohabitante
			regPanel = new RegPatientTabbedPane();
		}
		mainPanel.add(regPanel, c);

		// Register button
		JButton regButton = new JButton("Register");
		regButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(plan) {
					if(((RegPanelTemplate) regPanel).getJSONObject() == null) System.out.println("Hubo error");
					else System.out.println("Todo bien");
				}
				else {
					((RegPatientTabbedPane) regPanel).getJSONObject();
				}
			}
		});
		c.gridy= 1; c.anchor = GridBagConstraints.EAST;
		mainPanel.add(regButton, c);
		c.anchor = GridBagConstraints.CENTER;

		// Back to login
		JPanel loginPanel = new JPanel(new FlowLayout());
		JLabel msg2 = new JLabel("Alredy have an account?");
		msg2.setHorizontalAlignment(JLabel.CENTER);
		loginPanel.add(msg2);

		JButton loginButton = new JButton("Login");
		loginButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				_mainWindow.setContentPane(new LoginPanel(_ctrl, _mainWindow));
				_mainWindow.revalidate();
				_mainWindow.repaint();
			}
		});
		loginPanel.add(loginButton);
		c.gridy = 2;
		mainPanel.add(loginPanel, c);

		// Back to Selection Plan
		JPanel selectPanel = new JPanel(new FlowLayout());
		JLabel msg3 = new JLabel("Change your mind?");
		JLabel msg1 = new JLabel("You can select another plan here.");
		msg1.setFont(new Font("Arial", Font.PLAIN, 13));
		msg1.setForeground(Color.BLUE);
		msg1.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				_mainWindow.setContentPane(new RegisterPlanPanel(_ctrl, _mainWindow));
				_mainWindow.revalidate();
				_mainWindow.repaint();
			}
			@Override
			public void mousePressed(MouseEvent e) {}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}
		});
		msg1.setHorizontalAlignment(JLabel.CENTER);
		selectPanel.add(msg3); selectPanel.add(msg1);
		c.gridy = 3;
		mainPanel.add(selectPanel, c);



		this.add(mainPanel);
	}

}
