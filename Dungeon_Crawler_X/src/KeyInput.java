/********************************************
 * Written By: William Mckeever    			*
 * Date: 1/28/2018       					*
 * Class: KeyInput       					*
 *            								*
 * The class reads player inputs   			*
 ********************************************/

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{

	
	private Handler handler;
	
	public int count = 0;
	private SpriteSheet ss;
	public static boolean pause = false;
	public static boolean stop = false;
	public static boolean up = false;
	public static boolean down = false;
	public static boolean space = false;


	public KeyInput(Handler handler, SpriteSheet ss) {
		this.handler = handler;
		this.ss = ss;
	}
	
	/**
	 * Make action happen based of character movement
	 * @param e is a KeyEvent
	 */
	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();

		//System.out.println(key);
		//introduce walking by including counter, everyfour switches picture

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);
			if(tempObject.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_Q) {
					count++;
					if (count % 2 ==0){
						handler.setPause(false);
						pause = false;
					}
					else {
						handler.setPause(true);
						pause = true;
					}
				}
				
				if(key == KeyEvent.VK_W) {
					handler.setUp(true);
					handler.setStop(false);
					up = true;
					down = false;
				}
				if(key == KeyEvent.VK_S) {
					handler.setDown(true);
					handler.setStop(false);
					up = false;
					down = true;
				}
				if(key == KeyEvent.VK_A) {
					handler.setLeft(true);
					handler.setStop(false);
				}
				if(key == KeyEvent.VK_D) {
					handler.setRight(true);
					handler.setStop(false);
				}
				if(key == KeyEvent.VK_UP) {
					handler.setUpAim(true);
					
				}
				if(key == KeyEvent.VK_DOWN) {
					handler.setDownAim(true);
				}
				if(key == KeyEvent.VK_LEFT) {
					handler.setLeftAim(true);	
				}
				if(key == KeyEvent.VK_RIGHT) {
					handler.setRightAim(true);	
				}
				if(key == KeyEvent.VK_SPACE) {
					handler.setSpace(true);
					space = true;
				}
			}
		}

		if(key == KeyEvent.VK_ESCAPE) System.exit(1);

	}

	/**
	 * Make action happen based of character movement
	 * @param e is a KeyEvent
	 */
	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();

		for(int i = 0; i < handler.object.size(); i++) {
			GameObject tempObject = handler.object.get(i);

			if(tempObject.getID() == ID.Player) {
				
				if(key == KeyEvent.VK_W) handler.setUp(false);
				if(key == KeyEvent.VK_S) handler.setDown(false);
				if(key == KeyEvent.VK_A) handler.setLeft(false);
				if(key == KeyEvent.VK_D) handler.setRight(false);
				if(key == KeyEvent.VK_UP) {
					handler.setUpAim(false); 
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),0,-5,ID.Attack,ss, handler));
				}
				if(key == KeyEvent.VK_DOWN) {
					handler.setDownAim(false);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),0,5,ID.Attack,ss, handler));
				}
				if(key == KeyEvent.VK_LEFT) {
					handler.setLeftAim(false);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),-5,0,ID.Attack,ss, handler));
				}
				if(key == KeyEvent.VK_RIGHT) {
					handler.setRightAim(false);
					handler.addObject(new Fireball(tempObject.getX(),tempObject.getY(),5,0,ID.Attack,ss, handler));
				}
				if(key == KeyEvent.VK_SPACE) {
					handler.setSpace(false);
					space = false;
				}
				handler.setStop(true);
				
				//dead = true;

			}
		}
	}
}
