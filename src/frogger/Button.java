package frogger;

import javafx.scene.image.Image;


public class Button extends Actor{

    private int choice;

    public Button (String imageLink, int xpos, int ypos, int choice){

        this.choice = choice;

        if(choice == 1){
            setImage(new Image(imageLink, 156, 57, false, false ));
         }
        else if (choice == 2)
        {
            setImage(new Image(imageLink,398, 56, true, false ));
        }

        setX(xpos);
        setY(ypos);

    }


    @Override
    public void act(long now) {

    }
}
