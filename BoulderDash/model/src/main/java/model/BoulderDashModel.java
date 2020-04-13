package model;

import java.io.IOException;

import contract.IModel;
import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MyPlayer;

/**
 * <h1>The Class BoulderDashModel.</h1>
 *
 * @author Laetitia
 *
 */
/**
 * @author User
 *
 */
public class BoulderDashModel implements IModel {

	/** The map. */
	private IMap map;

	/** The my player. */
	private IMobile myPlayer;

	/**
	 * Instantiates a new boulder dash model.
	 *
	 * @param fileName        the file name
	 * @param myPlayerStartX the my player start X
	 * @param myPlayerStartY the my player start Y
	 * @throws IOException ignals that an I/O exception has occurred.
	 */
	public BoulderDashModel(final String fileName, final int myPlayerStartX, final int myPlayerStartY)
			throws IOException {
		this.setMap(new Map(fileName));
		this.setMyPlayer(new MyPlayer(myPlayerStartX, myPlayerStartY, this.getMap()));
	}

	/**
	 * Gets the map
	 */
	@Override
	public final IMap getMap() {
		return this.map;
	}

	/**
	 * Sets the map.
	 *
	 * @param map the map to set
	 */
	private void setMap(final IMap map) {
		this.map = map;
	}

	/**
	 * gets the player
	 */
	@Override
	public final IMobile getMyPlayer() {
		return this.myPlayer;
	}

	/**
	 * Sets the my player.
	 *
	 * @param myPlayer the player to set
	 */
	private void setMyPlayer(final IMobile myPlayer) {
		this.myPlayer = myPlayer;
	}

}