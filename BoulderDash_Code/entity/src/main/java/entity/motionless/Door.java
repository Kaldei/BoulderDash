package entity.motionless;

import entity.Permeability;
import entity.Sprite;

/**
 * @author Laetitia
 *
 */
public class Door extends MotionlessElement {
	
	    /** The Constant SPRITE. */
	    private static final Sprite SPRITE = new Sprite('D', "Door.png");

	    /**
	     * Instantiates a new door.
	     */
	    Door() {
	        super(SPRITE, Permeability.EXIT);
	    }
	}