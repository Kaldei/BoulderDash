package entity.motionless;

import entity.Permeability;
import entity.Sprite;

class Wall extends MotionlessElement {

    /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('#', "Wall.png");

    /**
     * Instantiates a new ditchLeft.
     */
    Wall() {
        super(SPRITE, Permeability.BLOCKING);
    }
}