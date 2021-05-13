package model.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author Laetitia
 *
 */
public class DBConnection {

	/**
	 * the database url
	 */
	private static String URL = "jdbc:mysql://localhost/boulderdash?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=false&useSSL=false";
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
	public void connect() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		connection=DriverManager.getConnection(URL, USER, PASSWD);
	}
	
	/**
	 * Gets the connection
	 * @return
	 */
	public Connection getConnection() {
		return connection;
	}
	
	/**
	 * Gets the URL
	 * @return
	 */
	public String getURL() {
		return URL;
	}

	/**
	 * Gets the user
	 * @return
	 */
	public  String getUSER() {
		return USER;
	}

	/**
	 * Gets the password
	 * @return
	 */
	public  String getPASSWD() {
		return PASSWD;
	}
}