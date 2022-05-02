package model.adminDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.DBConnector;
import model.Enums.HealthInsuranceType;

public class GetInsurancePricesDAO {

	private final static int NUM_INSURANCES = 2;

	public static double[] execute() throws SQLException {
		double[] prices = new double[NUM_INSURANCES];

		Connection con = DBConnector.connectdb();

		String sql = "SELECT price FROM health_insurances WHERE insurance_type = ?";
		PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
		st.setString(1, HealthInsuranceType.SINGLE.toString());
		st.execute();

		ResultSet resultSet = st.getResultSet();
		if (resultSet.next()) {
			prices[0] = resultSet.getDouble("price");
		}
		st.close();


		String sql2 = "SELECT price FROM health_insurances WHERE insurance_type = ?";
		PreparedStatement st2 = con.prepareStatement(sql2, Statement.RETURN_GENERATED_KEYS);
		st2.setString(1, HealthInsuranceType.FAMILIAR.toString());
		st2.execute();

		ResultSet resultSet2 = st2.getResultSet();
		if (resultSet2.next()) {
			prices[1] = resultSet2.getDouble("price");
		}
		st2.close();


		con.close();
		return prices;
	}

}
