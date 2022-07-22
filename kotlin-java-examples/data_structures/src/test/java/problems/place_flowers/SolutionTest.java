package problems.place_flowers;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SolutionTest {
    @Test public void canPlaceFlowers() {
        Solution solution = new Solution();
        int[] arr1 = {1,0,0,0,1};
        assertTrue(solution.canPlaceFlowers(arr1, 1));

        int[] arr2 = {1,0,0,0,1};
        assertFalse(solution.canPlaceFlowers(arr2, 2));

        int[] arr3 = {1,0,0,0,0,0,1};
        assertTrue(solution.canPlaceFlowers(arr3, 2));

        int[] arr4 = {1,0,0,0,0,1};
        assertFalse(solution.canPlaceFlowers(arr4, 2));

        int[] arr5 = {0,0,1,0,1};
        assertTrue(solution.canPlaceFlowers(arr5, 1));

        int[] arr6 = {1,0,0,0,1,0,0};
        assertTrue(solution.canPlaceFlowers(arr6, 2));
    }
}