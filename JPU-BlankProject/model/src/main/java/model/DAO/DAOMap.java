package model.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Laetitia
 *
 */
public class DAOMap {

	/**
	 * The connection
	 */
	private DBConnection MyConnection;
	private String txt = "C:\\Users\\calde\\git\\Project-Java-BoulderDash\\JPU-BlankProject\\model\\src\\main\\resources\\map.txt";

	/**
	 * Instantiates DAO map
	 */
	public DAOMap() {
		this.MyConnection = new DBConnection();
		this.MyConnection.connect();
	}

	/**
	 * load the level
	 * @param id
	 * @throws IOException
	 */
	public void loadlevel(int id) throws IOException {

		try {

			String sql = "{call maplevel(?)}";
			CallableStatement call = MyConnection.getConnection().prepareCall(sql);
			call.setInt(1, id);
			call.execute();
			final ResultSet resultSet = call.getResultSet();
			while (resultSet.next()) {
				BufferedWriter writer = new BufferedWriter(new FileWriter(txt));
				writer.write(resultSet.getString(1));
				writer.close();
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}