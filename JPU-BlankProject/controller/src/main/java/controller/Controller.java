package controller;

import java.io.IOException;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.Element;
import entity.Permeability;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

/**
 * The Class Controller.
 */
public final class Controller implements IBoulderDashController, IOrderPerformer {

	/** The Constant speed */
	private static final int speed = 200;

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/** The stack order */
	private UserOrder stackOrder;

	/**
	 * Instantiates a new controller.
	 *
	 * @param view  the view
	 * @param model the model
	 */

	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/**
	 * Order perform.
	 *
	 * @param controllerOrder the controller order
	 */
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IController#orderPerform(contract.ControllerOrder)
	 */
	@Override
	public final void play() throws InterruptedException {
		while (this.getModel().getMyPlayer().isAlive() == true) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case UP:
				blockableUp();
				killPlayer();
			
				break;
			case DOWN:
				blockableDown();
				killPlayer();
				
				break;
			case RIGHT:
				blockableRight();
				killPlayer();
				
				break;
			case LEFT:
				blockableLeft();
				killPlayer();
				
				break;
			case NOP:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}
			this.clearStackOrder();
			this.getView().followMyPlayer();
			
			// ALED SA MARCHE BG
			getView().test1();
			
			if ((getModel().getMap().getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY())))
					.getPermeability() == Permeability.WIN)) {
				getView().displayMessage("You win, Congratulations !");
				break;
			}
		}
	}

	@Override
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	private IView getView() {
		return this.view;
	}

	private void setView(final IView view) {
		this.view = view;
	}

	private IModel getModel() {
		return this.model;
	}

	private void setModel(final IModel model) {
		this.model = model;
	}

	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	// Mouvement methods

	// Wall and Rock up
	public void blockableUp() {
		if ((getModel().getMap()
				.getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY() - 1)))
				.getPermeability() != Permeability.BLOCKING)
				&& (getModel().getMap()
						.getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY() - 1)))
						.getPermeability() != Permeability.PUSHING)) {
			this.getModel().getMyPlayer().moveUp();
		} else {
			getModel().getMyPlayer().doNothing();
		}
	}

	// Wall and Rock down
	public void blockableDown() {
		if ((getModel().getMap()
				.getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY() + 1)))
				.getPermeability() != Permeability.BLOCKING)
				&& (getModel().getMap()
						.getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY() + 1)))
						.getPermeability() != Permeability.PUSHING)) {
			this.getModel().getMyPlayer().moveDown();
		} else {
			getModel().getMyPlayer().doNothing();
		}
	}

	// Wall and Rock Right
	public void blockableRight() {
		if ((getModel().getMap()
				.getOnTheMapXY((getModel().getMyPlayer().getX() + 1), ((getModel().getMyPlayer().getY())))
				.getPermeability() != Permeability.BLOCKING)
				&& (getModel().getMap()
						.getOnTheMapXY((getModel().getMyPlayer().getX() + 1), ((getModel().getMyPlayer().getY())))
						.getPermeability() != Permeability.PUSHING)) {
			this.getModel().getMyPlayer().moveRight();
		} else {
			getModel().getMyPlayer().doNothing();
		}
	}

	// Wall and Rock left
	public void blockableLeft() {
		if ((getModel().getMap()
				.getOnTheMapXY((getModel().getMyPlayer().getX() - 1), ((getModel().getMyPlayer().getY())))
				.getPermeability() != Permeability.BLOCKING)
				&& (getModel().getMap()
						.getOnTheMapXY((getModel().getMyPlayer().getX() - 1), ((getModel().getMyPlayer().getY())))
						.getPermeability() != Permeability.PUSHING)) {
			this.getModel().getMyPlayer().moveLeft();
		} else {
			getModel().getMyPlayer().doNothing();
		}
	}

	// Monster
	public void killPlayer() {
		if ((getModel().getMap().getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY())))
				.getPermeability() == Permeability.KILLING)) {
			getModel().getMyPlayer().die();
			getView().displayMessage("Game Over");
		}
	}
}
