package frogger;

import java.io.File;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

/** Class that controls the background music*/
public class BackgroundMusic {

	/**media player that can play music*/
	MediaPlayer mediaPlayer;

	/**Empty constructor*/
	public BackgroundMusic() {}

	/**Method that plays music*/
	public void playMusic() {
		String musicFile = "src/main/resources/music/Frogger Main Song Theme (loop).mp3";
		Media sound = new Media(new File(musicFile).toURI().toString());
		mediaPlayer = new MediaPlayer(sound);
		mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
	    mediaPlayer.play();
	}

	/**Method that stops music*/
	public void stopMusic() {
		mediaPlayer.stop();
	}

}
