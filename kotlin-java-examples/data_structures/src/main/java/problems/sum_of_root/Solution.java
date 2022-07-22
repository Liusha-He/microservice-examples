package problems.sum_of_root;

class Solution {
     private int sum = 0;

    private void preOrder(TreeNode treeNode, int val) {
        if (treeNode != null) {
            val = (val << 1) | treeNode.val;
            if (treeNode.left == null && treeNode.right == null) {
                sum += val;
            }
            preOrder(treeNode.left, val);
            preOrder(treeNode.right, val);
        }
    }

    public int sumRootToLeaf(TreeNode root) {
        preOrder(root, 0);
        return sum;
    }
}
