package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;

import contract.IOrderPerformer;
import contract.IModel;
import contract.IView;
import contract.UserOrder;

import javax.swing.SwingUtilities;
import fr.exia.showboard.BoardFrame;



/**
 * The Class View.
 *
 * @author Arthur Caldeireiro based on the work of Jean-Aymeric Diet
 */
public final class View extends Observable implements IView, Runnable, KeyListener {
	
	
	/**************************************************Interface********************************************/
	private IModel model;
	private IOrderPerformer controller;
	
	/**************************************************VarFrame********************************************/
	public static final int width = 10;

	public static final int height = 10;

	private static final int timeLoop = 100;

	private static final int sizeFrame = 400;

	private static final int widthBetweenFrame = 20;

	private static final Rectangle fullView = new Rectangle(0, 0, width, height);

	private final BoardFrame frameGameView;
	//private final ViewFrame viewFrame;

	
	
	/**************************************************Constructor*******************************************/
	/**
	 * Instantiates a new view.
	 *
	 * @param model the model
	 */
	public View(final IModel model) {
		this.frameGameView = new BoardFrame("Game View");
		
		SwingUtilities.invokeLater(this);
	}


	
	/**************************************************Message********************************************/
	/*
	 * (non-Javadoc)
	 *
	 * @see contract.IView#printMessage(java.lang.String)
	 */
	public void printMessage(final String message) {
		//this.viewFrame.printMessage(message);
	}

	
	
	/**************************************************Frame********************************************/
	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		this.setModel(model); 									// !!! A verif set le modele !!!

		frameGameView.setDimension(new Dimension(width, height));
		frameGameView.setDisplayFrame(fullView);
		frameGameView.setLocation(frameGameView.getX() + frameGameView.getWidth() + widthBetweenFrame,
				frameGameView.getY());
		frameGameView.setSize(sizeFrame, sizeFrame);
		frameGameView.setLocationRelativeTo(null); 				// Centre la fenetre
		
		frameGameView.addKeyListener(this);

		//this.frameConfigure(frameGameView);
		//this.frameGameView.setVisible(false);
	}

	
	/**************************************************Display********************************************/
	public final void frameConfigure(final BoardFrame frame) {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				//frame.addSquare(null, x, y); 		Motionless
				//frame.addPawn(null);				Mobile

				this.addObserver(frame.getObserver());
				frame.setVisible(true);
			}
		}
	}

	
	/**************************************************Observer********************************************/
	public final void move() throws InterruptedException {
		for (;;) {

			this.setChanged();
			this.notifyObservers();

			Thread.sleep(timeLoop);
		}
	}

	
	
	/**************************************************Model********************************************/
	/**
	 * Gets the model.
	 *
	 * @return the model
	 */
	protected IModel getModel() {
		return this.model;
	}

	/**
	 * Sets the model.
	 *
	 * @param model the new model
	 */
	private void setModel(final IModel model) {
		this.model = model;
	}
	
	
	
	/**************************************************Controller********************************************/
	/**
	 * Sets the controller.
	 *
	 * @param controller the new controller
	 */
	public void setController(final IOrderPerformer controller) {
		this.setController(controller);
	}
	
	/**
	 * Gets the controller.
	 *
	 * @return the controller
	 */
	private IOrderPerformer getController() {
		return this.controller;
	}
	
	
	
	/**************************************************KeyListener********************************************/
	/**
	 * Key code to controller order.
	 *
	 * @param keyCode the key code
	 * @return the controller order
	 */
	protected static UserOrder keyCodeToControllerOrder(final int keyCode) {
		switch (keyCode) {
		case KeyEvent.VK_UP:
			return UserOrder.UP;
		case KeyEvent.VK_DOWN:
			return UserOrder.DOWN;
		case KeyEvent.VK_LEFT:
			return UserOrder.LEFT;
		case KeyEvent.VK_RIGHT:
			return UserOrder.RIGHT;
		default:
			return UserOrder.NOP;
		}
	}
	
	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(final KeyEvent e) {

	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(final KeyEvent e) {
		try {
			this.getController().orderPerform(View.keyCodeToControllerOrder(e.getKeyCode()));
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(final KeyEvent e) {

	}

}
