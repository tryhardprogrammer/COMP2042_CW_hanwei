package frogger;

import javafx.application.Platform;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;
import javafx.stage.Stage;

import java.util.Optional;

public class ScreenController {

    Menu menu = new Menu();
    Help help = new Help();
    Leaderboard leaderboard = new Leaderboard();

    private static Stage stage;
    private static ScreenController screenController;
    Scene scene = new Scene(menu,600,800);

    private ScreenController() { }

    public void MenuScreen() {
        setScene(menu);
    }

    public void HelpScreen() {
        setScene(help);
    }

    public void GameScreen() {
        LevelController levelController = new LevelController(stage);
        levelController.generateLevel(1 );
    }

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

    public void Leaderboard(){
        leaderboard.ShowLeaderboard();
    }


    public void setScene(Parent parent) {
        scene.setRoot(parent);
        stage.setScene(scene);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public static ScreenController getInstance() {
        if (screenController == null) {
            screenController = new ScreenController();
        }
        return screenController;
    }

}