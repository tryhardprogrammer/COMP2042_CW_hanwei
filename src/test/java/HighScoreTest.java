import frogger.HighScore;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class HighScoreTest {
    //default highscore name and scores that will be set back later
    private int [] defaultScore = HighScore.getInstance().getScore();
    private String [] defaultName = HighScore.getInstance().getName();
    private int defaultCounter = HighScore.getInstance().getCounter();

    //array for testing#1
    private int [] testScore = {1100,1000,900,800,600,500,400,300,200,100};
    private String [] testName = {"A","B","C","D","E","F","G","H","J","K"};

    //array for results
    private int [] resultScore = {1100,1000,900,800,700,600,500,400,300,200};
    private String [] resultName = {"A","B","C","D","Z","E","F","G","H","J"};



    //check if score equals to 700, will it be sort to testScore[4]
    @Test
    public void testScoreSequence(){

        setUpTestLeaderboard();
        HighScore.getInstance().setNameEntered("Z");
        HighScore.getInstance().updateHighScoreFiles(700);

        assertArrayEquals(resultScore,testScore);
        assertArrayEquals(resultName,testName);

        setUpDefaultLeaderboard();
    }

    //check if lowest score in the array will be updated
    @Test
    public void testUpdateLowerScore(){

        setUpTestLeaderboard();

        assertEquals(resultScore[9],HighScore.getInstance().getLowestScore());

        setUpDefaultLeaderboard();
    }



    public void setUpTestLeaderboard(){
        HighScore.getInstance().setScore(testScore);
        HighScore.getInstance().setName(testName);
        HighScore.getInstance().setCounter(10);
    }


    public void setUpDefaultLeaderboard(){
        HighScore.getInstance().setScore(defaultScore);
        HighScore.getInstance().setName(defaultName);
        HighScore.getInstance().setCounter(defaultCounter);
        HighScore.getInstance().writeScoreFile();
        HighScore.getInstance().writeNameFile();
    }

}
