package entity.mobile;

public class MobileElementsFactory {

	private final static MonsterR monsterR = new MonsterR();
	private final static MonsterG monsterG = new MonsterG();
	private final static Diamond diamond = new Diamond();
	private final static Rock rock = new Rock();

	private static Mobile[] mobileElements = { monsterR, monsterG, diamond, rock };

	public static Mobile getFromFileSymbol(final char fileSymbol) {
		for (final Mobile mobileElement : mobileElements) {
			if (mobileElement.getSprite().getConsoleImage() == fileSymbol) {
				return mobileElement;
			}
		}
		return monsterR;
	}

	public static Mobile createMonsterR() {
		return monsterR;
	}
	
	public static Mobile createMonsterG() {
		return monsterG;
	}

	public static Mobile createDiamond() {
		return diamond;
	}

	public static Mobile createRock() {
		return rock;
	}

}
