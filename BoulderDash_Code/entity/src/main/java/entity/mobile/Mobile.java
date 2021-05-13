package entity.mobile;

import java.awt.Point;

import fr.exia.showboard.IBoard;
import entity.Element;
import entity.IMap;
import entity.Permeability;
import entity.Sprite;

/**
 * <h1>The Mobile Class.</h1>
 *
 * @author Laetitia
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

	/**
	 * The XY
	 */
	private Point position;

	/** The alive. */
	private Boolean alive = true;

	/** The road. */
	private IMap map;

	/** The board. */
	private IBoard board;

	/**
	 * Instantiates a new mobile.
	 *
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 * 
	 * @param sprite
	 * @param permeability
	 */
	Mobile(final Sprite sprite, final Permeability permeability) {
		super(sprite, permeability);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x
	 * @param y
	 * @param sprite
	 * @param map
	 * @param permeability
	 */
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}

	/*
	 * Move up
	 * 
	 */
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	/*
	 * Move left
	 * 
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	/*
	 * Move down
	 * 
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	/*
	 * Move right
	 * 
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	/*
	 * do nothing
	 * 
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * Sets the has moved.
	 */
	protected void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/*
	 * Gets the X
	 * 
	 */
	@Override
	public final int getX() {
		return this.getPosition().x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x the new x
	 */
	public final void setX(final int x) {
		this.getPosition().x = x;

	}

	/*
	 * Gets the Y
	 * 
	 */
	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 */
	public final void setY(final int y) {
		this.getPosition().y = y;

	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the new map
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/*
	 * 
	 * 
	 */
	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	/**
	 * Dies.
	 */
	public void die() {
		this.alive = false;
		this.setHasMoved();
	}

	/*
	 * Gets the position
	 * 
	 */
	@Override
	public Point getPosition() {
		return this.position;
	}

	/**
	 * Sets the position.
	 *
	 * @param position the position to set
	 */
	public void setPosition(final Point position) {
		this.position = position;
	}

	/**
	 * Gets the board.
	 *
	 * @return the board
	 */
	protected IBoard getBoard() {
		return this.board;
	}

}
