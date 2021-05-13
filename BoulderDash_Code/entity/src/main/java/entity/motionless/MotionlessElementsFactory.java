package entity.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Laetitia
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

	private static final Wall wall = new Wall();
	private static final Door door = new Door();
	private static final Background background = new Background();
	private static final Ground ground = new Ground();

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static MotionlessElement[] motionlessElements = {wall, background, door, ground};

	/**
	 * creates the wall
	 * @return
	 */
	public static MotionlessElement createWall() {
		return wall;
	}

	/**
	 * creates the door
	 * @return
	 */
	public static MotionlessElement createDoor() {
		return door;
	}

	/**
	 * creates the background
	 * @return
	 */
	public static MotionlessElement createBackground() {
		return background;
	}
	
	/**
	 * 
	 * creates the ground
	 * @return
	 */
	public static MotionlessElement createGround() {
		return ground;
	}

	/**
	 * Gets the good MotionlessElement from file symbol.
	 *
	 * @param fileSymbol the file symbol
	 * @return the from file symbol
	 */
	public static MotionlessElement getFromFileSymbol(final char fileSymbol) {
		for (final MotionlessElement motionlessElement : motionlessElements) {
			if (motionlessElement.getSprite().getConsoleImage() == fileSymbol) {
				return motionlessElement;
			}
		}
		return background;
	}
}