package frogger;


import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;


/**Parent class of every view (It's like scene in JavaFX)*/
public abstract class World extends Pane {

	/**Timer*/
	private AnimationTimer timer;

	/**Constructor that add a listener for key events*/
    public World() {
    	
    	sceneProperty().addListener(new ChangeListener<Scene>() {

			@Override
			public void changed(ObservableValue<? extends Scene> observable, Scene oldValue, Scene newValue) {
				if (newValue != null) {
					newValue.setOnKeyReleased(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyReleased() != null) 
								getOnKeyReleased().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyReleased() != null) {
									anActor.getOnKeyReleased().handle(event);
								}
							}
						}
						
					});
					
					newValue.setOnKeyPressed(new EventHandler<KeyEvent>() {

						@Override
						public void handle(KeyEvent event) {
							if(getOnKeyPressed() != null) 
								getOnKeyPressed().handle(event);
							List<Actor> myActors = getObjects(Actor.class);
							for (Actor anActor: myActors) {
								if (anActor.getOnKeyPressed() != null) {
									anActor.getOnKeyPressed().handle(event);
								}
							}
						}
						
					});
				}
				
			}
    		
		});
    }

    /**Creates timer*/
    public void createTimer() {
		timer = new AnimationTimer() {
			@Override
			public void handle(long now) {
				act(now);
				List<Actor> actors = getObjects(Actor.class);

				for (Actor anActor : actors) {
					anActor.act(now);
				}
			};
		};
	}

	/**Starts timer*/
    public void start() {
    	createTimer();
        timer.start();
    }

    /**Stops timer*/
    public void stop() {
        timer.stop();
    }

    /**Adds actor(nodes) into the Pane
	 * @param actor Actor object
	 */
    public void add(Actor actor) {
        getChildren().add(actor);
    }

	/**Removes actor(nodes) from the Pane
	 * @param actor Actor object
	 */
    public void remove(Actor actor) {
        getChildren().remove(actor);
    }

	/**
	 * Get all Actor objects that's in World object
	 * @param <A> class that extends Actor class
	 * @param cls class of the object which is in World object
	 * @return the Object's classes that intersects with the current Actor object
	 */
    public <A extends Actor> List<A> getObjects(Class<A> cls) {
        ArrayList<A> someArray = new ArrayList<A>();
        for (Node n: getChildren()) {
            if (cls.isInstance(n)) {
                someArray.add((A)n);
            }
        }
        return someArray;
    }

    /**Abstract class for children class to implement
	 * @param now time
	 */
    public abstract void act(long now);
}
