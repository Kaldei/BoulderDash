package entity;

import java.awt.Image;

public abstract class Element implements IElement {

    /**
     * <h1>The Element Class.</h1>
     *
     * @author Laetitia
     * @version 0.1
     */

    /**
     * The sprite.
     */
    private Sprite sprite;

    /**
     * The permeability.
     */
    private Permeability permeability;

    private Boolean hasChanged = false;

    /**
     * @param sprite
     * @param permeability
     */
    public Element(final Sprite sprite, final Permeability permeability) {
        this.setSprite(sprite);
        this.setPermeability(permeability);
    }


    /**
     * Gets the sprite
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
     * Gets the Image
     *
     */
    public final Image getImage() {
        return this.getSprite().getImage();
    }


    public Boolean getHasChanged() {
        return hasChanged;
    }

    public void setHasChanged(Boolean hasChanged) {
        this.hasChanged = hasChanged;
    }
}