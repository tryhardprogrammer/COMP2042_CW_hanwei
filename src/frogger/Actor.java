package frogger;

import javafx.scene.image.ImageView;
import java.util.ArrayList;

/**
 * Class that handles actors(objects that can be interacted) in the game
 * It's actually like Nodes in JavaFX
 * */
public abstract class Actor extends ImageView{

    /**
     * Move Actors
     * @param dx distance of x-axis for the Actor object to move
     * @param dy distance of y-axis for the Actor object to move
     * */
    public void move(double dx, double dy) {
        setX(getX() + dx);
        setY(getY() + dy);
    }

    /**
     * Get Parent of the current Actor object
     * @return Parent of the Actors
     */
    public World getWorld() {
        return (World) getParent();
    }

    /**
     * Get width of the current Actor object
     * @return width of Actor
     */
    public double getWidth() {
        return this.getBoundsInLocal().getWidth();
    }

    /**
     * Get width of the current Actor object
     * @return width of Actor
     */
    public double getHeight() {
        return this.getBoundsInLocal().getHeight();
    }

    /**
     * Get all Actor objects that is intersecting the current Actor object
     * @param <A> class that extends Actor class
     * @param cls class of the object which is intersecting the current Actor object
     * @return the Object's classes that intersects with the current Actor object
     */
    public <A extends Actor> java.util.List<A> getIntersectingObjects(java.lang.Class<A> cls){
        ArrayList<A> someArray = new ArrayList<A>();
        for (A actor: getWorld().getObjects(cls)) {
            if (actor != this && actor.intersects(this.getBoundsInLocal())) {
                someArray.add(actor);
            }
        }
        return someArray;
    }



    /**Abstract method for actor objects to implement how it acts
     * @param now time
     */
    public abstract void act(long now);


}
