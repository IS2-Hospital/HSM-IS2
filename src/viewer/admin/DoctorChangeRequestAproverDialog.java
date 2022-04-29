package viewer.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;

import control.Controller;

public class DoctorChangeRequestAproverDialog extends JDialog {

	private static final long serialVersionUID = 1L;
	private Controller _ctrl;
	private List<String> dni;
	private JTextArea descText;
	private JLabel patientLabel;
	private JLabel doctorLabel;
	private JLabel newLabel;

	public DoctorChangeRequestAproverDialog(Controller _ctrl) {
		this._ctrl = _ctrl;
		InitGUI();
	}

	private void InitGUI() {
		pack();
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(300, 200));
		setLayout(new BorderLayout());
		add(new JLabel("Select a request to continue"), BorderLayout.NORTH);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel selector = new JPanel();
		selector.setLayout(new FlowLayout());

		selector.add(new JLabel("Doctor: "));
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		List<String> requests = _ctrl.getRequestIDList();
		try {
			dni = _ctrl.getDNIFromRequest(requests.get(0));
		}
		catch(SQLException e) {

		}
		catch(IndexOutOfBoundsException e) {
			JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(this), "There are no unresponded requests",
					"Request Manager", JOptionPane.INFORMATION_MESSAGE);
			this.dispose();
			return;
		}
		for (String i : requests) {
			model.addElement(i);
		}
		JComboBox<String> selection = new JComboBox<String>(model);
		selection.setPreferredSize(new Dimension (80, 20));
		selector.add(selection);
		selection.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					try {
						dni = _ctrl.getDNIFromRequest(selection.getSelectedItem().toString());
					} catch (SQLException e2) {

					}
					try {
						patientLabel.setText("Patient: " + _ctrl.getPatientData(dni.get(0)).getFullName());
					} catch (NullPointerException e1) {
						patientLabel.setText("Patient: None");
					}
					try {
						doctorLabel.setText("Prev Doctor: " + _ctrl.getDoctorData(dni.get(1)).getFullName());
					} catch (NullPointerException e1) {
						doctorLabel.setText("Prev Doctor: None");
					}
					try {
						newLabel.setText("New Doctor: " + _ctrl.getDoctorData(dni.get(2)).getFullName());
					} catch (NullPointerException e1) {
						newLabel.setText("New Doctor: None");
					}
					descText.setText(_ctrl.getReason(selection.getSelectedItem().toString()));

				}
			}
		}
				);
		selection.setSelectedIndex(0);
		main.add(selector, BorderLayout.NORTH);

		JPanel center = new JPanel();
		center.setLayout(new BorderLayout());
		JPanel inside = new JPanel();
		inside.setLayout(new BorderLayout());
		center.add(inside, BorderLayout.CENTER);
		main.add(center, BorderLayout.CENTER);

		patientLabel = new JLabel();
		try {
			patientLabel.setText("Patient: " + _ctrl.getPatientData(dni.get(0)).getFullName());
		} catch (NullPointerException e1) {
			patientLabel.setText("Patient: None");
		}
		inside.add(patientLabel,BorderLayout.NORTH);

		doctorLabel = new JLabel();
		try {
			doctorLabel.setText("Prev Doctor: " + _ctrl.getDoctorData(dni.get(1)).getFullName());
		} catch (NullPointerException e1) {
			doctorLabel.setText("Prev Doctor: None");
		}
		inside.add(doctorLabel,BorderLayout.CENTER);


		newLabel = new JLabel();
		try {
			newLabel.setText("New Doctor: " + _ctrl.getDoctorData(dni.get(2)).getFullName());
		} catch (NullPointerException e1) {
			newLabel.setText("New Doctor: None");
		}
		inside.add(newLabel,BorderLayout.SOUTH);

		descText = new JTextArea();
		descText.setPreferredSize(new Dimension(120, 120));
		descText.setText(_ctrl.getReason(selection.getSelectedItem().toString()));


		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout(20, 10));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(100,30));
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DoctorChangeRequestAproverDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					_ctrl.aproveChange(selection.getSelectedItem().toString());
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error while confirming", JOptionPane.ERROR_MESSAGE);
				}
				DoctorChangeRequestAproverDialog.this.dispose();
			}

		});

		buttons.add(okButton, BorderLayout.EAST);

		main.add(buttons, BorderLayout.SOUTH);

		add(main);

		setVisible(true);
		setSize(new Dimension(300,120));
	}
}
