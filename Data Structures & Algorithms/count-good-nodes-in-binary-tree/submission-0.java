/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        return 1 + dfs(root.left, root.val) + dfs(root.right, root.val);
    }

    public int dfs(TreeNode root, int val) {
        if (root == null) return 0;

        int left = dfs(root.left, Math.max(val, root.val));
        int right = dfs(root.right, Math.max(val, root.val));

        return (root.val < val ? 0 : 1) + left + right;
    }
}
