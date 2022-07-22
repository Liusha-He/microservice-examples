package problems.unique_number;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> occurMap = new HashMap<>();
        for (int n: arr) {
            occurMap.put(n, occurMap.getOrDefault(n, 0) + 1);
        }

        Set<Integer> occurSet = new HashSet<>();
        for (int n : occurMap.values()) {
            if (!occurSet.add(n)) {
                return false;
            }
        }
        occurSet.clear();
        return true;
    }
}
