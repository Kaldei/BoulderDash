package entity.mobile;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import entity.IElement;

public class MobileElementsFactoryTest {

	MobileElementsFactory mobile;
	char expected;

	@Before
	public void setUp() throws Exception {
		this.mobile = new MobileElementsFactory();

	}

	@Test
	public void testGetFromFileSymbol() {
		IElement element = new Rock();
		assertEquals(element.getSprite().getImage(), MobileElementsFactory.getFromFileSymbol('O').getSprite().getImage());
	}

	@Test
	public void testCreateMonsterR() {
		this.expected = 'X';
		assertEquals(expected, MobileElementsFactory.createMonsterR().getSprite().getConsoleImage());
	}

	@Test
	public void testCreateMonsterG() {
		this.expected = 'G';
		assertEquals(expected, MobileElementsFactory.createMonsterG().getSprite().getConsoleImage());
	}

	@Test
	public void testCreateDiamond() {
		this.expected = '*';
		assertEquals(expected, MobileElementsFactory.createDiamond().getSprite().getConsoleImage());
	}

	@Test
	public void testCreateRock() {
		this.expected = 'O';
		assertEquals(expected, MobileElementsFactory.createRock().getSprite().getConsoleImage());

	}

}
