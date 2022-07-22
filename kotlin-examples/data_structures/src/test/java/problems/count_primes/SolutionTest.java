package problems.count_primes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test public void countPrimes() {
        Solution solution = new Solution();
        assertEquals(4, solution.countPrimes(10));
        assertEquals(0, solution.countPrimes(0));
        assertEquals(0, solution.countPrimes(1));
        assertEquals(0, solution.countPrimes(2));
        assertEquals(1, solution.countPrimes(3));
        assertEquals(25, solution.countPrimes(100));
        assertEquals(1, solution.countPrimes(3));
        assertEquals(41_537, solution.countPrimes(499_979));
    }
}