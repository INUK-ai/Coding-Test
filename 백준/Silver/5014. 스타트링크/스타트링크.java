import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int F, S, G, U, D;
    private static int[] moves;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        moves = new int[F + 1];
        visited = new boolean[F + 1];

        int result = bfs();
        System.out.println(result == -1 ? "use the stairs" : result);
    }

    private static int bfs() {

        Queue<Integer> queue = new LinkedList<>();
        queue.add(S);
        visited[S] = true;

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == G) return moves[cur];

            for (int next : new int[]{cur + U, cur - D}) {
                if (next < 1) continue;
                if (next > F) continue;
                if (visited[next]) continue;

                visited[next] = true;
                moves[next] = moves[cur] + 1;
                queue.add(next);
            }
        }

        return -1;
    }
}
