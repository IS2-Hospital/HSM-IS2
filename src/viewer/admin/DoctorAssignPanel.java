package viewer.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;

import control.Controller;
import launcher.Main;
import model.Doctor;
import model.Patient;

/**
 *
 * @author rodri
 */
@SuppressWarnings("serial")
public class DoctorAssignPanel extends javax.swing.JPanel {

	private static DoctorAssignPanel instance = null;
	private Vector<Patient> patientList;
	private Vector<Doctor> doctorList;
	Controller ctrl;
	/**
	 * Creates new form assignDoctorPanel
	 */
	public DoctorAssignPanel(Controller ctrl) {
		this.ctrl = ctrl;
		initComponents();
	}

	public static DoctorAssignPanel getInstace(Controller ctrl) {
		if (instance == null)
			instance = new DoctorAssignPanel(ctrl);
		instance.open();

		return instance;
	}

	private void open() {
		patientList = ctrl.getAllPatients();
		doctorList = ctrl.getDoctorList();
		patientComboBox.setModel(new DefaultComboBoxModel<>(patientList));
		doctorComboBox.setModel(new DefaultComboBoxModel<>(doctorList));
	}


	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		doctorSelectPanel = new javax.swing.JPanel();
		patientSelectPanel = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		doctorComboBox = new javax.swing.JComboBox<>();
		patientSelectPanel1 = new javax.swing.JPanel();
		jLabel12 = new javax.swing.JLabel();
		patientComboBox = new javax.swing.JComboBox<>();
		ButtonsPanel = new javax.swing.JPanel();
		ok = new misc.RSButtonMetro();

		setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.Y_AXIS));

		doctorSelectPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(0, 0, 0, 0));
		doctorSelectPanel.setLayout(new javax.swing.BoxLayout(doctorSelectPanel, javax.swing.BoxLayout.Y_AXIS));

		patientSelectPanel.setBorder(javax.swing.BorderFactory.createEmptyBorder(150, 1, -90, 1));

		jLabel10.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel10.setForeground(new java.awt.Color(51, 51, 51));
		jLabel10.setText("Select a doctor: ");
		patientSelectPanel.add(jLabel10);

		doctorList = new Vector<>();
		doctorComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(doctorList));
		patientSelectPanel.add(doctorComboBox);

		doctorSelectPanel.add(patientSelectPanel);

		patientSelectPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, -90, 1));

		jLabel12.setFont(new java.awt.Font("Tahoma", 1, 15)); // NOI18N
		jLabel12.setForeground(new java.awt.Color(51, 51, 51));
		jLabel12.setText("Select a patient: ");
		patientSelectPanel1.add(jLabel12);

		patientList = new Vector<>();
		patientComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(patientList));
		patientSelectPanel1.add(patientComboBox);

		doctorSelectPanel.add(patientSelectPanel1);

		add(doctorSelectPanel);

		ok.setText("OK");
		ok.setColorHover(new java.awt.Color(138, 202, 234));
		ok.setColorNormal(new java.awt.Color(8, 72, 135));
		ok.setColorPressed(new java.awt.Color(8, 72, 135));
		ok.setColorTextHover(new java.awt.Color(51, 51, 51));
		ok.setColorTextNormal(new java.awt.Color(242, 242, 242));
		ok.setColorTextPressed(new java.awt.Color(242, 242, 242));
		ok.setFocusPainted(false);
		ok.setRolloverEnabled(false);
		ok.setRolloverEnabled(false);
		ok.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				okActionPerformed(e);
			}
		});
		ButtonsPanel.add(ok);

		add(ButtonsPanel);
	}// </editor-fold>


	protected void okActionPerformed(ActionEvent e) {
		try {
			ctrl.assignPatientDoctor(((Doctor) doctorComboBox.getSelectedItem()).getDni(), ((Patient) patientComboBox.getSelectedItem()).getDni());
			JOptionPane.showMessageDialog(null, "Changes were saved sucessfully", "", JOptionPane.INFORMATION_MESSAGE);
		} catch (SQLException e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage(), "Error while inserting in database", JOptionPane.ERROR_MESSAGE);
			if (Main.SHOW_EXCEPTIONS_TRACE)
				e1.printStackTrace();
		}
		catch (IllegalArgumentException e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage(), "", JOptionPane.ERROR_MESSAGE);
		}
	}


	// Variables declaration - do not modify
	private javax.swing.JPanel ButtonsPanel;
	private javax.swing.JComboBox<Doctor> doctorComboBox;
	private javax.swing.JPanel doctorSelectPanel;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel12;
	private misc.RSButtonMetro ok;
	private javax.swing.JComboBox<Patient> patientComboBox;
	private javax.swing.JPanel patientSelectPanel;
	private javax.swing.JPanel patientSelectPanel1;
	// End of variables declaration
}