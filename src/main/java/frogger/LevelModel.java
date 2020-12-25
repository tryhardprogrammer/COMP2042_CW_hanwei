package frogger;

import javafx.animation.AnimationTimer; 

/**Model, which is the logical part for every level*/
public class LevelModel {

    /**Controls music*/
    private BackgroundMusic music = new BackgroundMusic();
    /**timer for animation*/
    private AnimationTimer timer;
    /**current animal in the level*/
    private Animal animal;
    /**number of levels completed*/
    private int levelCompleted = 0;

    /**all points added from all levels completed*/
    private int overallPoints = 0;



    /**current level that needs to be handle*/
    private Levels currentLevel;

    /**Empty Constructor*/
    public LevelModel() {};



    /**Creates the animation timer for each level
     * Handles what to do when player finish the game
     * Updates score
     */
    public void createTimer() {

        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {

                if(currentLevel.isExitFlag()){
                    System.out.println("Player request exit game...");
                    overallPoints += animal.getCurrentPoint();
                    stopLevel();
                    checkIfLeaderboard();

                }
                if (animal.changeScore()) {
                    LevelController.getInstance().setNumber(overallPoints + animal.getCurrentPoint());
                }
                if (animal.checkFinished()) {
                    overallPoints += animal.getCurrentPoint();

                    if (levelCompleted < 4) {
                        ++levelCompleted;
                        LevelController.getInstance().initLevel(levelCompleted + 1);
                    } else {
                        System.out.print("Stopping Game...");
                        stopLevel();
                        checkIfLeaderboard();

                    }
                }
            }
        };
    }

    /**
     * Checks if player makes it into leaderboard
     * Then, call the respective alert box
     */
    public void checkIfLeaderboard(){
        if(HighScore.getInstance().checkLeaderboard(overallPoints)){
            LevelController.getInstance().playerWins();
        }
        else{
            LevelController.getInstance().playerLoses();
        }
    }

    /**Starts everything like timer and music*/
    public void start() {
        createTimer();
        timer.start();
        music.playMusic();
    }

    /**stops timer*/
    public void stopLevel() {
        timer.stop();
        music.stopMusic();
        currentLevel.stop();
    }



    /**get player's accumulative points
     * @return accumulative points
     */
    public int getOverallPoints(){
        return overallPoints;
    }

    /**sets animal
     * @param animal receive animal from any level
     */
    public void setAnimal(Animal animal){
        this.animal = animal;
    }

    /**sets currentLEvel
     * @param levels level that is executing now
     */
    public void setCurrentLevel(Levels levels){
        currentLevel = levels;
    }

}
