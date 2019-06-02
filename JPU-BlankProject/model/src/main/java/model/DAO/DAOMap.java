package model.DAO;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOMap {

	private DBConnection MyConnection;
	private String txt = "C:\\Users\\Antho\\git\\Project-5\\JPU-BlankProject\\model\\src\\main\\resources\\map.txt";

	public DAOMap() {
		this.MyConnection = new DBConnection();
		this.MyConnection.connect();
	}

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