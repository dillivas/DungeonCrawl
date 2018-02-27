
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;

public class Game extends Canvas implements Runnable{

	private static final long serialVersionUID = 665215786302647934L;

	public static final int WIDTH = 640, HEIGHT = 512;
	
	private boolean running = false;
	private Handler handler;
	private Thread thread;
	private HUD hud;
	private GameScreen gameScreen;
	private SpriteSheet ss;
	private BufferedImage sprite_sheet = null;
	private BufferedImage floor = null;
	private BufferedImage level = null;

	/**
	 * Game Constructor
	 * IMPORTAINT: this will need to be edited so that we can add objetcs in based on map layout later
	 */
	public Game() {
		
		Render.load();
		
		//Game Engine Set up
		new Window(WIDTH, HEIGHT, "Dungeon Crawler", this);
		handler = new Handler();
		BufferedImageLoader loader = new BufferedImageLoader();
		level = loader.loadImage("/Test2.png");
		sprite_sheet = loader.loadImage("/BlocksNew1.png");
		ss = new SpriteSheet(sprite_sheet);
		floor = ss.grabImage(1, 1, 32, 32);
		loadLevel(level);
		hud = new HUD();
		gameScreen = new GameScreen();
		
		this.addKeyListener(new KeyInput(handler, ss));
		
		
		start();
	}

	/**
	 * Start Game
	 */
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}

	/**
	 * Stop Game
	 */
	public synchronized void stop() {
		try {
			thread.join();
			running = false;
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Game Loop.
	 * Also controls the frames.
	 */
	public void run(){
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		int updates = 0;
		while(running)
		{
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			while(delta >=1){
				delta--;
				updates++;
				if (HUD.HEALTH != 0 && KeyInput.pause == false && Launch.start == true) {
  					tick();
  				}	
			}
			if(running)
				render();
			frames++;

			if(System.currentTimeMillis() - timer > 1000){
				timer += 1000;
				System.out.println("FPS: "+ frames + " Updates: " + updates);
				frames = 0;
				updates =0;
			
			}
		}
		stop();
	}

	private void tick() {
		
		handler.tick();
		hud.tick();
	}

	/**
	 * Controls what renders on the screen
	 */
	//used to be private
	public void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}

		Graphics g = bs.getDrawGraphics();
		///////////////////////////////////////
		
		for(int xx = 0; xx < (30*72); xx += 32) {
			for(int yy = 0; yy < (30*72); yy += 32) {
				g.drawImage(floor, xx, yy, null);
			}
		}
		
		handler.render(g);
		hud.render(g);
		gameScreen.startScreen(g);
		gameScreen.render(g);
		///////////////////////////////////////
		g.dispose();
		bs.show();
	}
	
	/**
	 * Double buffer to get ride if screen flicker.
	 * @param g
	 */
	
	
	/**
	 * Method to make sure player stays within room
	 * @param var player movement
	 * @param min room size
	 * @param max room size
	 * @return player position
	 */
	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else 
			return var;
	}

	public static int clampWall(int var, int min, int max) {
		if(var >= max)
			return var = max + 32;
		else if(var <= min)
			return var = min - 32;
		else 
			return var;
	}
	
	//Loading the Level
	private void loadLevel(BufferedImage image) {
		int width = image.getWidth();
		int height = image.getHeight();
		
		for(int xx = 0; xx < width; xx++) {
			for(int yy = 0; yy < height; yy++) {
				int pixel = image.getRGB(xx, yy);
				int red = (pixel >> 16) & 0xff;
				int green = (pixel >> 8) & 0xff;
				int blue = (pixel) & 0xff;
				/////////////////////////////////////////////////////////
				//Load Level First then enemy and player
				if(red == 0 && green == 0 && blue == 255)
					handler.addObject(new Player(xx*32, yy*32, ID.Player,ss, handler));
				if(red == 255 && green == 0 && blue == 0)
					handler.addObject(new Block(xx*32, yy*32, ID.Block,ss));
				if(red == 255 && green == 100 && blue == 0)
					handler.addObject(new Lava(xx*32, yy*32, ID.Lava,ss));
				if(red == 0 && green == 255 && blue == 0)
					handler.addObject(new BasicEnemy(xx*32, yy*32, ID.Enemy,ss,handler));
				//////////////////////////////////////////////////////////
			}
		}
	}
}