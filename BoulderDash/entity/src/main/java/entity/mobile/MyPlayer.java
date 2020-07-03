package entity.mobile;

import java.io.IOException;

import entity.IMap;
import entity.Permeability;
import entity.Sprite;
import entity.motionless.MotionlessElementsFactory;

/**
 * <h1>The MyVehicle Class.</h1>
 *
 * @author Laetitia
 */
public class MyPlayer extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite sprite = new Sprite('H', "PNope.png");

	/** The Constant spriteTurnLeft. */
	private static final Sprite spriteTurnLeft = new Sprite('H', "PLeft.png");

	/** The Constant spriteTurnRight. */
	private static final Sprite spriteTurnRight = new Sprite('H', "PRight.png");
	/** The Constant spriteTurnUp. */
	private static final Sprite spriteTurnUp = new Sprite('H', "PUp.png");
	/** The Constant spriteTurnDown. */
	private static final Sprite spriteTurnDown = new Sprite('H', "PDown.png");
	/** The Constant spriteDead. */
	private static final Sprite spriteDead = new Sprite('H', "PDead.png");

	/**
	 * Instantiates a new my player.
	 *
	 * @param x   the x
	 * @param y   the y
	 * @param map the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public MyPlayer(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.BLOCKING);
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnUp.loadImage();
		spriteTurnDown.loadImage();
		spriteDead.loadImage();
	}

	/*
	 * move left for player
	 * 
	 */
	@Override
	public final void moveLeft() {
		if ((getMap().getOnTheMapXY((getX() - 1), ((getY()))).getPermeability() == Permeability.BLOCKING)
				|| (getMap().getOnTheMapXY((getX() - 1), ((getY()))).getPermeability() == Permeability.PUSHING)) {
			doNothing();
			pushRockLeft();
			this.setSprite(spriteTurnLeft);

		} else {
			super.moveLeft();
			this.setSprite(spriteTurnLeft);
			removeGround();
			getDiamond();
			this.setHasMoved();
		}
	}

	/**
	 * move right for player
	 */
	@Override
	public final void moveRight() {
		if (getMap().getOnTheMapXY(getX() + 1, getY()).getPermeability() == Permeability.BLOCKING
				|| (getMap().getOnTheMapXY((getX() + 1), ((getY()))).getPermeability() == Permeability.PUSHING)) {
			doNothing();
			pushRockRight();
			this.setSprite(spriteTurnRight);
		} else {
			super.moveRight();
			this.setSprite(spriteTurnRight);
			removeGround();
			getDiamond();
			this.setHasMoved();
		}
	}

	/**
	 * move down for player
	 */
	public final void moveDown() {
		if ((getMap().getOnTheMapXY((getX()), (getY() + 1)).getPermeability() != Permeability.BLOCKING)
				&& (getMap().getOnTheMapXY((getX()), (getY() + 1))).getPermeability() != Permeability.PUSHING) {
			super.moveDown();
			this.setSprite(spriteTurnDown);
			removeGround();
			getDiamond();
			this.setHasMoved();
		} else {
			doNothing();
		}
	}

	/**
	 * move up for the player
	 */
	public final void moveUp() {
		if ((getMap().getOnTheMapXY((getX()), (getY() - 1)).getPermeability() != Permeability.BLOCKING)
				&& (getMap().getOnTheMapXY((getX()), (getY() - 1))).getPermeability() != Permeability.PUSHING) {
			super.moveUp();
			this.setSprite(spriteTurnUp);
			removeGround();
			getDiamond();
			this.setHasMoved();
		} else {
			doNothing();
		}
	}

	/*
	 * player dies
	 * 
	 */
	@Override
	public final void die() {
		super.die();
		this.setSprite(spriteDead);
	}

	/*
	 * player does nothing
	 * 
	 */
	@Override
	public final void doNothing() {
		super.doNothing();
		this.setSprite(sprite);
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.PUSHING) {
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX(), this.getY() - 1);
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
		}
	}

	/**
	 * removes ground
	 */
	public void removeGround() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DISAPPEAR) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
			this.setHasMoved();

		}

	}

	int nb_diamonds;

	/**
	 * gets the diamond
	 */
	public int getDiamonds() {
		return nb_diamonds;
	}

	/**
	 * gets the diamond
	 */
	public void getDiamond() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DIAMOND) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
			nb_diamonds++;
			System.out.println("You have " + nb_diamonds + " Diamonds !");
			this.setHasMoved();
			if (nb_diamonds == 10) {
				System.out.println("go win !");
			}
		}
	}

	/**
	 * push rock to right
	 */
	public void pushRockRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.PUSHING && this
				.getMap().getOnTheMapXY(this.getX() + 2, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX() + 1, this.getY());
			super.moveRight();
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX() + 1, this.getY());
			this.setHasMoved();
		}
	}

	/**
	 * push rock to left
	 */
	public void pushRockLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.PUSHING && this
				.getMap().getOnTheMapXY(this.getX() - 2, this.getY()).getPermeability() == Permeability.PENETRABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX() - 1, this.getY());
			super.moveLeft();
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX() - 1, this.getY());
			this.setHasMoved();
		}
	}

}
