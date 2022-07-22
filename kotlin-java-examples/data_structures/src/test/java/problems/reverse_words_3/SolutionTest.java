package problems.reverse_words_3;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void reverseWords() {
        String string = "Let's take LeetCode contest";
        Solution solution = new Solution();
        assertEquals("s'teL ekat edoCteeL tsetnoc", solution.reverseWords(string));
    }
}