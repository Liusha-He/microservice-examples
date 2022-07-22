package problems.delete_columns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void minDeletionSize() {
        Solution solution = new Solution();
        String[] arr1 = {"cba", "daf", "ghi"};
        assertEquals(1, solution.minDeletionSize(arr1));

        String[] arr2 = {"a","b"};
        assertEquals(0, solution.minDeletionSize(arr2));

        String[] arr3 = {"zyx","wvu","tsr"};
        assertEquals(3, solution.minDeletionSize(arr3));

        String[] arr4 = {"rrjk","furt","guzm"};
        assertEquals(2, solution.minDeletionSize(arr4));
    }
}