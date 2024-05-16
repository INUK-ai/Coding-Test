import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    static class Node {
        char value;
        Node left;
        Node right;

        Node(char value) {
            this.value = value;
        }
    }

    public static void main(String[] args) throws Exception {

        int T = 10;

        for (int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());
            Node[] nodes = new Node[N + 1];

            for(int i = 1; i < N + 1; i++) {
                nodes[i] = new Node(' ');
            }

            for(int i = 1; i < N + 1; i++) {
                st = new StringTokenizer(br.readLine());
                int index = Integer.parseInt(st.nextToken());
                nodes[index].value = st.nextToken().charAt(0);

                if (st.hasMoreTokens()) {
                    int left_index = Integer.parseInt(st.nextToken());
                    nodes[index].left = nodes[left_index];
                }

                if (st.hasMoreTokens()) {
                    int right_index = Integer.parseInt(st.nextToken());
                    nodes[index].right = nodes[right_index];
                }
            }

            StringBuilder result = new StringBuilder();
            inorderTraversal(nodes[1], result);

            sb.append("#").append(t).append(" ").append(result.toString()).append("\n");
        }

        System.out.println(sb);
    }

    private static void inorderTraversal(Node node, StringBuilder result) {
        if(node != null) {
            inorderTraversal(node.left, result);
            result.append(node.value);
            inorderTraversal(node.right, result);
        }
    }
}