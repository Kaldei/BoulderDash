package contract;


/**
 * @author Anthony
 *
 */
public interface IBoulderDashController {
	
	/**
	 * @throws InterruptedException
	 */
	void play() throws InterruptedException;
	
	/**
	 * @return this
	 */
	IOrderPerformer getOrderPerformer();
}
