import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static ArrayList<Integer>[] graph;
    static int[] parents;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        int N = Integer.parseInt(br.readLine());

        graph = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];

        for(int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            graph[from].add(to);
            graph[to].add(from);
        }

        dfs(1);

        for(int i = 2; i < N + 1; i++) {
            sb.append(parents[i]).append("\n");
        }

        System.out.println(sb);
    }

    private static void dfs(int node) {
        visited[node] = true;

        for(int child : graph[node]) {
            if(!visited[child]) {
                parents[child] = node;
                dfs(child);
            }
        }
    }
}