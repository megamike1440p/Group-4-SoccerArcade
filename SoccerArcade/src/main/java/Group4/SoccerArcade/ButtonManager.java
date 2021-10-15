package Group4.SoccerArcade;
import javafx.geometry.Pos;
import javafx.scene.control.Button;

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
		start.setText("Start James");
		start.setOnAction(e-> 
		{
				//TEST
				System.out.println("Start Pressed");
				App.getStage().setScene(new MenuManager().playerSelect());
		});
		return start;
	}
	
	/**
	 * Options button
	 * @return option
	 * @author Andrew
	 */
	public Button getOptions() 
	{
		Button option = new Button();
		option.setText("  Options  ");
		option.setOnAction(e->
		{
			//TEST
			System.out.println("Options Pressed");
		});
		
		return option;
	}
	
	/**
	 * Exit button
	 * @return exit
	 * @author Andrew
	 */
	public Button getExit() {
		Button exit = new Button();
		exit.setText("     EXIT     ");
		exit.setOnAction(e->
		{			
			//TEST
			System.out.println("Exit Pressed");
			System.exit(0);
		});
		
		return exit;
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
	
	/**
	 * The back button to return to the main menu
	 * @return back
	 * @author Whitten
	 */
	public Button back()
	{
		Button back = new Button();
		back.setText("     Back     ");
		back.setOnAction(e->
		{
			System.out.println("Back pressed");
			App.getStage().setScene(new MenuManager().mainMenu());
		});
		return back;
	}
}