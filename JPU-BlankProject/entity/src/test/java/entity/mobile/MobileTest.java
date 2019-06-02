package entity.mobile;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class MobileTest {

	int IExpected;
	MyPlayer myplayer;
	Boolean BExpected;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.myplayer = new MyPlayer(1, 2, null);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testgetX() {
		IExpected = 1;
		assertEquals(this.IExpected, this.myplayer.getX());
	}

	@Test
	public void testgetY() {
		IExpected = 2;
		assertEquals(this.IExpected, this.myplayer.getY());
	}

	@Test
	public void testposition() {
		final Point PExpected = new Point(1, 2);
		assertEquals(PExpected, this.myplayer.getPosition());
	}
	
	@Test
	public void testmoveRight() {
		IExpected = 2;
		this.myplayer.moveRight();
		assertEquals(this.IExpected, this.myplayer.getX());
	}
	
	@Test
	public void testdie() {
		BExpected = false ;
		this.myplayer.die();
		assertEquals(this.BExpected,this.myplayer.isAlive());
	}

}
