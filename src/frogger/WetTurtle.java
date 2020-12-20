package frogger;

import javafx.scene.image.Image;

public class WetTurtle extends MovingObjects {

	private int size = 130;
	private boolean sunk = false;

	private Image turtle1 = new Image("file:src/resources/pictures/turtle/TurtleAnimation1.png", size, size, true, true);
	private Image turtle2 = new Image("file:src/resources/pictures/turtle/TurtleAnimation2Wet.png", size, size, true, true);
	private Image turtle3 = new Image("file:src/resources/pictures/turtle/TurtleAnimation3Wet.png", size, size, true, true);
	private Image turtle4 = new Image("file:src/resources/pictures/turtle/TurtleAnimation4Wet.png", size, size, true, true);

	public WetTurtle(int xpos, int ypos, int s) {
		super(xpos, ypos, s);
		setImage(getTurtle2());
	}

	@Override
	public void act(long now) {

				if (now/900000000  % 4 ==0) {
					setImage(getTurtle2());
					sunk = false;
					
				}
				else if (now/900000000 % 4 == 1) {
					setImage(getTurtle1());
					sunk = false;
				}
				else if (now/900000000 %4 == 2) {
					setImage(getTurtle3());
					sunk = false;
				} else if (now/900000000 %4 == 3) {
					setImage(getTurtle4());
					sunk = true;
				}
			
		move(speed , 0);
		if (getX() > 600 && speed>0)
			setX(-200);
		if (getX() < -75 && speed<0)
			setX(600);
	}



	public boolean getSunk() {
		return sunk;
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

	public Image getTurtle4() {
		return turtle4;
	}
}
