package frogger;

import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import java.util.List;


public class Levels extends World{

    private BackgroundMusic music = new BackgroundMusic();
    private BackgroundImage backgroundImage;
    private AnimationTimer timer;
    private Animal animal;
    private double speedup;

    public void act(long now) { }

    public Levels(int choice){


        switch (choice){
            case 1:
                backgroundImage = new BackgroundImage(4);
                add(backgroundImage);
                Level1();
                break;
            case 2:
                backgroundImage = new BackgroundImage(5);
                add(backgroundImage);
                Level2();
                break;
            case 3:
                 backgroundImage = new BackgroundImage(6);
                add(backgroundImage);
                Level3();
                break;
            case 4:
                 backgroundImage = new BackgroundImage(7);
                add(backgroundImage);
                Level4();
                break;
            case 5:
                 backgroundImage = new BackgroundImage(8);
                add(backgroundImage);
                Level5();
                break;
        }
    }

    public void Level1() {

        speedup = 0.75;

        setEnd();

        add(new Log(3, 150, 0, 166, 0.75*speedup));
        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 0, 276, -2*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 270, 329, 0.75*speedup));
        add(new Log(3, 150, 490, 329, 0.75*speedup));


        add(new Turtle(300, 376, -1*speedup));
        add(new Turtle(650, 376, -1*speedup));
        add(new Turtle(600, 217, -1*speedup));
        add(new Turtle(400, 217, -1*speedup));
        add(new Turtle(200, 217, -1*speedup));


        animal = new Animal();
        add(animal);
        add(new Vehicle(1,2, 0, 649, 1*speedup));
        add(new Vehicle(1,2, 300, 649, 1*speedup));
        add(new Vehicle(1,2, 600, 649, 1*speedup));

        add(new Vehicle(1,1, 250, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(1,1, 500, 490, -5*speedup));
        add(new Digit(0, 560, 25));

        start();
    }

    public void Level2() {

        speedup = 1;
        setEnd();

        add(new Log(3, 150, 0, 166, 0.75*speedup));
        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 0, 276, -2*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 270, 329, 0.75*speedup));
        add(new Log(3, 150, 490, 329, 0.75*speedup));

        add(new Turtle(500, 376, -1*speedup));
        add(new Turtle(300, 376, -1*speedup));
        add(new WetTurtle(700, 376, -1*speedup));
        add(new Turtle(600, 217, -1*speedup));
        add(new Turtle(400, 217, -1*speedup));
        add(new WetTurtle(200, 217, -1*speedup));


        animal = new Animal();
        add(animal);
        add(new Vehicle(1,2, 0, 649, 1*speedup));
        add(new Vehicle(1,2, 300, 649, 1*speedup));
        add(new Vehicle(1,2, 600, 649, 1*speedup));


        add(new Vehicle(1,1, 150, 597, -1*speedup));
        add(new Vehicle(1,1, 450, 597, -1*speedup));
        add(new Vehicle(1,1, 650, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(1,1, 500, 490, -5*speedup));
        add(new Digit(0, 560, 25));

        start();
    }

    public void Level3() {

        speedup = 1.3;
        setEnd();

        add(new Log(3, 150, 0, 166, 0.75*speedup));
        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 350, 329, 0.75*speedup));


        add(new Turtle(500, 376, -1*speedup));
        add(new WetTurtle(300, 376, -1*speedup));
        add(new WetTurtle(700, 376, -1*speedup));
        add(new Turtle(600, 217, -1*speedup));
        add(new WetTurtle(400, 217, -1*speedup));
        add(new WetTurtle(200, 217, -1*speedup));


        animal = new Animal();
        add(animal);


        add(new Vehicle(1,1, 100, 597, -1*speedup));
        add(new Vehicle(1,1, 250, 597, -1*speedup));
        add(new Vehicle(1,1, 400, 597, -1*speedup));
        add(new Vehicle(1,1, 550, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(2,2, 0, 649, 1*speedup));
        add(new Vehicle(2,2, 350, 649, 1*speedup));
        add(new Vehicle(2,2, 850, 649, 1*speedup));
        add(new Vehicle(1,1, 400, 490, -5*speedup));
        add(new Digit(0, 560, 25));

        start();
    }

    public void Level4() {

        speedup = 1.65;
        setEnd();

        add(new Log(3, 150, 0, 166, 0.75*speedup));
        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 350, 329, 0.75*speedup));

        add(new WetTurtle(500, 376, -1*speedup));
        add(new WetTurtle(300, 376, -1*speedup));
        add(new WetTurtle(600, 217, -1*speedup));
        add(new WetTurtle(200, 217, -1*speedup));


        animal = new Animal();
        add(animal);

        add(new Vehicle(1,1, 100, 597, -1*speedup));
        add(new Vehicle(1,1, 250, 597, -1*speedup));
        add(new Vehicle(1,1, 400, 597, -1*speedup));
        add(new Vehicle(1,1, 550, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(2,2, 0, 649, 1*speedup));
        add(new Vehicle(2,2, 350, 649, 1*speedup));
        add(new Vehicle(2,2, 850, 649, 1*speedup));
        add(new Vehicle(1,1, 400, 490, -5*speedup));
        add(new Digit(0, 560, 25));

        start();
    }

    public void Level5() {

        speedup = 2;
        setEnd();


        add(new Log(3, 150, 440, 166, 0.75*speedup));
        add(new Log(1, 300, 400, 276, -2*speedup));
        add(new Log(3, 150, 50, 329, 0.75*speedup));
        add(new Log(3, 150, 350, 329, 0.75*speedup));

        add(new WetTurtle(500, 376, -1*speedup));
        add(new WetTurtle(300, 376, -1*speedup));
        add(new WetTurtle(600, 217, -1*speedup));
        add(new WetTurtle(200, 217, -1*speedup));


        animal = new Animal();
        add(animal);

        add(new Vehicle(1,1, 100, 597, -1*speedup));
        add(new Vehicle(1,1, 250, 597, -1*speedup));
        add(new Vehicle(1,1, 400, 597, -1*speedup));
        add(new Vehicle(1,1, 550, 597, -1*speedup));
        add(new Vehicle(2,2, 0, 540, 1*speedup));
        add(new Vehicle(2,2, 500, 540, 1*speedup));
        add(new Vehicle(2,2, 0, 649, 1*speedup));
        add(new Vehicle(2,2, 350, 649, 1*speedup));
        add(new Vehicle(2,2, 850, 649, 1*speedup));
        add(new Vehicle(1,1, 200, 490, -5*speedup));
        add(new Vehicle(1,1, 600, 490, -5*speedup));
        add(new Digit(0, 560, 25));

        start();
    }

    public void setEnd(){
        add(new End(13,96));
        add(new End(141,96));
        add(new End(141 + 141-13,96));
        add(new End(141 + 141-13+141-13+1,96));
        add(new End(141 + 141-13+141-13+141-13+3,96));
    }


    public void createTimer() {
        timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                partialHandle(now);
                if (animal.changeScore()) {
                    setNumber(animal.getCurrentPoint());
                }
                if (animal.checkWin()) {
                    System.out.print("STOPP:");
                    //stopMusic();
                    stop();
                    stop();
                    Alert alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("You Have Won The Game!");
                    alert.setHeaderText("Your High Score: "+animal.getCurrentPoint()+"!");
                    alert.setContentText("Highest Possible Score: 800");
                    alert.show();
                }
            }
        };
    }

    public void start() {
        createTimer();
        timer.start();
        music.playMusic();
    }

    public void stop() {
        timer.stop();
    }

    public void setNumber(int n) {
        int shift = 0;
        while (n > 0) {
            int d = n / 10;
            int k = n - d * 10;
            n = d;
            add(new Digit(k, 560 - shift, 25));
            shift+=30;
        }
    }


}
