package Group4.SoccerArcade;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.*;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.*;


public class App extends Application 
{
	/**
	 * ON APP START
	 */
	public void start(Stage primaryStage)
	{
		//SET THE TITLE
		primaryStage.setTitle("Soccer Arcade");
		
		//CREATE THE MAIN MENU
		MenuManager manager = new MenuManager();
		primaryStage.setScene(manager.mainMenu());

		
		//SHOW THE SCENES
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