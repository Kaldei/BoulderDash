package entity ;

import java.util.Observable;

/**
 * <h1>The Interface IMap.</h1>
 *
 * @author Laetitia
 * @version 0.1
 */
public interface IMap {

    /**
     * Gets the width.
     *
     * @return the width
     */
    int getWidth();

    /**
     * Gets the height.
     *
     * @return the height
     */
    int getHeight();

    /**
     * Gets on the map XY.
     *
     * @param x
     *            the x
     * @param y
     *            the y
     * @return the on the road XY
     */
    IElement getOnTheMapXY(int x, int y);
    
    /**
     * Sets on the Map XY 
     * @param element
     * @param x
     * @param y
     */
    void setOnTheMapXY(IElement element, final int x, final int y);
    
    /**
     * Apply Rock gravity
     */
    void gravity();
    
    /**
     * Apply gravity
     */
    void gravityDiag();
    
    /**
     * Apply diamond gravity
     */
    void gravityD();
    
    /**
     * Apply gravity
     */
    void gravityDiagD();

    /**
     * Sets the mobile has changed.
     */
    void setMobileHasChanged();

    /**
     * Gets the observable.
     *
     * @return the observable
     */
    Observable getObservable();
}