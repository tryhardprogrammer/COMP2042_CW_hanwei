package frogger;

/**Superclass for all moving obstacles like Log, Car, Truck, Turtles, Wet Turtles*/
public class MovingObjects extends Actor{

    /**speed of object*/
    public double speed;

    /**Constructor for class MovingObjects
     * @param speed speed of object
     * @param xpos starting x-axis point of the object
     * @param ypos starting y-axis point of the object
     */
    public MovingObjects(int xpos, int ypos, double speed){
        this.speed = speed;
        setX(xpos);
        setY(ypos);
    }

    /**gets the speed of object
     * @return speed */
    public double getSpeed(){
        return speed;
    }

    /**Empty abstract method from superclass*/
    @Override
    public void act(long now){ }

}
