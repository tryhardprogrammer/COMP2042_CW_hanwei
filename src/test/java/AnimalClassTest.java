import frogger.Animal;
import frogger.Levels;
import javafx.embed.swing.JFXPanel;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class AnimalClassTest {

    JFXPanel jfxPanel = new JFXPanel();

    Animal animal = new Animal();
    Levels lvl = new Levels();


    @Test
    public void testResetPosition(){

        lvl.setAnimal(animal);
        lvl.addAnimal();
        animal.setX(400);
        animal.setY(500);


        animal.resetPos();
        assertEquals(300, animal.getX(),0.0);
        assertEquals(701.133332, animal.getY(),0.0);

    }

    @Test
    public void testOutOfBounds(){

        lvl.setAnimal(animal);
        lvl.addAnimal();            //adds animal (nodes) into world(pane)
        animal.setY(735);           //Y-axis of animal getting out of upper bounds


        animal.act(0);      //reaction when animal is out of bounds
        assertEquals(animal.getStartY(), animal.getY(),0.0);


        animal.setY(-1);            //Y-axis of animal getting out of lower bounds

        animal.act(0);          //reaction when animal is out of bounds
        assertEquals(animal.getStartY(), animal.getY(), 0.0);
    }

    //test if animal gets point when it moves upwards
    @Test
    public void testPointsWhenMovingUp(){
        animal.fireEvent(new KeyEvent(KeyEvent.KEY_PRESSED, KeyCode.W.toString(), KeyCode.W.toString(), KeyCode.W, false, false, false, false));
        animal.fireEvent(new KeyEvent(KeyEvent.KEY_RELEASED,KeyCode.W.toString(), KeyCode.W.toString(), KeyCode.W, false, false, false, false));

        assertEquals(2, animal.getCurrentPoint());

    }


}
