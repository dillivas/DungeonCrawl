/************************************************
 * Written By: William Mckeever    				*
 * Date: 1/28/2018       						*
 * Class: Wall      							*
 *            									*
 * The class controls a wall or block object	*
 * to act as a obstacle to the player.			*
 ************************************************/



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Fireball extends GameObject {
	
	 private Handler handler;
	
	 public Fireball(int x, int y, int speedX,  int speedY, ID id, SpriteSheet ss, Handler handler) {
		super(x,y,speedX,speedY,id, ss);
		this.handler = handler;
		this.ss = ss;
	 }
	 
	 @Override
	 public Rectangle getBounds() {
		 return new Rectangle(x,y,16,16);
	 }
	 @Override
	 public void tick() {
			x += speedX;
			y += speedY;

			collision();
	 }
	 
	 private void collision() {
			for(int i = 0;i < handler.object.size(); i++) {
				GameObject tempObject = handler.object.get(i);
				if(tempObject.getID() == ID.Block) {
					if(getBounds().intersects(tempObject.getBounds())) {
						handler.removeObject(this);
					}
				}
			}
		}
	 @Override
	 public void render(Graphics g) {
		 
		 //Graphics2D g2d = (Graphics2D)g;
		 
		 g.drawImage(Render.fireball,x,y,16,16, null);
		 
		  //g.setColor(Color.orange);
		  //g.fillOval(x, y, 16, 16);
	}
}

