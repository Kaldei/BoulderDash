package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public class MonsterG extends Mobile{

	/** The Constant SPRITE. */
	private static final Sprite SPRITE = new Sprite('G', "greenMonster.png");

	/**
	 * Instantiates a new monster.
	 */
	MonsterG() {
		super(SPRITE, Permeability.KILLABLE);
	}

	@Override
	public void win() {
		// TODO Auto-generated method stub
		return;
	}

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