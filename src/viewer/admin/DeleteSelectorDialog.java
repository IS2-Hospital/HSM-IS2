package viewer.admin;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import control.Controller;
import model.Patient;

public class DeleteSelectorDialog extends JDialog {

	private Controller _ctrl;

	public DeleteSelectorDialog(Controller _ctrl) {
		this._ctrl = _ctrl;
		initGUI();
	}

	private void initGUI() {
		pack();
		setPreferredSize(new Dimension(500, 200));
		setMinimumSize(new Dimension(500, 200));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(new JLabel("Select a patient"), BorderLayout.NORTH);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel selector = new JPanel();
		selector.setLayout(new FlowLayout());

		selector.add(new JLabel("Patient: "));
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		List<Patient> patients = _ctrl.getAllPatients();
		for (Patient i : patients) {
			model.addElement(i.getDni());
		}
		JComboBox<String> selection = new JComboBox<String>(model);
		selection.setPreferredSize(new Dimension (80, 20));
		selector.add(selection);
		main.add(selector, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout(20, 10));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(100,30));
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DeleteSelectorDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton notButton = new JButton("Delete");
		notButton.setPreferredSize(new Dimension(200,30));
		notButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor (DeleteSelectorDialog.this),
							"Are you sure you want to delete "+(String) selection.getSelectedItem()+" ?", "Commit", JOptionPane.YES_NO_OPTION )){
						_ctrl.deletePatient((String)selection.getSelectedItem());
					}
				}
				catch(SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Error on delete", JOptionPane.ERROR_MESSAGE);
				}
				DeleteSelectorDialog.this.dispose();
			}

		});

		buttons.add(notButton, BorderLayout.EAST);

		main.add(buttons, BorderLayout.SOUTH);

		add(main);

		setVisible(true);
		setSize(new Dimension(300,120));
	}


}
