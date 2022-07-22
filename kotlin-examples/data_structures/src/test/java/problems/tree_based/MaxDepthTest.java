package problems.tree_based;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxDepthTest {
    @Test public void maxDepth() {
        TreeMaxDepth solution = new TreeMaxDepth();

        TreeNode left = new TreeNode(15, null, null);
        TreeNode right = new TreeNode(7, null, null);
        TreeNode tl = new TreeNode(9, null, null);
        TreeNode tr = new TreeNode(20, left, right);
        TreeNode t = new TreeNode(2, tl, tr);

        assertEquals(3, solution.maxDepth(t));
    }
}