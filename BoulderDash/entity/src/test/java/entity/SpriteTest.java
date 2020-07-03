package entity;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Rock;

/**
 * @author Laetitia
 *
 */
public class SpriteTest {

	static Rock rock;

	/**
	 * Instanciates a new rock
	 * @throws Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rock = new Rock();
	}
	

	/**
	 *  test get the image
	 */
	@Test
	public void testgetImageName() {
		final String SExpected = "Rock.png";
		assertEquals(SExpected, rock.getSprite().getImageName());

	}

	/**
	 * test the get console image
	 */
	@Test
	public void testgetConsoleImage() {
		final char CExpected = 'O';
		assertEquals(CExpected, rock.getSprite().getConsoleImage());
	}

}
