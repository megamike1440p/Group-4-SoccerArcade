package Group4.SoccerArcade;
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
		ButtonManager button = new ButtonManager();	
		StackPane root = new StackPane();
		Scene mainMenu = new Scene(root, 480, 360);
		root.getChildren().add(button.getStart());
		return mainMenu;
	}//END MAIN MENU SCENE
	
	/*
	public Scene playerSelect()
	{
		Scene playerSelect = new Scene(root);
		
	}
	*/
}
