package frogger;

/**Sets up the Menu view*/
public class Menu extends World{

        /**Initialize play button*/
        Button playButton = new Button("file:src/main/resources/pictures/button/playbutton.png",120,546, 1);
        /**Initialize help button*/
        Button helpButton = new Button("file:src/main/resources/pictures/button/helpbutton.png",307,546, 1);
        /**Initialize leaderboard button*/
        Button leaderboardButton = new Button("file:src/main/resources/pictures/button/hsbutton.png", 101, 629,2);

        /**Constructor that adds essential nodes to the scene*/
        public Menu (){
                BackgroundImage background = new BackgroundImage("file:src/main/resources/pictures/background/menu.png");
                add(background);
                add(playButton);
                add(leaderboardButton);
                add(helpButton);


                playButton.setOnMouseClicked(event -> {
                        ScreenController.getInstance().Dialog();
                });

                helpButton.setOnMouseClicked(event -> {
                        ScreenController.getInstance().HelpScreen();
                });

                leaderboardButton.setOnMouseClicked(event -> {
                        ScreenController.getInstance().Leaderboard();
                });
        }

        /**abstract classes inhertied from World*/
        public void createTimer() { }
        /**abstract classes inhertied from World*/
        public void act(long now){ }
}
