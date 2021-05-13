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
	private static final Sprite sprite = new Sprite('H', "pNope.png");
	/** The Constant spriteTurnLeft. */
	private static final Sprite spriteTurnLeft = new Sprite('H', "pLeft.png");
	/** The Constant spriteTurnRight. */
	private static final Sprite spriteTurnRight = new Sprite('H', "pRight.png");
	/** The Constant spriteTurnUp. */
	private static final Sprite spriteTurnUp = new Sprite('H', "pUp.png");
	/** The Constant spriteTurnDown. */
	private static final Sprite spriteTurnDown = new Sprite('H', "pDown.png");
	/** The Constant spriteDead. */
	private static final Sprite spriteDead = new Sprite('H', "pDead.png");
	/** The Constant spriteWin. */
	private static final Sprite spriteWin = new Sprite('H', "pWin.png");

	/** The Diamond counter. */
	private int nb_diamonds;

	/**
	 * Instantiates a new my player.
	 *
	 * @param x   the x
	 * @param y   the y
	 * @param map the map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public MyPlayer(final int x, final int y, final IMap map) throws IOException {
		super(x, y, sprite, map, Permeability.WALL);
		spriteTurnLeft.loadImage();
		spriteTurnRight.loadImage();
		spriteTurnUp.loadImage();
		spriteTurnDown.loadImage();
		spriteDead.loadImage();
		spriteWin.loadImage();
	}


	/**
	 * move left for player
	 * 
	 */
	@Override
	public final void moveLeft() {
		if ((getMap().getOnTheMapXY((getX() - 1), ((getY()))).getPermeability() == Permeability.WALL) || (getMap().getOnTheMapXY((getX() - 1), ((getY()))).getPermeability() == Permeability.BOULDER)) {
			doNothing();
			pushBoulderLeft();
			this.setSprite(spriteTurnLeft);
		} else {
			super.moveLeft();
			this.setSprite(spriteTurnLeft);
			dig();
			grabDiamond();
			this.setHasMoved();
		}
	}

	/**
	 * move right for player
	 */
	@Override
	public final void moveRight() {
		if (getMap().getOnTheMapXY(getX() + 1, getY()).getPermeability() == Permeability.WALL || (getMap().getOnTheMapXY((getX() + 1), ((getY()))).getPermeability() == Permeability.BOULDER)) {
			doNothing();
			pushBoulderRight();
			this.setSprite(spriteTurnRight);
		} else {
			super.moveRight();
			this.setSprite(spriteTurnRight);
			dig();
			grabDiamond();
			this.setHasMoved();
		}
	}

	/**
	 * move down for player
	 */
	public final void moveDown() {
		if ((getMap().getOnTheMapXY((getX()), (getY() + 1)).getPermeability() != Permeability.WALL) && (getMap().getOnTheMapXY((getX()), (getY() + 1))).getPermeability() != Permeability.BOULDER) {
			super.moveDown();
			this.setSprite(spriteTurnDown);
			dig();
			grabDiamond();
			this.setHasMoved();
		} else {
			doNothing();
		}
	}

	/**
	 * move up for the player
	 */
	public final void moveUp() {
		if ((getMap().getOnTheMapXY((getX()), (getY() - 1)).getPermeability() != Permeability.WALL) && (getMap().getOnTheMapXY((getX()), (getY() - 1))).getPermeability() != Permeability.BOULDER) {
			grabDiamond();
			super.moveUp();
			this.setSprite(spriteTurnUp);
			dig();
			grabDiamond();
			this.setHasMoved();
		} else {
			doNothing();
		}
	}

	/**
	 * player dies
	 * 
	 */
	@Override
	public final void die() {
		super.die();
		this.setSprite(spriteDead);
	}

	/**
	 * player wins
	 *
	 */
	@Override
	public final void win() {
		this.setSprite(spriteWin);
	}

	/**
	 * player does nothing
	 * 
	 */
	@Override
	public final void doNothing() {
 		super.doNothing();
		this.setSprite(sprite);
		this.dig();
		this.grabDiamond();
	}

	/**
	 * removes ground
	 */
	public void dig() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DIGGABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
			this.setHasMoved();
		}
	}


	/**
	 * gets the diamond
	 */
	public void grabDiamond() {
		if (this.getMap().getOnTheMapXY(this.getX(), this.getY()).getPermeability() == Permeability.DIAMOND) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX(), this.getY());
			nb_diamonds++;
		}
	}

	/**
	 * push rock to right
	 */
	public void pushBoulderRight() {
		if (this.getMap().getOnTheMapXY(this.getX() + 1, this.getY()).getPermeability() == Permeability.BOULDER && this.getMap().getOnTheMapXY(this.getX() + 2, this.getY()).getPermeability() == Permeability.WALKABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX() + 1, this.getY());
			super.moveRight();
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX() + 1, this.getY());
			this.setHasMoved();
		}
	}

	/**
	 * push rock to left
	 */
	public void pushBoulderLeft() {
		if (this.getMap().getOnTheMapXY(this.getX() - 1, this.getY()).getPermeability() == Permeability.BOULDER && this.getMap().getOnTheMapXY(this.getX() - 2, this.getY()).getPermeability() == Permeability.WALKABLE) {
			this.getMap().setOnTheMapXY(MotionlessElementsFactory.createBackground(), this.getX() - 1, this.getY());
			super.moveLeft();
			this.getMap().setOnTheMapXY(MobileElementsFactory.createRock(), this.getX() - 1, this.getY());
			this.setHasMoved();
		}
	}

	/**
	 * gets the diamond
	 */
	public int getDiamonds() {
		return nb_diamonds;
	}
}
