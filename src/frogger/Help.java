package frogger;

import javafx.stage.Stage;

public class Help extends World{

    Button backButton = new Button("file:src/resources/pictures/button/backbutton.png",207,716, 1);

    public Help ( ){
        BackgroundImage background = new BackgroundImage("file:src/resources/pictures/background/help.png");
        add(background);
        add(backButton);


        backButton.setOnMouseClicked(event -> {
            ScreenController.getInstance().MenuScreen();
        });
    }


    public void createTimer() { }
    public void act(long now){ }
}
