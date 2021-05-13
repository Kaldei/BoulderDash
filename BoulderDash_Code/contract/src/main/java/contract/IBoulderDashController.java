package contract;


/**
 * @author Anthony
 *
 */
public interface IBoulderDashController {
	
	/**
	 * @throws InterruptedException
	 */
	void play();
	
	/**
	 * @return this
	 */
	IOrderPerformer getOrderPerformer();
}
