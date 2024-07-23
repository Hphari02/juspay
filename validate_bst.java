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
        return recursion(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean recursion(TreeNode root,long minval,long maxval)
    {
        if(root==null)
        {
            return true;
        }
        if(root.val<=minval || root.val>=maxval )
        {
            return false;
        }
        
        boolean left_answer=recursion(root.left,minval,root.val);
        boolean right_answer=recursion(root.right,root.val,maxval);
        
        return left_answer && right_answer;
    }
}
