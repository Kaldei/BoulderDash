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

	private IView view;

	private IModel model;

	private Controller controller;

	private UserOrder stackOrder = UserOrder.UP;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		this.controller = new Controller(view, model);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testController() {
		// Constructor
	}

	@Test
	public void testPlay() {
		// No test available
		// fail("Not yet implemented");
	}

	@Test
	public void testOrderPerform() throws IOException {

		UserOrder expectedUserOrder = UserOrder.UP;
		controller.orderPerform(expectedUserOrder);
		assertEquals(expectedUserOrder, this.stackOrder);
	}

	@Test
	public void testGetOrderPerformer() {
		assertNotNull(controller.getOrderPerformer());
	}

	@Test
	public void testKillPlayer() {
		// No test available
		// fail("Not yet implemented");
	}

	@Test
	public void testKillMonster() {
		// No test available
		// fail("Not yet implemented");
	}

	@Test
	public void testClearOrder() {
		//assertEquals(UserOrder.NOP, controller.getOrderPerformer());
	}

	public UserOrder getStackOrder() {
		return stackOrder;
	}

	public void setStackOrder(UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

}
