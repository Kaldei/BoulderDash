package contract;


public interface IBoulderDashController {
	
	void play() throws InterruptedException;
	
	IOrderPerformer getOrderPerformer();
}
