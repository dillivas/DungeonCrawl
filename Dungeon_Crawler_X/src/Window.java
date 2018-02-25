/****************************************************************************
 * Written By: William Mckeever            									*
 * Date: 1/28/2018               											*
 * Class: Window               												*
 *                    														*
 * Source Assistance: https://www.youtube.com/watch?v=1gir2R7G9ws&t=661s 	*
 *                    														*
 * The Class controls the game window          								*
 ****************************************************************************/

//Ctrl + shift + o to auto add imports
//Imports List
import java.awt.Canvas;
import java.awt.Dimension;
import javax.swing.JFrame;

public class Window extends Canvas{
 
	 //Add generated serial version ID
	 //unsure what this does
	 private static final long serialVersionUID = 354447516600833510L;
	 
	 /**
	  * Window constructor
	  *
	  * @param width of window
	  * @param height of window
	  * @param title of window
	  * @param game be displayed
	  */
	 public Window (int width, int height, String title, Game game) {
		  System.out.println("Working");
		  JFrame frame = new JFrame(title);
		  
		  frame.setPreferredSize(new Dimension(width, height));
		  frame.setMaximumSize(new Dimension(width, height));
		  frame.setMinimumSize(new Dimension(width, height));
		  
		  //Very important to closing the game correctly
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setResizable(false);
		  frame.setLocationRelativeTo(null);
		  frame.add(game);
		  frame.setVisible(true);
		  game.start();
		  
	 }
}
