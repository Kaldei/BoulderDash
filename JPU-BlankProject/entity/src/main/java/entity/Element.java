package entity;

import java.awt.Image;

import fr.exia.showboard.ISquare;

public abstract class Element implements IElement {

	/**
	 * <h1>The Element Class.</h1>
	 *
	 * @author Laetitia
	 * @version 0.1
	 */

	/** The sprite. */
	private Sprite sprite;

	/** The permeability. */
	private Permeability permeability;

	/**
	 * Instantiates a new element.
	 *
	 * @param sprite       the sprite
	 * @param permeability the permeability
	 */
	public Element(final Sprite sprite, final Permeability permeability) {
		this.setSprite(sprite);
		this.setPermeability(permeability);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.IElement#getSprite()
	 */
	public final Sprite getSprite() {
		return this.sprite;
	}

	/**
	 * Sets the sprite.
	 *
	 * @param sprite the new sprite
	 */
	protected final void setSprite(final Sprite sprite) {
		this.sprite = sprite;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.insanevehicles.model.element.IElement#getPermeability()
	 */
	public final Permeability getPermeability() {
		return this.permeability;
	}

	/**
	 * Sets the permeability.
	 *
	 * @param permeability the new permeability
	 */
	private void setPermeability(final Permeability permeability) {
		this.permeability = permeability;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see fr.exia.showboard.ISquare#getImage()
	 */
	public final Image getImage() {
		return this.getSprite().getImage();
	}
}