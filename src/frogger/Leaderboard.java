package frogger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

/**
 * Leaderboard view
 * Creates alert box for showing leaderboard*/
public class Leaderboard {


    /**Constructor getting the instance of HighScore*/
    public Leaderboard(){
        HighScore.getInstance().initHighScore();

    }

    /**Creates alert box showing the leaderboard*/
    public void ShowLeaderboard(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Leaderboard! (Top 10 Players)");
        alert.setHeaderText(null);
        alert.setContentText(HighScore.getInstance().getLeaderboardString());
        alert.showAndWait();
    }


}
