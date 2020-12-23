package frogger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Leaderboard {



    public Leaderboard(){

        HighScore.getInstance().initHighScore();

    }

    public void ShowLeaderboard(){
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Leaderboard! (Top 10 Players)");
        alert.setHeaderText(null);
        alert.setContentText(HighScore.getInstance().getLeaderboardString());
        alert.showAndWait();
    }


}
