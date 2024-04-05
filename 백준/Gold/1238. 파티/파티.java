import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N, M, X;

    public static class Node implements Comparable<Node> {

        int end;
        int time;

        public Node(int end, int time) {
            this.end = end;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    static List<List<Node>> graph = new ArrayList<>();
    static List<List<Node>> reverseGraph = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());

            graph.get(from).add(new Node(to, time));
            reverseGraph.get(to).add(new Node(from, time));
        }

        int[] distanceToX = dijkstra(X, graph);
        int[] distanceFromX = dijkstra(X, reverseGraph);

        int maxTime = 0;
        for(int i = 1; i < N + 1; i++) {
            maxTime = Math.max(maxTime, distanceToX[i] + distanceFromX[i]);
        }

        System.out.println(maxTime);
    }

    static int[] dijkstra(int start, List<List<Node>> graph) {

        int[] distance = new int[N + 1];

        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node current = pq.poll();

            if(distance[current.end] < current.time) continue;

            for(Node next : graph.get(current.end)) {
                if(distance[next.end] > current.time + next.time) {
                    distance[next.end] = current.time + next.time;
                    pq.offer(new Node(next.end, distance[next.end]));
                }
            }
        }

        return distance;
    }
}