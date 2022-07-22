package problems.tree_based;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class SymmetricTreeTest {
    @Test public void isSymmetric() {
        SymmetricTree solution = new SymmetricTree();

        TreeNode l1 = new TreeNode(5, null, null);
        TreeNode r1 = new TreeNode(4, null, null);
        TreeNode t1 = new TreeNode(2, l1, r1);
        TreeNode t2 = new TreeNode(2, r1, l1);
        TreeNode t = new TreeNode(1, t1, t2);

        assertTrue(solution.isSymmetric(t));
    }
}