package frogger;

public class Level1 extends Levels{

    private double speedup = 0.75;
    private Animal animal;

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

    public Animal getAnimal(){
        return animal;
    }

    public void setAnimal(Animal animal){
        animal = animal;
    }



}
