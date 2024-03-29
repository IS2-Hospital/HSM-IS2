package viewer;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.border.TitledBorder;

import control.Controller;
import viewer.doctor.RegPanelDoctor;
import viewer.patient.RegPatientPanel;

/**
 *
 * @author arturomelero in NetBeans
 */

public class RegisterPlanPanel extends javax.swing.JPanel{
	/**
	 * Creates new form NewJFrame
	 */

	private static final String TITLE = "Suscription Plan";

	Controller _ctrl;
	MainWindow _mainWindow;

	public RegisterPlanPanel(Controller ctrl, MainWindow mainWindow) {
		_ctrl = ctrl;
		_mainWindow = mainWindow;
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {

		MainPanel = new javax.swing.JPanel();
		SelectPlanPanel = new javax.swing.JPanel();
		filler3 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 40), new java.awt.Dimension(0, 40), new java.awt.Dimension(32767, 15));
		jSeparator1 = new javax.swing.JSeparator();
		jLabel1 = new javax.swing.JLabel();
		AllPlansPanel = new javax.swing.JPanel();
		IndividualPlanPanel = new javax.swing.JPanel();
		IndivPlanTitle = new javax.swing.JPanel();
		jLabel3 = new javax.swing.JLabel();
		jSeparator2 = new javax.swing.JSeparator();
		IndivPlanText = new javax.swing.JPanel();
		jLabel4 = new javax.swing.JLabel();
		IndivSuscribePanel = new javax.swing.JPanel();
		jLabel2 = new javax.swing.JLabel();
		jButton1 = new javax.swing.JButton();
		filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
		CohabitantsPlanPanel = new javax.swing.JPanel();
		CohPlanTitle = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jSeparator3 = new javax.swing.JSeparator();
		CohPlanText = new javax.swing.JPanel();
		jLabel6 = new javax.swing.JLabel();
		CohSuscribePanel = new javax.swing.JPanel();
		jLabel7 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		filler2 = new javax.swing.Box.Filler(new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 0), new java.awt.Dimension(30, 32767));
		DoctorlPlanPanel = new javax.swing.JPanel();
		DocPlanTitle = new javax.swing.JPanel();
		jLabel8 = new javax.swing.JLabel();
		jSeparator4 = new javax.swing.JSeparator();
		DocPlanText = new javax.swing.JPanel();
		jLabel9 = new javax.swing.JLabel();
		DocSuscribePanel = new javax.swing.JPanel();
		jLabel10 = new javax.swing.JLabel();
		jButton3 = new javax.swing.JButton();
		jPanel1 = new javax.swing.JPanel();
		jLabel11 = new javax.swing.JLabel();
		jButton4 = new javax.swing.JButton();

		this.setLayout(new GridBagLayout());

		MainPanel.setLayout(new java.awt.BorderLayout());
		javax.swing.border.Border innerEmpty = BorderFactory.createEmptyBorder(20, 25, 20, 25);
		javax.swing.border.Border outterTitled = BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.black, 3), TITLE,
				TitledBorder.CENTER, TitledBorder.TOP, new Font("times new roman",Font.PLAIN,12), Color.black);
		MainPanel.setBorder(BorderFactory.createCompoundBorder(outterTitled, innerEmpty));

		SelectPlanPanel.add(filler3);

		jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
		jSeparator1.setForeground(new java.awt.Color(0, 0, 0));
		jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
		jSeparator1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
		jSeparator1.setBounds(new java.awt.Rectangle(264, 59, 20, 40));
		jSeparator1.setMaximumSize(new java.awt.Dimension(5, 30));
		jSeparator1.setMinimumSize(new java.awt.Dimension(5, 30));
		jSeparator1.setPreferredSize(new java.awt.Dimension(2, 30));
		jSeparator1.setRequestFocusEnabled(false);
		SelectPlanPanel.add(jSeparator1);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("Select a plan. We have everything you need!");
		SelectPlanPanel.add(jLabel1);

		MainPanel.add(SelectPlanPanel, java.awt.BorderLayout.PAGE_START);

		IndividualPlanPanel.setBackground(new java.awt.Color(255, 255, 204));
		IndividualPlanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(20, 10, 10, 10)));
		IndividualPlanPanel.setLayout(new java.awt.BorderLayout());

		IndivPlanTitle.setBackground(new java.awt.Color(255, 255, 204));
		IndivPlanTitle.setLayout(new java.awt.BorderLayout());

		jLabel3.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel3.setText("    Individual Plan");
		IndivPlanTitle.add(jLabel3, java.awt.BorderLayout.CENTER);

		jSeparator2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		jSeparator2.setPreferredSize(new java.awt.Dimension(50, 3));
		IndivPlanTitle.add(jSeparator2, java.awt.BorderLayout.PAGE_END);

		IndividualPlanPanel.add(IndivPlanTitle, java.awt.BorderLayout.NORTH);

		IndivPlanText.setBackground(new java.awt.Color(255, 255, 204));
		IndivPlanText.setLayout(new java.awt.GridBagLayout());

		jLabel4.setText("<html> <br>The perfect plan for just yourself, <br>with all the benefits our clinic has<br> to offer.<br> <br> We will love taking care of you <br> for just 30$/month<br>---------------------------");
		IndivPlanText.add(jLabel4, new java.awt.GridBagConstraints());

		IndividualPlanPanel.add(IndivPlanText, java.awt.BorderLayout.CENTER);

		IndivSuscribePanel.setBackground(new java.awt.Color(255, 255, 204));

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
		jLabel2.setText("Suscribe by cliking here    ");
		IndivSuscribePanel.add(jLabel2);

		jButton1.setBackground(new java.awt.Color(255, 204, 153));
		jButton1.setText("Individual's");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				individualPlanActionPerformed(evt);
			}
		});
		IndivSuscribePanel.add(jButton1);

		IndividualPlanPanel.add(IndivSuscribePanel, java.awt.BorderLayout.SOUTH);

		AllPlansPanel.add(IndividualPlanPanel);
		AllPlansPanel.add(filler1);

		CohabitantsPlanPanel.setBackground(new java.awt.Color(255, 255, 204));
		CohabitantsPlanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(20, 10, 10, 10)));
		CohabitantsPlanPanel.setLayout(new java.awt.BorderLayout());

		CohPlanTitle.setBackground(new java.awt.Color(255, 255, 204));
		CohPlanTitle.setLayout(new java.awt.BorderLayout());

		jLabel5.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel5.setText("    Cohabitants Plan");
		CohPlanTitle.add(jLabel5, java.awt.BorderLayout.CENTER);

		jSeparator3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		jSeparator3.setPreferredSize(new java.awt.Dimension(50, 3));
		CohPlanTitle.add(jSeparator3, java.awt.BorderLayout.PAGE_END);

		CohabitantsPlanPanel.add(CohPlanTitle, java.awt.BorderLayout.NORTH);

		CohPlanText.setBackground(new java.awt.Color(255, 255, 204));
		CohPlanText.setLayout(new java.awt.GridBagLayout());

		jLabel6.setText("<html> <br>The perfect plan for you and<br> those you are living with. It's<br>like multiple individual plan!<br> <br> We will love taking care of you <br> for just 20$/month*pp(min 3pp)<br>---------------------------");
		CohPlanText.add(jLabel6, new java.awt.GridBagConstraints());

		CohabitantsPlanPanel.add(CohPlanText, java.awt.BorderLayout.CENTER);

		CohSuscribePanel.setBackground(new java.awt.Color(255, 255, 204));

		jLabel7.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
		jLabel7.setText("Suscribe by cliking here ");
		CohSuscribePanel.add(jLabel7);

		jButton2.setBackground(new java.awt.Color(255, 204, 153));
		jButton2.setText("Cohabitant's");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				cohabitantPlanActionPerformed(evt);
			}
		});
		CohSuscribePanel.add(jButton2);

		CohabitantsPlanPanel.add(CohSuscribePanel, java.awt.BorderLayout.SOUTH);

		AllPlansPanel.add(CohabitantsPlanPanel);
		AllPlansPanel.add(filler2);

		DoctorlPlanPanel.setBackground(new java.awt.Color(204, 255, 255));
		DoctorlPlanPanel.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true), javax.swing.BorderFactory.createEmptyBorder(20, 10, 10, 10)));
		DoctorlPlanPanel.setLayout(new java.awt.BorderLayout());

		DocPlanTitle.setBackground(new java.awt.Color(204, 255, 255));
		DocPlanTitle.setLayout(new java.awt.BorderLayout());

		jLabel8.setBackground(new java.awt.Color(204, 255, 255));
		jLabel8.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
		jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
		jLabel8.setText("    Doctor's Plan");
		DocPlanTitle.add(jLabel8, java.awt.BorderLayout.CENTER);

		jSeparator4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
		jSeparator4.setPreferredSize(new java.awt.Dimension(50, 3));
		DocPlanTitle.add(jSeparator4, java.awt.BorderLayout.PAGE_END);

		DoctorlPlanPanel.add(DocPlanTitle, java.awt.BorderLayout.NORTH);

		DocPlanText.setBackground(new java.awt.Color(204, 255, 255));
		DocPlanText.setLayout(new java.awt.GridBagLayout());

		jLabel9.setText("<html> <br>Are you a interested in working <br> with us? It's your lucky day! We <br> are looking for new personal. <br> <br> We just need to ask you a few<br> cuestions. Prepare your CV!<br>---------------------------");
		DocPlanText.add(jLabel9, new java.awt.GridBagConstraints());

		DoctorlPlanPanel.add(DocPlanText, java.awt.BorderLayout.CENTER);

		DocSuscribePanel.setBackground(new java.awt.Color(204, 255, 255));

		jLabel10.setFont(new java.awt.Font("Tahoma", 0, 13)); // NOI18N
		jLabel10.setText("Suscribe by cliking here    ");
		DocSuscribePanel.add(jLabel10);

		jButton3.setBackground(new java.awt.Color(204, 204, 255));
		jButton3.setText("Doctor's");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				doctorPlanActionPerformed(evt);
			}
		});
		DocSuscribePanel.add(jButton3);

		DoctorlPlanPanel.add(DocSuscribePanel, java.awt.BorderLayout.SOUTH);

		AllPlansPanel.add(DoctorlPlanPanel);

		MainPanel.add(AllPlansPanel, java.awt.BorderLayout.CENTER);

		jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 10, 10, 10));

		jLabel11.setFont(new java.awt.Font("Tahoma", 0, 15)); // NOI18N
		jLabel11.setText("Already have an accout?");
		jPanel1.add(jLabel11);

		jButton4.setText("Login");
		jButton4.addActionListener(new java.awt.event.ActionListener() {
			@Override
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				loginActionPerformed(evt);
			}
		});
		jPanel1.add(jButton4);

		MainPanel.add(jPanel1, java.awt.BorderLayout.SOUTH);

		this.add(MainPanel);

	}// </editor-fold>

	private void individualPlanActionPerformed(java.awt.event.ActionEvent evt) {
		_mainWindow.setContentPane(new RegPatientPanel(_ctrl, _mainWindow, true));
		_mainWindow.revalidate();
		_mainWindow.repaint();
	}

	private void cohabitantPlanActionPerformed(java.awt.event.ActionEvent evt) {
		_mainWindow.setContentPane(new RegPatientPanel(_ctrl, _mainWindow, false));
		_mainWindow.revalidate();
		_mainWindow.repaint();
	}

	private void doctorPlanActionPerformed(java.awt.event.ActionEvent evt) {
		_mainWindow.setContentPane(new RegPanelDoctor(_ctrl, _mainWindow));
		_mainWindow.revalidate();
		_mainWindow.repaint();	}

	private void loginActionPerformed(java.awt.event.ActionEvent evt) {
		_mainWindow.setContentPane(new LoginPanel(_ctrl, _mainWindow));
		_mainWindow.revalidate();
		_mainWindow.repaint();
	}

	// Variables declaration - do not modify
	private javax.swing.JPanel AllPlansPanel;
	private javax.swing.JPanel CohPlanText;
	private javax.swing.JPanel CohPlanTitle;
	private javax.swing.JPanel CohSuscribePanel;
	private javax.swing.JPanel CohabitantsPlanPanel;
	private javax.swing.JPanel DocPlanText;
	private javax.swing.JPanel DocPlanTitle;
	private javax.swing.JPanel DocSuscribePanel;
	private javax.swing.JPanel DoctorlPlanPanel;
	private javax.swing.JPanel IndivPlanText;
	private javax.swing.JPanel IndivPlanTitle;
	private javax.swing.JPanel IndivSuscribePanel;
	private javax.swing.JPanel IndividualPlanPanel;
	private javax.swing.JPanel MainPanel;
	private javax.swing.JPanel SelectPlanPanel;
	private javax.swing.Box.Filler filler1;
	private javax.swing.Box.Filler filler2;
	private javax.swing.Box.Filler filler3;
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JPanel jPanel1;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JSeparator jSeparator2;
	private javax.swing.JSeparator jSeparator3;
	private javax.swing.JSeparator jSeparator4;
	// End of variables declaration
}
