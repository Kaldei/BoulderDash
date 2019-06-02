package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;;



public class ScorePane extends JPanel {


	/**
	 * 
	 */
	private static final long serialVersionUID = 4027710322664344956L;
	private int diamond;
	
	public ScorePane (int diamond) { 
		//setDiamond(diamond);
		  // this.setBackground(Color.ORANGE); 
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Font font = new Font("Courier", Font.BOLD, 20);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Diamonds needed : 10", 10, 30);
		g.drawString("Your Diamonds : " + getDiamond(), 10, 65);
		
	}

	public int getDiamond() {
		return diamond;
	}

	public void setDiamond(int diamond) {
		this.diamond = diamond;
	}

}
