package problems.tree_based;


public class SymmetricTree {
    private boolean isSymmetricTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.value == q.value && isSymmetricTree(p.left, q.right) && isSymmetricTree(p.right, q.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root.left == null && root.right == null) {
            return true;
        }
        if (root.left == null || root.right == null) {
            return false;
        }
        return isSymmetricTree(root.left, root.right);
    }
}
