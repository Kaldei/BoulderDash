package entity;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Boulder;

/**
 * @author Laetitia
 *
 */
public class SpriteTest {

	static Boulder boulder;

	/**
	 * Instanciates a new rock
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		boulder = new Boulder();
	}
	

	/**
	 *  test get the image
	 */
	@Test
	public void testgetImageName() {
		final String SExpected = "Rock.png";
		assertEquals(SExpected, boulder.getSprite().getImageName());

	}

	/**
	 * test the get console image
	 */
	@Test
	public void testgetConsoleImage() {
		final char CExpected = 'O';
		assertEquals(CExpected, boulder.getSprite().getConsoleImage());
	}

}
