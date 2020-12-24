package frogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

/**Main application*/
public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {


		ScreenController.getInstance().setStage(primaryStage);
		primaryStage.setTitle("Frogger!");
		primaryStage.getIcons().add(new Image("file:src/resources/pictures/background/logo.png"));
		ScreenController.getInstance().MenuScreen();
		primaryStage.show();




	}


}
