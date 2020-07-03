package entity.mobile;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Before;
import org.junit.Test;

import entity.IMap;


/**
 * @author Laetitia
 *
 */
public class MobileTest {

	int IExpected;
	MyPlayer myplayer;
	Boolean BExpected;
	IMap map;
	IMobile player ;

	
	/**
	 * Instanciates the new player
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
;		this.myplayer = new MyPlayer(1, 2, map);
		
	}


	/**
	 * test the get X
	 */
	@Test
	public void testgetX() {
		IExpected = 1;
		assertEquals(this.IExpected, this.myplayer.getX());
	}

	/**
	 * test the get Y
	 */
	@Test
	public void testgetY() {
		IExpected = 2;
		assertEquals(this.IExpected, this.myplayer.getY());
	}

	/**
	 * test the position
	 */
	@Test
	public void testposition() {
		final Point PExpected = new Point(1, 2);
		assertEquals(PExpected, this.myplayer.getPosition());
	}
	/*
	@Test
	public void testmoveRight() {
		fail();
		this.myplayer.moveRight();
		IExpected = 2;
		assertEquals(this.IExpected, this.myplayer.getX());
	}*/
	
	/*@Test
	public void testdie() {
		fail();
		BExpected = false ;
		this.myplayer.die();
		assertEquals(this.BExpected,this.myplayer.isAlive());
	}
	*/

}
