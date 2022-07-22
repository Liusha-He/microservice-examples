package problems.arithemetic_progression;

import static org.junit.Assert.assertFalse;

public class SolutionTest {

    @org.junit.Test public void canMakeArithmeticProgression() {
        Solution solution = new Solution();
        int[] arr = {1,2,4};
        assertFalse(solution.canMakeArithmeticProgression(arr));
    }
}