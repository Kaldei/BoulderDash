package model;

import java.io.BufferedReader;

import model.DAO.DAOMap;
import entity.IElement;
import entity.IMap;
import entity.Permeability;
import entity.mobile.MobileElementsFactory;
import entity.motionless.MotionlessElementsFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Observable;

/**
 * <h1>The Road Class.</h1>
 *
 * @author Laetitia
 * @version 0.1
 */

class Map extends Observable implements IMap {

	private DAOMap MyMap = new DAOMap();

	/** The width. */
	private int width;

	/** The height. */
	private int height;

	/** The on the map. */
	private IElement[][] onTheMap;

	/**
	 * Instantiates a new road with the content of the file fileName.
	 *
	 * @param fileName the file name where the map is
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	Map(final String fileName) throws IOException {
		super();
		this.MyMap.loadlevel(1);
		this.loadFile(fileName);
	}

	/**
	 * Loads file.
	 *
	 * @param fileName the file name
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void loadFile(final String fileName) throws IOException {
		final BufferedReader buffer = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
		String line;
		int y = 0;
		line = buffer.readLine();
		this.setWidth(Integer.parseInt(line));
		line = buffer.readLine();
		this.setHeight(Integer.parseInt(line));
		this.onTheMap = new IElement[this.getWidth()][this.getHeight()];
		line = buffer.readLine();
		while (line != null) {
			for (int x = 0; x < line.toCharArray().length; x++) {
				if (((line.toCharArray()[x]) == 'X') || ((line.toCharArray()[x]) == 'O')
						|| ((line.toCharArray()[x]) == '*')) {
					this.setOnTheMapXY(MobileElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
				} else {
					this.setOnTheMapXY(MotionlessElementsFactory.getFromFileSymbol(line.toCharArray()[x]), x, y);
				}
			}
			line = buffer.readLine();
			y++;
		}
		buffer.close();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getWidth()
	 */
	@Override
	public final int getWidth() {
		return this.width;
	}

	/**
	 * Sets the width.
	 *
	 * @param width the new width
	 */
	private void setWidth(final int width) {
		this.width = width;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getHeight()
	 */
	@Override
	public final int getHeight() {
		return this.height;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	private void setHeight(final int height) {
		this.height = height;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getOnTheRoadXY(int, int)
	 */
	@Override
	public final IElement getOnTheMapXY(final int x, final int y) {
		return this.onTheMap[x][y];
	}

	/**
	 * Sets the on the road XY.
	 *
	 * @param element the element
	 * @param x       the x
	 * @param y       the y
	 */
	public void setOnTheMapXY(final IElement element, final int x, final int y) {
		this.onTheMap[x][y] = element;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#setMobileHasChanged()
	 */
	@Override
	public final void setMobileHasChanged() {
		this.setChanged();
		this.notifyObservers();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.IRoad#getObservable()
	 */
	@Override
	public Observable getObservable() {
		return this;
	}

	public void gravity() {
		for (int y = this.getHeight() - 1; y > 0; y--) {
			for (int x = this.getWidth() - 1; x > 0; x--) {
				if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.PUSHING
						&& this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
					this.setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createRock(), x, y + 1);
				}
			}
		}
	}

	public void gravityDiag() {
		for (int y = this.getHeight() - 1; y > 0; y--) {
			for (int x = this.getWidth() - 1; x > 0; x--) {
				if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.PUSHING
						&& this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PUSHING) {
					if (this.getOnTheMapXY(x + 1, y + 1).getPermeability() == Permeability.PENETRABLE
							&& this.getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
						this.setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
						this.setOnTheMapXY(MobileElementsFactory.createRock(), x + 1, y);
					}
				}
				if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.PUSHING
						&& this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PUSHING) {
					if (this.getOnTheMapXY(x - 1, y + 1).getPermeability() == Permeability.PENETRABLE
							&& this.getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
						this.setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
						this.setOnTheMapXY(MobileElementsFactory.createRock(), x - 1, y + 1);
					}
				}
			}
		}
	}

	public void gravityD() {
		for (int y = this.getHeight() - 1; y > 0; y--) {
			for (int x = this.getWidth() - 1; x > 0; x--) {
				if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND
						&& this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.PENETRABLE) {
					this.setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
					this.setOnTheMapXY(MobileElementsFactory.createDiamond(), x, y + 1);
				}
			}
		}
	}

	public void gravityDiagD() {
		for (int y = this.getHeight() - 1; y > 0; y--) {
			for (int x = this.getWidth() - 1; x > 0; x--) {
				if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND
						&& this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.DIAMOND) {
					if (this.getOnTheMapXY(x + 1, y + 1).getPermeability() == Permeability.PENETRABLE
							&& this.getOnTheMapXY(x + 1, y).getPermeability() == Permeability.PENETRABLE) {
						this.setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
						this.setOnTheMapXY(MobileElementsFactory.createDiamond(), x + 1, y);
					}
				}
				if (this.getOnTheMapXY(x, y).getPermeability() == Permeability.DIAMOND
						&& this.getOnTheMapXY(x, y + 1).getPermeability() == Permeability.DIAMOND) {
					if (this.getOnTheMapXY(x - 1, y + 1).getPermeability() == Permeability.PENETRABLE
							&& this.getOnTheMapXY(x - 1, y).getPermeability() == Permeability.PENETRABLE) {
						this.setOnTheMapXY(MotionlessElementsFactory.createBackground(), x, y);
						this.setOnTheMapXY(MobileElementsFactory.createDiamond(), x - 1, y + 1);
					}
				}
			}
		}
	}

	public DAOMap getMyMap() {
		return MyMap;
	}

}