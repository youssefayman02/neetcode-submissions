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
    private Set<Integer> set = new HashSet<>();

    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, 0, res);
        return res;
    }

    public void dfs(TreeNode root, int depth, List<Integer> res) {
        if (root == null) return;
        
        if (!set.contains(depth)) {
            res.add(root.val);
            set.add(depth);
        }

        dfs(root.right, depth + 1, res);
        dfs(root.left, depth + 1, res);
    }
}
