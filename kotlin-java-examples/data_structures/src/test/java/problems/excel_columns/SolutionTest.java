package problems.excel_columns;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test public void convertToTitle() {
        Solution solution = new Solution();

        assertEquals("A", solution.convertToTitle(1));
        assertEquals("AA", solution.convertToTitle(27));
        assertEquals("AB", solution.convertToTitle(28));
        assertEquals("AZ", solution.convertToTitle(52));
        assertEquals("ZY", solution.convertToTitle(701));
        assertEquals("AAY", solution.convertToTitle(727));
    }
}