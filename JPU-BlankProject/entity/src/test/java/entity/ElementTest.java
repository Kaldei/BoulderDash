package entity;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Diamond;
import entity.mobile.MyPlayer;
import entity.mobile.Rock;

public class ElementTest {



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
	public void testgetPermeability() {
		final Permeability PExpected = Permeability.PUSHING;
		assertEquals(PExpected,this.rock.getPermeability());
	}

	@Test
	public void testgetSprite() {
		final Sprite SExpected = new Sprite('O', "Rock.png");
		assertEquals(SExpected,this.rock.getSprite());
	}
}
