package problems.height_checker;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void heightChecker() {
        Solution solution = new Solution();
        int[] arr1 = {1,2,1};
        assertEquals(2, solution.heightChecker(arr1));
    }
}