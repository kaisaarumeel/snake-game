package group13.backend;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class ScoreMapComparator implements Comparator<Map<String, Object>> {
    private final String key;

    public ScoreMapComparator(String key) {
        this.key = key;
    }

    @Override
    public int compare(Map<String, Object> o1, Map<String, Object> o2) {
        Integer valueOne = (Integer) o1.get(key);
        Integer valueTwo = (Integer) o2.get(key);
        return valueOne.compareTo(valueTwo);
    }
}
