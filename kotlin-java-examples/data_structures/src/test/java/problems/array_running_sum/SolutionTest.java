package problems.array_running_sum;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test public void runningSum() {
        Solution solution = new Solution();

        int[] arr1 = {1,2,3,4};
        assertArrayEquals(new int[]{1,3,6,10}, solution.runningSum(arr1));

        int[] arr2 = {1,1,1,1,1};
        assertArrayEquals(new int[]{1,2,3,4,5}, solution.runningSum(arr2));

        int[] arr3 = {3,1,2,10,1};
        assertArrayEquals(new int[]{3,4,6,16,17}, solution.runningSum(arr3));
    }
}