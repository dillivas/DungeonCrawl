/**
 * This class Launches the game and controls the game reseting
 * @author William
 * date 2/27/2018
 * class Launch
 */
public class Launch {
/**
 * Contains the variables to trigger the restart of the game,
 * what the current game is, and a trigger to start the game.
 */
public static boolean restart = false;
public static boolean start = false;
public static Game currentGame;

/**
 * Class Constructer for Launch
 */
	private Launch() {
		currentGame = new Game();
		checkForRestart();
} 
/**
 * This function checks for the game to restart and restarts the game.	
 */
public static void checkForRestart(){
	//Always run loop checking for restart
	while(true){
			if(restart==true){
				currentGame = new Game();
				restart = false;
				start = false;
			}
		}
	}
	/**
	 * This Main function launches the game
	 * @param args default main argument
	 */
	public static void main(String args[]) {
		//Start new launch and game
		new Launch();
	}
}
