package model.DAO;

import static org.junit.Assert.*;

import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.mysql.jdbc.Connection;

public class DBConnectionTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	java.sql.Connection connection;
	DAOMap dao = null;

	@Before
	public void setUp() throws Exception, SQLException {
		final String URL = "jdbc:mysql://localhost/javabdd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&autoReconnect=true&useSSL=false";
		final String USER = "root";
		final String PASSWD = "";
		connection = DriverManager.getConnection(URL, USER, PASSWD);

		this.dao = new DAOMap();

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testconnect() throws SQLException {
		final String SExpected = "com.mysql.jdbc.JDBC4Connection@2077d4de";
		dao = null;
		assertEquals(SExpected, this.connection);
	}

}
