
package viewer;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
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

		JPanel bgPanel = new BgPanel();
		bgPanel.setLayout(new GridBagLayout());
		bgPanel.add(new LoginPanel(_ctrl));
		this.setContentPane(bgPanel);
		this.setPreferredSize(new Dimension(1500, 1500));

		// NECESARIO ------------------------------------------------------------
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setLocationRelativeTo(null); // center window in the screen
		this.setVisible(true);
	}

	class BgPanel extends JPanel {
		java.awt.Image bg = new ImageIcon("resources/icons/background.jpg").getImage();
		@Override
		public void paintComponent(Graphics g) {
			g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
		}
	}
}
