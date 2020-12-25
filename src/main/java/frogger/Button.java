package frogger;

import javafx.scene.image.Image;

/**Buttons for Menu, Help*/
public class Button extends Actor{


    /**Initialize buttons
     * @param imageLink image directory
     * @param xpos x-position of the button
     * @param ypos y-position of the button
     * @param choice which size button to create
     */
    public Button (String imageLink, int xpos, int ypos, int choice){


        //play, help, back button
        if(choice == 1){
            setImage(new Image(imageLink, 156, 57, false, false ));
         }
        //instruction button
        else if (choice == 2)
        {
            setImage(new Image(imageLink,398, 56, true, false ));
        }
        else if(choice ==3){

            setImage(new Image(imageLink, 40, 40, true, true));
        }

        setX(xpos);
        setY(ypos);

    }

    /**Empty abstract class inherited from Actor class*/
    @Override
    public void act(long now) {

    }
}
