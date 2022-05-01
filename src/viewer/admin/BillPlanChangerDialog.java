package viewer.admin;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import control.Controller;

public class BillPlanChangerDialog extends JDialog {

	private Controller _ctrl;

	public BillPlanChangerDialog(Controller ctrl) {
		this._ctrl = ctrl;
		initGUI();
	}

	private void initGUI() {
		pack();
		setPreferredSize(new Dimension(300, 200));
		setLocationRelativeTo(null);
		setLayout(new BorderLayout());
		add(new JLabel("Select a plan"), BorderLayout.NORTH);

		JPanel main = new JPanel();
		main.setLayout(new BorderLayout());

		JPanel selector = new JPanel();
		selector.setLayout(new FlowLayout());

		selector.add(new JLabel("Plan: "));
		DefaultComboBoxModel<String> model = new DefaultComboBoxModel<String>();
		List<String> doctors = _ctrl.getPlanList();
		for (String i : doctors) {
			model.addElement(i);
		}
		JComboBox<String> selection = new JComboBox<String>(model);
		selection.setPreferredSize(new Dimension (80, 20));
		selector.add(selection);
		main.add(selector, BorderLayout.CENTER);

		JPanel putter = new JPanel();
		putter.setLayout(new FlowLayout());

		putter.add(new JLabel("Bill: "));
		JTextArea price = new JTextArea();
		price.setPreferredSize(new Dimension(80, 20));
		putter.add(price);

		main.add(putter, BorderLayout.SOUTH);
		JPanel buttons = new JPanel();
		buttons.setLayout(new BorderLayout(20, 10));

		JButton cancelButton = new JButton("Cancel");
		cancelButton.setPreferredSize(new Dimension(100,30));
		cancelButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				BillPlanChangerDialog.this.dispose();
			}

		});
		buttons.add(cancelButton, BorderLayout.WEST);

		JButton okButton = new JButton("Ok");
		okButton.setPreferredSize(new Dimension(100,30));
		okButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_ctrl.changeBillPlan(selection.getSelectedItem().toString(), price.getText());
				BillPlanChangerDialog.this.dispose();
			}

		});

		buttons.add(okButton, BorderLayout.EAST);

		add(buttons, BorderLayout.SOUTH);

		add(main, BorderLayout.CENTER);

		setVisible(true);
		setSize(new Dimension(300,140));
	}

}
