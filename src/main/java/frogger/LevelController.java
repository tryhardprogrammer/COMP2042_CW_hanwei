package frogger;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

public class LevelController {

    /**Scene*/
    private Scene scene;
    /**the stage of the whole application*/
    private static Stage stage;

    /**Create Level 1 instance*/
    private Level1 level1 = new Level1();
    /**Create Level 1 instance*/
    private Level2 level2 = new Level2();
    /**Create Level 1 instance*/
    private Level3 level3 = new Level3();
    /**Create Level 1 instance*/
    private Level4 level4 = new Level4();
    /**Create Level 1 instance*/
    private Level5 level5 = new Level5();

    /**current level that needs to be handle*/
    private Levels levelHandler;

    /**Create LevelModel instance (the only class who initializes LevelModel)*/
    private LevelModel levelModel = new LevelModel();

    /**For implementing Singleton pattern*/
    private static LevelController levelController;

    /**Empty Constuctor*/
    LevelController(){}

    /**Alert box if player made into Leaderboard*/
    public void playerWins(){
        HighScore.getInstance().updateHighScoreFiles(levelModel.getOverallPoints());
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("OH MY FROG!");
        alert.setHeaderText("Congratulations! You're Amazing!!");
        alert.setContentText("You made it into the LEADERBOARD with the score of "+ levelModel.getOverallPoints()+"!" + "\nCheck out the Leaderboard in Main Menu! :D");
        alert.setOnHidden(event -> ScreenController.getInstance().MenuScreen());
        alert.show();
    }

    /**Alert box if player didn't made into Leaderboard*/
    public void playerLoses(){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Bad news :(");
        alert.setHeaderText("Aww Too bad!");
        alert.setContentText("You need " + (HighScore.getInstance().getLowestScore()-levelModel.getOverallPoints()) +" more points to make it into LEADERBOARD.\nBetter luck next time!");
        alert.setOnHidden(event -> ScreenController.getInstance().MenuScreen());
        alert.show();
    }

    /**Initialise the desired level
     * @param choice indicating which level to generate
     */
    public void initLevel(int choice) {

        if(choice == 1){
            levelHandler = new Level1();
            levelHandler.add(new Digit(0, 560, 25));
            setLvlScreen(levelHandler);
            setNumber(0);
            levelModel.setAnimal(levelHandler.getAnimal());
            levelModel.setCurrentLevel(levelHandler);
            levelHandler.start();
            levelModel.start();
        }
        else {
            switch (choice) {
                case 2:
                    levelHandler = new Level2();
                    break;
                case 3:
                    levelHandler = new Level3();
                    break;
                case 4:
                    levelHandler = new Level4();
                    break;
                case 5:
                    levelHandler = new Level5();
                    break;
            }
            setNumber(levelModel.getOverallPoints());
            setLvlScreen(levelHandler);
            levelHandler.start();
            levelModel.setAnimal(levelHandler.getAnimal());
            levelModel.setCurrentLevel(levelHandler);

        }
    }

    /**Sets the level screen to stage
     * @param parent the level object
     */
    public void setLvlScreen(Parent parent){
        scene = new Scene(parent, 600, 800);
        stage.setScene(scene);
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
            levelHandler.add(new Digit(ones, 560 - shift, 25));
            shift+=30;
        }
    }

    /**sets stage from the application stage
     * @param stage the application stage
     */
    public void setStage(Stage stage){
        this.stage = stage;
    }

    /**
     * Prevents other classes to initialize this class to achieve Singleton
     * @return leverController which is the instance of leverController
     */
    public static LevelController getInstance() {
        if (levelController == null) {
            levelController = new LevelController();
        }
        return levelController;
    }
}
