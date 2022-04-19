package viewer.admin;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import control.Controller;

public class PatientModWindowPassword extends PatientModWindow{

	Controller _ctrl;
	JTextField password;

	public PatientModWindowPassword(Controller _ctrl, String dni) {
		super(_ctrl, dni);
		this._ctrl = _ctrl;
	}

	@Override
	protected JPanel initGUI() {
		setMinimumSize(new Dimension(280, 450));
		JPanel panel = new JPanel();
		panel.add(super.initGUI());
		JPanel aux = new JPanel();
		aux.setLayout(new FlowLayout());
		aux.add(new JLabel ("Password: "));
		password = new JTextField();
		password.setPreferredSize(new Dimension(80,20));
		password.setText("");
		aux.add(password);
		panel.add(aux);
		return panel;
	}

	@Override
	protected void commit() {
		if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor (PatientModWindowPassword.this),
				"Are you sure you want to commit the data?", "Commit", JOptionPane.YES_NO_OPTION )){
			List<String> colData = getIntroducedData();
			if (colData.size() != 12) {
				JOptionPane.showMessageDialog(null, "Not enough arguments",
						"Error on data collection", JOptionPane.ERROR_MESSAGE);
			}
			else {
				try {
					_ctrl.updatePatient(colData);
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage(),
							"Error on Query", JOptionPane.ERROR_MESSAGE);
				}
				PatientModWindowPassword.this.dispose();
			}
		}
	}

	@Override
	public List<String> getIntroducedData(){
		List<String> data = super.getIntroducedData();
		data.add(password.getText());
		return data;
	}
}
