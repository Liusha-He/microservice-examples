package problems.minimum_subsequence;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void minSubsequence() {
        Solution solution = new Solution();
        int[] arr = {4,4,7,6,7};
        List<Integer> resList = new ArrayList<>();
        resList.add(7);
        resList.add(7);
        resList.add(6);
        assertEquals(resList, solution.minSubsequence(arr));
    }
}