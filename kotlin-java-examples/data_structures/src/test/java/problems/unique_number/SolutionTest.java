package problems.unique_number;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SolutionTest {

    @Test
    public void uniqueOccurrences() {
        Solution s = new Solution();
        int[] arr1 = {-3,0,1,-3,1,1,1,-3,10,0};
        assertTrue(s.uniqueOccurrences(arr1));
    }
}