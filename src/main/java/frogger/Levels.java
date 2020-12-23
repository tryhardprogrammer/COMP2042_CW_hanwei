package frogger;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.Optional;

/**Parent class that should be inherited for all levels*/
public class Levels extends World{

    /**current animal in game*/
    private Animal animal;
    /**Back Button*/
    private Button backButtonInGame = new Button("file:src/resources/pictures/button/backingame.png", 515,756,3);
    /**Flag that indicates whether user wants to exit*/
    private boolean exitFlag = false;

    /**empty constructor*/
    public Levels () {}

    /**Sets end zones*/
    public void setEnds(){
        add(new End(13,96));
        add(new End(141,96));
        add(new End(141 + 141-13,96));
        add(new End(141 + 141-13+141-13+1,96));
        add(new End(141 + 141-13+141-13+141-13+3,96));
    }

    /**Add back button in levels
     * if players wants to exit, exitFlag will be true which will stops timer in LevelModel
     */
    public void addButton(){
        add(backButtonInGame);
        backButtonInGame.setOnMouseClicked(event -> {

            stop();
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Wait what?");
            alert.setHeaderText("Don't give up!");
            alert.setContentText("Are you sure you want to leave?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK){
                exitFlag = true;
            } else {
                start();
            }
        });
    }

    /**Get the current animal
     * @return current animal
     */
    public Animal getAnimal(){
        return animal;
    }

    /**Empty abstract method inherited*/
    @Override
    public void act(long now) { }

    /**checks if exit flag is true of false
     * @return  user wants to exit or not
     */
    public boolean isExitFlag(){
        return exitFlag;
    }

}