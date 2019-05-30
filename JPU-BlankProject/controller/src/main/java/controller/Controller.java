package controller;

import java.io.IOException;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;

/**
 * The Class Controller.
 */
public final class Controller implements IBoulderDashController, IOrderPerformer{

	/** The Constant speed */
	private static final int speed = 500;
	
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
	public final void play() throws InterruptedException{
		while (this.getModel().getMyPlayer().isAlive() == true) {
			Thread.sleep(speed);	 
			switch (this.getStackOrder()) {
				case UP:
					this.getModel().getMyPlayer().moveUp();
					break;
				case DOWN:
					this.getModel().getMyPlayer().moveDown();
					break;
				case RIGHT:
					this.getModel().getMyPlayer().moveRight();
					break;
				case LEFT:
					this.getModel().getMyPlayer().moveLeft();
					break;
				case NOP: 
				default: 
					this.getModel().getMyPlayer().doNothing();
					break;
				}
				this.clearStackOrder();
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
	
	
}
