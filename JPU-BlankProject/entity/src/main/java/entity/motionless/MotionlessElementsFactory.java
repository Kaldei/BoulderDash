package entity.motionless;

/**
 * <h1>A factory to create MotionlessElements objects.</h1>
 *
 * @author Laetitia
 * @version 0.1
 */
public abstract class MotionlessElementsFactory {

	private static final Wall WALL = new Wall();
	private static final Door DOOR = new Door();
	private static final Background BACKGROUND = new Background();
	private static final Ground GROUND = new Ground();

	/**
	 * The motionless elements is an array of all possible MotionlessElement.
	 */
	private static MotionlessElement[] motionlessElements = { WALL, BACKGROUND, DOOR, GROUND};

	public static MotionlessElement createWall() {
		return WALL;
	}

	public static MotionlessElement createDoor() {
		return DOOR;
	}

	public static MotionlessElement createMacadam() {
		return BACKGROUND;
	}
	
	public static MotionlessElement createGround() {
		return GROUND;
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
		return BACKGROUND;
	}
}