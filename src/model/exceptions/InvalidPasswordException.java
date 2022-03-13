package model.exceptions;

@SuppressWarnings("serial")
public class InvalidPasswordException extends LoginException{
	
	private final static String PASSWORD_ERROR = "Invalid password.";
	
	public InvalidPasswordException() {
		super(PASSWORD_ERROR);
	}
}
