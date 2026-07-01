public class Codec {

    private int idx;

    public String serialize(TreeNode root) {
        List<String> res = new ArrayList<>();
        serializeDFS(root, res);
        return String.join(",", res);
    }

    private void serializeDFS(TreeNode node, List<String> res) {
        if (node == null) {
            res.add("N");
            return;
        }
        res.add(Integer.toString(node.val));
        serializeDFS(node.left, res);
        serializeDFS(node.right, res);
    }

    public TreeNode deserialize(String data) {
        String[] values = data.split(",");
        idx = 0;
        return deserializeDFS(values);
    }

    private TreeNode deserializeDFS(String[] values) {
        if (values[idx].equals("N")) {
            idx++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(values[idx]));
        idx++;
        node.left = deserializeDFS(values);
        node.right = deserializeDFS(values);
        return node;
    }
}