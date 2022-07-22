package problems.tree_based;

public class SortedArrayToBinaryTree {
    private TreeNode toTreeNode(int left, int right, int[] arr) {
        if (left > right) {
            return null;
        }

        int midpoint = (left + right) / 2;
        TreeNode root = new TreeNode(arr[midpoint]);
        root.left = toTreeNode(left, midpoint - 1, arr);
        root.right = toTreeNode(midpoint + 1, right, arr);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        return toTreeNode(left, right, nums);
    }
}
