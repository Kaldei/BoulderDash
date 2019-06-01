package controller;

import java.io.IOException;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.Permeability;


/**
 * The Class Controller.
 */
public final class Controller implements IBoulderDashController, IOrderPerformer {

	/** The Constant speed */
	private static final int speed = 100;

	/** The view. */
	private IView view;

	/** The model. */
	private IModel model;

	/** The stack order */
	private UserOrder stackOrder;
	
	private int diamondsCounter = 10;

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
				getModel().getMyPlayer().moveUp();
				killPlayer();
			
				break;
			case DOWN:
				getModel().getMyPlayer().moveDown();
				killPlayer();
				
				break;
			case RIGHT:
				getModel().getMyPlayer().moveRight();
				killPlayer();
				
				break;
			case LEFT:
				getModel().getMyPlayer().moveLeft();
				killPlayer();
				
				break;
			case NOP:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}
			this.clearStackOrder();
			this.getView().followMyPlayer();
			
			getView().updateView();
			getModel().getMyPlayer().coordCailloux();
			
			if ((getModel().getMap().getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY())))
					.getPermeability() == Permeability.WIN) && getModel().getMyPlayer().getDiamonds() >= diamondsCounter) {
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


	// Monster
	public void killPlayer() {
		if ((getModel().getMap().getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY())))
				.getPermeability() == Permeability.KILLING)) {
			getModel().getMyPlayer().die();
			getView().displayMessage("Game Over");
		}
	}
}
