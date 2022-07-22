package problems.inorder_traversal;

import problems.same_tree.TreeNode;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test public void inorderTraversal() {
        TreeNode t = new TreeNode(1,
                null,
                new TreeNode(2, new TreeNode(3), null));
        Solution sol = new Solution();
        List<Integer> l = sol.inorderTraversal(t);
        List<Integer> exp = new ArrayList<>();
        exp.add(1);
        exp.add(3);
        exp.add(2);
        assertEquals(exp, l);
    }
}