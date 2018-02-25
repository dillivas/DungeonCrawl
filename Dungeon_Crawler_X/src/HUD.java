/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: HUD       	 					*
 *            								*
 * The class keeps track of player HUD  	*
 ********************************************/


import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	
	//Move Health to player and displaye health and mana in game function. Should stop null pointer
	GameObject gameObject;
	 
	 public static int HEALTH = 100;
	 
	 //Change to not drain health constantly
	 public void tick() {
		  
		  HEALTH = Game.clamp(HEALTH,0,100);
		  
	 }
	 
	 public void render(Graphics g) {
		  g.setColor(Color.gray);
		  g.fillRect(15 , 15, 200, 32);
		  g.setColor(Color.red);
		  g.fillRect(15 , 15, HEALTH * 2, 32);
		  g.setColor(Color.white);
		  g.drawRect(15 , 15, 200, 32);
	 }
	 
	 
}