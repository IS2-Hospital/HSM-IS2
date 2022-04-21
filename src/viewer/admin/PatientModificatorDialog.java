package viewer.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import control.Controller;
import model.Patient;

public class PatientModificatorDialog extends JDialog {

	private Controller _ctrl;

	public PatientModificatorDialog(Controller ctrl) {
		_ctrl = ctrl;
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
				PatientModificatorDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton notButton = new JButton("Do not modify password");
		notButton.setPreferredSize(new Dimension(200,30));
		notButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PatientModWindow(_ctrl, (String)selection.getSelectedItem());
				PatientModificatorDialog.this.dispose();
			}

		});

		buttons.add(notButton, BorderLayout.EAST);

		JButton okButton = new JButton("Modify password");
		okButton.setPreferredSize(new Dimension(200,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PatientModWindowPassword(_ctrl, (String)selection.getSelectedItem());
				PatientModificatorDialog.this.dispose();
			}

		});

		buttons.add(okButton, BorderLayout.WEST);

		main.add(buttons, BorderLayout.SOUTH);

		add(main);

		setVisible(true);
		setSize(new Dimension(300,120));
	}

}
