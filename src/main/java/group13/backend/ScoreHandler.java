package group13.backend;

import java.util.*;

public class ScoreHandler {
    private List<Map<String, Integer>> scoreList;

    public ScoreHandler() {
        this.scoreList = new ArrayList<>();
        // Whenever the object is created it loads existing data from the json file
        this.loadScore();
    }

    public List<Map<String, Integer>> getScoreList() {
        return scoreList;
    }

    public void addNewScore(String playerName, int score) {
        this.scoreList.add(new HashMap<String, Integer>(){
            {
                put(playerName, score);
            }
        });
        // After adding the score to the list, sync it with json file
        this.saveScore();
    }

    // Loads the list of scores from the json file
    public void loadScore() {


    }

    // Saves the current list of scores to the json file
    public void saveScore() {


    }

    // Method to return a specified number of top scores sorted
    public List<Map<String, Integer>> getHighScore(int topNum) {
        // first load json, in case there are changes
        this.loadScore();
        List<Map<String, Integer>> sortedList = new ArrayList<>(scoreList);
        sortedList.sort(new ScoreMapComparator("score"));
        return sortedList.subList(0, topNum - 1);
    }
}
