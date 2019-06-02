package entity.motionless;

import entity.Permeability;
import entity.Sprite;

/**
 * @author Laetitia
 *
 */
public class Ground extends MotionlessElement{
	 /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Ground.png");

    /**
     * Instantiates a new ground.
     */
    Ground() {
        super(SPRITE, Permeability.DISAPPEAR);
    }

}