package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;

public class ChangeBillPlanDAO {

	public static void execute(String typeName, double newBill) throws SQLException {
		Connection adminConex = DBConnector.connectdb();

		PreparedStatement st = adminConex.prepareStatement("UPDATE health_insurances SET price = "+ newBill + " Where insurance_type = '" + typeName + "'", Statement.RETURN_GENERATED_KEYS);
		st.execute();

		adminConex.close();
	}
}
