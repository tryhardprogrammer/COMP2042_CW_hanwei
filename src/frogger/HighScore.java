package frogger;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextInputDialog;

import java.io.*;
import java.util.Optional;
import java.util.Scanner;

public class HighScore {

    private int[] score = new int[10];
    private String [] name = new String[10];
    private int i = 0, temp1 = 0, j = 0;
    private int getscore = 0;
    private int counter = 0;
    private int lowestScore = 0;
    private String nameEntered, temp2;
    private String leaderboardString;
    private StringBuffer sb = new StringBuffer();

    private String scoreDirectory = "src/resources/records/inthighscore.txt";
    private String nameDirectory = "src/resources/records/namehighscore.txt";

    private static HighScore highScore;

    public HighScore(){
        readScoreFile();
        readNameFile();
    }


    public boolean checkLeaderboard(int playerScore){
        return (playerScore > score[9]);
    }


    public void initHighScore(){

        setString();
        lowestScore = score[counter-1];
        System.out.println(leaderboardString);

    }

    public void setString(){

        sb.delete(0, sb.length());

        for (i =0; i<counter; i++){
            temp2 = name[i] + " : " + score[i] + "\n";
            sb.append(temp2);
        }
        leaderboardString = sb.toString();
    }

    public void updateHighScoreFiles(int getscore){
        System.out.println(nameEntered);

        for(i = 0; i < counter; i++){
            if(getscore > score[i]){

                for(j = counter -1; j > i; j--){
                    score[j+1] = score[j];
                    name[j+1] = name[j];
                }

                score[i] = getscore;
                name[i] = nameEntered;
                break;
            }
        }
        counter++;

        writeNameFile();
        writeScoreFile();
        initHighScore();
    }




    public void writeScoreFile() {
        try {
            FileWriter writer = new FileWriter(scoreDirectory);
            BufferedWriter outputWriter = new BufferedWriter(writer);


            for (i=0; i<9; i++) {
                outputWriter.write(score[i] + " ");
            }

            outputWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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

            System.out.println(counter);
            for(i =0; i<counter; i++) System.out.println(score[i]);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void writeNameFile() {
        try {
            FileWriter writer = new FileWriter(nameDirectory);
            BufferedWriter outputWriter = new BufferedWriter(writer);

            for (i=0; i<10; i++) {
                outputWriter.write(name[i] + "\n");
            }

            outputWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

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

            for(i =0; i<counter; i++) System.out.println(name[i]);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public String getLeaderboardString(){
        return leaderboardString;
    }

    public static HighScore getInstance() {
        if (highScore == null) {
            highScore = new HighScore();
        }
        return highScore;
    }

    public void setNameEntered(String nameEntered) {
        this.nameEntered = nameEntered;
    }

    public int getLowestScore(){
        return lowestScore;
    }
}
