import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    private static class Node {

        private char value;
        private Node left;
        private Node right;

        public Node(char value) {
            this.value = value;
        }
    }

    private static Map<Character, Node> tree = new HashMap<>();

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char value = st.nextToken().charAt(0);
            char leftValue = st.nextToken().charAt(0);
            char rightValue = st.nextToken().charAt(0);

            tree.putIfAbsent(value, new Node(value));

            if (leftValue != '.') {
                tree.putIfAbsent(leftValue, new Node(leftValue));
                tree.get(value).left = tree.get(leftValue);
            }

            if (rightValue != '.') {
                tree.putIfAbsent(rightValue, new Node(rightValue));
                tree.get(value).right = tree.get(rightValue);
            }
        }

        Node root = tree.get('A');

        preOrder(root);
        inOrder(root);
        postOrder(root);
        
        System.out.println(preOrderResult);
        System.out.println(inOrderResult);
        System.out.println(postOrderResult);
    }

    static StringBuilder preOrderResult = new StringBuilder();
    static StringBuilder inOrderResult = new StringBuilder();
    static StringBuilder postOrderResult = new StringBuilder();

    private static void preOrder(Node node) {
        if (node == null) return;
        preOrderResult.append(node.value);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void inOrder(Node node) {
        if (node == null) return;
        inOrder(node.left);
        inOrderResult.append(node.value);
        inOrder(node.right);
    }

    static void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postOrderResult.append(node.value);
    }
}
