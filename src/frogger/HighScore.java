package frogger;

import java.io.*;
import java.nio.Buffer;
import java.util.Scanner;

public class HighScore {

    private int[] arr = new int[10];
    private int i = 0;

    public void writeFile() {
        try {
            FileWriter writer = new FileWriter("src/resources/records/highscore.txt");
            BufferedWriter outputWriter = new BufferedWriter(writer);

            for (int i : arr) {
                outputWriter.write(arr[i] + " ");
            }

            outputWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    public void readFile() {
        try {
            File reader = new File("src/resources/records/highscore.txt");
            Scanner scanner = new Scanner(reader);

            while (scanner.hasNextInt()) {
                arr[i] = scanner.nextInt();
                i++;
            }
            scanner.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
