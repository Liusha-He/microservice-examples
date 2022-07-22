package problems.lucky_numbers;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test public void luckyNumbers() {
        Solution solution = new Solution();
        int[][] matrix = {{3,7,8},{9,11,13},{15,16,17}};
        List<Integer> res = new ArrayList<>();
        res.add(15);
        assertEquals(res, solution.luckyNumbers(matrix));
    }
}