package Group4.SoccerArcade;
import java.util.Optional;

import javafx.animation.AnimationTimer;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

/**
 * This class contains information regarding creating and controlling player characters, as well as setting the game scene, could stand to be separated into two classes
 * @author 
 */
public class GameSetter 
{
	//Width and height of the game scene (subject to change when options are implemented)
	private static final double W = 1280, H = 720; 
	
	//Player one sprite
	private static final String playerOneCharacterURL = "https://i.ibb.co/q9j6RQL/character-Blue-1.png";
	private Image playerOneSprite;
	
	//Player two sprite
	private static final String playerTwoCharacterURL = "https://i.ibb.co/qxsm9nm/character-Green-9.png";
	private Image playerTwoSprite;
	
	//Ball Sprite
	private static final String ballURL = "https://icons.iconarchive.com/icons/martin-berube/sport/32/Soccer-icon.png";
	private Image ballSprite;
	
	//Nodes for player one and two
	private Node playerOne;
	private Node playerTwo;
	
	//Ball Node
	private Node ball;
	
	//Bools for controlling character movements
	boolean running, goNorth, goSouth, goEast, goWest;
	boolean running2, goNorth2, goSouth2, goEast2, goWest2;
	boolean collision = false;
	
	/**
	 * Collision detection
	 */
	private boolean playerCollision()
	{
		if (playerOne.getBoundsInParent().intersects(playerTwo.getBoundsInParent()))
		{
			System.out.println("collision == true");
			return true;
		}
		else 
		{
			System.out.println("collision == false");
			return false;
		}
	}
	
	/**
	 * movePlayerBy is a function which works in conjunction with movePlayerTwo and an animation timer in order to control a sprite's movement
	 * @param player
	 * @param dx
	 * @param dy
	 */
	public void movePlayerBy(Node player, int dx, int dy) 
    {
    	if (dx == 0 && dy == 0) return;
    	final double cx = player.getBoundsInLocal().getWidth()  / 2;
    	final double cy = player.getBoundsInLocal().getHeight() / 2;
    	double x = cx + player.getLayoutX() + dx;
    	double y = cy + player.getLayoutY() + dy;
    	movePlayerTo(player, x, y);
    }
	
	/**
	 * movePlayerTo is a function which works in conjunction with movePlayerBy and an animation timer in order to control a sprite's movement
	 * @param player
	 * @param x
	 * @param y
	 */
    public void movePlayerTo(Node player, double x, double y) 
    {
        final double cx = player.getBoundsInLocal().getWidth()  / 2;
        final double cy = player.getBoundsInLocal().getHeight() / 2;
        if (collision != true &&
        	x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H)
        
        {
            player.relocate(x - cx, y - cy);
        }
    }
    
    
    /**
     *	pause is a function that allows the player to return to the main menu or cancel and return to the game 
     * 
     * 
     */
    
    private void pause() 
	{
		Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("PAUSE");
		alert.setHeaderText("EXIT TO MAIN MENU");
		alert.setResizable(false);		
		alert.setX(W/2);
		alert.setY(H/2);
		Optional<ButtonType> result = alert.showAndWait();
		ButtonType button = result.orElse(ButtonType.CANCEL);

		if (button == ButtonType.OK) 
		{
			App.getStage().setScene(new MenuManager().mainMenu());
		} else 
		{
		    System.out.println("canceled");
		}
	}
    
    
    /**
     * Set a one player game scene
     */
    public void setOnePlayer() 
    {
    	//Create the player character image
    	playerOneSprite = new Image(playerOneCharacterURL);
    	playerOne = new ImageView(playerOneSprite);
    	
    	//Create the ball image
    	ballSprite = new Image(ballURL);
    	ball = new ImageView(ballSprite);
    	
    	//Create a group and a scene, and move the player and ball to the starting position
    	Group soccerField = new Group(playerOne, ball);
    	movePlayerTo(playerOne, W / 4, H / 2);
    	Scene onePlayer = new Scene(soccerField, W, H, Color.FORESTGREEN);
    	
    	//Set the controls for the player
    	onePlayer.setOnKeyPressed(e-> 
    	{   
            switch (e.getCode()) 
            {
        		case W: goNorth = true; playerOne.setRotate(270); break;
        		case S: goSouth = true; playerOne.setRotate(90); break;
        		case A: goWest  = true; playerOne.setRotate(180); break;
        		case D: goEast  = true; playerOne.setRotate(0); break;
               	case SHIFT: running = true; break;
               	case ESCAPE: pause(); break;
           	}
    	});
    	onePlayer.setOnKeyReleased(e->
    	{
    		switch (e.getCode()) 
    		{
                	case W: goNorth = false; break;
                	case S: goSouth = false; break;
                	case A: goWest  = false; break;
                	case D: goEast  = false; break;
                    case SHIFT: running = false; break;
            }
    	});
    
    //An animation timer for controlling player one's movement
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            int dx = 0, dy = 0;

            if (goNorth) dy -= 1;
            if (goSouth) dy += 1;
            if (goEast)  dx += 1;
            if (goWest)  dx -= 1;
            if (running) { dx *= 3; dy *= 3; }
            movePlayerBy(playerOne, dx, dy);
        }
    };
    timer.start();
    App.getStage().setScene(onePlayer);
	}
    
    /**
     * Set a two player game scene
     */
    public void setTwoPlayer() 
    {
    	//Create the player images
        playerOneSprite = new Image(playerOneCharacterURL);
        playerOne = new ImageView(playerOneSprite);
        playerTwoSprite = new Image(playerTwoCharacterURL);
        playerTwo = new ImageView(playerTwoSprite);
        
    	//Create the ball image
    	ballSprite = new Image(ballURL);
    	ball = new ImageView(ballSprite);
        
        //Create a group and a scene, and set the players starting positions
        Group soccerField = new Group(playerOne, playerTwo, ball);
        movePlayerTo(playerOne, W / 4, H / 2);
        movePlayerTo(playerTwo, W / 1.25, H / 2);
        playerTwo.setRotate(180);
        Scene twoPlayer = new Scene(soccerField, W, H, Color.FORESTGREEN);
        
        //Set the controls for two players
        twoPlayer.setOnKeyPressed(e-> 
        {
        	switch (e.getCode()) 
            {
            	case W: goNorth = true; playerOne.setRotate(270); break;
                case S: goSouth = true; playerOne.setRotate(90); break;
                case A: goWest  = true; playerOne.setRotate(180); break;
                case D: goEast  = true; playerOne.setRotate(0); break;
                case SHIFT: running = true; break;
                case UP: goNorth2 = true; playerTwo.setRotate(270); break;
                case DOWN: goSouth2 = true; playerTwo.setRotate(90); break;
                case LEFT: goWest2  = true; playerTwo.setRotate(180); break;
                case RIGHT: goEast2  = true; playerTwo.setRotate(0); break;
                case CONTROL: running2 = true; break;
                case ESCAPE: pause(); break;
            }
            
        });
        twoPlayer.setOnKeyReleased(e->
        {
        	switch (e.getCode()) 
            {
            	case W: goNorth = false; break;
                case S: goSouth = false; break;
               	case A: goWest  = false; break;
               	case D: goEast  = false; break;
               	case SHIFT: running = false; break;
                case UP:    goNorth2 = false; break;
                case DOWN:  goSouth2 = false; break;
                case LEFT:  goWest2  = false; break;
                case RIGHT: goEast2  = false; break;
                case CONTROL: running2 = false; break;
            } 
         });
        
        //Timer for player one's animations, also handles collision testing
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) 
            {
                int dx = 0, dy = 0;
                if ((goNorth == true) && (playerCollision()) == false) {dy -= 1;}
                else if ((goNorth == true) && (playerCollision()) == true) {dy += 1;}
                if ((goSouth == true) && (playerCollision()) == false) {dy += 1;}
                else if ((goSouth == true) && (playerCollision()) == true) {dy -= 1;}
                if ((goEast == true) && (playerCollision()) == false) {dx += 1;}
                else if ((goEast == true) && (playerCollision()) == true) {dx -=1;}
                if ((goWest == true) && (playerCollision()) == false) {dx -= 1;}
                else if ((goWest == true) && (playerCollision()) == true) {dx +=1;}
                if (running) { dx *= 2; dy *= 2; }
                movePlayerBy(playerOne, dx, dy);
            }
        };
        
        //Timer for player two's animations, also handles collision checking
        AnimationTimer timer2 = new AnimationTimer() {
            @Override
            public void handle(long now) 
            {
                int dx = 0, dy = 0;
                if ((goNorth2 == true) && (playerCollision()) == false) {dy -= 1;}
                else if ((goNorth2 == true) && (playerCollision()) == true) {dy += 1;}
                if ((goSouth2 == true) && (playerCollision()) == false) {dy += 1;}
                else if ((goSouth2 == true) && (playerCollision()) == true) {dy -= 1;}
                if ((goEast2 == true) && (playerCollision()) == false) {dx += 1;}
                else if ((goEast2 == true) && (playerCollision()) == true) {dx -=1;}
                if ((goWest2 == true) && (playerCollision()) == false) {dx -= 1;}
                else if ((goWest2 == true) && (playerCollision()) == true) {dx +=1;}
                if (running2) { dx *= 2; dy *= 2; }
                movePlayerBy(playerTwo, dx, dy);
            }
        };
        
        //Start the timers and set the scene
        timer.start();
        timer2.start();
        App.getStage().setScene(twoPlayer);
    }
}

