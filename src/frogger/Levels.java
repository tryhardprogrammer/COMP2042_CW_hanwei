package frogger;

/**Parent class that should be inherited for all levels*/
public class Levels extends World{

    /**current animal in game*/
    private Animal animal;

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

    /**Get the current animal
     * @return current animal
     */
    public Animal getAnimal(){
        return animal;
    }

    /**Empty abstract method inherited*/
    @Override
    public void act(long now) { }


}
