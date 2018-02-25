/************************************************
 * Written By: William Mckeever    				*
 * Date: 1/28/2018       						*
 * Class: Block      							*
 *            									*
 * The class controls a wall or block object	*
 * to act as a obstacle to the player.			*
 ************************************************/



import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class Block extends GameObject{
	
	private BufferedImage block_image;
	
	public Block(int x, int y, ID id, SpriteSheet ss) {
		super(x,y,id, ss);
		block_image = ss.grabImage(2,1,32,32);
	}
	@Override
	public void tick() {
		
	}
	@Override
	public void render(Graphics g) {
		/*g.setColor(Color.red);
		g.fillRect(x, y, 32, 32);*/
		g.drawImage(block_image, x, y, null);
	}
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x,y,32,32);
	}
}
