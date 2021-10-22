package Group4.SoccerArcade;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MenuManager extends Pane
{
	/**
	 * Panes to be used in scenes
	 */
	private BorderPane mainPane = new BorderPane();
	private BorderPane playerSelectPane = new BorderPane();
	private BorderPane optionsPane = new BorderPane();
	private BorderPane pausePane = new BorderPane();

	/**
	 * scenes to be returned to the stage
	 */
	private Scene mainMenu;
	private Scene playerSelectMenu;
	private Scene optionsMenu;
	private Scene pauseMenu;
	
	/**
	 * CONSTRUCTOR
	 * TODO
	 */
	public MenuManager()
	{
		super();
	}

	/**
	 * The main menu scene
	 * @return mainMenu
	 * @author Whitten/Andrew
	 */
	public Scene mainMenu() 
	{ 
		ButtonManager button = new ButtonManager();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().addAll(button.start(),button.getOptions(),button.getExit());
        vbox.setSpacing(5);
        vbox.setScaleX(4);
        vbox.setScaleY(4);
        mainMenu = new Scene(mainPane, 1920, 1080);
        mainPane.setCenter(vbox);
		return mainMenu;
	}//END MAIN MENU SCENE
	
	/**
	 * The scene for the player select screen
	 * @return playerSelect
	 * @author Whitten/Andrew
	 */
	public Scene playerSelect()
	{	
		ButtonManager button = new ButtonManager();
		VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(button.onePlayer(), button.twoPlayer(), button.back());
        vbox.setSpacing(5);
        vbox.setScaleX(4);
        vbox.setScaleY(4);
		playerSelectMenu = new Scene(playerSelectPane, 1920, 1080);
		playerSelectPane.setCenter(vbox);
		return playerSelectMenu;
	}//END PLAYER SELECT SCENE
}
