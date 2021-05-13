package model.DAO;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;


/**
 * @author Laetitia
 *
 */
public class DBConnectionTest {

	DBConnection DBC;
	final String USER = "root";
	final String PASSWD = "";
	final String URL = "jdbc:mysql://localhost/javabdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
	

	/**
	 * @throws Exception
	 * @throws SQLException
	 */
	@Before
	public void setUp() throws Exception, SQLException {
		this.DBC= new DBConnection();
	}

	/**
	 * Test the connection
	 * @throws SQLException
	 */
	@Test
	public void testconnect() throws SQLException {
		assertNotNull(this.DBC);
	}

	/**
	 * test the get url
	 * @throws SQLException
	 */
	@Test
	public void testgetUrl() throws SQLException {
		assertEquals(this.URL, this.DBC.getURL());
	}
	
	/**
	 * test the get user
	 * @throws SQLException
	 */
	@Test
	public void testgetUser() throws SQLException {
		assertEquals(this.USER, this.DBC.getUSER());
	}
	
	/**
	 * test the get passeword
	 * @throws SQLException
	 */
	@Test
	public void testgetPassword() throws SQLException {
		assertEquals(this.PASSWD, this.DBC.getPASSWD());
	}
	
	
	/**
	 * test the get instance
	 */
	@Test
	public void testGetInstance() {
		final String expected = "com.mysql.jdbc.JDBC4Connection@2077d4de";
		assertNotNull(expected, DBC.toString());
	}
	
}
