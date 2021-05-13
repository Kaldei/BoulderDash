package entity.mobile;

import entity.Permeability;
import entity.Sprite;

/**
 * <h1> The Diamond class</h1>
 * @author Laetitia
 *
 */
public class Diamond extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('*', "diamond.png");


	/**
	 * Instantiates a new obstacle.
	 */
	 Diamond() {
		super(SPRITE, Permeability.DIAMOND);
	}


	@Override
	public void win() {
		// TODO Auto-generated method stub
		return;
	}

	/**
	 * Gets the diamonds
	 */
	@Override
	public int getDiamonds() {
		// TODO Auto-generated method stub
		return 0;
	}

	/**
	 *Gets the diamonds
	 */
	@Override
	public void grabDiamond() {
		return;
	}
}
