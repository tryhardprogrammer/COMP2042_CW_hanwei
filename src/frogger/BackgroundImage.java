package frogger;

import javafx.scene.image.Image;

/**Sets background image*/
public class BackgroundImage extends Actor{

	/**Empty method inherited from abstract class Actor*/
	@Override
	public void act(long now) { }

	/**Sets background image
	 * @param imageLink the directory for the image
	 */
	public BackgroundImage(String imageLink) {
		setImage(new Image(imageLink, 600, 800, false, true));
	}

}
