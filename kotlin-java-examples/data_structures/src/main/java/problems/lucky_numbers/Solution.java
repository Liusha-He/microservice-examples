package problems.lucky_numbers;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        List<Integer> luckyNums = new ArrayList<>();
        List<Integer> minIndexInRows = new ArrayList<>();
        List<Integer> minNums = new ArrayList<>();
        for (int[] ints : matrix) {
            int min = ints[0];
            int index = 0;
            for (int j = 0; j < ints.length; j++) {
                if (ints[j] < min) {
                    min = ints[j];
                    index = j;
                }
            }
            minIndexInRows.add(index);
            minNums.add(min);
        }

        for (int i=0 ; i< minIndexInRows.size(); i++) {
            int max = matrix[0][minIndexInRows.get(i)];
            for (int[] ints : matrix) {
                if (ints[minIndexInRows.get(i)] > max) {
                    max = ints[minIndexInRows.get(i)];
                }
            }
            if (max == minNums.get(i)) {
                luckyNums.add(max);
            }
        }
        return luckyNums;
    }
}
