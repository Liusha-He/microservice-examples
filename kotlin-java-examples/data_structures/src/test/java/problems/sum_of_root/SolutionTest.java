package problems.sum_of_root;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SolutionTest {

    @Test
    public void sumRootToLeaf() {
        Solution solution1 = new Solution();

        // [1,0,1,0,1,0,1]
        TreeNode lleft = new TreeNode(0);
        TreeNode lright = new TreeNode(1);
        TreeNode left = new TreeNode(0, lleft, lright);

        TreeNode rleft = new TreeNode(0);
        TreeNode rright = new TreeNode(1);
        TreeNode right = new TreeNode(1, rleft, rright);

        TreeNode root = new TreeNode(1, left, right);
        assertEquals(22, solution1.sumRootToLeaf(root));

        // [0]
        Solution solution2 = new Solution();
        TreeNode root0 = new TreeNode(0);
        assertEquals(0, solution2.sumRootToLeaf(root0));

        // [1]
        Solution solution3 = new Solution();
        TreeNode root1 = new TreeNode(1);
        assertEquals(1, solution3.sumRootToLeaf(root1));

        // [1,1]
        Solution solution4 = new Solution();
        TreeNode root11 = new TreeNode(1);
        root11.left = root1;
        assertEquals(3, solution4.sumRootToLeaf(root11));

        // null
        Solution solution5 = new Solution();
        TreeNode rootNull = new TreeNode();
        assertEquals(0, solution5.sumRootToLeaf(rootNull));
    }
}