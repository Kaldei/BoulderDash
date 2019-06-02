package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;

/**
 * @author Laetitia
 *
 */
public class DBConnection {

	/**
	 * the database url
	 */
	private static String URL = "jdbc:mysql://localhost/javabdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	/**
	 * the user
	 */
	private static String USER = "root";
	/**
	 * the password 
	 */
	private static String PASSWD = "";

	private Connection connection = null;

	private DBConnection INSTANCE;

	/**
	 * Gets the instance
	 * @return
	 */
	public DBConnection getInstance() {
		if (INSTANCE != null) {
			INSTANCE = new DBConnection();
		}
		return INSTANCE;
	}

	/**
	 * Connects to the database
	 */
	public void connect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection(URL, USER, PASSWD);
			System.out.println("Connexion etablished !");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Gets the connection
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
}