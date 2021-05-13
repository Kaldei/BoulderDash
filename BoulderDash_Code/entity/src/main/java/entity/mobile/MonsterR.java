package entity.mobile;

import entity.Permeability;
import entity.Sprite;

/**
 * @author Laetitia
 *
 */

public class MonsterR extends Mobile {

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('R', "redMonster.png");

	/**
	 * Instantiates a new monster.
	 */
	MonsterR() {
		super(SPRITE, Permeability.KILLABLE);
	}

	@Override
	public void win() {
		// TODO Auto-generated method stub
		return;
	}

	/**
	 *Gets the diamonds
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

