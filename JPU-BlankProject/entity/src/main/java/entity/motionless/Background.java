package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Background extends MotionlessElement{
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "Background.png");

    /**
     * Instantiates a new macadam.
     */
    Background() {
        super(SPRITE, Permeability.PENETRABLE);
    }

}