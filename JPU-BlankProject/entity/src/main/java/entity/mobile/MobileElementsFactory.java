package entity.mobile;

public class MobileElementsFactory {

	private final static Monster monster = new Monster();
	private final static Diamond diamond = new Diamond();
	private final static Rock rock = new Rock();

	private static Mobile[] mobileElements = { monster, diamond, rock };

	public static Mobile getFromFileSymbol(final char fileSymbol) {
		for (final Mobile mobileElement : mobileElements) {
			if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
				return mobileElement;
			}
		}
		return monster;
	}

	public static Mobile createMonster() {
		return monster;
	}

	public static Mobile createDiamond() {
		return diamond;
	}

	public static Mobile createRock() {
		return rock;
	}

}
