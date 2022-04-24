package viewer.admin;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
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
import model.Doctor;
import model.Patient;
import model.exceptions.sqlExeptions.SqlConnectionException;


public class AdminPanel extends JPanel {

	Controller _ctrl;

	JButton exitButton;
	JButton patientList;
	JButton doctorList;
	JButton doctorPatients;

	private JButton modifyPatientButton;

	private JButton modDoctorButton;

	private JButton ansreqButton;

	private JButton assignDoctor;
	public AdminPanel(Controller ctrl) throws SqlConnectionException {
		_ctrl = ctrl;
		initGUI();
	}

	private void initGUI() throws SqlConnectionException {
		setPreferredSize(new Dimension (600, 500));

		setLayout(new GridLayout(4,3,50,20));

		patientList = new JButton("Patient List");
		patientList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				List<Patient> resultSet = _ctrl.getAllPatients();
				JFrame popUp = new JFrame();
				JPanel content = new JPanel();
				content.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Patients", TitledBorder.CENTER, TitledBorder.TOP));
				try {
					JTable table = new JTable (new UserListTableModel<Patient>(resultSet));
					table.setPreferredSize(new Dimension(700,700));
					JScrollPane scroll = new JScrollPane(table);
					scroll.setPreferredSize(new Dimension (800, 700));
					content.add( scroll);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(AdminPanel.this, e1.getMessage(),
							"Database Error", JOptionPane.ERROR_MESSAGE);
				}
				content.setPreferredSize(new Dimension(800,600));
				content.setSize(new Dimension(800,600));
				popUp.setSize(new Dimension(850,700));
				popUp.setContentPane(content);
				popUp.setVisible(true);
				popUp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}

		});

		doctorList = new JButton("Doctor List");
		doctorList.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				List<Doctor> resultSet = _ctrl.getDoctorList();
				JFrame popUp = new JFrame();
				JPanel content = new JPanel();
				content.setBorder(BorderFactory.createTitledBorder( BorderFactory.createEtchedBorder(), "Doctors", TitledBorder.CENTER, TitledBorder.TOP));
				try {
					JTable table = new JTable (new UserListTableModel(resultSet));
					table.setPreferredSize(new Dimension(700,700));
					JScrollPane scroll = new JScrollPane(table);
					scroll.setPreferredSize(new Dimension (800, 700));
					content.add( scroll);
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(AdminPanel.this, e1.getMessage(),
							"Database Error", JOptionPane.ERROR_MESSAGE);
				}
				content.setPreferredSize(new Dimension(800,600));
				content.setSize(new Dimension(800,600));
				popUp.setSize(new Dimension(850,700));
				popUp.setContentPane(content);
				popUp.setVisible(true);
				popUp.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			}

		});

		doctorPatients = new JButton("Doctor's patients");
		doctorPatients.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DoctorSelectorDialog(_ctrl);
			}

		});

		modifyPatientButton = new JButton("Modify Patient");
		modifyPatientButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new PatientModificatorDialog(_ctrl);
			}

		});

		modDoctorButton = new JButton("Modify Doctor");
		modDoctorButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DoctorModificatorDialog(_ctrl) ;
			}

		});

		ansreqButton = new JButton("Doc Change Requests");
		ansreqButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DoctorChangeRequestAproverDialog(_ctrl);
			}

		});

		assignDoctor = new JButton("Assign Doctor");
		assignDoctor.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new DoctorAssignDialog(_ctrl);
			}

		});

		exitButton = new JButton("Exit");
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (JOptionPane.OK_OPTION == JOptionPane.showConfirmDialog(SwingUtilities.getWindowAncestor (AdminPanel.this),
						"Are you sure you want to close the program?", "Exit", JOptionPane.YES_NO_OPTION ));
				System.exit(0);
			}

		});

		add(patientList);
		add(doctorList);
		add(doctorPatients);

		add(modifyPatientButton);
		add(modDoctorButton);
		add(ansreqButton);

		add(assignDoctor);
		add(new JLabel (""));
		add(new JLabel (""));

		add(new JLabel (""));
		add(exitButton);
		add(new JLabel (""));
	}

}
