package frogger;

import java.io.*;
import java.util.Scanner;

/**Class that controls and responsible for the highscore of the ga,e*/
public class HighScore {

    /**Array of top 10 highscores*/
    private int[] score = new int[10];
    /**Array of the players achieving in top 10 highscores */
    private String [] name = new String[10];

    /**Counter for for loops*/
    private int i = 0, j = 0;
    /**Gets the current score of the player*/
    private int getscore = 0;
    /**Counters that counts how many highscore exists*/
    private int counter = 0;
    /**records lowestScore*/
    private int lowestScore = 0;


    /**Current player's name*/
    private String nameEntered;
    /**Holds temporary strings*/
    private String temp2;
    /**Records a long single String about all the highscore players and their scores*/
    private String leaderboardString;
    /**String buffers that will make multiple strings into a single string using append*/
    private StringBuffer sb = new StringBuffer();

    /**Highscore textfile directory*/
    private String scoreDirectory = "src/resources/records/inthighscore.txt";
    /**Names of players textfile directory*/
    private String nameDirectory = "src/resources/records/namehighscore.txt";

    /**For implementing Singleton pattern*/
    private static HighScore highScore;

    /**Constructor that reads the score and name text files*/
    public HighScore(){
        readScoreFile();
        readNameFile();
    }

    /**
     * Checks if the player made into the leaderboard
     * @param playerScore the player's score
     * @return boolean value about if player score is smaller lowest score in leaderboard
     */
    public boolean checkLeaderboard(int playerScore){
        return (playerScore > score[9]);
    }

    /**initalize highscore by setting a single string for showing in the alert box and set the lowest score*/
    public void initHighScore(){

        setString();
        lowestScore = score[counter-1];
    }

    /**Sets all the player's name and score into a single string*/
    public void setString(){

        sb.delete(0, sb.length());

        for (i =0; i<counter; i++){
            temp2 = name[i] + " : " + score[i] + "\n";
            sb.append(temp2);
        }
        leaderboardString = sb.toString();
    }

    /**
     * Updates high score in sequence with player's score
     * @param getscore Player's score
     */
    public void updateHighScoreFiles(int getscore){

        //if leaderboard is not full and the current score is the lowest
        if(counter < 10 && getscore < lowestScore){
            score[counter] = getscore;
            name[counter] = nameEntered;
            lowestScore = getscore;
        }
        else if (counter ==10){
            for(i = 0; i < counter; i++) {
                if (getscore > score[i]) {
                    for (j = counter - 1; j > i; j--) {
                        score[j] = score[j-1];
                        name[j] = name[j-1];
                    }
                    score[i] = getscore;
                    name[i] = nameEntered;
                    break;
                }
            }
            lowestScore = score[counter-1];
        }
        else{
            for(i = 0; i < counter; i++) {
                if (getscore > score[i]) {

                    for (j = counter - 1; j > i; j--) {
                        score[j + 1] = score[j];
                        name[j + 1] = name[j];
                    }

                    score[i] = getscore;
                    name[i] = nameEntered;
                    break;
                }
                System.out.println("heyy");

            }
            lowestScore = score[counter];
            counter++;
        }


        writeNameFile();
        writeScoreFile();
        initHighScore();
    }



    /**writes score file*/
    public void writeScoreFile() {
        try {
            FileWriter writer = new FileWriter(scoreDirectory);
            BufferedWriter outputWriter = new BufferedWriter(writer);


            for (i=0; i<counter; i++) {
                outputWriter.write(score[i] + " ");
            }

            outputWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**reads score file*/
    public void readScoreFile() {
        try {
            File reader = new File(scoreDirectory);

            if(!reader.exists()){
                reader.createNewFile();
            }

            Scanner scanner = new Scanner(reader);

            i=0;

            while (scanner.hasNextInt()) {
                score[i] = scanner.nextInt();

                if(score[i]!=0){
                    ++counter;
                }

                i++;

            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**writes name file*/
    public void writeNameFile() {
        try {
            FileWriter writer = new FileWriter(nameDirectory);
            BufferedWriter outputWriter = new BufferedWriter(writer);

            for (i=0; i<counter; i++) {
                outputWriter.write(name[i] + "\n");
            }

            outputWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    /**reads name file*/
    public void readNameFile() {
        try {
            File reader = new File(nameDirectory);

            if(!reader.exists()){
                reader.createNewFile();
            }

            Scanner scanner = new Scanner(reader);

            i=0;

            while (scanner.hasNextLine()) {
                name[i] = scanner.nextLine();
                i++;
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**get the single string containing all player's name and score
     * @return the string containing all player's name and score
     */
    public String getLeaderboardString(){
        return leaderboardString;
    }

    /**
     * Prevents other classes to initialize this class to acheive Singleton
     * @return highScore the instance of HighScore*/
    public static HighScore getInstance() {
        if (highScore == null) {
            highScore = new HighScore();
        }
        return highScore;
    }

    /**set the player's name
     * @param nameEntered player's name
     */
    public void setNameEntered(String nameEntered) {
        this.nameEntered = nameEntered;
    }

    /**get lowest score in leaderboard
     * @return the lowest score;
     */
    public int getLowestScore(){
        return lowestScore;
    }

    public int [] getScore(){
        return score;
    }

    public String [] getName(){
        return name;
    }

    public void setScore(int [] score){
        this.score = score;
    }

    public void setName(String [] name){
        this.name = name;
    }

    public int getCounter(){
        return counter;
    }

    public void setCounter(int counter){
        this.counter = counter;
    }


}
