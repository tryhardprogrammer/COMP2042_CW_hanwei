package frogger;

import javafx.scene.image.Image;

/** Representing the goals of the frogger game*/
public class End extends Actor{

	/** state of object End to indicate if goal is reached*/
	private boolean activated = false;

	/**Empty method inherited from abstract class Actor*/
	@Override
	public void act(long now) {	}

	/**Constructor for class End
	 * @param x the x-coordinate for the End object
	 * @param y the y-coordiante for the End object
	 */
	public End(int x, int y) {
		setX(x);
		setY(y);
		setImage(new Image("file:src/resources/pictures/end/End.png", 60, 60, true, true));
	}

	/**Sets unactivated End to activated End when the goal is reached*/
	public void activateEnd() {
		setImage(new Image("file:src/resources/pictures/end/FrogEnd.png", 70, 70, true, true));
		activated = true;
	}

	/**Sets activated End to unactivated End when reset is needed*/
	public void unactivateEnd(){
		setImage(new Image("file:src/resources/pictures/end/End.png", 60, 60, true, true));
		activated = false;
	}

	/**Checks the boolean value of variable activated
	 * @return the state of End object
	 */
	public boolean getActivated() {
		return activated;
	}

}
