package tdd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiMap {
    private Map<Integer, List<Integer>> map = new HashMap<>();

    public boolean isEmpty() {
        return map.isEmpty();
    }

    public int size() {
        return map.size();
    }

    public void put(int i, List<Integer> integers) {
        map.put(i, integers);
    }

    public int valueSize() {
        int totalValues = 0;
        for (Integer key : map.keySet()) {
            totalValues += map.get(key).size();
        }
        return totalValues;
    }

    public List<Integer> get(Integer key) {
        if (!map.containsKey(key)) {
            throw new NotExistKeyException();
        }
        return map.get(key);
    }
}
