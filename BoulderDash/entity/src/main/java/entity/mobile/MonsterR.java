package entity.mobile;

import entity.Permeability;
import entity.Sprite;

/**
 * @author Laetitia
 *
 */

public class MonsterR extends Mobile{

	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('X', "MDown.png");

	    /**
	     * Instantiates a new monster.
	     */
	    MonsterR() {
	        super(SPRITE, Permeability.KILLING);
	    }

		/**
		 *Gets the diamond
		 */
		@Override
		public int getDiamonds() {
			// TODO Auto-generated method stub
			return 0;
		}
	}

