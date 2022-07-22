package problems.subdomain_visit_count;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void subdomainVisits() {
        Solution solution = new Solution();

        String[] arr2 = {"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        List<String> resList2 = new ArrayList<>();
        resList2.add("951 com");
        resList2.add("900 google.mail.com");
        resList2.add("1 intel.mail.com");
        resList2.add("5 org");
        resList2.add("5 wiki.org");
        resList2.add("901 mail.com");
        resList2.add("50 yahoo.com");
        assertEquals(resList2, solution.subdomainVisits(arr2));
    }
}