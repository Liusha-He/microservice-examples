package problems.minimum_cost;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test public void minCostToMoveChips() {
        Solution solution = new Solution();
        int[] arr = {6,4,7,8,2,10,2,7,9,7};
        assertEquals(4, solution.minCostToMoveChips(arr));
    }
}