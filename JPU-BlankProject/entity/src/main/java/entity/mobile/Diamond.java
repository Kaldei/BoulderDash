package entity.mobile;

import entity.Permeability;
import entity.Sprite;

public class Diamond extends Mobile{

	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('*', "diamond.png");
	    

	    /**
	     * Instantiates a new obstacle.
	     */
	    Diamond() {
	        super(SPRITE, Permeability.BLOCKING);
	    }
	}
