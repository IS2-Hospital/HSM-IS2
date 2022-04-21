package viewer;

import javax.swing.JOptionPane;

public class ErrorHandler {

	public static void showError(String string, String string2) {
		JOptionPane.showMessageDialog(null, string, string2
				, JOptionPane.ERROR_MESSAGE);
	}

}
