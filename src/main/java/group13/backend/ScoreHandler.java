package group13.backend;

import java.io.File;
import java.nio.file.Paths;
import java.util.*;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * This class handles saving scores and player names to a JSON file, as well as loading them.
 * It also provides methods for retrieving the list of top n number of players,
 * as well as returning the name of the last player.
 * It combines adding scores with writing to the JSON file, so all changes are saved immediately.
 * Same goes for retrieving the list of high scores, which ensures the data that's returned is up-to-date.
 */

public class ScoreHandler {
    private List<Map<String, Object>> scoreList;
    private final ObjectMapper objectMapper;

    public ScoreHandler() {
        this.scoreList = new ArrayList<>();
        this.objectMapper = new ObjectMapper();
        // Whenever the object is created it loads existing data from the json file
        this.loadScore();

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
        if (!scoresDataFile.exists() || scoresDataFile.length() == 0) {
            // If it doesn't exist there's nothing to load so return, will create file when saving the score
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
    public List<Map<String, Object>> getHighScoreList(int topNum) {
        // first load json, in case there are changes
        this.loadScore();
        List<Map<String, Object>> sortedList = new ArrayList<>(scoreList);
        sortedList.sort(Collections.reverseOrder(new ScoreMapComparator("score")));
        // In case the list contains fewer scores than topNum just return the whole list
        if (sortedList.size() < topNum) {
            return sortedList;
        }
        return sortedList.subList(0, topNum - 1);
    }

    public String getLastPlayer() {
        if (scoreList.isEmpty()) {
            return "No players saved yet!";
        }
        return (String) this.scoreList.get(scoreList.size() - 1).get("name");
    }
}
