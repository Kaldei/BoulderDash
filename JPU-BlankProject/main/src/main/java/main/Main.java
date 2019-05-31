/**
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
package main;

import java.io.IOException;

import contract.IBoulderDashController;
import contract.IModel;
import contract.IView;
import contract.UserOrder;
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
	
	private static String txt = "C:\\Users\\calde\\git\\Project-5\\JPU-BlankProject\\model\\src\\main\\resources\\map.txt";
	
	public static void main(final String[] args) throws IOException, InterruptedException {
		final IModel model = new BoulderDashModel(txt,1,1);
		final View view = new View(model.getMap(), model.getMyPlayer());
		final IBoulderDashController controller = new Controller(view, model);
		view.setOrderPerformer(controller.getOrderPerformer());

		controller.play();
		//controller.orderPerform(UserOrder.NOP);
	}
}
