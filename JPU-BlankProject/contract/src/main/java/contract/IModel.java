package contract;

import java.util.Observable;

import entity.IMap;
import entity.mobile.IMobile;


/**
 * The Interface IModel.
 *
 * @author Jean-Aymeric Diet
 */
public interface IModel {


	IMap getMap();

  
    IMobile getMyPlayer();


}