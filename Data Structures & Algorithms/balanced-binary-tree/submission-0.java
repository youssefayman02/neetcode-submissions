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
    public boolean isBalanced(TreeNode root) {
        return dfs(root)[0] == 1;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) return new int[]{1, 0};

        int[] leftTree = dfs(root.left);
        int[] rightTree = dfs(root.right);

        int[] res = new int[2];

        res[0] = leftTree[0] == 1 && rightTree[0] == 1 && (Math.abs(leftTree[1] - rightTree[1]) <= 1) ? 1 : 0;
        res[1] = 1 + Math.max(leftTree[1], rightTree[1]);

        return res;
    }
}
