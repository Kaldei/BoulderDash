package contract;

/**
 * The Interface IView.
 *
 * @author Jean-Aymeric Diet
 */
public interface IView {

	/**
	 * Prints the message.
	 *
	 * @param message the message
	 */
	void displayMessage(final String message);
	void followMyPlayer();
	
	
	void updateView();
}
