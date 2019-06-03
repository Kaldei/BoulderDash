package controller;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import contract.IModel;
import contract.IView;
import contract.UserOrder;

public class ControllerTest {

	/**
	 * The view
	 */
	private IView view;

	/**
	 * The model
	 */
	private IModel model;

	/**
	 * The controller
	 */
	private Controller controller;

	/**
	 * stackOrder
	 */
	private UserOrder stackOrder = UserOrder.UP;
	
	/**
	 * @return
	 */
	public UserOrder getStackOrder() {
		return stackOrder;
	}

	/**
	 * @param stackOrder
	 */
	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	/**
	 * @throws Exception
	 */
	@Before
	public void setUp() throws Exception {
		// setup a new controller
		this.controller = new Controller(view, model);
	}

	@After
	public void tearDown() throws Exception {
	}
	
	/**
	 * test the method Play
	 */
	@Test
	public void testPlay() {
		// No test available
		// fail("Not yet implemented");
	}

	/**
	 * @throws IOException
	 */
	@Test
	public void testOrderPerform() throws IOException {

		UserOrder expectedUserOrder = UserOrder.UP;
		controller.orderPerform(expectedUserOrder);
		assertEquals(expectedUserOrder, this.stackOrder);
	}

	/**
	 * test the method GetOrderPerformer
	 */
	@Test
	public void testGetOrderPerformer() {
		assertNotNull(controller.getOrderPerformer());
	}

	/**
	 * Test the method KillPlayer
	 */
	@Test
	public void testKillPlayer() {
		// No test available
		// fail("Not yet implemented");
	}

	/**
	 * Test the method KillMonster
	 */
	@Test
	public void testKillMonster() {
		// No test available
		// fail("Not yet implemented");
	}

	/**
	 * Test the method clearOrder
	 */
	@Test
	public void testClearOrder() {
		//assertEquals(UserOrder.NOP, controller.getOrderPerformer());
	}
}
