package frogger;

/**Add all essential actors into level3*/
public class Level3 extends Levels{

    /**speed of the actors*/
    private double speedup = 1.3;

    /**Constructor that adds all actors into Scene*/
    public Level3() {

        getChildren().clear();

        backgroundImage.setLevelBackgroundImage(3);
        add(backgroundImage);
        addEnd();

        add(new Log(3, 150, 0, 166, 0.75*speedup));
        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 350, 329, 0.75*speedup));


        add(new Turtle(500, 376, -1*speedup));
        add(new WetTurtle(300, 376, -1*speedup));
        add(new WetTurtle(700, 376, -1*speedup));
        add(new Turtle(600, 217, -1*speedup));
        add(new WetTurtle(400, 217, -1*speedup));
        add(new WetTurtle(200, 217, -1*speedup));


        addAnimal();

        add(new Vehicle(1,1, 100, 597, -1*speedup));
        add(new Vehicle(1,1, 250, 597, -1*speedup));
        add(new Vehicle(1,1, 400, 597, -1*speedup));
        add(new Vehicle(1,1, 550, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(2,2, 0, 649, 1*speedup));
        add(new Vehicle(2,2, 350, 649, 1*speedup));
        add(new Vehicle(2,2, 850, 649, 1*speedup));
        add(new Vehicle(1,1, 400, 490, -5*speedup));


        addButton();
    };



}
