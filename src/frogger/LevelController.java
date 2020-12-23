package frogger;

import javafx.animation.AnimationTimer;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

/**Controls how each level works with AnimationTimer*/
public class LevelController{

    /**Controls music*/
    private BackgroundMusic music = new BackgroundMusic();
    /**timer for animation*/
    private AnimationTimer timer;
    /**current animal in the level*/
    private Animal animal;
    /**number of levels completed*/
    private int levelCompleted = 0;
    /**Scene*/
    private Scene scene;
    /**the stage of the whole application*/
    private Stage stage;
    /**all points added from all levels completed*/
    private int overallPoints = 0;

    /**current level that needs to be handle*/
    private Levels currentLevel;

    /**Constructor that gets the application's stage
     * @param stage application's stage
     */
    public LevelController(Stage stage){
        this.stage = stage;
    }

    /**Creates the animation timer for each level
     * Handles what to do when player finish the game
     * Updates score
     */
    public void createTimer() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {


                if (animal.changeScore()) {
                    setNumber(overallPoints + animal.getCurrentPoint());
                }
                if (animal.checkFinished()) {
                    overallPoints += animal.getCurrentPoint();

                    if (levelCompleted < 4) {
                        ++levelCompleted;
                        initLevel(levelCompleted + 1);
                    } else {
                        System.out.print("STOPP:");
                        music.stopMusic();
                        stop();
                        currentLevel.stop();

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


    /**Starts everything like timer and music*/
    public void start() {
        createTimer();
        timer.start();
        music.playMusic();
    }

    /**stops timer*/
    public void stop() {
        timer.stop();
    }

    /**Handles the score displays
     * @param n the number that needs to be set
     */
    public void setNumber(int n) {
        int shift = 0;

        while (n > 0) {
            int tens  = n / 10;
            int ones = n - tens * 10;
            n = tens;
            currentLevel.add(new Digit(ones, 560 - shift, 25));
            shift+=30;
        }
    }

    /**Initialise the desired level
     * @param choice indicating which level to generate
     */
    public void initLevel(int choice) {

        if(choice == 1){
            currentLevel = new Level1();
            currentLevel.add(new Digit(0, 560, 25));
            setLvlScreen(currentLevel);
            setNumber(0);
            animal = currentLevel.getAnimal();
            start();
        }
        else {
            switch (choice) {
                case 2:
                    currentLevel = new Level2();
                    break;
                case 3:
                    currentLevel = new Level3();
                    break;
                case 4:
                    currentLevel = new Level4();
                    break;
                case 5:
                    currentLevel = new Level5();
                    break;
            }
            setNumber(overallPoints);
            setLvlScreen(currentLevel);
            animal = currentLevel.getAnimal();

        }
    }

    /**Sets the level screen to stage
     * @param parent the level object
     */
    public void setLvlScreen(Parent parent){
        scene = new Scene(parent, 600, 800);
        stage.setScene(scene);
    }

}
