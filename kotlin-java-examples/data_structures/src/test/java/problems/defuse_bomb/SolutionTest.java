package problems.defuse_bomb;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {

    @Test
    public void decrypt() {
        Solution solution = new Solution();
        int[] code1 = {5,7,1,4};
        int k1 = 3;
        int[] res = {12,10,16,13};
        assertArrayEquals(res, solution.decrypt(code1, k1));
    }
}