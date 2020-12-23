package frogger;

import javafx.stage.Stage;

/**Sets up Help view by adding essential Actors(Nodes)*/
public class Help extends World{

    /**Initialize back button*/
    Button backButton = new Button("file:src/resources/pictures/button/backbutton.png",207,716, 1);

    /**Constructor that adds essential nodes to the scene*/
    public Help ( ){
        BackgroundImage background = new BackgroundImage("file:src/resources/pictures/background/help.png");
        add(background);
        add(backButton);


        backButton.setOnMouseClicked(event -> {
            ScreenController.getInstance().MenuScreen();
        });
    }

    /**abstract classes inhertied from World*/
    public void createTimer() { }

    /**abstract classes inhertied from World*/
    public void act(long now){ }
}
