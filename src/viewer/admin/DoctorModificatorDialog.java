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
import model.Doctor;

public class DoctorModificatorDialog extends JDialog {

	private Controller _ctrl;

	public DoctorModificatorDialog(Controller _ctrl) {
		this._ctrl = _ctrl;
		initGUI();
	}

	private void initGUI() {
		pack();
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(300, 200));
		setLayout(new BorderLayout());
		add(new JLabel("Select a doctor to modify"), BorderLayout.NORTH);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel selector = new JPanel();
		selector.setLayout(new FlowLayout());

		selector.add(new JLabel("Doctor: "));
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		List<Doctor> doctors = _ctrl.getDoctorList();
		for (Doctor i : doctors) {
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
				DoctorModificatorDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DoctorModWindow(_ctrl, (String)selection.getSelectedItem());
				DoctorModificatorDialog.this.dispose();
			}

		});

		buttons.add(okButton, BorderLayout.EAST);

		main.add(buttons, BorderLayout.SOUTH);

		add(main);

		setVisible(true);
		setSize(new Dimension(300,120));
	}

}
