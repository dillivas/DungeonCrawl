import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

public class Render {
	
	public static BufferedImage playerStop;
	public static BufferedImage playerUp;
	public static BufferedImage playerDown;
	public static BufferedImage playerLeft;
	public static BufferedImage playerRight;
	
	public static BufferedImage playerRightStanding;
	public static BufferedImage playerLeftStanding;
	public static BufferedImage playerDownStanding;
	public static BufferedImage playerUpStanding;
	
	public static BufferedImage playerRightWalk1;
	public static BufferedImage playerRightWalk2;
	
	public static BufferedImage playerLeftWalk1;
	public static BufferedImage playerLeftWalk2;
	
	public static BufferedImage playerForwardWalk1;
	public static BufferedImage playerForwardWalk2;
	
	public static BufferedImage playerDownWalk1;
	public static BufferedImage playerDownWalk2;
	
	public static BufferedImage enemyImage;
	public static BufferedImage ghostImage;
	
	public static BufferedImage fireball;
	public static BufferedImage pauseScreen;
	public static BufferedImage gameQuit;
	public static BufferedImage gameRestart;
	public static BufferedImage pauseQuit;
	public static BufferedImage pauseRestart;
	public static BufferedImage startQuit;
	public static BufferedImage gameStart;


	
	public static void load()
	{
		try {
			System.out.println("image loaded");
			//playerImage = ImageIO.read(Render.class.getResource("Images/KoolaidMan.JPG"));
			playerStop = ImageIO.read(new File("src/player_images/forward_stand.gif"));
			playerUp = ImageIO.read(new File("src/player_images/forward_walk1.gif"));
			playerDown = ImageIO.read(new File("src/player_images/down_stand.gif"));
			playerLeft = ImageIO.read(new File("src/player_images/left_stand.gif"));
			playerRight = ImageIO.read(new File("src/player_images/right_stand.gif"));
			
			playerRightWalk1 = ImageIO.read(new File("src/player_images/right_walk1.gif"));
			playerRightWalk2 = ImageIO.read(new File("src/player_images/right_walk2.gif"));
			
			playerLeftWalk1 = ImageIO.read(new File("src/player_images/left_walk1.gif"));
			playerLeftWalk2 = ImageIO.read(new File("src/player_images/left_walk2.gif"));
			
			playerForwardWalk1 = ImageIO.read(new File("src/player_images/forward_walk1.gif"));
			playerForwardWalk2 = ImageIO.read(new File("src/player_images/forward_walk2.gif"));
			
			playerDownWalk1 = ImageIO.read(new File("src/player_images/down_walk1.gif"));
			playerDownWalk2 = ImageIO.read(new File("src/player_images/down_walk2.gif"));
			
			playerRightStanding = ImageIO.read(new File("src/player_images/right_stand.gif"));
			playerLeftStanding = ImageIO.read(new File("src/player_images/left_stand.gif"));
			playerDownStanding = ImageIO.read(new File("src/player_images/down_stand.gif"));
			playerUpStanding = ImageIO.read(new File("src/player_images/forward_stand.gif"));
			
			//pauseScreen = ImageIO.read(new File("src/Images/pause_screen.PNG"));
			pauseQuit = ImageIO.read(new File("src/Images/QuitPause.PNG"));
			pauseRestart = ImageIO.read(new File("src/Images/RestartPause.PNG"));
			gameRestart = ImageIO.read(new File("src/Images/RestartGame.PNG"));
			gameQuit = ImageIO.read(new File("src/Images/QuitGame.PNG"));
			gameStart = ImageIO.read(new File("src/Images/GameStart.PNG"));
			startQuit = ImageIO.read(new File("src/Images/StartQuit.PNG"));

			enemyImage = ImageIO.read(new File("src/Images/blob.gif"));
			ghostImage = ImageIO.read(new File("src/Images/ghost.gif"));

			fireball = ImageIO.read(new File("src/Images/fireball.gif"));

		} catch (IOException e) {
			System.out.print("Failed to load image");
			e.printStackTrace();
		}
	}
	
	public BufferedImage loadImage(String str) {
		BufferedImage img = null;

		InputStream is = Render.class.getResourceAsStream(str);
		try {
			img = ImageIO.read(is);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return img;
	}
}