/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import contract.ControllerOrder;
import controller.Controller;
import model.BoulderDashModel;
import view.View;

/**
 * The Class Main.
 *
 * @author Jean-Aymeric Diet
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException 
	 *
	 */
	
	private static String txt = "map.txt";
	
	public static void main(final String[] args) throws IOException {
		final BoulderDashModel model = new BoulderDashModel(txt,1,1);
		final View view = new View(model);
		final Controller controller = new Controller(view, model);
		view.setController(controller);
		// coucou

		controller.control();
		controller.orderPerform(ControllerOrder.English);
	}
}
