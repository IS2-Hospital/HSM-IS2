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

import control.Controller;
import model.Doctor;
import model.Patient;

public class DoctorAssignDialog extends JDialog {



	private Controller _ctrl;

	public DoctorAssignDialog(Controller _ctrl) {
		this._ctrl = _ctrl;
		InitGUI();
	}

	private void InitGUI() {
		setLocationRelativeTo(null);
		pack();
		setPreferredSize(new Dimension(300, 200));
		setLayout(new BorderLayout());
		add(new JLabel("Select a doctor"), BorderLayout.NORTH);

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
		selection.setPreferredSize(new Dimension (100, 20));
		selector.add(selection);
		main.add(selector, BorderLayout.NORTH);

		JPanel selectorPac = new JPanel();
		selectorPac.setLayout(new FlowLayout());

		selectorPac.add(new JLabel("Patient: "));
		DefaultComboBoxModel<String> modelPac = new DefaultComboBoxModel<String>();
		List<Patient> patients = _ctrl.getAllPatients();
		for (Patient i : patients) {
			modelPac.addElement(i.getDni());
		}
		JComboBox<String> selectionpac = new JComboBox<String>(modelPac);
		selectionpac.setPreferredSize(new Dimension (100, 20));
		selectorPac.add(selectionpac);
		main.add(selectorPac, BorderLayout.CENTER);

		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout(20, 10));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(100,30));
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DoctorAssignDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					_ctrl.assignPatientDoctor(selection.getSelectedItem().toString(), selectionpac.getSelectedItem().toString());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error while inserting in database", JOptionPane.ERROR_MESSAGE);
				}
			}

		});

		buttons.add(okButton, BorderLayout.EAST);

		add(buttons, BorderLayout.SOUTH);

		add(main, BorderLayout.CENTER);

		setVisible(true);
		setSize(new Dimension(300,150));
	}

}
