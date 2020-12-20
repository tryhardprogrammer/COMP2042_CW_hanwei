package frogger;

import javafx.scene.image.Image;

/**Class for car and truck objects*/
public class Vehicle extends MovingObjects{

	/**Constructor for vehicle
	 * @param imageLink image directory for the object
	 * @param xpos x-coordinate for the object for its starting point
	 * @param ypos y-coordinate for the object for its starting point
	 * @param s speed of the object
	 * @param w width of object
	 * @param h height of object
	 * */
	public Vehicle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		super(xpos, ypos, s);
		setImage(new Image(imageLink, w,h, true, true));
	}

	/**Method from parent abstract class to react if object is out of bound
	 * @param now time
	 */
	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -50 && getSpeed()<0)
			setX(600);
	}
	


}
