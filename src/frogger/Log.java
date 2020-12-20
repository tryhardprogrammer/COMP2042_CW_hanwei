package frogger;

import javafx.scene.image.Image;

/**Creates Log where the Animal object can stand on */
public class Log extends MovingObjects {

	/**Constructor for vehicle
	 * @param imageLink image directory for the object
	 * @param size width and height of the object
	 * @param xpos x-coordinate for the object for its starting point
	 * @param ypos y-coordinate for the object for its starting point
	 * @param s speed of the object
	 */
	public Log(String imageLink, int size, int xpos, int ypos, double s) {
		super(xpos, ypos, s);
		setImage(new Image(imageLink, size,size, true, true));
	}

	/**
	 * Method to set the speed and direction (speed > 0 is right, speed < 0 is left) of log
	 * @param now time
	 */
	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX()>600 && getSpeed()>0)
			setX(-180);
		if (getX()<-300 && getSpeed()<0)
			setX(700);
	}

}
