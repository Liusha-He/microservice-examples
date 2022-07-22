package problems.tree_based;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SameTreeTest {
    @Test public void isSameTree() {
        SameTree solution = new SameTree();

        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode p = new TreeNode(1, left, right);
        TreeNode q = new TreeNode(1, left, right);

        assertTrue(solution.isSameTree(p, q));
    }
}