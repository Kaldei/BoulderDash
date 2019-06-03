package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;;

/**
 * The Class ScorePane.
 * 
 * @author Arthur Caldeireiro
 */
public class ScorePane extends JPanel {

	/** The serial version */
	private static final long serialVersionUID = 4027710322664344956L;
	

	
	/**
	 * Instantiates a new ScorePane.
	 * 
	 * @param diamond
	 */
	public ScorePane (int diamond) { 
		//setDiamond(diamond);
		// this.setBackground(Color.ORANGE); 
	}

	/**
	 * Draw the text in the pane.
	 *
	 */
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Diamonds needed : 10", 10, 30);
		g.drawString("Your Diamonds : " , 10, 65);
		
	}

	

}
