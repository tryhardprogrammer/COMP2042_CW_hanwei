package frogger;

import javafx.scene.image.Image;

/**Buttons for Menu, Help*/
public class Button extends Actor{

    /**Selects which size of buttons to create*/
    private int choice;

    /**Initialize buttons
     * @param imageLink image directory
     * @param xpos x-position of the button
     * @param ypos y-position of the button
     * @param choice which size button to create
     */
    public Button (String imageLink, int xpos, int ypos, int choice){

        this.choice = choice;

        //play, help, back button
        if(choice == 1){
            setImage(new Image(imageLink, 156, 57, false, false ));
         }
        //instruction button
        else if (choice == 2)
        {
            setImage(new Image(imageLink,398, 56, true, false ));
        }

        setX(xpos);
        setY(ypos);

    }

    /**Empty abstract class inherited from Actor class*/
    @Override
    public void act(long now) {

    }
}
