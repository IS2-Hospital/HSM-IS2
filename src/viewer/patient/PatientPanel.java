/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewer.patient;

import javax.swing.JPanel;

import control.Controller;

/**
 *
 * @author reven
 */
public class PatientPanel extends javax.swing.JPanel {

	private String dni;
	private Controller ctrl;

	AppointmentsPanel appointmentsPanel;
	AskForAppointmentPanel askForAppointmentPanel;
	PatientHomePanel homePanel;

	/**
	 * Creates new form PatientPanel
	 * @param dni
	 */
	public PatientPanel(Controller ctrl, String dni) {
		this.ctrl = ctrl;
		this.dni = dni;

		initComponents();

		appointmentsPanel = new AppointmentsPanel(ctrl, dni);
		askForAppointmentPanel = new AskForAppointmentPanel(this);
		homePanel = new PatientHomePanel();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		northpanel = new javax.swing.JPanel();
		logoButton = new misc.RSButtonMetro();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
		nameLabel = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		profileButton = new misc.RSButtonMetro();
		leftpanel = new javax.swing.JPanel();
		leftSubPanel = new javax.swing.JPanel();
		leftMenu = new javax.swing.JPanel();
		homeButton = new misc.RSButtonMetro();
		historyButton = new misc.RSButtonMetro();
		appointButton = new misc.RSButtonMetro();
		leftDownMenu = new javax.swing.JPanel();
		askForButton = new misc.RSButtonMetro();
		treatmentsButton = new misc.RSButtonMetro();
		centerPanel = new javax.swing.JPanel();
		voidCenterPanel = new javax.swing.JPanel();
		southpanel = new javax.swing.JPanel();
		aboutUsButton = new misc.RSButtonMetro();

		setBackground(new java.awt.Color(0, 0, 0));
		setMinimumSize(new java.awt.Dimension(985, 561));
		setOpaque(false);
		setLayout(new java.awt.BorderLayout());

		northpanel.setPreferredSize(new java.awt.Dimension(967, 50));
		northpanel.setLayout(new javax.swing.BoxLayout(northpanel, javax.swing.BoxLayout.X_AXIS));

		logoButton.setBackground(new java.awt.Color(242, 242, 242));
		logoButton.setForeground(new java.awt.Color(8, 72, 135));
		logoButton.setIcon(new javax.swing.ImageIcon(("resources/icons/logo45x45.png"))); // NOI18N
		logoButton.setText("Pablo's Clinic");
		logoButton.setColorHover(new java.awt.Color(242, 242, 242));
		logoButton.setColorNormal(new java.awt.Color(242, 242, 242));
		logoButton.setColorPressed(new java.awt.Color(242, 242, 242));
		logoButton.setColorTextHover(new java.awt.Color(8, 72, 135));
		logoButton.setColorTextNormal(new java.awt.Color(8, 72, 135));
		logoButton.setColorTextPressed(new java.awt.Color(8, 72, 135));
		logoButton.setFocusPainted(false);
		logoButton.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
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
		nameLabel.setText("Ramón Ramirez");
		northpanel.add(nameLabel);

		jSeparator1.setForeground(new java.awt.Color(242, 242, 242));
		jSeparator1.setToolTipText("");
		jSeparator1.setMaximumSize(new java.awt.Dimension(5, 32767));
		jSeparator1.setPreferredSize(new java.awt.Dimension(5, 10));
		northpanel.add(jSeparator1);

		profileButton.setIcon(new javax.swing.ImageIcon(("resources/icons/profile.png"))); // NOI18N
		profileButton.setColorHover(new java.awt.Color(138, 202, 234));
		profileButton.setColorNormal(new java.awt.Color(242, 242, 242));
		profileButton.setColorPressed(new java.awt.Color(138, 202, 234));
		profileButton.setFocusPainted(false);
		profileButton.setPreferredSize(new java.awt.Dimension(45, 35));
		profileButton.setRolloverEnabled(false);
		northpanel.add(profileButton);

		add(northpanel, java.awt.BorderLayout.PAGE_START);

		leftpanel.setPreferredSize(new java.awt.Dimension(220, 364));

		leftSubPanel.setBackground(new java.awt.Color(216, 216, 216));
		leftSubPanel.setLayout(new java.awt.BorderLayout());

		leftMenu.setBackground(new java.awt.Color(214, 214, 214));

		homeButton.setBackground(new java.awt.Color(214, 214, 214));
		homeButton.setForeground(new java.awt.Color(51, 51, 51));
		homeButton.setIcon(new javax.swing.ImageIcon(("resources/icons/home.png"))); // NOI18N
		homeButton.setText("Home");
		homeButton.setColorHover(new java.awt.Color(138, 202, 234));
		homeButton.setColorNormal(new java.awt.Color(214, 214, 214));
		homeButton.setColorPressed(new java.awt.Color(138, 202, 234));
		homeButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		homeButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		homeButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		homeButton.setFocusPainted(false);
		homeButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		homeButton.setRolloverEnabled(false);
		homeButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				homeButtonActionPerformed(evt);
			}
		});

		historyButton.setForeground(new java.awt.Color(51, 51, 51));
		historyButton.setIcon(new javax.swing.ImageIcon(("resources/icons/history.png"))); // NOI18N
		historyButton.setText("Clinic History");
		historyButton.setColorHover(new java.awt.Color(138, 202, 234));
		historyButton.setColorNormal(new java.awt.Color(214, 214, 214));
		historyButton.setColorPressed(new java.awt.Color(138, 202, 234));
		historyButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		historyButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		historyButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		historyButton.setFocusPainted(false);
		historyButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		historyButton.setRolloverEnabled(false);
		historyButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				historyButtonActionPerformed(evt);
			}
		});

		appointButton.setForeground(new java.awt.Color(51, 51, 51));
		appointButton.setIcon(new javax.swing.ImageIcon(("resources/icons/appointments.png"))); // NOI18N
		appointButton.setText("My Appointments");
		appointButton.setColorHover(new java.awt.Color(138, 202, 234));
		appointButton.setColorNormal(new java.awt.Color(214, 214, 214));
		appointButton.setColorPressed(new java.awt.Color(138, 202, 234));
		appointButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		appointButton.setColorTextNormal(new java.awt.Color(51, 51, 51));
		appointButton.setColorTextPressed(new java.awt.Color(51, 51, 51));
		appointButton.setFocusPainted(false);
		appointButton.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		appointButton.setRolloverEnabled(false);
		appointButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				appointButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout leftMenuLayout = new javax.swing.GroupLayout(leftMenu);
		leftMenu.setLayout(leftMenuLayout);
		leftMenuLayout.setHorizontalGroup(
				leftMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftMenuLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(leftMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(homeButton, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
								.addComponent(historyButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(appointButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(35, Short.MAX_VALUE))
				);
		leftMenuLayout.setVerticalGroup(
				leftMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftMenuLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(homeButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(historyButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(appointButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		leftSubPanel.add(leftMenu, java.awt.BorderLayout.PAGE_START);

		leftDownMenu.setBackground(new java.awt.Color(214, 214, 214));

		askForButton.setText("Ask for appointment");
		askForButton.setColorHover(new java.awt.Color(138, 202, 234));
		askForButton.setColorNormal(new java.awt.Color(8, 72, 135));
		askForButton.setColorPressed(new java.awt.Color(8, 72, 135));
		askForButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		askForButton.setColorTextNormal(new java.awt.Color(242, 242, 242));
		askForButton.setColorTextPressed(new java.awt.Color(242, 242, 242));
		askForButton.setFocusPainted(false);
		askForButton.setRolloverEnabled(false);
		askForButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				askForButtonActionPerformed(evt);
			}
		});

		treatmentsButton.setText("My treatments");
		treatmentsButton.setColorHover(new java.awt.Color(138, 202, 234));
		treatmentsButton.setColorNormal(new java.awt.Color(8, 72, 135));
		treatmentsButton.setColorPressed(new java.awt.Color(8, 72, 135));
		treatmentsButton.setColorTextHover(new java.awt.Color(51, 51, 51));
		treatmentsButton.setColorTextNormal(new java.awt.Color(242, 242, 242));
		treatmentsButton.setColorTextPressed(new java.awt.Color(242, 242, 242));
		treatmentsButton.setFocusPainted(false);
		treatmentsButton.setRolloverEnabled(false);
		treatmentsButton.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				treatmentsButtonActionPerformed(evt);
			}
		});

		javax.swing.GroupLayout leftDownMenuLayout = new javax.swing.GroupLayout(leftDownMenu);
		leftDownMenu.setLayout(leftDownMenuLayout);
		leftDownMenuLayout.setHorizontalGroup(
				leftDownMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(leftDownMenuLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(leftDownMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(askForButton, javax.swing.GroupLayout.DEFAULT_SIZE, 188, Short.MAX_VALUE)
								.addComponent(treatmentsButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(14, Short.MAX_VALUE))
				);
		leftDownMenuLayout.setVerticalGroup(
				leftDownMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, leftDownMenuLayout.createSequentialGroup()
						.addGap(12, 12, 12)
						.addComponent(askForButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(treatmentsButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		leftSubPanel.add(leftDownMenu, java.awt.BorderLayout.PAGE_END);

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
		southpanel.add(aboutUsButton);

		add(southpanel, java.awt.BorderLayout.PAGE_END);
	}// </editor-fold>

	private void homeButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void appointButtonActionPerformed(java.awt.event.ActionEvent evt) {
		setCenterPanel(appointmentsPanel);
	}

	private void historyButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void treatmentsButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}

	private void askForButtonActionPerformed(java.awt.event.ActionEvent evt) {
		askForAppointmentPanel.open();
		setCenterPanel(askForAppointmentPanel);
	}

	private void logoButtonActionPerformed(java.awt.event.ActionEvent evt) {
		// TODO add your handling code here:
	}


	// Variables declaration - do not modify
	private misc.RSButtonMetro aboutUsButton;
	private misc.RSButtonMetro appointButton;
	private misc.RSButtonMetro askForButton;
	private javax.swing.JPanel centerPanel;
	private javax.swing.Box.Filler filler1;
	private misc.RSButtonMetro historyButton;
	private misc.RSButtonMetro homeButton;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JPanel leftDownMenu;
	private javax.swing.JPanel leftMenu;
	private javax.swing.JPanel leftSubPanel;
	private javax.swing.JPanel leftpanel;
	private misc.RSButtonMetro logoButton;
	private javax.swing.JLabel nameLabel;
	private javax.swing.JPanel northpanel;
	private misc.RSButtonMetro profileButton;
	private javax.swing.JPanel southpanel;
	private misc.RSButtonMetro treatmentsButton;
	private javax.swing.JPanel voidCenterPanel;
	// End of variables declaration

	public String getDniPatient() {
		return dni;
	}

	public Controller getCtrl() {
		return ctrl;
	}

	public PatientHomePanel getHomePanel() {
		return homePanel;
	}

	public void setCenterPanel(JPanel p) {
		centerPanel.removeAll();
		centerPanel.add(p);
		p.revalidate();
		p.repaint();
	}
}