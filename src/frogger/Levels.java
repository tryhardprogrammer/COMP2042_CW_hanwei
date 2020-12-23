package frogger;


public class Levels extends World{

    private Animal animal;

    public Levels () {}

    @Override
    public void act(long now) { }


    public void setEnds(){
        add(new End(13,96));
        add(new End(141,96));
        add(new End(141 + 141-13,96));
        add(new End(141 + 141-13+141-13+1,96));
        add(new End(141 + 141-13+141-13+141-13+3,96));
    }

    public Animal getAnimal(){
        return animal;
    }

    public void setAnimal(Animal animal){
        this.animal = animal;
    }


}
