package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public class Diamond extends Mobile{

	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('*', "Diamond.png");
	    

	    /**
	     * Instantiates a new obstacle.
	     */
	    Diamond() {
	        super(SPRITE, Permeability.DIAMOND);
	    }


		@Override
		public int getDiamonds() {
			// TODO Auto-generated method stub
			return 0;
		}
	}
