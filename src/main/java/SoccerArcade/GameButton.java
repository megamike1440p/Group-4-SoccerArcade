package SoccerArcade;

import javafx.scene.control.Button;

public class GameButton extends Button
{
	/**
	 * The start button 
	 */
	private Button start = new Button();
	
	/**
	 * Method to add the start button
	 * @return start
	 */
	public Button addStartButton()
	{
		start.setText("Start da game!");
		return start;
	}
	
	/**
	 * constructor
	 */
	public gameButton() 
	{
		super();
	}
	
	
}
