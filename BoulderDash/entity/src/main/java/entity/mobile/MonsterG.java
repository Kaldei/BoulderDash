package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public class MonsterG extends Mobile{

	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('G', "M2Down.png");

	    /**
	     * Instantiates a new monster.
	     */
	    MonsterG() {
	        super(SPRITE, Permeability.KILLING);
	    }

		@Override
		public int getDiamonds() {
			// TODO Auto-generated method stub
			return 0;
		}
	}