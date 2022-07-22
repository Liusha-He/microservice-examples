package problems.height_checker;

import java.util.Arrays;

class Solution {
    public int heightChecker(int[] heights) {
        int[] stdHeights = Arrays.copyOf(heights, heights.length);
        Arrays.sort(stdHeights);

        int res = 0;
        for (int i=0; i<heights.length; i++) {
            if (heights[i] != stdHeights[i]) {
                res += 1;
            }
        }
        return res;
    }
}
