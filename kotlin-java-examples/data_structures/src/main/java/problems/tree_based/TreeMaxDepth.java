package problems.tree_based;

public class TreeMaxDepth {
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : 1 + Math.max(
                maxDepth(root.left), maxDepth(root.right)
        );
    }
}
