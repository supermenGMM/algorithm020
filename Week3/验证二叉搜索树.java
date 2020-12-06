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
    
     public boolean isValidBST(TreeNode root) {
        return inorderTraversal(root);
    }
    Integer preval = null;
    //中序遍历
    public boolean inorderTraversal(TreeNode node) {
        if (node == null) {
            return true;
        }
        if(!inorderTraversal(node.left)){
            return false;
        }
         System.out.println(preval);
        if (preval == null) {
            preval = node.val;
        }else{
            if(preval>=node.val){
                return false;
            }else{
                preval = node.val;
            }
        }
        System.out.println(preval);
        if(!inorderTraversal(node.right)){
            return false;
        }
        return true;
    }
}