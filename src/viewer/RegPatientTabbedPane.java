package viewer;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/*
 * TabbedPaneDemo.java requires one additional file:
 *   images/middle.gif.
 */

import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class RegPatientTabbedPane extends JPanel{

	public RegPatientTabbedPane() {
		initGUI();
	}

	private void initGUI() {

		this.setLayout(new GridBagLayout());
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// JLabel DNI
		JTabbedPane tabbedPane = new JTabbedPane();
		tabbedPane.setFocusable(false);

		tabbedPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					int index = tabbedPane.getSelectedIndex();
					if(index > 1) {
						JPopupMenu popupMenu = new JPopupMenu();
						JMenuItem delete = new JMenuItem("Delete");
						delete.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								tabbedPane.remove(index);
							}

						});
						popupMenu.add(delete);
						popupMenu.show(mainPanel, e.getX(), e.getY() + 40);
					}
				}
			}
			@Override
			public void mouseReleased(MouseEvent e) {}
			@Override
			public void mouseEntered(MouseEvent e) {}
			@Override
			public void mouseExited(MouseEvent e) {}

		});

		JButton addButton = new JButton("+");
		addButton.setBorder(null);
		addButton.setFocusPainted(false);
		addButton.setContentAreaFilled(false);
		addButton.setPreferredSize(new Dimension(50, 50));
		addButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if(tabbedPane.getTabCount() <= 5) {
					UIManager.put("OPtionPane.okButtonText", "OK");
					UIManager.put("OPtionPane.cancelButtonText", "Cancel");

					String tabName = JOptionPane.showInputDialog(null, "Enter member name", "NEW MEMBER", JOptionPane.INFORMATION_MESSAGE);

					if(tabName != null) {
						JLabel tabTitleLabel = new JLabel(tabName);
						JPanel panel = new RegPanelTemplate();

						tabbedPane.addTab("TAB", panel);
						tabbedPane.setTabComponentAt(tabbedPane.getTabCount() - 1, tabTitleLabel);
						tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);
					}
				}
				else {
					JOptionPane.showMessageDialog(mainPanel, "<html>Sorry. We are currently not accepting more than 5 people <br>in a Cohabitant's plan. Expect to solve this problem sooner.");
				}
			}
		});

		tabbedPane.addTab("", null);

		tabbedPane.setTabComponentAt(0,  addButton);

		tabbedPane.addTab("Main Count", new RegPanelTemplate());
		tabbedPane.setSelectedIndex(tabbedPane.getTabCount()-1);

		JPanel helpPanel = new JPanel(new FlowLayout());
		JLabel helpLabel = new JLabel("Do you need help?");
		JButton help = new JButton("Help");
		help.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainPanel, "<html> - In case you want to delete a member, right<br> click in his tab. <br> "
						+ "<br>- Right now, it's impossible for us to add more <br> than five members to our Cohabitant's plan.",
						"Help", JOptionPane.INFORMATION_MESSAGE);
			}

		});
		helpPanel.add(helpLabel); helpPanel.add(help);

		c.gridx = 0; c.gridy = 0;
		mainPanel.add(tabbedPane, c);
		c.gridy = 1;
		mainPanel.add(helpPanel, c);
		this.add(mainPanel);

	}
}



