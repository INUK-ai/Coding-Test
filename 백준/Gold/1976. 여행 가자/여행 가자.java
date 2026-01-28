import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[] parent;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
        }

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= N; j++) {
                int v = Integer.parseInt(st.nextToken());
                if (v == 1) union(i, j);
            }
        }

        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        int root = find(first);

        boolean possible = true;
        for (int i = 1; i < M; i++) {
            int next = Integer.parseInt(st.nextToken());
            if (find(next) != root) {
                possible = false;
                break;
            }
        }

        if (possible) {
            System.out.println("YES");
        }  else {
            System.out.println("NO");
        }
    }

    public static void union(int from, int to) {
        int x = find(from);
        int y = find(to);

        if (x == y) return;
        parent[y] = x;
    }

    public static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }
}