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

    public String rSerialize(TreeNode root, String str){
        if(root == null)
            return str+"null,";

        str += root.val+",";
        str = rSerialize(root.left, str);
        str = rSerialize(root.right, str);
        return str;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public TreeNode rdeserialize(List<String> l){
        if(l.get(0).equals("null")){
            l.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(l.get(0)));
        l.remove(0);
        node.left = rdeserialize(l);
        node.right = rdeserialize(l);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");
        List<String> l = new ArrayList<>(Arrays.asList(str));
        return rdeserialize(l);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));