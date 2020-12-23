package frogger;

/**Add all essential actors into level1*/
public class Level1 extends Levels{

    /**speed of the actors*/
    private double speedup = 0.75;

    /**animal of the current level*/
    private Animal animal;

    /**Constructor that adds all actors into Scene*/
    public Level1() {
        getChildren().clear();

        BackgroundImage backgroundImage = new BackgroundImage(1);
        add(backgroundImage);
        setEnds();

        add(new Log(3, 150, 0, 166, 0.75*speedup));
        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 0, 276, -2*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 270, 329, 0.75*speedup));
        add(new Log(3, 150, 490, 329, 0.75*speedup));


        add(new Turtle(300, 376, -1*speedup));
        add(new Turtle(650, 376, -1*speedup));
        add(new Turtle(600, 217, -1*speedup));
        add(new Turtle(400, 217, -1*speedup));
        add(new Turtle(200, 217, -1*speedup));


        animal = new Animal();
        add(animal);

        add(new Vehicle(1,2, 0, 649, 1*speedup));
        add(new Vehicle(1,2, 300, 649, 1*speedup));
        add(new Vehicle(1,2, 600, 649, 1*speedup));

        add(new Vehicle(1,1, 250, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(1,1, 500, 490, -5*speedup));

        start();
    }

    /**get animal actor
     * @return animal actor
     */
    public Animal getAnimal(){
        return animal;
    }

    /**set animal actor
     * @param animal the animal actor
     */
    public void setAnimal(Animal animal){
        animal = animal;
    }

}
