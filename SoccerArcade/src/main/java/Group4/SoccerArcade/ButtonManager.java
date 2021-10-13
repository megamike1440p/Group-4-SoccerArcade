package Group4.SoccerArcade;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;

public class ButtonManager extends Button
{
	/**
	 * The start button 
	 */
		/**
	 * constructor
	 */
	public ButtonManager() 
	{
		super();
	}
	
	/**
	 * Method to add the start button
	 * @return start
	 */
	public Button getStart()
	{
		Button start = new Button();
		start.setText("Start da game!");
		start.setOnAction(e-> 
		{
				//TEST
				System.out.println("Start Pressed");
		});
		return start;
	}
	

	
	
}
