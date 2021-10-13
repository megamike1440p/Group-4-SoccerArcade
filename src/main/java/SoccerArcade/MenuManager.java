package SoccerArcade;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
public class MenuManager extends Pane
{
	/**
	 * CONSTRUCTOR
	 */
	public MenuManager()
	{
	}

	/**
	* The scene for the main menu
	 * @return mainMenu
	 */
	public Scene mainMenu() 
	{
		GameButton start = new GameButton();
		start.setText("START DA GAME!");
		
		//What happens when "Start" is pressed: 
		start.setOnAction(new EventHandler<ActionEvent>() 
		{
			public void handle(ActionEvent event)
			{
				//TEST
				System.out.println("Start Pressed");
				//Create a scene for the sub menu
				
				StackPane root = new StackPane();
				Scene playerSelect = new Scene(root, 480, 360);
				
				
				//Create button for player one
				Button onePlayer = new Button();
				onePlayer.setText("One Player!");

				//Swap scenes
				root.getChildren().add(onePlayer);
				
				
				onePlayer.setOnAction(new EventHandler<ActionEvent>()
						{
							public void handle(ActionEvent event)
							{
								//What happens when "One Player" is pressed:
								System.out.println("One Player Pressed");
							}
						});
				
			}
		});
		
		
		StackPane root = new StackPane();
		Scene mainMenu = new Scene(root, 480, 360);
		root.getChildren().add(start);
		return mainMenu;
	}//END MAIN MENU SCENE
	
	public Scene playerSelect()
	{
		
	}
}
