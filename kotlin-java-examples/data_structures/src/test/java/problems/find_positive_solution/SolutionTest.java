package problems.find_positive_solution;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void findSolution() {
        Solution solution = new Solution();

        // Add function
        List<List<Integer>> expected1 = new ArrayList<>();
        int[][] arr1 = {{1,4}, {2,3}, {3,2}, {4,1}};
        for (int[] a: arr1) {
            List<Integer> list = new ArrayList<>();
            list.add(a[0]); list.add(a[1]);
            expected1.add(list);
        }
        assertEquals(expected1, solution.findSolution(new Add(), 5));

        // Multiply function
        List<List<Integer>> expected2 = new ArrayList<>();
        int[][] arr2 = {{1,5}, {5,1}};
        for (int[] a: arr2) {
            List<Integer> list = new ArrayList<>();
            list.add(a[0]); list.add(a[1]);
            expected2.add(list);
        }
        assertEquals(expected2, solution.findSolution(new Multiply(), 5));
    }
}