
package viewer.pacient;

/**
 *
 * @author Pablopar
 */
public class AboutUsPanel extends javax.swing.JPanel {

	/**
	 * Creates new form AboutUsPanel
	 */
	public AboutUsPanel() {
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

		toolsUsedLabel = new javax.swing.JLabel();
		ourTeamLabel = new javax.swing.JLabel();
		titleLabel = new javax.swing.JLabel();
		jSeparator1 = new javax.swing.JSeparator();
		whoLabel = new javax.swing.JLabel();
		jScrollPane1 = new javax.swing.JScrollPane();
		jTextArea1 = new javax.swing.JTextArea();
		jScrollPane2 = new javax.swing.JScrollPane();
		jTextArea2 = new javax.swing.JTextArea();
		jScrollPane3 = new javax.swing.JScrollPane();
		jTextArea3 = new javax.swing.JTextArea();
		infoPanel = new javax.swing.JPanel();
		jLabel5 = new javax.swing.JLabel();
		jLabel6 = new javax.swing.JLabel();

		setBackground(new java.awt.Color(255, 255, 255));
		setBorder(javax.swing.BorderFactory.createCompoundBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204), new java.awt.Color(153, 153, 153), new java.awt.Color(204, 204, 204)), javax.swing.BorderFactory.createTitledBorder(null, "About Us", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.ABOVE_TOP, new java.awt.Font("Segoe UI", 0, 12), new java.awt.Color(204, 204, 204)))); // NOI18N
		setName(""); // NOI18N
		setPreferredSize(new java.awt.Dimension(934, 483));

		toolsUsedLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
		toolsUsedLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		toolsUsedLabel.setIcon(new javax.swing.ImageIcon("/resources/AboutImages/DatabaseImage.png")); // NOI18N
		toolsUsedLabel.setText("Tools Used");
		toolsUsedLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		toolsUsedLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		toolsUsedLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		ourTeamLabel.setFont(new java.awt.Font("Times New Roman", 0, 12)); // NOI18N
		ourTeamLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		ourTeamLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/resources/AboutImages/OurTeam.jpg"))); // NOI18N
		ourTeamLabel.setText("Our Team");
		ourTeamLabel.setVerticalAlignment(javax.swing.SwingConstants.BOTTOM);
		ourTeamLabel.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
		ourTeamLabel.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

		titleLabel.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
		titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
		titleLabel.setText("About Pablo's Clinic");

		whoLabel.setFont(new java.awt.Font("Times New Roman", 0, 18)); // NOI18N
		whoLabel.setText("Who are we?");

		jTextArea1.setColumns(20);
		jTextArea1.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
		jTextArea1.setRows(5);
		jTextArea1.setText("We are a team of young developers that are trying to provide people with a system to manage and organize an\nentire hospital's worth of data. \n\nOur objectives are mainly to create an easy to use interface wich we intend to connect to a miain server which \ncontains the relevant data to our patient's well being.");
		jTextArea1.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
		jScrollPane1.setViewportView(jTextArea1);
		jTextArea1.getAccessibleContext().setAccessibleName("");
		jTextArea1.getAccessibleContext().setAccessibleDescription("");

		jTextArea2.setColumns(20);
		jTextArea2.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
		jTextArea2.setRows(5);
		jTextArea2.setText("In order to develop this type of app we had to use many different tools for each tipe of developing challenge\nwe have faced. For instance the main app was made using Eclipse's Java tool and Net beans, very useful\nwhen dealing with UI development. \n\nMySql was used for the main part of the database, as well as Modelio forthe diagrams and outline of internal\ndetails.");
		jScrollPane2.setViewportView(jTextArea2);

		jTextArea3.setColumns(20);
		jTextArea3.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
		jTextArea3.setRows(5);
		jTextArea3.setText("Our team is made out of computer science students from the Universidad Complutense de Madrid who are\nmore than eager to develop tools that should help hospital's organize their data in the most efficient way.\n\nWith various degrees of profciency in programming, graphic design and team organization we believe that\nthis task will bring yet another take on health management that will light up some aspects of this type of \ndata management.");
		jScrollPane3.setViewportView(jTextArea3);

		infoPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153), new java.awt.Color(102, 102, 102), new java.awt.Color(153, 153, 153)));

		jLabel5.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
		jLabel5.setText("More info at      TLF: +34 948 54 89 93");

		jLabel6.setFont(new java.awt.Font("Bahnschrift", 0, 12)); // NOI18N
		jLabel6.setText("E-Mail: pclinic@pablo.es");

		javax.swing.GroupLayout infoPanelLayout = new javax.swing.GroupLayout(infoPanel);
		infoPanel.setLayout(infoPanelLayout);
		infoPanelLayout.setHorizontalGroup(
				infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(infoPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addComponent(jLabel5)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jLabel6)
						.addContainerGap(26, Short.MAX_VALUE))
				);
		infoPanelLayout.setVerticalGroup(
				infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(infoPanelLayout.createSequentialGroup()
						.addContainerGap()
						.addGroup(infoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel6)
								.addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				);

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		this.setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(55, 55, 55)
										.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGap(51, 51, 51)
										.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 859, javax.swing.GroupLayout.PREFERRED_SIZE))
								.addGroup(layout.createSequentialGroup()
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addGroup(layout.createSequentialGroup()
														.addGap(51, 51, 51)
														.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
																.addComponent(toolsUsedLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
																.addComponent(ourTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
														.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED))
												.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
														.addContainerGap()
														.addComponent(whoLabel)
														.addGap(36, 36, 36)))
										.addGap(56, 56, 56)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(infoPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jScrollPane3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 593, javax.swing.GroupLayout.PREFERRED_SIZE))))
						.addContainerGap(20, Short.MAX_VALUE))
				);
		layout.setVerticalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap()
						.addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(18, 18, 18)
						.addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGap(43, 43, 43)
										.addComponent(whoLabel)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 59, Short.MAX_VALUE)
										.addComponent(ourTeamLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18))
								.addGroup(layout.createSequentialGroup()
										.addGap(18, 18, 18)
										.addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(30, 30, 30)
										.addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(toolsUsedLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGroup(layout.createSequentialGroup()
										.addGap(22, 22, 22)
										.addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
										.addGap(18, 18, 18)
										.addComponent(infoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
				);

		toolsUsedLabel.getAccessibleContext().setAccessibleDescription("");

		getAccessibleContext().setAccessibleName("");
	}// </editor-fold>


	// Variables declaration - do not modify
	private javax.swing.JPanel infoPanel;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JScrollPane jScrollPane1;
	private javax.swing.JScrollPane jScrollPane2;
	private javax.swing.JScrollPane jScrollPane3;
	private javax.swing.JSeparator jSeparator1;
	private javax.swing.JTextArea jTextArea1;
	private javax.swing.JTextArea jTextArea2;
	private javax.swing.JTextArea jTextArea3;
	private javax.swing.JLabel ourTeamLabel;
	private javax.swing.JLabel titleLabel;
	private javax.swing.JLabel toolsUsedLabel;
	private javax.swing.JLabel whoLabel;
	// End of variables declaration
}
