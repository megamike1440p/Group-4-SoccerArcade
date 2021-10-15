package Group4.SoccerArcade;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuManager extends Pane
{
	/**
	 * Panes
	 */
	private BorderPane mainPane;
	private BorderPane playerSelectPane;
	private BorderPane optionsPane;
	private BorderPane pausePane;

	/**
	 * scenes
	 */
	private Scene mainMenu;
	private Scene playerSelectMenu;
	private Scene optionsMenu;
	private Scene pauseMenu;
	
	/**
	 * CONSTRUCTOR
	 */
	public MenuManager()
	{
		super();
	}

	public Scene mainMenu() 
	{ 
		ButtonManager button = new ButtonManager();
        BorderPane mainPane = new BorderPane();
        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(button.start());
        //vbox.getChildren().add(button.getOptions());
        //vbox.getChildren().add(button.getExit());
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
	 * @author Whitten
	 */
	public Scene playerSelect()
	{	
		ButtonManager button = new ButtonManager();
		playerSelectPane = new BorderPane();
		VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
		vbox.getChildren().addAll(button.onePlayer(), button.twoPlayer());
        vbox.setSpacing(5);
        vbox.setScaleX(4);
        vbox.setScaleY(4);
		playerSelectMenu = new Scene(playerSelectPane, 1920, 1080);
		playerSelectPane.setCenter(vbox);
		return playerSelectMenu;
	}//END PLAYER SELECT SCENE
}
