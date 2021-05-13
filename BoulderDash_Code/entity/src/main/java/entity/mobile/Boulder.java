package entity.mobile;

import entity.Permeability;
import entity.Sprite;

/**
 * @author Laetitia
 *
 */
public class Boulder extends Mobile {

	 /** The Constant SPRITE. */
    private static final Sprite SPRITE = new Sprite('O', "boulder.png");

    /**
     * Instantiates a new obstacle.
     */
    public Boulder() {
        super(SPRITE, Permeability.BOULDER);
    }
    
    @Override
    public void moveRight() {
    	super.moveRight();
    }

    @Override
    public void win() {
        // TODO Auto-generated method stub
        return;
    }

    @Override
    public void moveLeft() {
    	super.moveLeft();
    }
    
    @Override 
    public void moveDown() {
    	super.moveDown();
    }

	@Override
	public int getDiamonds() {
		// TODO Auto-generated method stub
		return 0;
	}

    /**
     *Gets the diamonds
     */
    @Override
    public void grabDiamond() {
        return;
    }
	
	
}