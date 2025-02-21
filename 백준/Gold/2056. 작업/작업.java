import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static List<Integer>[] graph;
    private static int[] indegree, time, dp;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        indegree = new int[N + 1];
        time = new int[N + 1];
        dp = new int[N + 1];

        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());

            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                int preTask = Integer.parseInt(st.nextToken());
                graph[preTask].add(i);
                indegree[i]++;
            }
        }

        System.out.println(topologySort());
    }

    private static int topologySort() {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i];
            }
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            for (int next : graph[cur]) {
                dp[next] = Math.max(dp[next], dp[cur] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }

        return Arrays.stream(dp).max().getAsInt();
    }
}
