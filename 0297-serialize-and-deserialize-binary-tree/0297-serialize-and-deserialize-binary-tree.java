/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {

    private String hSerialize(TreeNode root, String str) {
        if(root == null)
            return str+"null,";
        
        str += root.val+",";
        str = hSerialize(root.left, str);
        str = hSerialize(root.right, str);
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return hSerialize(root, "");
    }

    private TreeNode hDeserialize(List<String> dList) {
        if(dList.get(0).equals("null")){
            dList.remove(0);
            return null;
        }
        TreeNode result = new TreeNode(Integer.valueOf(dList.get(0)));
        dList.remove(0);
        result.left = hDeserialize(dList);
        result.right = hDeserialize(dList);
        return result;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> dList = new ArrayList<>(Arrays.asList(str));
        return hDeserialize(dList);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));