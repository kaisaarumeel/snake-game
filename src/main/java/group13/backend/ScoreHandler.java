package group13.backend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ScoreHandler {
    private List<Map<String, Integer>> scoreList;

    public ScoreHandler() {
        this.scoreList = new ArrayList<>();
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
    }

    public void loadScore() {
        // Loads the list of scores from the json file

    }

    public void saveScore() {
        // Saves the current list of scores to the json file

    }
}
