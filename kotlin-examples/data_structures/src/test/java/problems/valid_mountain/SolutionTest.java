package problems.valid_mountain;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test public void validMountainArray() {
        Solution solution = new Solution();

        int[] arr1 = {2,1};
        assertFalse(solution.validMountainArray(arr1));

        int[] arr2 = {3,5,5};
        assertFalse(solution.validMountainArray(arr2));

        int[] arr3 = {0,3,2,1};
        assertTrue(solution.validMountainArray(arr3));

        int[] arr4 = {1,2,3,2,1};
        assertTrue(solution.validMountainArray(arr4));
    }
}