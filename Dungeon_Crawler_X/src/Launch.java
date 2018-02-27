
public class Launch {

	public static boolean restart = false;
	public static boolean start = false;
	public static Game currentGame;
	
	public static void checkForRestart(){
		while(true) {
			if(restart == true) {
				currentGame = new Game();
				restart = false;
				start = false;
			}
		}
	}
	
	public static void main(String args[]) {
		currentGame = new Game();
		checkForRestart();
	}
}
