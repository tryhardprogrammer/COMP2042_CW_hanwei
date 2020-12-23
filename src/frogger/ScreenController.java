package frogger;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

/**Controllers that controls which view to show*/
public class ScreenController {
    /**Menu view instance*/
    private Menu menu = new Menu();
    /**Help view instance*/
    private Help help = new Help();
    /**Leaderboard view instance*/
    private Leaderboard leaderboard = new Leaderboard();

    /**Stage of the application*/
    private static Stage stage;
    /**For implementing Singleton pattern*/
    private static ScreenController screenController;
    /**Scene*/
    private Scene scene = new Scene(menu,600,800);

    /**Empty constructor*/
    private ScreenController() { }

    /**Sets Menu View*/
    public void MenuScreen() {
        setScene(menu);
    }

    /**Sets Help View*/
    public void HelpScreen() {
        setScene(help);
    }

    /**Sets Game View*/
    public void GameScreen() {
        LevelController levelController = new LevelController(stage);
        levelController.initLevel(1 );
    }

    /**Sets get name dialog*/
    public void Dialog(){
        TextInputDialog dialog = new TextInputDialog("Player");
        dialog.setTitle("Before we start...");
        dialog.setHeaderText("Enter your name so we know who you are! :)");
        dialog.setContentText("Enter your name : ");
        dialog.setOnHidden(evt -> GameScreen());
        Optional<String> result = dialog.showAndWait();
        if (result.isPresent()){
            HighScore.getInstance().setNameEntered(result.get());
            System.out.println("Your name: " + result.get());
        }
        else{
            System.out.println("No entered");
        }
    }

    /**Sets leaderboard view*/
    public void Leaderboard(){
        leaderboard.ShowLeaderboard();
    }

    /**Sets scene to stage
     * @param parent get scene
     */
    public void setScene(Parent parent) {
        scene.setRoot(parent);
        stage.setScene(scene);
    }

    /**sets stage to the application stage
     * @param stage the application stage
     */
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    /**
     * Prevents other classes to initialize this class to acheive Singleton
     * @return screenController which is the instance of screenController*/
    public static ScreenController getInstance() {
        if (screenController == null) {
            screenController = new ScreenController();
        }
        return screenController;
    }

}