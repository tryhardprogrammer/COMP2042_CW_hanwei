package frogger;

import javafx.scene.image.Image;

public class Turtle extends MovingObjects{

	/**size of turtle*/
	private int size = 130;

	/**image of the object*/
	private Image turtle1 = new Image("file:src/resources/pictures/turtle/TurtleAnimation1.png", size, size, true, true);
	/**image of the object*/
	private Image turtle2 = new Image("file:src/resources/pictures/turtle/TurtleAnimation2.png", size, size, true, true);
	/**image of the object*/
	private Image turtle3 = new Image("file:src/resources/pictures/turtle/TurtleAnimation3.png", size, size, true, true);


	/**Constructor for vehicle
	 * @param xpos x-coordinate for the object for its starting point
	 * @param ypos y-coordinate for the object for its starting point
	 * @param s speed of the object
	 * */
	public Turtle(int xpos, int ypos, int s) {
		super(xpos,ypos, s);
		setImage(getTurtle2());
	}

	/**Method from parent abstract class
	 * animation of object
	 * react if object is out of bound
	 * @param now time
	 */
	@Override
	public void act(long now) {

				if (now/900000000  % 3 ==0) {
					setImage(getTurtle2());
					
				}
				else if (now/900000000 % 3 == 1) {
					setImage(getTurtle1());
					
				}
				else if (now/900000000 %3 == 2) {
					setImage(getTurtle3());
					
				}
			
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -75 && getSpeed()<0)
			setX(600);
	}


	public Image getTurtle1() {
		return turtle1;
	}

	public Image getTurtle2() {
		return turtle2;
	}

	public Image getTurtle3() {
		return turtle3;
	}
}
