package problems.remove_string_duplicates;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void removeDuplicates() {
        Solution solution = new Solution();
        String S = "abbaca";
        assertEquals("ca", solution.removeDuplicates(S));

        String S2 = "aaaaaac";
        assertEquals("c", solution.removeDuplicates(S2));
    }
}