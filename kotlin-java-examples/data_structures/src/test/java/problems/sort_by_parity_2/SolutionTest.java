package problems.sort_by_parity_2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void sortArrayByParityII() {
        Solution solution = new Solution();
        int[] arr = {4,2,5,7};
        int i = 0;
        for (int anInt: solution.sortArrayByParityII(arr)) {
            assertEquals(i%2, anInt%2);
            i++;
        }
    }
}