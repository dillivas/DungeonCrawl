import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

public class GameScreen{

	Handler handler;

	public char lastKey = 'd';
	public static boolean newGame = false;
	public static boolean start = false;


	public void startScreen(Graphics g) {
		if (start == false) {
			g.drawImage(Render.gameStart,0,0,637,485, null);
			if(KeyInput.space == true) {
				start = true;
			}

			if(KeyInput.up == true) {
				g.drawImage(Render.gameStart,0,0,637,485, null);

				if(KeyInput.space == true) {
					start = true;
				}
				//g.fillRect(x, y, 32, 32);
			}

			if (KeyInput.down == true){
				g.drawImage(Render.startQuit,0,0,637,485, null);
				if(KeyInput.space == true) {
					System.exit(1);		
				}

				//newGame
				//g.fillRect(x, y, 32, 32);
			}
			//g.fillRect(x, y, 32, 32);
		}
	}

	public void render(Graphics g) {
		if (KeyInput.pause == true) {
			//g.drawImage(Render.pauseQuit,0,0,637,485, null);
			if(KeyInput.space == true) {
				System.exit(1);
			}

			if(KeyInput.up == true) {
				g.drawImage(Render.pauseQuit,0,0,637,485, null);

				if(KeyInput.space == true) {
					System.exit(1);
				}
				//g.fillRect(x, y, 32, 32);
			}

			if (KeyInput.down == true){
				g.drawImage(Render.pauseRestart,0,0,637,485, null);
				//newGame
				//g.fillRect(x, y, 32, 32);
			}
			//g.fillRect(x, y, 32, 32);
		}

		if(HUD.HEALTH == 0) {
			//g.drawImage(Render.gameRestart,0,0,650,485, null);
			if(KeyInput.space == true) {
				//newGame()
			}

			if(KeyInput.up == true) {
				g.drawImage(Render.gameQuit,0,0,637,485, null);

				if(KeyInput.space == true) {
					System.exit(1);
				}
				//g.fillRect(x, y, 32, 32);
			}

			if (KeyInput.down == true){
				g.drawImage(Render.gameRestart,0,0,637,485, null);
				//newGame

				//g.fillRect(x, y, 32, 32);s
			}
			{
			}
		}
	}
}

