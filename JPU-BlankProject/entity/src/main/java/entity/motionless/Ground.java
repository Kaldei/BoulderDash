package entity.motionless;

import entity.Permeability;
import entity.Sprite;

public class Ground extends MotionlessElement{
	 /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite(' ', "Door.png");

    /**
     * Instantiates a new obstacle.
     */
    Ground() {
        super(SPRITE, Permeability.DISAPPEAR);
    }

}