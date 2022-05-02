package viewer.admin;

import java.awt.event.ActionEvent;

import javax.swing.JPanel;

import control.Controller;
import model.exceptions.sqlExeptions.SqlConnectionException;
import viewer.MainWindow;


public class AdminPanel extends JPanel {

	private static final long serialVersionUID = 1L;

	Controller _ctrl;
	MainWindow _mainWindow;

	public AdminPanel(Controller ctrl, MainWindow mainWindow) throws SqlConnectionException {
		_ctrl = ctrl;
		_mainWindow = mainWindow;

		initGUI();
	}

	private void initGUI() {

		northpanel = new javax.swing.JPanel();
		logoButton = new misc.RSButtonMetro();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
		nameLabel = new javax.swing.JLabel();
		leftpanel = new javax.swing.JPanel();
		leftSubPanel = new javax.swing.JPanel();
		leftMenu = new javax.swing.JPanel();
		patientListButton = new misc.RSButtonMetro();
		doctorListButton = new misc.RSButtonMetro();
		doctorPatientsButton = new misc.RSButtonMetro();
		modifyPatientButton = new misc.RSButtonMetro();
		modDoctorButton = new misc.RSButtonMetro();
		ansreqButton = new misc.RSButtonMetro();
		assignDoctorButton = new misc.RSButtonMetro();

		centerPanel = new javax.swing.JPanel();
		voidCenterPanel = new javax.swing.JPanel();
		southpanel = new javax.swing.JPanel();
		aboutUsButton = new misc.RSButtonMetro();
		signOutButton = new misc.RSButtonMetro();

		setBackground(new java.awt.Color(0, 0, 0));
		setMinimumSize(new java.awt.Dimension(985, 561));
		setOpaque(false);
		setLayout(new java.awt.BorderLayout());

		northpanel.setPreferredSize(new java.awt.Dimension(967, 50));
		northpanel.setLayout(new javax.swing.BoxLayout(northpanel, javax.swing.BoxLayout.X_AXIS));

		logoButton.setBackground(new java.awt.Color(242, 242, 242));
		logoButton.setForeground(new java.awt.Color(8, 72, 135));
		logoButton.setIcon(new javax.swing.ImageIcon(("resources/icons/logo45x45.png")));
		logoButton.setText("Pablo's Clinic");
		logoButton.setColorHover(new java.awt.Color(242, 242, 242));
		logoButton.setColorNormal(new java.awt.Color(242, 242, 242));
		logoButton.setColorPressed(new java.awt.Color(242, 242, 242));
		logoButton.setColorTextHover(new java.awt.Color(8, 72, 135));
		logoButton.setColorTextNormal(new java.awt.Color(8, 72, 135));
		logoButton.setColorTextPressed(new java.awt.Color(8, 72, 135));
		logoButton.setFocusPainted(false);
		logoButton.setFont(new java.awt.Font("Tahoma", 1, 24));
		logoButton.setMaximumSize(new java.awt.Dimension(300, 45));
		logoButton.setPreferredSize(new java.awt.Dimension(220, 35));
		logoButton.setRolloverEnabled(false);
		logoButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				logoButtonActionPerformed(evt);
			}
		});
		northpanel.add(logoButton);
		northpanel.add(filler1);

		nameLabel.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

		add(northpanel, java.awt.BorderLayout.PAGE_START);

		leftpanel.setPreferredSize(new java.awt.Dimension(220, 364));//l

		leftSubPanel.setBackground(new java.awt.Color(216, 216, 216));
		leftSubPanel.setLayout(new java.awt.BorderLayout());

		leftMenu.setBackground(new java.awt.Color(214, 214, 214));
		leftMenu.setPreferredSize(new java.awt.Dimension(220, 364));

		patientListButton.setBackground(new java.awt.Color(214, 214, 214));
		patientListButton.setForeground(new java.awt.Color(51, 51, 51));
		patientListButton.setIcon(new javax.swing.ImageIcon(("resources/icons/patient.png"))); // NOI18N
		patientListButton.setText("Patient List");
		patientListButton.setColorHover(new java.awt.Color(138, 202, 234));
		patientListButton.setColorNormal(new java.awt.Color(214, 214, 214));
		patientListButton.setColorPressed(new java.awt.Color(138, 202, 234));
		patientListButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		patientListButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		patientListButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		patientListButton.setFocusPainted(false);
		patientListButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		patientListButton.setRolloverEnabled(false);
		patientListButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				patientListButtonActionPerformed(evt);
			}
		});

		doctorListButton.setForeground(new java.awt.Color(51, 51, 51));
		doctorListButton.setIcon(new javax.swing.ImageIcon(("resources/icons/doctor.png"))); // NOI18N
		doctorListButton.setText("Doctor List");
		doctorListButton.setColorHover(new java.awt.Color(138, 202, 234));
		doctorListButton.setColorNormal(new java.awt.Color(214, 214, 214));
		doctorListButton.setColorPressed(new java.awt.Color(138, 202, 234));
		doctorListButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		doctorListButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		doctorListButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		doctorListButton.setFocusPainted(false);
		doctorListButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		doctorListButton.setRolloverEnabled(false);
		doctorListButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doctorListButtonActionPerformed(evt);
			}
		});

		doctorPatientsButton.setForeground(new java.awt.Color(51, 51, 51));
		doctorPatientsButton.setIcon(new javax.swing.ImageIcon(("resources/icons/patient.png"))); // NOI18N
		doctorPatientsButton.setText("Doctor Patients");
		doctorPatientsButton.setColorHover(new java.awt.Color(138, 202, 234));
		doctorPatientsButton.setColorNormal(new java.awt.Color(214, 214, 214));
		doctorPatientsButton.setColorPressed(new java.awt.Color(138, 202, 234));
		doctorPatientsButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		doctorPatientsButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		doctorPatientsButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		doctorPatientsButton.setFocusPainted(false);
		doctorPatientsButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		doctorPatientsButton.setRolloverEnabled(false);
		doctorPatientsButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doctorPatientsButtonActionPerformed(evt);
			}
		});

		modifyPatientButton.setForeground(new java.awt.Color(51, 51, 51));
		modifyPatientButton.setIcon(new javax.swing.ImageIcon("resources/icons/modifyPatient.png"));
		modifyPatientButton.setText("Modify Patient");
		modifyPatientButton.setColorHover(new java.awt.Color(138, 202, 234));
		modifyPatientButton.setColorNormal(new java.awt.Color(214, 214, 214));
		modifyPatientButton.setColorPressed(new java.awt.Color(138, 202, 234));
		modifyPatientButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		modifyPatientButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		modifyPatientButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		modifyPatientButton.setFocusPainted(false);
		modifyPatientButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		modifyPatientButton.setRolloverEnabled(false);
		modifyPatientButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//new PatientModificatorDialog(_ctrl);
				modPacientButtonButtonActionPerformed(evt);
			}
		});

		modDoctorButton.setForeground(new java.awt.Color(51, 51, 51));
		modDoctorButton.setIcon(new javax.swing.ImageIcon(("resources/icons/ModifyDoctor.png"))); // NOI18N
		modDoctorButton.setText("Modify Doctor");
		modDoctorButton.setColorHover(new java.awt.Color(138, 202, 234));
		modDoctorButton.setColorNormal(new java.awt.Color(214, 214, 214));
		modDoctorButton.setColorPressed(new java.awt.Color(138, 202, 234));
		modDoctorButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		modDoctorButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		modDoctorButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		modDoctorButton.setFocusPainted(false);
		modDoctorButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		modDoctorButton.setRolloverEnabled(false);
		modDoctorButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				//new DoctorModificatorDialog(_ctrl);
			}
		});

		ansreqButton.setForeground(new java.awt.Color(51, 51, 51));
		ansreqButton.setIcon(new javax.swing.ImageIcon(("resources/icons/doctorChangeRequest.png"))); // NOI18N
		ansreqButton.setText("DR Change Request");
		ansreqButton.setColorHover(new java.awt.Color(138, 202, 234));
		ansreqButton.setColorNormal(new java.awt.Color(214, 214, 214));
		ansreqButton.setColorPressed(new java.awt.Color(138, 202, 234));
		ansreqButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		ansreqButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		ansreqButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		ansreqButton.setFocusPainted(false);
		ansreqButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		ansreqButton.setRolloverEnabled(false);
		ansreqButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				ansreqButtonactionPerformed(evt);
			}
		});

		assignDoctorButton.setForeground(new java.awt.Color(51, 51, 51));
		assignDoctorButton.setIcon(new javax.swing.ImageIcon(("resources/icons/assignDoctor.png"))); // NOI18N
		assignDoctorButton.setText("Assign Doctor");
		assignDoctorButton.setColorHover(new java.awt.Color(138, 202, 234));
		assignDoctorButton.setColorNormal(new java.awt.Color(214, 214, 214));
		assignDoctorButton.setColorPressed(new java.awt.Color(138, 202, 234));
		assignDoctorButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		assignDoctorButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		assignDoctorButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		assignDoctorButton.setFocusPainted(false);
		assignDoctorButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		assignDoctorButton.setRolloverEnabled(false);
		assignDoctorButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				//new DoctorAssignDialog(_ctrl);
			}
		});

		javax.swing.GroupLayout leftMenuLayout = new javax.swing.GroupLayout(leftMenu);
		leftMenu.setLayout(leftMenuLayout);
		leftMenuLayout.setHorizontalGroup(
				leftMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftMenuLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(leftMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(patientListButton, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(doctorListButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(doctorPatientsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(modifyPatientButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(modDoctorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(ansreqButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(assignDoctorButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								)
						.addContainerGap(35, Short.MAX_VALUE))
				);
		leftMenuLayout.setVerticalGroup(
				leftMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftMenuLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(patientListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(doctorListButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(doctorPatientsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(modifyPatientButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(modDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(ansreqButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(assignDoctorButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						)
				);

		leftSubPanel.add(leftMenu, java.awt.BorderLayout.PAGE_START);

		javax.swing.GroupLayout leftpanelLayout = new javax.swing.GroupLayout(leftpanel);
		leftpanel.setLayout(leftpanelLayout);
		leftpanelLayout.setHorizontalGroup(
				leftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftpanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(leftSubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);
		leftpanelLayout.setVerticalGroup(
				leftpanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftpanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(leftSubPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addContainerGap())
				);

		add(leftpanel, java.awt.BorderLayout.LINE_START);

		centerPanel.setLayout(new java.awt.BorderLayout());

		javax.swing.GroupLayout voidCenterPanelLayout = new javax.swing.GroupLayout(voidCenterPanel);
		voidCenterPanel.setLayout(voidCenterPanelLayout);
		voidCenterPanelLayout.setHorizontalGroup(
				voidCenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 765, Short.MAX_VALUE)
				);
		voidCenterPanelLayout.setVerticalGroup(
				voidCenterPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGap(0, 527, Short.MAX_VALUE)
				);

		centerPanel.add(voidCenterPanel, java.awt.BorderLayout.CENTER);

		add(centerPanel, java.awt.BorderLayout.CENTER);

		southpanel.setPreferredSize(new java.awt.Dimension(30, 30));
		java.awt.FlowLayout flowLayout1 = new java.awt.FlowLayout(java.awt.FlowLayout.RIGHT, 5, 0);
		flowLayout1.setAlignOnBaseline(true);
		southpanel.setLayout(flowLayout1);

		aboutUsButton.setForeground(new java.awt.Color(51, 51, 51));
		aboutUsButton.setText("About Us");
		aboutUsButton.setColorHover(new java.awt.Color(242, 242, 242));
		aboutUsButton.setColorNormal(new java.awt.Color(242, 242, 242));
		aboutUsButton.setColorPressed(new java.awt.Color(242, 242, 242));
		aboutUsButton.setColorTextHover(new java.awt.Color(8, 72, 135));
		aboutUsButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		aboutUsButton.setColorTextPressed(new java.awt.Color(8, 72, 135));
		aboutUsButton.setFocusPainted(false);
		aboutUsButton.setPreferredSize(new java.awt.Dimension(80, 35));
		aboutUsButton.setRolloverEnabled(false);
		aboutUsButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				aboutUsButtonActionPerformed(evt);
			}
		});
		southpanel.add(aboutUsButton);

		signOutButton.setForeground(new java.awt.Color(51, 51, 51));
		signOutButton.setText("Sign Out");
		signOutButton.setColorHover(new java.awt.Color(242, 242, 242));
		signOutButton.setColorNormal(new java.awt.Color(242, 242, 242));
		signOutButton.setColorPressed(new java.awt.Color(242, 242, 242));
		signOutButton.setColorTextHover(new java.awt.Color(8, 72, 135));
		signOutButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		signOutButton.setColorTextPressed(new java.awt.Color(8, 72, 135));
		signOutButton.setFocusPainted(false);
		signOutButton.setPreferredSize(new java.awt.Dimension(80, 35));
		signOutButton.setRolloverEnabled(false);
		signOutButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				signOutButtonActionPerformed(evt);
			}
		});
		southpanel.add(signOutButton);

		add(southpanel, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>

	private void signOutButtonActionPerformed(java.awt.event.ActionEvent evt) {

	}

	private void aboutUsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		//setCenterPanel(aboutUsPanel);
	}

	private void patientListButtonActionPerformed(java.awt.event.ActionEvent evt) {
		setCenterPanel(PatientListPanel.getInstace(_ctrl));
	}

	private void doctorListButtonActionPerformed(java.awt.event.ActionEvent evt) {
		setCenterPanel(DoctorListPanel.getInstace(_ctrl));
	}

	private void doctorPatientsButtonActionPerformed(java.awt.event.ActionEvent evt){
		setCenterPanel(DoctorPatientsPanel.getInstace(_ctrl));
	}

	private void modPacientButtonButtonActionPerformed(java.awt.event.ActionEvent evt){
		setCenterPanel(PacientModPanel.getInstace(_ctrl));
	}

	private void ansreqButtonactionPerformed(ActionEvent evt) {
		setCenterPanel(DoctorChangeRequestAproverPanel.getInstance(_ctrl));
	}

	private void logoButtonActionPerformed(java.awt.event.ActionEvent evt) {
		_mainWindow.signOut();
	}


	// Variables declaration - do not modify
	private misc.RSButtonMetro aboutUsButton;
	private misc.RSButtonMetro signOutButton;
	private misc.RSButtonMetro doctorPatientsButton;
	private misc.RSButtonMetro doctorListButton;
	private misc.RSButtonMetro patientListButton;
	private misc.RSButtonMetro modifyPatientButton;
	private misc.RSButtonMetro modDoctorButton;
	private misc.RSButtonMetro ansreqButton;
	private misc.RSButtonMetro assignDoctorButton;
	private javax.swing.JPanel centerPanel;
	private javax.swing.Box.Filler filler1;
	private javax.swing.JPanel leftMenu;
	private javax.swing.JPanel leftSubPanel;
	private javax.swing.JPanel leftpanel;
	private misc.RSButtonMetro logoButton;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JPanel northpanel;
	private javax.swing.JPanel southpanel;
	private javax.swing.JPanel voidCenterPanel;
	// End of variables declaration

	public void setCenterPanel(JPanel p) {
		centerPanel.removeAll();
		centerPanel.add(p);
		p.revalidate();
		p.repaint();
	}

}
