package Group4.SoccerArcade;
import javafx.application.Application;
import javafx.stage.Stage;

public class App extends Application
{
	//private static Stage staticStage;
	private MenuManager manager = new MenuManager();
	private static Stage staticStage;
	public static Stage getStage() {return staticStage;}
	
	/**
	 * ON APP START
	 */
	public void start(Stage primaryStage)
	{
		staticStage = primaryStage;

		//SET THE TITLE
		primaryStage.setTitle("Soccer Arcade");
		
		//CREATE THE MAIN MENU
		App.getStage().setScene(manager.mainMenu());
		
		//SHOW THE SCENES
		primaryStage.sizeToScene();
		primaryStage.show();
	}

	/**
	 * MAIN METHOD 
	 * @param args
	 */
	public static void main(String[] args)
	{
		launch(args);
	}
}