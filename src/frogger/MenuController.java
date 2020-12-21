package frogger;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;

public class MenuController {

        ScreenController screenController = new ScreenController();

        @FXML
        private Button playButton;

        public void playButtonOnAction(ActionEvent event){
            screenController.activateScreen("Level1");
        }



}
