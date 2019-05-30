package model ;

import java.io.IOException;
import java.util.Observable;


import contract.IModel;
import entity.IMap;
import entity.mobile.IMobile;
import entity.mobile.MyPlayer;


/**
 * <h1>The Class InsaneVehiclesModel.</h1>
 */
public class BoulderDashModel implements IModel {

    /** The road. */
    private IMap map;

    /** The my vehicle. */
    private IMobile myPlayer;

    /**
     * Instantiates a new insane vehicles model.
     *
     * @param fileName
     *            the file name
     * @param myVehicleStartX
     *            the my vehicle start X
     * @param myVehicleStartY
     *            the my vehicle start Y
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public BoulderDashModel(final String fileName, final int myPlayerStartX, final int myPlayerStartY)
            throws IOException {
        this.setMap(new Map(fileName));
        this.setMyPlayer(new MyPlayer(myPlayerStartX, myPlayerStartY, this.getMap()));
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getRoad()
     */
    @Override
    public final IMap getMap() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the road to set
     */
    private void setMap(final IMap map) {
        this.map = map;
    }

    /* (non-Javadoc)
     * @see fr.exia.insanevehicles.model.IInsaneVehiclesModel#getMyVehicle()
     */
    
    public final IMobile getMyPlayer() {
        return this.myPlayer;
    }

    /**
     * Sets the my vehicle.
     *
     * @param myVehicle
     *            the myVehicle to set
     */
    private void setMyPlayer(final IMobile myPlayer) {
        this.myPlayer = myPlayer;
    }

	

}