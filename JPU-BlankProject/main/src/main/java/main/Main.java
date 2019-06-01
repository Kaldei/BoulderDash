/**
 * @author Laetitia, Arthur, Anthony
 * @version 1.0.8
 */
package main;

import java.io.IOException;

import contract.IBoulderDashController;
import contract.IModel;
import controller.Controller;
import model.BoulderDashModel;
import view.View;

/**
 * The Class Main.
 *
 * @author Laetitia, Arthur, Anthony
 */
public abstract class Main {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 * @throws IOException 
	 *
	 */
	
	private static String txt = "C:\\Users\\User\\Documents\\GitHub\\Project-5\\JPU-BlankProject\\model\\src\\main\\resources\\map.txt";
	
	public static void main(final String[] args) throws IOException, InterruptedException {
		final IModel model = new BoulderDashModel(txt,1,1);
		final View view = new View(model.getMap(), model.getMyPlayer());
		final IBoulderDashController controller = new Controller(view, model);
		view.setOrderPerformer(controller.getOrderPerformer());

		controller.play();
	}
}
