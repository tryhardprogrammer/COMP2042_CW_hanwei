package frogger;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;


public class LevelController{

    private BackgroundMusic music = new BackgroundMusic();
    private AnimationTimer timer;
    private Animal animal;
    private int levelCompleted = 0;
    Scene scene;
    Stage stage;
    private int overallPoints = 0;
    private String nameEntered;

    private HighScore highScore = new HighScore();


    Levels level1;
    Level1 test;

    public LevelController() {}

    public LevelController(Stage stage){
        this.stage = stage;
    }


    public void createTimer() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                if (animal.changeScore()) {
                    setNumber(overallPoints + animal.getCurrentPoint());
                }
                if (animal.checkFinished()) {
                    overallPoints += animal.getCurrentPoint();

                    if (levelCompleted < 1) {
                        ++levelCompleted;
                        generateLevel(levelCompleted + 1);
                    } else {
                        System.out.print("STOPP:");
                        music.stopMusic();
                        stop();
                        level1.stop();

                        if(HighScore.getInstance().checkLeaderboard(overallPoints)){

                            HighScore.getInstance().updateHighScoreFiles(overallPoints);
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("OH MY FROG!");
                            alert.setHeaderText("Congratulations! You're Amazing!!");
                            alert.setContentText("You made it into the LEADERBOARD with the score of "+overallPoints+"!" + "\nCheck out the Leaderboard in Main Menu! :D");
                            alert.setOnHidden(event -> ScreenController.getInstance().MenuScreen());
                            alert.show();
                        }
                        else{
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("Bad news :(");
                            alert.setHeaderText("Too bad!");
                            alert.setContentText("You need " + (HighScore.getInstance().getLowestScore()-overallPoints) +" more points to make it into LEADERBOARD.\nBetter luck next time!");
                            alert.setOnHidden(event -> ScreenController.getInstance().MenuScreen());
                            alert.show();
                        }




                    }
                }
            }
        };

    }



    public void start() {
        createTimer();
        timer.start();
        music.playMusic();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;

        while (n > 0) {
            int tens  = n / 10;
            int ones = n - tens * 10;
            n = tens;
            level1.add(new Digit(ones, 560 - shift, 25));
            shift+=30;
        }
    }

    public void act(long now) { }


    public void generateLevel(int choice) {

        if(choice == 1){
            level1 = new Level1();
            level1.add(new Digit(0, 560, 25));
            setLvlScreen(level1);
            setNumber(0);
            animal = level1.getAnimal();
            start();
        }
        else {
            switch (choice) {
                case 2:
                    level1 = new Level2();
                    break;
                case 3:
                    level1 = new Level3();
                    break;
                case 4:
                    level1 = new Level4();
                    break;
                case 5:
                    level1 = new Level5();
                    break;
            }
            setNumber(overallPoints);
            setLvlScreen(level1);
            animal = level1.getAnimal();

        }
    }

    public void setLvlScreen(Parent parent){
        scene = new Scene(parent, 600, 800);
        stage.setScene(scene);
    }

    public Animal getAnimal(){
        return animal;
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }

}
