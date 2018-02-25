

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class PauseScreen extends GameObject {
	
	Handler handler;
	
	public char lastKey = 'd';
	public static boolean newGame = false;
	/**
	 * BasicEnemy constructor
	 * @param x coordinates
	 * @param y coordinates
	 * @param id enemy type
	 */
	public PauseScreen(int x, int y, ID id,SpriteSheet ss, Handler handler) {
		super(x, y, id, ss);
		speedX = 2;
		speedY = 2;
		this.handler = handler;
	}

	/**
	 * This is the basic enemies hit box.
	 */
	public Rectangle getBounds() {
		//System.out.println(x);
		return new Rectangle(0,0,0,0);
	}

	/**
	 * Controls BasicEnemy movements
	 */
	public void tick() {
		/*x += speedX;
		y += speedY;
		if(x <= 0 || x >= Game.WIDTH - 37) speedX *= -1;
		if(y <= 0 || y >= Game.HEIGHT - 60) speedY *= -1;*/
	}

	/**
	 * Controls BasicEnemy rendering
	 */
	public void render(Graphics g) {
		if (handler.getPause() == true) {
			g.drawImage(Render.pauseQuit,0,0,650,458, null);
			if(handler.getStop() == true && lastKey=='w') {
				g.drawImage(Render.pauseQuit,0,0,650,458, null);
					if(handler.getSpace() == true) {
						System.exit(1);
					}
			}
			if(handler.getStop() == true && lastKey=='s') {
				g.drawImage(Render.pauseRestart,0,0,650,458, null);
				if(handler.getSpace() == true) {
					new Game();
				}
			}
			
			if(handler.getUp() == true) {
				g.drawImage(Render.pauseQuit,0,0,650,458, null);
				lastKey = 'w'; 
				//g.fillRect(x, y, 32, 32);
			}

			if (handler.getDown() == true){
				g.drawImage(Render.pauseRestart,0,0,650,458, null);
				lastKey = 's';
				//g.fillRect(x, y, 32, 32);
			}
			//g.fillRect(x, y, 32, 32);
		}
		
		if(HUD.HEALTH == 0) {
			g.drawImage(Render.gameRestart,0,0,650,458, null);

			if(handler.getStop() == true && lastKey=='w') {
				g.drawImage(Render.gameQuit,0,0,650,458, null);
					if(handler.getSpace() == true) {
						System.exit(1);
					}
			}
			if(handler.getStop() == true && lastKey=='s') {
				g.drawImage(Render.gameRestart,0,0,650,458, null);
				if(handler.getSpace() == true) {
					newGame = true;
				}
			}
			
			if(handler.getUp() == true) {
				g.drawImage(Render.gameQuit,0,0,650,458, null);
				lastKey = 'w'; 
				//g.fillRect(x, y, 32, 32);
			}

			if (handler.getDown() == true){
				g.drawImage(Render.gameRestart,0,0,650,458, null);
				lastKey = 's';
				//g.fillRect(x, y, 32, 32);
			}
				{
			}
		}
	}
}

