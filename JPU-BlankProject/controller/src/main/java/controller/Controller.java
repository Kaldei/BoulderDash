package controller;

import java.io.IOException;
import java.util.Random;

import contract.IOrderPerformer;
import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
import entity.Permeability;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

/**
 * @author Anthony
 *
 */

public final class Controller implements IBoulderDashController, IOrderPerformer {

	/** 
	 * The speed  
	 * */
	private static final int speed = 100;

	/** 
	 * The view 
	 * */
	private IView view;

	/** 
	 * The model 
	 * */
	private IModel model;

	/** 
	 * stakckOrder 
	 * */
	private UserOrder stackOrder;
	
	
	/** 
	 * The diamonds counter 
	 * */
	private int diamondsCounter = 10;

	/** 
	 * The random 
	 * */
	Random rand = new Random();
	
	/** 
	 * The diretion for Red Monsters
	 * */
	private int rdirection;
	
	/** 
	 * The diretion for Green Monsters
	 * */
	private int gDirection;

	/**
	 * @param view
	 * @param model
	 */
	public Controller(final IView view, final IModel model) {
		this.setView(view);
		this.setModel(model);
		this.clearStackOrder();
	}

	/** 
	 * Play method 
	 * */
	@Override
	public final void play() throws InterruptedException {
		while (this.getModel().getMyPlayer().isAlive() == true) {
			Thread.sleep(speed);
			switch (this.getStackOrder()) {
			case UP:
				getModel().getMyPlayer().moveUp();

				break;
			case DOWN:
				getModel().getMyPlayer().moveDown();

				break;
			case RIGHT:
				getModel().getMyPlayer().moveRight();

				break;
			case LEFT:
				getModel().getMyPlayer().moveLeft();

				break;
			case NOP:
			default:
				this.getModel().getMyPlayer().doNothing();
				break;
			}
			this.clearStackOrder();
			this.getView().followMyPlayer();
			getView().updateView();
			this.getModel().getMap().gravity();
			this.getModel().getMap().gravityDiag();
			this.getModel().getMap().gravityD();
			this.getModel().getMap().gravityDiagD();
			killMonster();
			killPlayer();

			if ((getModel().getMap()
					.getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY())))
					.getPermeability() == Permeability.WIN)
					&& getModel().getMyPlayer().getDiamonds() >= diamondsCounter) {
				getView().displayMessage("You win, Congratulations !");
				break;
			}

			this.MonsterRMove();
			this.MonsterGMove();

			gDirection = gDirection + 1;
			rdirection = rand.nextInt(4);
		}
	}

	/**
	 * @throws InterruptedException
	 */
	public void MonsterRMove() throws InterruptedException {
		Thread.sleep(speed);
		switch (rdirection) {
		case 1:
			MRMoveRight();
			break;
		case 0:
			MRMoveLeft();
			break;
		case 2:
			MRMoveUp();
			break;
		case 3:
			MRMoveDown();
			break;

		default:
			break;
		}

	}
	
	/**
	 * MonsterG Move method
	 */
	public void MonsterGMove() {
		if (gDirection <= 10) { 
		MGMoveRight();
		} else if (gDirection <= 20) {
			MGMoveLeft();
		} else {
			gDirection = 0;
		}
			
	}

	/**	
	 * Monster MoveRight method 
	 * */
	public void MGMoveRight() {
		for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
			for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'G' && this
						.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterG(), x + 1, y);
				}
			}
		}
	}

	
	/**
	 * MonsterG Move Left Method
	 */
	public void MGMoveLeft() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'G' && this
						.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterG(), x - 1, y);
				}
			}
		}
	}
	
	/**	
	 * Monster Move Right method 
	 * */
	public void MRMoveRight() {
		for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
			for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'X' && this
						.getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x + 1, y);
				}
			}
		}
	}

	
	/**
	 * MonsterR Move Left method
	 */
	public void MRMoveLeft() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'X' && this
						.getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x - 1, y);
				}
			}
		}
	}

	/**
	 * MonsterR Move Up method
	 */
	public void MRMoveUp() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'X' && this
						.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x, y - 1);
				}
			}
		}
	}

	/**
	 * MonsterR Move Down method
	 */
	public void MRMoveDown() {
		for (int y = this.getModel().getMap().getHeight() - 1; y > 0; y--) {
			for (int x = this.getModel().getMap().getWidth() - 1; x > 0; x--) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage() == 'X' && this
						.getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.getModel().getMap().setOnTheMapXY(MobileElementsFactory.createMonsterR(), x, y + 1);
				}
			}
		}
	}

	/**
	 * orderPerform method
	 */
	@Override
	public final void orderPerform(final UserOrder userOrder) throws IOException {
		this.setStackOrder(userOrder);
	}

	/**
	 * @return
	 */
	private IView getView() {
		return this.view;
	}

	/**
	 * @param view
	 */
	private void setView(final IView view) {
		this.view = view;
	}

	/**
	 * @return
	 */
	private IModel getModel() {
		return this.model;
	}

	/**
	 * @param model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}

	/**
	 * @return
	 */
	private UserOrder getStackOrder() {
		return this.stackOrder;
	}

	/**
	 * @param stackOrder
	 */
	private void setStackOrder(final UserOrder stackOrder) {
		this.stackOrder = stackOrder;
	}

	/**
	 * clearStackOrder method
	 */
	private void clearStackOrder() {
		this.stackOrder = UserOrder.NOP;
	}

	/**
	 * getOrderPerformer method
	 */
	@Override
	public IOrderPerformer getOrderPerformer() {
		return this;
	}

	/**
	 * killPlayer method
	 */
	public void killPlayer() {
		if ((getModel().getMap().getOnTheMapXY((getModel().getMyPlayer().getX()), ((getModel().getMyPlayer().getY())))
				.getPermeability() == Permeability.KILLING)) {
			getModel().getMyPlayer().die();
			getView().displayMessage("Game Over");
		}
	}

	/**
	 * killMonster method
	 */
	public void killMonster() {
		for (int x = 0; x < this.getModel().getMap().getWidth(); x++) {
			for (int y = 0; y < this.getModel().getMap().getHeight(); y++) {
				if (this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLING
						&& this.getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability() == Permeability.PUSHING
						|| this.getModel().getMap().getOnTheMapXY(x, y).getPermeability() == Permeability.KILLING
								&& this.getModel().getMap().getOnTheMapXY(x, y - 1)
										.getPermeability() == Permeability.DIAMOND) {
					this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);

					// Test if Wall x-1
					if ((getModel().getMap().getOnTheMapXY(x - 1, y).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x - 1, y);
					}

					// Test if Wall x-1 / y+1
					if ((getModel().getMap().getOnTheMapXY(x - 1, y + 1).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x - 1,
								y + 1);
					}

					// Test if Wall x / y+1
					if ((getModel().getMap().getOnTheMapXY(x, y + 1).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y + 1);
					}

					// Test if Wall x+1 / y+1
					if ((getModel().getMap().getOnTheMapXY(x + 1, y + 1).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x + 1,
								y + 1);
					}

					// Test if Wall x+1 / y
					if ((getModel().getMap().getOnTheMapXY(x + 1, y).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x + 1, y);
					}

					// Test if Wall x+1 / y-1
					if ((getModel().getMap().getOnTheMapXY(x + 1, y - 1).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x + 1,
								y - 1);
					}

					// Test if Wall x / y-1
					if ((getModel().getMap().getOnTheMapXY(x, y - 1).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y - 1);
					}

					// Test if Wall x-1 / y-1
					if ((getModel().getMap().getOnTheMapXY(x - 1, y - 1).getPermeability()) != Permeability.BLOCKING) {
						this.getModel().getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), x - 1,
								y - 1);
					}
				}
			}
		}
	}
}
