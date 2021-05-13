package view;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.Observable;

import contract.IOrderPerformer;
import contract.IView;
import contract.UserOrder;
import entity.mobile.IMobile;

import javax.swing.*;

import fr.exia.showboard.BoardFrame;

import entity.IMap;

/**
 * The Class View.
 *
 * @author Arthur Caldeireiro based on the work of Jean-Aymeric Diet
 */
public final class View extends Observable implements IView, KeyListener {

	/** The Game Windows (Frame) */
	private BoardFrame boardFrame;

	/** The Game View (Part of the map we see) */
	final Rectangle gameView = new Rectangle(0, 0, 11, 11);

	/** The map. */
	private IMap map;

	/** The player */
	private IMobile myPlayer;

	/** The order performer. */
	private IOrderPerformer orderPerformer;


	/**
	 * 
	 * Instantiates a new View.
	 * 
	 * @param map
	 * @param myPlayer
	 * @throws IOException
	 */
	public View(final IMap map, final IMobile myPlayer) {
		try {
			this.setmap(map);
		} catch (IOException e) {
			e.printStackTrace();
		}
		this.setmyPlayer(myPlayer);
		try {
			this.getmyPlayer().getSprite().loadImage();
		} catch (IOException e) {
			e.printStackTrace();
		}

		this.boardFrame = new BoardFrame();
		this.boardFrame.setDimension(new Dimension(this.getmap().getWidth(), this.getmap().getHeight()));
		this.boardFrame.setDisplayFrame(this.gameView);
		this.boardFrame.addKeyListener(this);

		this.boardFrame.addPawn(this.getmyPlayer());

		this.updateView();
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followmyPlayer()
	 */
	@Override
	public final void followMyPlayer() {
		if (this.getmyPlayer().getX() >= this.gameView.width / 2 && this.getmyPlayer().getX() <= this.getmap().getWidth() - this.gameView.width / 2 - 1) {
			this.getgameView().x = this.getmyPlayer().getX() - this.gameView.width / 2;
		}
		if (this.getmyPlayer().getY() >= this.gameView.height / 2 && this.getmyPlayer().getY() <= this.getmap().getHeight() - this.gameView.height / 2 - 1) {
			this.getgameView().y = this.getmyPlayer().getY() - this.gameView.height / 2;
		}
	}

	/**
	 *  Update the view with the new position of the frames
	 */
	public void updateView() {
		for (int x = 0; x < this.getmap().getWidth(); x++) {
			for (int y = 0; y < this.getmap().getHeight(); y++) {
				boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
			}
		}
		this.getmap().getObservable().addObserver(boardFrame.getObserver());
	}

	/**
	 * Key code to user order.
	 *
	 * @param keyCode the key code
	 * @return the user order
	 */
	private static UserOrder keyCodeToUserOrder(final int keyCode) {
		UserOrder userOrder;
		switch (keyCode) {
		case KeyEvent.VK_RIGHT:
			userOrder = UserOrder.RIGHT;
			break;
		case KeyEvent.VK_LEFT:
			userOrder = UserOrder.LEFT;
			break;
		case KeyEvent.VK_UP:
			userOrder = UserOrder.UP;
			break;
		case KeyEvent.VK_DOWN:
			userOrder = UserOrder.DOWN;
			break;
		default:
			userOrder = UserOrder.NOP;
			break;
		}
		return userOrder;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see
	 * fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.
	 * String)
	 */
	@Override
	public final void displayMessage(final String message) {
		//JOptionPane.showMessageDialog(null, message);
		int choice = JOptionPane.showInternalConfirmDialog(null, message, "BoulderDash",JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);

		if (choice == 0) {
			boardFrame.dispose();
		} else {
			System.exit(0);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyTyped(final KeyEvent keyEvent) {
		// Nop
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	@Override
	public final void keyPressed(final KeyEvent keyEvent) {
		try {
			this.getOrderPerformer().orderPerform(keyCodeToUserOrder(keyEvent.getKeyCode()));
		} catch (final IOException exception) {
			exception.printStackTrace();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	@Override
	public void keyReleased(final KeyEvent keyEvent) {
		// Nop
	}

	/**
	 * Gets the map.
	 *
	 * @return the map
	 */
	private IMap getmap() {
		return this.map;
	}

	/**
	 * Display the map
	 *
	 * @param map the new map
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	private void setmap(final IMap map) throws IOException {
		this.map = map;
		for (int x = 0; x < this.getmap().getWidth(); x++) {
			for (int y = 0; y < this.getmap().getHeight(); y++) {
				this.getmap().getOnTheMapXY(x, y).getSprite().loadImage();
			}
		}
	}

	/**
	 * Gets the player.
	 *
	 * @return the player
	 */
	private IMobile getmyPlayer() {
		return this.myPlayer;
	}

	/**
	 * Sets  the player.
	 * 
	 * @param myPlayer
	 */
	private void setmyPlayer(final IMobile myPlayer) {
		this.myPlayer = myPlayer;
	}


	/**
	 * Gets the gameView.
	 *
	 * @return the gameView
	 */
	private Rectangle getgameView() {
		return this.gameView;
	}

	/**
	 * Gets the order performer.
	 *
	 * @return the order performer
	 */
	private IOrderPerformer getOrderPerformer() {
		return this.orderPerformer;
	}

	/**
	 * Sets the order performer.
	 *
	 * @param orderPerformer the new order performer
	 */
	public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
		this.orderPerformer = orderPerformer;
	}

	/**
	 * Gets the order BoardFrame.
	 *
	 * @return the BoardFrame
	 */
	public BoardFrame getBoardFrame() {
		return boardFrame;
	}
}