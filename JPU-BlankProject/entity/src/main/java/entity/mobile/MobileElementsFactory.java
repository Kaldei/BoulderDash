package entity.mobile;

/**
 * @author Laetita
 *
 */
public class MobileElementsFactory {

	/**
	 * The monster
	 */
	private final static Monster monster = new Monster();
	/**
	 * The diamond
	 */
	private final static Diamond diamond = new Diamond();
	/**
	 * The rock
	 */
	private final static Rock rock = new Rock();

	/**
	 * The list of mobile elements
	 */
	private static Mobile[] mobileElements = { monster, diamond, rock };

	/**
	 * Gets char from file
	 * @param fileSymbol
	 * @return
	 */
	public static Mobile getFromFileSymbol(final char fileSymbol) {
		for (final Mobile mobileElement : mobileElements) {
			if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
				return mobileElement;
			}
		}
		return monster;
	}

	/**
	 * creates Monster
	 * @return
	 */
	public static Mobile createMonster() {
		return monster;
	}

	/**
	 * creates diamond
	 * @return
	 */
	public static Mobile createDiamond() {
		return diamond;
	}

	/**
	 * creates rock
	 * @return
	 */
	public static Mobile createRock() {
		return rock;
	}

}
