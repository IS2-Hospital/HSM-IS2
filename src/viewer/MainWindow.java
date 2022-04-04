
package viewer;

import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

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

		//JPanel bgPanel = new BgPanel();
		//bgPanel.setLayout(new GridBagLayout());
		//bgPanel.add(new LoginPanel(_ctrl, this));
		//this.setContentPane(bgPanel);
		this.setLayout(new GridBagLayout());
		this.setContentPane(new LoginPanel(_ctrl, this));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(800, 800));

		// NECESARIO ------------------------------------------------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null); // center window in the screen
		this.setVisible(true);
		ImageIcon image = new ImageIcon("resources/icons/logo.png"); //icon image
		setIconImage(image.getImage());



	}
}
