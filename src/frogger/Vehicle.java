package frogger;

import javafx.scene.image.Image;

public class Vehicle extends MovingObjects{

	public Vehicle(String imageLink, int xpos, int ypos, double s, int w, int h) {
		super(xpos, ypos, s);
		setImage(new Image(imageLink, w,h, true, true));
	}

	@Override
	public void act(long now) {
		move(getSpeed() , 0);
		if (getX() > 600 && getSpeed()>0)
			setX(-200);
		if (getX() < -50 && getSpeed()<0)
			setX(600);
	}
	


}
