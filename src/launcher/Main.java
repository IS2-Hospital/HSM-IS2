package launcher;

import javax.swing.SwingUtilities;

import control.Controller;
import model.userManagment.LoginAuthenticator;
import model.userManagment.UserManager;
import model.userManagment.UserRegisterer;
import viewer.MainWindow;

public class Main {

	private static void startGUIMode() throws Exception {
		UserManager userManager = new UserManager(new LoginAuthenticator(), new UserRegisterer());
		Controller ctrl = new Controller(userManager);

		SwingUtilities.invokeAndWait(new Runnable() {
			@Override
			public void run() {
				new MainWindow(ctrl);
			}
		});
	}

	public static void main(String[] args) {
		try {
			startGUIMode();
		} catch (Exception e) {
			System.err.println("Something went wrong ...");
			System.err.println();
			e.printStackTrace();
		}
	}
}
