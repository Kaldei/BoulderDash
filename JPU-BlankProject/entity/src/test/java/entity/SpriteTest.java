package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.mobile.Rock;

/**
 * @author Laetitia
 *
 */
public class SpriteTest {

	Rock rock;

	/**
	 * Instanciates a new rock
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		this.rock = new Rock();
	}

	/**
	 *  test get the image
	 */
	@Test
	public void testgetImageName() {
		final String SExpected = "Rock.png";
		assertEquals(SExpected, this.rock.getSprite().getImageName());

	}

	/**
	 * test the get console image
	 */
	@Test
	public void testgetConsoleImage() {
		final char CExpected = 'O';
		assertEquals(CExpected, this.rock.getSprite().getConsoleImage());
	}

}
