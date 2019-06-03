package entity;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.mobile.Rock;

public class ElementTest {

	
	Rock rock;
	
	@Before
	public void setUp() throws Exception {
		this.rock = new Rock();
	}

	@Test
	public void testgetPermeability() {
		final Permeability PExpected = Permeability.PUSHING;
		assertEquals(PExpected,this.rock.getPermeability());
	}

	@Test
	public void testgetSprite() {
		assertNotNull(this.rock.getSprite());
	}
}
