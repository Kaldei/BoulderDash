package entity;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

import entity.mobile.Boulder;

public class ElementTest {

	
	static Boulder boulder;
	
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		boulder = new Boulder();
	}

	@Test
	public void testgetPermeability() {
		final Permeability PExpected = Permeability.BOULDER;
		assertEquals(PExpected, boulder.getPermeability());
	}

	@Test
	public void testgetSprite() {
		assertNotNull(boulder.getSprite());
	}
}
