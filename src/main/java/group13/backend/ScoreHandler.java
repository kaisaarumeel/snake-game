package group13.backend;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ScoreHandler {
    private List<Map<String, Object>> scoreList;
    private final ObjectMapper objectMapper;

    public ScoreHandler() {
        this.scoreList = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
        // Whenever the object is created it loads existing data from the json file
        this.loadScore();

    }

    public List<Map<String, Object>> getScoreList() {
        return scoreList;
    }

    public void addNewScore(String playerName, int score) {
        this.scoreList.add(new HashMap<>() {
            {
                put("name", playerName);
                put("score", score);
            }
        });
        // After adding the score to the list, sync it with json file
        this.saveScore();
    }

    // Loads the list of scores from the json file
    public void loadScore() {
        // First check if the json file exists
        File scoresDataFile = new File("src/main/resources/scores.json");
        if (!scoresDataFile.exists()) {
            // If it doesn't exist there's nothing to load so return
            return;
        }
        try {
            this.scoreList = objectMapper.readValue(scoresDataFile, this.scoreList.getClass());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Saves the current list of scores to the json file
    public void saveScore() {
        try {
            objectMapper.writeValue(Paths.get("src/main/resources/scores.json").toFile(), this.scoreList);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Method to return a specified number of top scores sorted
    public List<Map<String, Object>> getHighScore(int topNum) {
        // first load json, in case there are changes
        this.loadScore();
        List<Map<String, Object>> sortedList = new ArrayList<>(scoreList);
        sortedList.sort(Collections.reverseOrder(new ScoreMapComparator("score")));
        return sortedList.subList(0, topNum - 1);
    }
}
