import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(bf.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int first = Integer.parseInt(st.nextToken());

        int[][] relation = new int[N + 1][N + 1];
        int[] visited = new int[N + 1];

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            relation[from][to] = 1;
            relation[to][from] = 1;
        }

        String dfs_answer = dfs(relation, first);
        String bfs_answer = bfs(relation, first);

        System.out.println(dfs_answer);
        System.out.println(bfs_answer);
    }

    private static String dfs(int[][] relation, int x) {

        StringBuilder sb = new StringBuilder();
        int[] visited = new int[relation.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(x);
        visited[x] = 1;
        sb.append(x);

        while(!stack.isEmpty()) {
            int num = stack.peek();
            int visit = 0;

            for(int i = 0; i < relation[num].length; i++) {
                if(relation[num][i] == 1 && visited[i] == 0) {
                    stack.push(i);
                    visited[i] = 1;
                    sb.append(" " + i);

                    visit = 1;
                    break;
                }
            }

            if(visit == 0) {
                stack.pop();
            }
        }

        return sb.toString();
    }

    public static String bfs(int[][] relation, int x) {

        StringBuilder sb = new StringBuilder();
        int[] visited = new int[relation.length];

        Queue<Integer> queue = new LinkedList<>();
        queue.offer(x);
        visited[x] = 1;
        sb.append(x);

        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int i = 0; i < relation[num].length; i++) {
                if(relation[num][i] == 1 && visited[i] == 0) {
                    queue.offer(i);
                    visited[i] = 1;

                    sb.append(" " + i);
                }
            }
        }

        return sb.toString();
    }
}
