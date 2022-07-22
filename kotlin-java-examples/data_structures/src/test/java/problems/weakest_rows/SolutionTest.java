package problems.weakest_rows;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SolutionTest {
    @Test
    public void kWeakestRows() {
        Solution solution = new Solution();
        int[][] mat = {{1, 1, 0, 0, 0},
                {1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {1, 1, 1, 1, 1}};
        int[] output = {2, 0, 3};
        solution.kWeakestRows(mat, 3);

        int[][] mat2 = {{1, 0, 0, 0},
                {1, 1, 1, 1},
                {1, 0, 0, 0},
                {1, 0, 0, 0}};
        int[] output2 = {0,2};
        assertArrayEquals(output2, solution.kWeakestRows(mat2, 2));

    }
}