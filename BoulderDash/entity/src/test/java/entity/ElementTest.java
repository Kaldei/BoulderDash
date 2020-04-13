package entity;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Rock;

public class ElementTest {

	
	static Rock rock;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		rock = new Rock();
	}

	@Test
	public void testgetPermeability() {
		final Permeability PExpected = Permeability.PUSHING;
		assertEquals(PExpected,rock.getPermeability());
	}

	@Test
	public void testgetSprite() {
		assertNotNull(rock.getSprite());
	}
}
