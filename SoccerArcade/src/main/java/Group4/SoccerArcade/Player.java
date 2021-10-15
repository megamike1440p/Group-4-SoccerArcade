package Group4.SoccerArcade;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Player extends Rectangle
{
    private static final double W = 600, H = 400;
    private static final String HERO_IMAGE_LOC = "https://icons.iconarchive.com/icons/martin-berube/sport/32/Soccer-icon.png";
    private Image heroImage;
    private Node hero;
    boolean running, goNorth, goSouth, goEast, goWest;
    
    private void moveHeroBy(int dx, int dy) 
    {
    	if (dx == 0 && dy == 0) return;
    	final double cx = hero.getBoundsInLocal().getWidth()  / 2;
    	final double cy = hero.getBoundsInLocal().getHeight() / 2;
    	double x = cx + hero.getLayoutX() + dx;
    	double y = cy + hero.getLayoutY() + dy;
    	moveHeroTo(x, y);
    }
    
    private void moveHeroTo(double x, double y) 
    {
        final double cx = hero.getBoundsInLocal().getWidth()  / 2;
        final double cy = hero.getBoundsInLocal().getHeight() / 2;
        if (x - cx >= 0 &&
            x + cx <= W &&
            y - cy >= 0 &&
            y + cy <= H) 
        {
            hero.relocate(x - cx, y - cy);
        }
    }
    
    public void setGameScene() 
    {
    	heroImage = new Image(HERO_IMAGE_LOC);
    	hero = new ImageView(heroImage);
    	Group dungeon = new Group(hero);
    	moveHeroTo(W / 2, H / 2);
    	Scene scene = new Scene(dungeon, W, H, Color.FORESTGREEN);
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() 
    	{
        @Override
        	public void handle(KeyEvent event) 
        	{
            	switch (event.getCode()) 
            	{
                	case UP: goNorth = true; break;
                	case DOWN: goSouth = true; break;
                	case LEFT: goWest  = true; break;
                	case RIGHT: goEast  = true; break;
                	case SHIFT: running = true; break;
            	}
        	}
    	});

    scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            switch (event.getCode()) {
                case UP:    goNorth = false; break;
                case DOWN:  goSouth = false; break;
                case LEFT:  goWest  = false; break;
                case RIGHT: goEast  = false; break;
                case SHIFT: running = false; break;
            }
        }
    });
    AnimationTimer timer = new AnimationTimer() {
        @Override
        public void handle(long now) {
            int dx = 0, dy = 0;

            if (goNorth) dy -= 1;
            if (goSouth) dy += 1;
            if (goEast)  dx += 1;
            if (goWest)  dx -= 1;
            if (running) { dx *= 3; dy *= 3; }

            moveHeroBy(dx, dy);
        }
    };
    timer.start();
    App.getStage().setScene(scene);
    																}
    
}
