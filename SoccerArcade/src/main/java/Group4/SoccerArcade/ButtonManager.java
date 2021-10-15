package Group4.SoccerArcade;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonManager
{
	/**
	 * constructor
	 */
	public ButtonManager() 
	{
		//super();
	}
	
	/**
	 * Can't create a manager as a class variable for some reason, if its done as a class variable an exception is throw unless the one in the main method is removed. Not sure why.
	 * Method to add the start button
	 * @return start
	 * @author Whitten
	 */
	public Button start()
	{
		Button start = new Button();
		start.setText("Start da game!");
		start.setOnAction(e-> 
		{
				//TEST
				System.out.println("Start Pressed");
				App.getStage().setScene(new MenuManager().playerSelect());
		});
		return start;
	}
	/**
	 * Method to add the 'one player' button
	 * @return onePlayer
	 * @author Whitten
	 */
	public Button onePlayer()
	{
		Button onePlayer = new Button();
		onePlayer.setText("One Player");
		onePlayer.setAlignment(Pos.CENTER_LEFT);
		onePlayer.setOnAction(e-> 
		{
			System.out.println("One Player pressed");
		});
		return onePlayer;
	}
	
	/**
	 * Method to add the 'Two Players' button
	 * @return twoPlayer
	 * @author Whitten
	 */

	public Button twoPlayer()
	{
		Button twoPlayer = new Button();
		twoPlayer.setText("Two Player");
		twoPlayer.setOnAction(e-> 
		{
			System.out.println("Two Player pressed");
		});
		return twoPlayer;
	}
}