/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
   TreeNode res = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //查找节点下是否有p和q，有记录，继续找下一个。直到找不到为止
        findLowestComAncestor(root, p, q);
        return res;
    }

    //如果节点的左子树或者右子树包含p或者q，则返回true（包含这个节点本身）
    private boolean findLowestComAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //左子树 或右子树
        if (root == null) {
            return false;
        }
        boolean left = findLowestComAncestor(root.left, p, q);
        boolean right = findLowestComAncestor(root.right, p, q);
        if (left && right || ((left||right)&&(root==p||root==q))) {
            res = root;
        }
        return left || right ||( root == p || root == q);

    }
}