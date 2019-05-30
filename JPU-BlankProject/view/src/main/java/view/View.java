package view;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import contract.IOrderPerformer;
import contract.IView;
import contract.UserOrder;
import entity.IMap;
import entity.mobile.IMobile;
import fr.exia.showboard.BoardFrame;

/**
 * <h1>The InsaneVehiclesView Class.</h1>
 *
 * @author Jade
 * @version 0.4
 */
public class View implements Runnable, KeyListener, IView {

    /** The Constant roadView. */
    private static final int roadView   = 10;

    /** The Constant squareSize. */
    private static final int squareSize = 50;

    /** The Constant closeView. */
    private Rectangle        closeView;

    /** The road. */
    private IMap            map;

    /** My vehicle. */
    private IMobile          myPlayer;

    /** The view. */
    private int              view;

    /** The order performer. */
    private IOrderPerformer  orderPerformer;

    /**
     * Instantiates a new insane vehicles View.
     *
     * @param road
     *            the road
     * @param myVehicle
     *            the my vehicle
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    public View(final IMap map, final IMobile myPlayer) throws IOException {
        this.setView(roadView);
        this.setMap(map);
        this.setMyPlayer(myPlayer);
        this.getMyPlayer().getSprite().loadImage();
        this.setCloseView(new Rectangle(0, this.getMyPlayer().getY(), this.getMap().getWidth(), roadView));
        SwingUtilities.invokeLater(this);
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#displayMessage(java.lang.String)
     */
    public final void displayMessage(final String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Runnable#run()
     */
    @Override
    public final void run() {
        final BoardFrame boardFrame = new BoardFrame("Close view");
        boardFrame.setDimension(new Dimension(this.getMap().getWidth(), this.getMap().getHeight()));
        boardFrame.setDisplayFrame(this.closeView);
        boardFrame.setSize(this.closeView.width * squareSize, this.closeView.height * squareSize);
        boardFrame.setHeightLooped(false);
        boardFrame.addKeyListener(this);
        boardFrame.setFocusable(true);
        boardFrame.setFocusTraversalKeysEnabled(false);

        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
                boardFrame.addSquare(this.map.getOnTheMapXY(x, y), x, y);
            }
        }
        boardFrame.addPawn(this.getMyPlayer());

        this.getMap().getObservable().addObserver(boardFrame.getObserver());
        this.followMyPlayer();

        boardFrame.setVisible(true);
    }

    /**
     * Prints the road and the player's vehicle in the console.
     *
     * @param yStart
     *            the y start
     */
    public final void show(final int yStart) {
        int y = yStart % this.getMap().getHeight();
        for (int view = 0; view < this.getView(); view++) {
            for (int x = 0; x < this.getMap().getWidth(); x++) {
                if ((x == this.getMyPlayer().getX()) && (y == yStart)) {
                    System.out.print(this.getMyPlayer().getSprite().getConsoleImage());
                } else {
                    System.out.print(this.getMap().getOnTheMapXY(x, y).getSprite().getConsoleImage());
                }
            }
            y = (y + 1) % this.getMap().getHeight();
            System.out.print("\n");
        }
    }

    /**
     * Key code to user order.
     *
     * @param keyCode
     *            the key code
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
     * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
     */
    @Override
    public void keyTyped(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
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
     * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
     */
    @Override
    public void keyReleased(final KeyEvent keyEvent) {
        // Nop
    }

    /*
     * (non-Javadoc)
     * @see fr.exia.insanevehicles.view.IInsaneVehiclesView#followMyvehicle()
     */
    public final void followMyPlayer() {
        this.getCloseView().y = this.getMyPlayer().getY() - 1;
    }

    /**
     * Gets the road.
     *
     * @return the road
     */
    private IMap getMap() {
        return this.map;
    }

    /**
     * Sets the road.
     *
     * @param road
     *            the new road
     * @throws IOException
     *             Signals that an I/O exception has occurred.
     */
    private void setMap(final IMap map) throws IOException {
        this.map = map;
        for (int x = 0; x < this.getMap().getWidth(); x++) {
            for (int y = 0; y < this.getMap().getHeight(); y++) {
              this.getMap().getOnTheMapXY(x, y).getSprite().loadImage();
        }
        }
    }

    /**
     * Gets my vehicle.
     *
     * @return my vehicle
     */
    private IMobile getMyPlayer() {
        return this.myPlayer;
    }

    /**
     * Sets my vehicle.
     *
     * @param myVehicle
     *            my new vehicle
     */
    private void setMyPlayer(final IMobile myPlayer) {
        this.myPlayer = myPlayer;
    }

    /**
     * Gets the view.
     *
     * @return the view
     */
    private int getView() {
        return this.view;
    }

    /**
     * Sets the view.
     *
     * @param view
     *            the new view
     */
    private void setView(final int view) {
        this.view = view;
    }

    /**
     * Gets the close view.
     *
     * @return the close view
     */
    private Rectangle getCloseView() {
        return this.closeView;
    }

    /**
     * Sets the close view.
     *
     * @param closeView
     *            the new close view
     */
    private void setCloseView(final Rectangle closeView) {
        this.closeView = closeView;
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
     * @param orderPerformer
     *            the new order performer
     */
    public final void setOrderPerformer(final IOrderPerformer orderPerformer) {
        this.orderPerformer = orderPerformer;
    }

	@Override
	public void printMessage(String message) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void followMyVehicle() {
		// TODO Auto-generated method stub
		
	}
}
