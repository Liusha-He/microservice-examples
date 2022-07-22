package problems.sum_of_root;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    // constructors
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
