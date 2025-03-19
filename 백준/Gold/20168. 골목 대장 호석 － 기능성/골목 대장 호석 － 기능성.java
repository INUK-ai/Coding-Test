import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M, A, B, C;
    private static List<int[]>[] graph;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        int maxToll = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[u].add(new int[]{v, cost});
            graph[v].add(new int[]{u, cost});

            maxToll = Math.max(maxToll, cost);
        }

        int low = 0, high = maxToll, result = -1;
        while (low <= high) {
            int mid = (low + high) / 2;

            if (canReach(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean canReach(int maxToll) {

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[A] = 0;
        pq.offer(new int[]{A, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], cost = cur[1];

            if (cost > dist[node]) continue;
            if (node == B && cost <= C) return true;

            for (int[] next : graph[node]) {
                int nextNode = next[0], toll = next[1];

                if (toll > maxToll) continue;

                int newCost = cost + toll;
                if (newCost < dist[nextNode]) {
                    dist[nextNode] = newCost;
                    pq.add(new int[]{nextNode, newCost});
                }
            }
        }

        return false;
    }
}