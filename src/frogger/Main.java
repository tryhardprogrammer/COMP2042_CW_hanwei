package frogger;

import java.io.File;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Main extends Application {
	AnimationTimer timer;
	frogger.MyStage background;
	frogger.Animal animal;
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
	    background = new frogger.MyStage();
	    Scene scene  = new Scene(background,600,800);
	    
		//Obstacle obstacle = new Obstacle("file:src/resources/pictures/truck/truck/truck/truck1Right.png", 25, 25, 3);
		//Obstacle obstacle1 = new Obstacle("file:src/resources/pictures/truck/truck/truck/truck2Right.png", 100, 100,2 );
		//Obstacle obstacle2 = new Obstacle("file:src/resources/pictures/truck/truck/truck/truck1Right.png",0,  150, 1);

		BackgroundImage froggerback = new BackgroundImage("file:src/resources/pictures/background/game.png");
	    
		background.add(froggerback);
		
		background.add(new frogger.Log("file:src/resources/pictures/log/log3.png", 150, 0, 166, 0.75));
		//background.add(new Log("file:src/resources/pictures/log/log3.png", 150, 220, 166, 0.75));
		background.add(new frogger.Log("file:src/resources/pictures/log/log3.png", 150, 440, 166, 0.75));
		//background.add(new Log("file:src/resources/pictures/log/log3.png", 150, 0, 166, 0.75));
		background.add(new frogger.Log("file:src/resources/pictures/log/logs.png", 300, 0, 276, -2));
		background.add(new frogger.Log("file:src/resources/pictures/log/logs.png", 300, 400, 276, -2));
		//background.add(new Log("file:src/resources/pictures/log/logs.png", 300, 800, 276, -2));
		background.add(new frogger.Log("file:src/resources/pictures/log/log3.png", 150, 50, 329, 0.75));
		background.add(new frogger.Log("file:src/resources/pictures/log/log3.png", 150, 270, 329, 0.75));
		background.add(new frogger.Log("file:src/resources/pictures/log/log3.png", 150, 490, 329, 0.75));
		//background.add(new Log("file:src/resources/pictures/log/log3.png", 150, 570, 329, 0.75));
		
		background.add(new frogger.Turtle(500, 376, -1, 130, 130));
		background.add(new frogger.Turtle(300, 376, -1, 130, 130));
		background.add(new frogger.WetTurtle(700, 376, -1, 130, 130));
		background.add(new frogger.WetTurtle(600, 217, -1, 130, 130));
		background.add(new frogger.WetTurtle(400, 217, -1, 130, 130));
		background.add(new frogger.WetTurtle(200, 217, -1, 130, 130));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 200, 100, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 0, 100, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 100, 120, -1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 200, 120, -1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 100, 140, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 200, 140, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 100, 160, -1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 300, 160, -1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 100, 180, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 200, 180, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 100, 200, -1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 200, 200, -1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 100, 220, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 200, 220, 1));
		//background.add(new Log("file:src/resources/pictures/log/log2.png", 400, 220, 1));
		//End end2 = new End();
		//End end3 = new End();
		//End end4 = new End();
		//End end5 = new End();
		background.add(new frogger.End(13,96));
		background.add(new frogger.End(141,96));
		background.add(new frogger.End(141 + 141-13,96));
		background.add(new frogger.End(141 + 141-13+141-13+1,96));
		background.add(new frogger.End(141 + 141-13+141-13+141-13+3,96));
		animal = new frogger.Animal("file:src/resources/pictures/frogger/froggerUp.png");
		background.add(animal);
		background.add(new frogger.Obstacle("file:src/resources/pictures/truck/truck1"+"Right.png", 0, 649, 1, 120, 120));
		background.add(new frogger.Obstacle("file:src/resources/pictures/truck/truck1"+"Right.png", 300, 649, 1, 120, 120));
		background.add(new frogger.Obstacle("file:src/resources/pictures/truck/truck1"+"Right.png", 600, 649, 1, 120, 120));
		//background.add(new Obstacle("file:src/resources/pictures/truck/truck1"+"Right.png", 720, 649, 1, 120, 120));
		background.add(new frogger.Obstacle("file:src/resources/pictures/car/car1Left.png", 100, 597, -1, 50, 50));
		background.add(new frogger.Obstacle("file:src/resources/pictures/car/car1Left.png", 250, 597, -1, 50, 50));
		background.add(new frogger.Obstacle("file:src/resources/pictures/car/car1Left.png", 400, 597, -1, 50, 50));
		background.add(new frogger.Obstacle("file:src/resources/pictures/car/car1Left.png", 550, 597, -1, 50, 50));
		background.add(new frogger.Obstacle("file:src/resources/pictures/truck/truck2Right.png", 0, 540, 1, 200, 200));
		background.add(new frogger.Obstacle("file:src/resources/pictures/truck/truck2Right.png", 500, 540, 1, 200, 200));
		background.add(new frogger.Obstacle("file:src/resources/pictures/car/car1Left.png", 500, 490, -5, 50, 50));
		background.add(new frogger.Digit(0, 560, 25));
		//background.add(obstacle);
		//background.add(obstacle1);
		//background.add(obstacle2);
		background.start();
		primaryStage.setScene(scene);
		primaryStage.show();
		start();  
	}
	public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
            	if (animal.changeScore()) {
            		setNumber(animal.getPoints());
            	}
            	if (animal.getStop()) {
            		System.out.print("STOPP:");
            		background.stopMusic();
            		stop();
            		background.stop();
            		Alert alert = new Alert(AlertType.INFORMATION);
            		alert.setTitle("You Have Won The Game!");
            		alert.setHeaderText("Your High Score: "+animal.getPoints()+"!");
            		alert.setContentText("Highest Possible Score: 800");
            		alert.show();
            	}
            }
        };
    }
	public void start() {
		background.playMusic();
    	createTimer();
        timer.start();
    }

    public void stop() {
        timer.stop();
    }
    
    public void setNumber(int n) {
    	int shift = 0;
    	while (n > 0) {
    		  int d = n / 10;
    		  int k = n - d * 10;
    		  n = d;
    		  background.add(new frogger.Digit(k, 560 - shift, 25));
    		  shift+=30;
    		}
    }
}
