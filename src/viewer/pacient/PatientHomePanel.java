/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package viewer.pacient;

/**
 *
 * @author Pablopar
 */
public class PatientHomePanel extends javax.swing.JPanel {

	/**
	 * Creates new form PatientHomePanel
	 */
	public PatientHomePanel() {
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed" desc="Generated Code">
	private void initComponents() {


		doctorLabel = new javax.swing.JLabel();
		textScroll = new javax.swing.JScrollPane();
		textField = new javax.swing.JTextArea();
		jSeparator1 = new javax.swing.JSeparator();
		imagesPanel = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();
		iconPanel = new javax.swing.JLabel();

		setBackground(new java.awt.Color(204, 204, 204));
		setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createTitledBorder(null, "Home", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Times New Roman", 0, 10), new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, java.awt.Color.white, java.awt.Color.lightGray, java.awt.Color.lightGray, java.awt.Color.darkGray))); // NOI18N

		doctorLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeImages/Doctor.jpg"))); // NOI18N

		textField.setColumns(20);
		textField.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
		textField.setRows(5);
		textField.setText("Welcome to Pablo's Clinic!\n\nYou can use the buttons at the left of the screen in order to see your future appointments, consult\nyour treatments or revise past appointments, pathologies or treatments.\n\nOur doctors will provide the best type of insurance for you and your loved ones.\n\nIf you have any questions you can see more information in the \"About us\" page.");
		textScroll.setViewportView(textField);

		jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
		jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeImages/BrokenToy.jpg"))); // NOI18N
		jLabel5.setText("Customized care for everyone");
		jLabel5.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jLabel5.setVerifyInputWhenFocusTarget(false);
		jLabel5.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
		jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeImages/DoctorItems.jpg"))); // NOI18N
		jLabel4.setText("The best care of the region");
		jLabel4.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jLabel4.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
		jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeImages/DoctorOnline.jpg"))); // NOI18N
		jLabel3.setText("The only one in online format");
		jLabel3.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		jLabel3.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jLabel3.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
		jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/HomeImages/DoctorFamily.jpg"))); // NOI18N
		jLabel6.setText("For you and for your family");
		jLabel6.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		jLabel6.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		javax.swing.GroupLayout imagesPanelLayout = new javax.swing.GroupLayout(imagesPanel);
		imagesPanel.setLayout(imagesPanelLayout);
		imagesPanelLayout.setHorizontalGroup(
				imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagesPanelLayout.createSequentialGroup()
						.addGap(41, 41, 41)
						.addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(12, 12, 12)
						.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(60, 60, 60))
				);
		imagesPanelLayout.setVerticalGroup(
				imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(imagesPanelLayout.createSequentialGroup()
						.addContainerGap(12, Short.MAX_VALUE)
						.addGroup(imagesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)))
				);

		iconPanel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/com/mycompany/proyectois/paneles/LogoHome.png"))); // NOI18N

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addContainerGap()
										.addComponent(jSeparator1))
								.addGroup(layout.createSequentialGroup()
										.addGap(31, 31, 31)
										.addComponent(doctorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(textScroll, javax.swing.GroupLayout.PREFERRED_SIZE, 542, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(iconPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(0, 0, Short.MAX_VALUE))
								.addGroup(layout.createSequentialGroup()
										.addContainerGap(28, Short.MAX_VALUE)
										.addComponent(imagesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 900, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap())
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addContainerGap(13, Short.MAX_VALUE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(doctorLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(iconPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(textScroll, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(imagesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(21, 21, 21))
				);
	}// </editor-fold>


	// Variables declaration - do not modify
	private javax.swing.JLabel doctorLabel;
	private javax.swing.JLabel iconPanel;
	private javax.swing.JPanel imagesPanel;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextArea textField;
	private javax.swing.JScrollPane textScroll;
	// End of variables declaration
}
