package entity;

import java.awt.Image;

import fr.exia.showboard.ISquare;

public interface IElement extends ISquare {
	/**
	 * Gets the sprite.
	 *
	 * @return the sprite
	 */
	Sprite getSprite();

	/**
	 * Gets the permeability.
	 *
	 * @return the permeability
	 */
	Permeability getPermeability();

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.ISquare#getImage()
	 */
	@Override
	Image getImage();

}