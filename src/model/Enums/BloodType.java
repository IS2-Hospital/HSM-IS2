package model.Enums;

public enum BloodType {
	On, Op, An, Ap, Bn, Bp, ABp, ABn;

	@Override
	public String toString() {
		switch(this) {
		case ABn:
			return "AB-";
		case ABp:
			return "AB+";
		case An:
			return "A-";
		case Ap:
			return "A+";
		case Bn:
			return "B-";
		case Bp:
			return "B+";
		case On:
			return "O-";
		case Op:
			return "O+";
		default:
			return "";
		}
	}

	// Use this instead of .getValue(String s)
	public static BloodType getEnum(String s) {
		switch(s) {
		case "AB-":
			return ABn;
		case "AB+":
			return ABp;
		case "A-":
			return An;
		case "A+":
			return Ap;
		case "B-":
			return Bn;
		case "B+":
			return Bp;
		case "O-":
			return On;
		case "O+":
			return Op;
		default:
			return null;
		}
	}
}
