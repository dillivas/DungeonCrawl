/************************************************
 * Written By: William Mckeever     			*
 * Date: 1/28/2018        						*
 * Class: Handler        						*
 *             									*
 * This class handles all of the game objects 	*
 ************************************************/


import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	 //List of objects
	 public LinkedList<GameObject> object = new LinkedList<GameObject>();
	 //Saves Player inputs
	 
	 private boolean up = false, down = false, right = false, left = false, stop = true;
	 private boolean upAim = false, downAim = false, rightAim = false, leftAim = false;
	 private boolean space = false;
	 private boolean pause = false;
	 
	 public boolean getPause() {
		return pause;
	}

	public void setPause(boolean pause) {
		this.pause = pause;
	}

	public boolean getSpace() {
		return space;
	}

	public void setSpace(boolean space) {
		this.space = space;
	}

	public boolean getUp() {
		return up;
	}

	public void setUp(boolean up) {
		this.up = up;
	}

	public boolean getDown() {
		return down;
	}

	public void setDown(boolean down) {
		this.down = down;
	}

	public boolean getRight() {
		return right;
	}

	public void setRight(boolean right) {
		this.right = right;
	}

	public boolean getLeft() {
		return left;
	}

	public void setLeft(boolean left) {
		this.left = left;
	}

	public boolean getStop() {
		return stop;
	}

	public void setStop(boolean stop) {
		this.stop = stop;
	}

	public boolean getUpAim() {
		return upAim;
	}

	public void setUpAim(boolean upAim) {
		this.upAim = upAim;
	}

	public boolean getDownAim() {
		return downAim;
	}

	public void setDownAim(boolean downAim) {
		this.downAim = downAim;
	}

	public boolean getRightAim() {
		return rightAim;
	}

	public void setRightAim(boolean rightAim) {
		this.rightAim = rightAim;
	}

	public boolean getLeftAim() {
		return leftAim;
	}

	public void setLeftAim(boolean leftAim) {
		this.leftAim = leftAim;
	}

	 
	 
	 /**
	  * Controls the game object tick
	  */
	 public void tick() {
		  for(int i = 0; i < object.size(); i++) {
			   GameObject tempObject = object.get(i);
			   tempObject.tick();
			  /* if(tempObject.getRemove() == true) {
				   removeObject(tempObject);
			   }*/
		  }
		//  if (HUD.HEALTH == 0) {
			 // Game.stop();
			//	System.out.print("hello");
		//	}
	 }
	 
	 /**
	  * Controls adding object rendering
	  * @param g graphics to render
	  */
	 public void render (Graphics g) {
		  for(int i = 0; i < object.size(); i++) {
			   GameObject tempObject = object.get(i);
			   tempObject.render(g);
		  }
	 }
	 
	 /**
	  * Adds the object to the list
	  * @param object to add to list
	  */
	 public void addObject(GameObject object) {
		 this.object.add(object);
	 }
	 
	 /**
	  * Removes the object from the list
	  * @param object to remove from the list
	  */
	 public void removeObject(GameObject object) {
		 this.object.remove(object);
	 }

}
