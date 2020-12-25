package frogger;

import javafx.scene.image.Image;

/**Class for car and truck objects*/
public class Vehicle extends MovingObjects{


	/**size of truck1*/
	private int truck1size = 120;
	/**size of truck2*/
	private int truck2size = 200;
	/**size of car*/
	private int carsize = 50;

	/**Constructor for vehicle
	 * @param typeofcar indicating which type of car for directory
	 * @param leftorright inidcating which direction of the car for directory
	 * @param xpos x-coordinate for the object for its starting point
	 * @param ypos y-coordinate for the object for its starting point
	 * @param s speed of the object
	 * FYI, 1 is car, 2 is truck1, 3 is truck2;
	 * FYI, 1 is Left, 2 is Right
	 * */
	public Vehicle(int typeofcar, int leftorright, int xpos, int ypos, double s) {
		super(xpos, ypos, s);

		if(typeofcar == 1){
			setImage(new Image("file:src/main/resources/pictures/car/car"+leftorright+".png", carsize, carsize, true, true));
		}
		else if(typeofcar == 2){
			setImage(new Image("file:src/main/resources/pictures/truck/truck1"+leftorright+".png", truck1size, truck1size, true, true));
		}
		else if(typeofcar == 3){
			setImage(new Image("file:src/main/resources/pictures/truck/truck2"+leftorright+".png", truck2size, truck2size, true, true));
		}

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
