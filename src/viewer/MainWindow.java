
package viewer;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Controller;
import viewer.patient.RegPanelTemplate;

public class MainWindow extends JFrame {

	private Image backgroundImage;

	Controller _ctrl;
	private LoginPanel _loginPanel;
	private RegPanelTemplate _regPanel;

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
		this.setMinimumSize(new Dimension(800, 600));

		// NECESARIO ------------------------------------------------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null); // center window in the screen
		this.setVisible(true);
		ImageIcon image = new ImageIcon("resources/icons/logo.png"); //icon image
		setIconImage(image.getImage());
		setFondo();
	}

	void setFondo() {
		try {
			Fondo fondo = new Fondo(ImageIO.read(new File("resources/icons/background.jpg")));
			JPanel panel = (JPanel) this.getContentPane();
			panel.setBorder(fondo);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void repaint() {
		super.repaint();
		setFondo();
	}

}
