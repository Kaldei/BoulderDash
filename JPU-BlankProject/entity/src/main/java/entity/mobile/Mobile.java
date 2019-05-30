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
 * @author Jade
 * @version 0.3
 */
abstract class Mobile extends Element implements IMobile {

	/**
	 * The x.
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
	 * @param sprite       the sprite
	 * @param road         the road
	 * @param permeability the permeability
	 */
	Mobile(final Sprite sprite, final IMap map, final Permeability permeability) {
		super(sprite, permeability);
		this.setMap(map);
		this.position = new Point();
	}
	
	Mobile(final Sprite sprite, final Permeability permeability) {
		super(sprite, permeability);
		this.position = new Point();
	}

	/**
	 * Instantiates a new mobile.
	 *
	 * @param x            the x
	 * @param y            the y
	 * @param sprite       the sprite
	 * @param road         the road
	 * @param permeability the permeability
	 */
	Mobile(final int x, final int y, final Sprite sprite, final IMap map, final Permeability permeability) {
		this(sprite, map, permeability);
		this.setX(x);
		this.setY(y);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveUp()
	 */
	@Override
	public void moveUp() {
		this.setY(this.getY() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveLeft()
	 */
	@Override
	public void moveLeft() {
		this.setX(this.getX() - 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveDown()
	 */
	@Override
	public void moveDown() {
		this.setY(this.getY() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#moveRight()
	 */
	@Override
	public void moveRight() {
		this.setX(this.getX() + 1);
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#doNothing()
	 */
	@Override
	public void doNothing() {
		this.setHasMoved();
	}

	/**
	 * Sets the has moved.
	 */
	private void setHasMoved() {
		this.getMap().setMobileHasChanged();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getX()
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
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getY()
	 */
	@Override
	public final int getY() {
		return this.getPosition().y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y the new y, as the road is an infinite loop, there's a modulo based
	 *          on the road height.
	 */
	public final void setY(final int y) {
		this.getPosition().y = y;
		
	}

	/**
	 * Gets the road.
	 *
	 * @return the road
	 */
	public IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the road.
	 *
	 * @param road the new road
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isAlive()
	 */
	@Override
	public Boolean isAlive() {
		return this.alive;
	}

	/**
	 * Dies.
	 */
	protected void die() {
		this.alive = false;
		this.setHasMoved();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#isCrashed()
	 */
	// @Override
	// public Boolean isCrashed() {
	// return this.getRoad().getOnTheRoadXY(this.getX(),
	// this.getY()).getPermeability() == Permeability.BLOCKING;
	// }

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.IPawn#getPosition()
	 */
	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.mobile.IMobile#getPosition()
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