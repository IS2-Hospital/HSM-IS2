package model.exceptions;

@SuppressWarnings("serial")
public class UserNotFoundException extends LogInException{
	
	private static final String LOGIN_ERROR = "User not found.";
	
	public UserNotFoundException() {
		super(LOGIN_ERROR);
	}
}
