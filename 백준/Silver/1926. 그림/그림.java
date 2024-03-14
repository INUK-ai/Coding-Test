import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> paper = new HashMap<>();
    static int N, M;
    static int[][] paint;
    static boolean[][] visited;
    static int paint_id;
    static int max_size;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        paint = new int[N][M];
        visited = new boolean[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j = 0; j < M; j++) {
                paint[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        paint_id = 0;
        max_size = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(paint[i][j] == 1 && !visited[i][j]) {
                    int size = bfs(i, j);
                    paper.put(paint_id, size);
                    paint_id++;
                    max_size = Math.max(max_size, size);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(paint_id).append("\n").append(max_size);

        System.out.println(sb);
    }

    private static int bfs(int x, int y) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        int size = 0;
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            size++;
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(paint[nx][ny] == 1 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        return size;
    }
}
