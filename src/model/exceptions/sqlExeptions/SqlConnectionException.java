package model.exceptions.sqlExeptions;

import java.sql.SQLException;

@SuppressWarnings("serial")
public class SqlConnectionException extends SQLException {
	public SqlConnectionException() {
		super("[ERROR] Connection failed");
	}
}
