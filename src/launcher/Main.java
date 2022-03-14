package launcher;

import javax.swing.SwingUtilities;

import control.Controller;
import viewer.MainWindow;

public class Main {

	private static void startGUIMode() throws Exception {
		Controller ctrl = new Controller();

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
