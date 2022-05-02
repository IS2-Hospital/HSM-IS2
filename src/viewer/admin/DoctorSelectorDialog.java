package viewer.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;
import javax.swing.border.TitledBorder;

import control.Controller;
import launcher.Main;
import model.Doctor;
import model.Patient;

public class DoctorSelectorDialog extends JDialog {
	private Controller _ctrl;
	public DoctorSelectorDialog(Controller _ctrl) {
		this._ctrl = _ctrl;
		initGUI();
	}
	public void initGUI(){
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
				DoctorSelectorDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Patient> resultSet;
				try {
					resultSet = _ctrl.resultAllPatientsFrom((String)selection.getSelectedItem());

					JFrame popUp = new JFrame();
					JPanel content = new JPanel();
					content.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Doctors", TitledBorder.CENTER, TitledBorder.TOP));

					JTable table = new JTable ();//new UserListTableModel(resultSet));
					table.setPreferredSize(new Dimension(700,700));
					JScrollPane scroll = new JScrollPane(table);
					scroll.setPreferredSize(new Dimension (800, 700));
					content.add( scroll);

					content.setPreferredSize(new Dimension(800,600));
					content.setSize(new Dimension(800,600));
					popUp.setSize(new Dimension(850,700));
					popUp.setContentPane(content);
					popUp.setVisible(true);
					popUp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
					DoctorSelectorDialog.this.dispose();

				} catch (SQLException e2) {
					JOptionPane.showMessageDialog(SwingUtilities.getWindowAncestor(DoctorSelectorDialog.this), e2.getMessage(), "", JOptionPane.ERROR_MESSAGE);

					if (Main.SHOW_EXCEPTIONS_TRACE)
						e2.printStackTrace();
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(DoctorSelectorDialog.this, e1.getMessage(),
							"Database Error", JOptionPane.ERROR_MESSAGE);

					if (Main.SHOW_EXCEPTIONS_TRACE)
						e1.printStackTrace();
				}
			}

		});

		buttons.add(okButton, BorderLayout.EAST);

		main.add(buttons, BorderLayout.SOUTH);

		add(main);

		setVisible(true);
		setSize(new Dimension(300,120));
	}
}
