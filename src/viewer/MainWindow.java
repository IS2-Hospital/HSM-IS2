
package viewer;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import control.Controller;

public class MainWindow extends JFrame {

	Controller _ctrl;

	public MainWindow(Controller ctrl) {
		super("La clinica de Pablo");
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {

		this.setLayout(new GridBagLayout());
		this.setContentPane(new LoginPanel(_ctrl, this));
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setMinimumSize(new Dimension(800, 600));

		// NECESARIO ------------------------------------------------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null); // center window in the screen
		this.setVisible(true);
		setIconImage(new ImageIcon("resources/icons/logo45x45.png").getImage());
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
