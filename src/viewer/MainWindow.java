
package viewer;

import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Controller;

public class MainWindow extends JFrame {

	Controller _ctrl;
	private LoginPanel _loginPanel;
	private RegPanel _regPanel;

	public MainWindow(Controller ctrl) {
		super("La clínica de Pablo");
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {

		JPanel mainPanel = new JPanel(new BorderLayout());
		setContentPane(mainPanel);

		// Initial Page (Login) ------------------------------------------------
		_loginPanel = new LoginPanel(_ctrl);
		mainPanel.add(_loginPanel, BorderLayout.PAGE_START);

		// NECESARIO ------------------------------------------------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
