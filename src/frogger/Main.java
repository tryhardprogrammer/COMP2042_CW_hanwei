package frogger;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

	Levels lvl1;
	BackgroundMusic test;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws IOException {

		Scene scene  = new Scene(scene,600,800);

		ScreenController screenController = new ScreenController(scene);

		initializeScreens(screenController);
		screenController.activateScreen("menu");

		primaryStage.setTitle("Frogger!");
		primaryStage.getIcons().add(new Image("file:src/main/resources/icon-frogger-boxart-96x96.png"));


		primaryStage.setScene(scene);
		primaryStage.show();




	}

	public void initializeScreens(ScreenController screenController) throws IOException {
		screenController.addScreen("menu", FXMLLoader.load(getClass().getResource( "menu.fxml" )));


	}

}
