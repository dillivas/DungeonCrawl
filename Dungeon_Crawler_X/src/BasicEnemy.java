/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: BasicEnemy      					*
 *            								*
 * The class control's a BasicEnemy object 	*
 ********************************************/

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class BasicEnemy extends GameObject{

	 private Handler handler;
	 Random rand = new Random();
	 int choose = 0;
	 int hp = 100;
	
	public BasicEnemy(int x, int y, ID id, SpriteSheet ss, Handler handler) {
		super(x, y, id, ss);
		this.handler = handler;
	}

	@Override
	public void tick() {
		x += speedX;
		y += speedY;
		
		choose = rand.nextInt(10);
		//AI behavior found on:
		//https://www.youtube.com/watch?v=JBGCCAv76YI&t=1s
		
		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
					
			if(tempObject.getID() == ID.Block) {
				if(getBoundsWall().intersects(tempObject.getBounds())) {
					x += (speedX*2) * -1;
					y += (speedY*2) * -1;
					speedX = 0;
					speedY = 0;
				}else if(choose == 0) {
					speedX = (rand.nextInt(4 - -4) + -4);
					speedY = (rand.nextInt(4 - -4) + -4);
				}
			}
			if(tempObject.getID() == ID.Attack) {
				if(getBounds().intersects(tempObject.getBounds())) {
					hp -= 25;
					//Removes fireball
					handler.removeObject(tempObject);
				}
			}
			if(tempObject.getID() == ID.Lava) {

				if(getBounds().intersects(tempObject.getBounds()) && (tempObject.getID() == ID.Lava)) {
					hp -= 1;
				
				}
			}
		}
		if(hp <= 0) handler.removeObject(this);
	}

	@Override
	public void render(Graphics g) {
		//g.setColor(Color.yellow);
		//g.fillRect(x, y, 32, 32);
		g.drawImage(Render.enemyImage,x,y,32,32, null);
	}

	@Override
	public Rectangle getBounds() {
		return new Rectangle(x ,y ,40,40);
	}
	
	public Rectangle getBoundsWall() {
		return new Rectangle(x - 16,y - 16,64,64);
	}


}
