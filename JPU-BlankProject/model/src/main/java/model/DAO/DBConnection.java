package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

	private static String URL = "jdbc:mysql://localhost/javabdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	private static String USER = "root";
	private static String PASSWD = "";

	private Connection connection = null;

	private DBConnection INSTANCE;

	public DBConnection getInstance() {
		if (INSTANCE != null) {
			INSTANCE = new DBConnection();
		}
		return INSTANCE;
	}

	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Connexion etablished !");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() {
		return connection;
	}
}