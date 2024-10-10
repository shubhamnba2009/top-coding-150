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

    public String rSerialize(TreeNode root, String s){
        if(root == null){
            s = s.concat("null,");
            return s;
        }

        s = s.concat(root.val+",");
        s = rSerialize(root.left, s);
        s = rSerialize(root.right, s);
        return s;
    }

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return rSerialize(root, "");
    }

    public TreeNode rDesearlize( List<String> lData ){
        if(lData.get(0).equals("null")){
            lData.remove(0);
            return null;
        }

        TreeNode node = new TreeNode(Integer.valueOf(lData.get(0)));
        lData.remove(0);
        node.left = rDesearlize(lData);
        node.right = rDesearlize(lData);
        return node;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] str = data.split(",");

        List<String> lData = new ArrayList<>(Arrays.asList(str));

        return rDesearlize(lData);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));