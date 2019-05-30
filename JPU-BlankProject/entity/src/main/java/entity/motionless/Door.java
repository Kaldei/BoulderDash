package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Door extends MotionlessElement {
	
	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('D', "Door.png");

	    /**
	     * Instantiates a new obstacle.
	     */
	    Door() {
	        super(SPRITE, Permeability.BLOCKING);
	    }
	}