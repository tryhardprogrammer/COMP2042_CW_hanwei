package frogger;

import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;

/***
 * Creates the character (for this game it's a frog) for the game
 * This class is essential because :
 * It controls the movement according the keys the user pressed
 * Checks and handles what to do if characters interacts with other objects (deaths and points)
 */
public class Animal extends Actor {
	/**current points the player holds*/
	private int currentPoint = 0;
	/**records number of ends the user had reached*/
	private int end = 0;
	/**counter for executing animation*/
	private int animationCounter = 0;
	/**records furthest position the character had reached before reaching a end zone*/
	private double furthestPos = 800;

	/**constant size of the character*/
	private static final int imgSize = 40;
	/**constant points the player earns when reaching a end zone*/
	private static final int point = 15;
	/**constant x-axis of the character's starting position*/
	private static final double startX = 300;
	/**constant y-axis of the character's starting position*/
	private static final double startY = 701.133332;
	/**constant x-axis distance of the character per move*/
	private static final double movementX = 21.333332;
	/**constant y-axis distance of the character per move*/
	private static final double movementY = 26.666666;

	/**indicates whether character dies from car crash*/
	private boolean carDeath = false;
	/**indicates whether character dies from drowning in water*/
	private boolean waterDeath = false;
	/**indicates whether the score should be updated*/
	private boolean changeScore = false;
	/**indicates whether the character is currently going through an animation*/
	private boolean busy = false;
	/**indicates whether the character is in motion*/
	private boolean noMove = false;

	/**image of the frog's moving forward*/
	private Image imgW1 = new Image("file:src/main/resources/pictures/frogger/froggerUp.png", imgSize, imgSize, true, true);
	/**image of the frog's moving left*/
	private Image imgA1 = new Image("file:src/main/resources/pictures/frogger/froggerLeft.png", imgSize, imgSize, true, true);
	/**image of the frog's moving backwards*/
	private Image imgS1 = new Image("file:src/main/resources/pictures/frogger/froggerDown.png", imgSize, imgSize, true, true);
	/**image of the frog's moving right*/
	private Image imgD1 = new Image("file:src/main/resources/pictures/frogger/froggerRight.png", imgSize, imgSize, true, true);
	/**image of the frog's jumping forward*/
	private Image imgW2 = new Image("file:src/main/resources/pictures/frogger/froggerUpJump.png", imgSize, imgSize, true, true);
	/**image of the frog's jumping left*/
	private Image imgA2 = new Image("file:src/main/resources/pictures/frogger/froggerLeftJump.png", imgSize, imgSize, true, true);
	/**image of the frog's jumping backwards*/
	private Image imgS2 = new Image("file:src/main/resources/pictures/frogger/froggerDownJump.png", imgSize, imgSize, true, true);
	/**image of the frog's jumping right*/
	private Image imgD2 = new Image("file:src/main/resources/pictures/frogger/froggerRightJump.png", imgSize, imgSize, true, true);

	/**Constructor for class Animal
	 * initialize image of the Animal object and starting point
	 * then calls the method handle to control the movement
	 */
	public Animal() {
		resetPos();
		setOnKeyPressed(event -> handle(event));
		setOnKeyReleased(event -> handle(event));
	}

	/**Handles movement of the frog
	 * @param event event of key pressed or released
	 */
	public void handle(KeyEvent event){
		if (isNoMove()) { }
		else {
			if (busy) {
				switch(event.getCode()) {
					case W:
						if (getY() < getFurthestPoint()) {
							setFurthestPoint(getY());
							setCurrentPoint(getCurrentPoint() + 2);
							setChangeScore(true);
						}
						move(0, -movementY);
						setImage(getImgW1());
						break;
					case A:
						move(-movementX, 0);
						setImage(getImgA1());
						break;
					case S:
						move(0, movementY);
						setImage(getImgS1());
						break;
					case D:
						move(movementX, 0);
						setImage(getImgD1());
						break;
				}
				busy = false;
			}
				else {
				switch(event.getCode()) {
					case W:
						move(0, -movementY);
						setImage(getImgW2());
						break;
					case A:
						move(-movementX, 0);
						setImage(getImgA2());
						break;
					case S:
						move(0, movementY);
						setImage(getImgS2());
						break;
					case D:
						move(movementX, 0);
						setImage(getImgD2());
						break;
				}
				busy = true;
			}
		}
	}



	/**
	 * Checks the current position of the Animal object and reacts to it
	 * @param now time
	 */
	@Override
	public void act(long now) {
		/*checks out of bounds*/
		if (getY()<0 || getY()>734) {
			resetPos();
		}
		if (getX()<0) {
			setX(0);
		}
		if (getX()>590) {
			move(-movementY*2, 0);
		}

		/*checks intersects*/
		if (getIntersectingObjects(Vehicle.class).size() >= 1) {
			setCarDeath(true);
		}

		if (getIntersectingObjects(Log.class).size() >= 1 && !isNoMove()) {
			move (getIntersectingObjects(Log.class).get(0).getSpeed(),0);
		}

		else if (getIntersectingObjects(Turtle.class).size() >= 1 && !isNoMove()) {
			move(getIntersectingObjects(Turtle.class).get(0).getSpeed(),0);
		}

		else if (getIntersectingObjects(WetTurtle.class).size() >= 1) {
			if (getIntersectingObjects(WetTurtle.class).get(0).getSunk()) {
				setWaterDeath(true);
			} else {
				move(getIntersectingObjects(WetTurtle.class).get(0).getSpeed(),0);
			}
		}
		else if (getIntersectingObjects(End.class).size() >= 1) {
			//if player access a end zone which is already occupied
			if (getIntersectingObjects(End.class).get(0).getActivated()) {
				setCurrentPoint(getCurrentPoint() - point);
			}
			else {
				setCurrentPoint(getCurrentPoint() + point);
				setFurthestPoint(800);
				getIntersectingObjects(End.class).get(0).activateEnd();
				setEnd(getEnd() + 1);
			}
			setChangeScore(true);
			resetPos();
		}

		/*reacts to death*/
		else if (getY()<413){
			setWaterDeath(true);
		}

		//if animal dies from car crash
		if (isCarDeath()) {
			setNoMove(true);
			if ((now)% 11 ==0) {
				setAnimationCounter(getAnimationCounter() + 1);
			}
			if (getAnimationCounter() ==1 || getAnimationCounter() ==2 || getAnimationCounter() ==3) {
				setImage(new Image("file:src/main/resources/pictures/death/cardeath"+ getAnimationCounter() +".png", imgSize, imgSize, true, true));
			}
			if (getAnimationCounter() == 4) {
				resetPos();
				setAnimationCounter(0);
				if (getCurrentPoint() >10) {
					setCurrentPoint(getCurrentPoint() - 10);
					setChangeScore(true);
				}
			}

		}
		//if animal drowns
		if (isWaterDeath()) {
			setNoMove(true);
			if ((now)% 11 ==0) {
				setAnimationCounter(getAnimationCounter() + 1);
			}
			if (getAnimationCounter() ==1 || getAnimationCounter() ==2 || getAnimationCounter() ==3 || getAnimationCounter() ==4)  {
				setImage(new Image("file:src/main/resources/pictures/death/waterdeath"+ getAnimationCounter() +".png", imgSize,imgSize , true, true));
			}
			if (getAnimationCounter() == 5) {
				resetPos();
				setAnimationCounter(0);
				if (getCurrentPoint() >10) {
					setCurrentPoint(getCurrentPoint() - 10);
					setChangeScore(true);
				}
			}
		}
	}

	/**checks if character finish the current level
	 * @return boolean value stating if all Ends are occupied
	 */
	public boolean checkFinished() {
		return getEnd() == 5;
	}

	/**
	 * checks if score need to be updated
	 * @return if score should be updated or not
	 */
	public boolean changeScore() {
		if (isChangeScore()) {
			setChangeScore(false);
			return true;
		}
		return false;
	}

	/**resets the position and other boolean values of the character*/
	public void resetPos(){
		setX(startX);
		setY(startY);
		setImage(getImgW1());
		setCarDeath(false);
		setWaterDeath(false);
		setNoMove(false);
	}


	public Image getImgW1() {
		return imgW1;
	}

	public Image getImgA1() {
		return imgA1;
	}

	public Image getImgS1() {
		return imgS1;
	}

	public Image getImgD1() {
		return imgD1;
	}

	public Image getImgW2() {
		return imgW2;
	}

	public Image getImgA2() {
		return imgA2;
	}

	public Image getImgS2() {
		return imgS2;
	}

	public Image getImgD2() {
		return imgD2;
	}

	public double getStartX() { return startX;}

	public double getStartY() {return startY;}

	public int getCurrentPoint() {
		return currentPoint;
	}

	public void setCurrentPoint(int currentPoint) {
		this.currentPoint = currentPoint;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public boolean isNoMove() {
		return noMove;
	}

	public void setNoMove(boolean noMove) {
		this.noMove = noMove;
	}

	public boolean isCarDeath() {
		return carDeath;
	}

	public void setCarDeath(boolean carDeath) {
		this.carDeath = carDeath;
	}

	public boolean isWaterDeath() {
		return waterDeath;
	}

	public void setWaterDeath(boolean waterDeath) {
		this.waterDeath = waterDeath;
	}

	public boolean isChangeScore() {
		return changeScore;
	}

	public void setChangeScore(boolean changeScore) {
		this.changeScore = changeScore;
	}

	public int getAnimationCounter() {
		return animationCounter;
	}

	public void setAnimationCounter(int carD) {
		this.animationCounter = carD;
	}

	public double getFurthestPoint() {
		return furthestPos;
	}

	public void setFurthestPoint(double w) {
		this.furthestPos = w;
	}
}
