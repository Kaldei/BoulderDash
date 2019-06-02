package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Rock;

public class SpriteTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	Rock rock;

	@Before
	public void setUp() throws Exception {
		this.rock = new Rock();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetImageName() {
		final String SExpected = "Rock.png";
		assertEquals(SExpected, this.rock.getSprite().getImageName());

	}

	@Test
	public void testgetConsoleImage() {
		final char CExpected = 'O';
		assertEquals(CExpected, this.rock.getSprite().getConsoleImage());
	}

}
