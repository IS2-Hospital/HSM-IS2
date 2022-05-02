package model;

public class DoctorChangeRequest {

	private Patient patient;
	private Doctor fromDoctor;
	private Doctor toDoctor;
	private String reason;

	public DoctorChangeRequest(Patient patient, Doctor fromDoctor, Doctor toDoctor, String reason) {
		this.patient = patient;
		this.fromDoctor = fromDoctor;
		this.toDoctor = toDoctor;
		this.reason = reason;
	}

	public Patient getPatient() {
		return patient;
	}

	public Doctor getFromDoctor() {
		return fromDoctor;
	}

	public Doctor getToDoctor() {
		return toDoctor;
	}

	public String getReason() {
		return reason;
	}

}
