package viewer;

import java.sql.SQLException;

import javax.swing.JOptionPane;

import control.Controller;
import model.Appointment;
import model.Enums.UserRole;
import model.doctorDAO.CancelAppointmentDoctorDAO;
import model.patientDAO.CancelAppointmentPatientDAO;

public class CancelAppointmentPanel {

	private String dni;
	private Controller ctrl;
	private UserRole role;
	private Appointment ap;

	public CancelAppointmentPanel (String dni, Controller ctrl, UserRole role, Appointment ap) {
		this.ctrl = ctrl;
		this.dni = dni;
		this.role = role;
		this.ap = ap;
		try {
			initComponents();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	private void initComponents() throws SQLException {
		String msg = "Are you sure you want to cancel the appointment at: " + ap.getDay() + " " + ap.getHour() + "?";
		if(JOptionPane.showConfirmDialog(null, msg, "Exit", JOptionPane.YES_NO_OPTION ) == JOptionPane.YES_OPTION) {
			if(role == UserRole.DOCTOR)
				CancelAppointmentDoctorDAO.execute(ap, dni);
			else
				CancelAppointmentPatientDAO.execute(ap, dni);
		}
	}
}
