import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

    private static class Node {

        public final int value;
        public final int x;
        public final int y;

        public Node left;
        public Node right;

        private Node(int value, int x, int y) {
            this.value = value;
            this.x = x;
            this.y = y;
        }
    }

    public int[][] solution(int[][] nodeinfo) {

        Node[] nodes = new Node[nodeinfo.length];
        for (int i = 0; i < nodeinfo.length; i++) {
            nodes[i] = new Node(i + 1, nodeinfo[i][0], nodeinfo[i][1]);
        }

        Arrays.sort(nodes, (a, b) -> b.y - a.y);
        
        Node root = constructTree(nodes);
        
        List<Integer> preorder = new ArrayList<>();
        preOrder(root, preorder);
        
        List<Integer> postorder = new ArrayList<>();
        postOrder(root, postorder);

        return new int[][]{
                preorder.stream().mapToInt(i -> i).toArray(),
                postorder.stream().mapToInt(i -> i).toArray()
        };
    }

    private Node constructTree(Node[] nodes) {

        Node root = nodes[0];

        for (int i = 1; i < nodes.length; i++) {
            insert(root, nodes[i]);
        }

        return root;
    }

    private void insert(Node root, Node node) {

        if (node.x < root.x) {
            if (root.left == null) {
                root.left = node;
            } else {
                insert(root.left, node);
            }
        } else {
            if (root.right == null) {
                root.right = node;
            } else {
                insert(root.right, node);
            }
        }
    }

    private void preOrder(Node node, List<Integer> visits) {

        if (node == null) return;

        visits.add(node.value);
        preOrder(node.left, visits);
        preOrder(node.right, visits);
    }

    private void postOrder(Node node, List<Integer> visits) {

        if (node == null) return;

        postOrder(node.left, visits);
        postOrder(node.right, visits);
        visits.add(node.value);
    }
}