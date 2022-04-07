package viewer.pacient;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

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

import org.json.JSONObject;

public class RegPatientTabbedPane extends JPanel{

	private JTabbedPane _tabbedPane;
	private ArrayList<RegPanelTemplate> _regPanelList = new ArrayList<RegPanelTemplate>();

	public RegPatientTabbedPane() {
		initGUI();
	}

	private void initGUI() {

		this.setLayout(new GridBagLayout());
		JPanel mainPanel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();

		// JLabel DNI
		_tabbedPane = new JTabbedPane();
		_tabbedPane.setFocusable(false);

		_tabbedPane.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {}
			@Override
			public void mousePressed(MouseEvent e) {
				if(SwingUtilities.isRightMouseButton(e)) {
					int index = _tabbedPane.getSelectedIndex();
					if(index > 2) {
						JPopupMenu popupMenu = new JPopupMenu();
						JMenuItem delete = new JMenuItem("Delete");
						delete.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								_tabbedPane.remove(index);
								_regPanelList.remove(index);
							}

						});
						popupMenu.add(delete);
						popupMenu.show(mainPanel, e.getX(), e.getY() + 80);
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

				if(_tabbedPane.getTabCount() <= 6) {
					UIManager.put("OPtionPane.okButtonText", "OK");
					UIManager.put("OPtionPane.cancelButtonText", "Cancel");

					String tabName = JOptionPane.showInputDialog(null, "Enter member name", "NEW MEMBER", JOptionPane.INFORMATION_MESSAGE);

					if(tabName != null) {
						JLabel tabTitleLabel = new JLabel(tabName);
						RegPanelTemplate panel = new RegPanelTemplate(mainPanel, tabName);
						_regPanelList.add(panel);
						_tabbedPane.addTab("TAB", panel);
						_tabbedPane.setTabComponentAt(_tabbedPane.getTabCount() - 1, tabTitleLabel);
						_tabbedPane.setSelectedIndex(_tabbedPane.getTabCount()-1);
					}
				}
				else {
					JOptionPane.showMessageDialog(mainPanel, "<html>Sorry. We are currently not accepting more than 6 people <br>in a Cohabitant's plan. Expecting to add new offers sooner.");
				}
			}
		});

		JButton helpButton = new JButton("Help");
		helpButton.setBorder(null);
		helpButton.setFocusPainted(false);
		helpButton.setContentAreaFilled(false);
		helpButton.setPreferredSize(new Dimension(50, 50));
		helpButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(mainPanel, "<html> - In case you want to delete a member, right<br> click in his tab. <br> "
						+ "<br>- Right now, it's impossible for us to add more <br> than six members to our Cohabitant's plan. <br>"
						+ "<br>- The minimum number of members requiered <br> to apply this offer is three people<br>",
						"Help", JOptionPane.INFORMATION_MESSAGE);
			}
		});

		_tabbedPane.addTab("", null);
		_tabbedPane.setTabComponentAt(0,  helpButton);
		_tabbedPane.addTab("", null);
		_tabbedPane.setTabComponentAt(1,  addButton);
		RegPanelTemplate mainCount = new RegPanelTemplate(mainPanel);
		_tabbedPane.addTab("Main Count", mainCount);
		_tabbedPane.setSelectedIndex(_tabbedPane.getTabCount()-1);
		_regPanelList.add(mainCount);

		c.gridx = 0; c.gridy = 0;
		mainPanel.add(_tabbedPane, c);

		this.add(mainPanel);

	}

	public JSONObject getJSONObject() {
		boolean valid = true;
		int nMember = _tabbedPane.getTabCount(), i = 2;
		if(nMember < 5) JOptionPane.showMessageDialog(_tabbedPane, "Sorry but less than 3 members can't apply for this plan.",
				"Unfulfilled requirements", JOptionPane.INFORMATION_MESSAGE);
		else {
			while(valid && i < nMember) {
				valid = _regPanelList.get(i-2).validateReg();
				if(!valid) _tabbedPane.setSelectedIndex(i);
				++i;
			}
			if(valid) ; // TODO construir JSONArray
		}
		return null;
	}
}



