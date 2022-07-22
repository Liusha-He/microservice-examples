package problems.tree_based;

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null) {
            return false;
        }
        return p.value == q.value && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
