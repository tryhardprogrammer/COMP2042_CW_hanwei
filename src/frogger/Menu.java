package frogger;



public class Menu extends World{

        Button playButton = new Button("file:src/resources/pictures/button/playbutton.png",120,546, 1);
        Button helpButton = new Button("file:src/resources/pictures/button/helpbutton.png",307,546, 1);
        Button leaderboardButton = new Button("file:src/resources/pictures/button/hsbutton.png", 101, 629,2);

        public Menu (){
                BackgroundImage background = new BackgroundImage("file:src/resources/pictures/background/menu.png");
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


        public void createTimer() { }
        public void act(long now){ }


}
