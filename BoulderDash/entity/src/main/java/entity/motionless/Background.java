package entity.motionless;

import entity.Permeability;
import entity.Sprite;

/**
 * @author Laetitia
 *
 */
public class Background extends MotionlessElement{
	
	/** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('.', "Background.png");

    /**
     * Instantiates a new background.
     */
    Background() {
        super(SPRITE, Permeability.PENETRABLE);
    }

}