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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)
            return result;
        Queue<TreeNode> q = new ArrayDeque<>();

        q.add(root);
        while(!q.isEmpty()){
            int len = q.size();
            List<Integer> tmp = new ArrayList<>();

            for(int i = 0;i<len;i++){
                TreeNode tmpNode = q.poll();
                if(tmpNode.left!=null)q.add(tmpNode.left);
                if(tmpNode.right!=null)q.add(tmpNode.right);
                tmp.add(tmpNode.val);
            }
            result.add(tmp);
        }

        return result;
    }
}