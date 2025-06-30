import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N;
    private static List<Integer>[] tree;
    private static int deleteNode;
    private static int leafCount = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        int[] parent = new int[N];
        tree = new ArrayList[N];

        for (int i = 0; i < N; i++) {
            tree[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        int root = -1;

        for (int i = 0; i < N; i++) {
            parent[i] = Integer.parseInt(st.nextToken());
            if (parent[i] == -1) {
                root = i;
            } else {
                tree[parent[i]].add(i);
            }
        }

        deleteNode = Integer.parseInt(br.readLine());

        if (deleteNode == root) {
            System.out.println(0);
        } else {
            dfs(root);
            System.out.println(leafCount);
        }
    }

    private static void dfs(int node) {
        if (node == deleteNode) {
            return;
        }

        boolean isLeaf = true;

        for (int child : tree[node]) {
            if (child != deleteNode) {
                isLeaf = false;
                dfs(child);
            }
        }

        if (isLeaf) {
            leafCount++;
        }
    }
}