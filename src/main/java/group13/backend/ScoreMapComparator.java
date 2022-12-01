package group13.backend;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ScoreMapComparator implements Comparator<Map<String, Integer>> {
    private final String key;

    public ScoreMapComparator(String key) {
        this.key = key;
    }

    @Override
    public int compare(Map<String, Integer> o1, Map<String, Integer> o2) {
        Integer valueOne = o1.get(key);
        Integer valueTwo = o2.get(key);
        return valueOne.compareTo(valueTwo);
    }
}
