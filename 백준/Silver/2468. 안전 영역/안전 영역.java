import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;

    static Map<Integer, Integer> year_size = new HashMap<>();
    static int N, year;
    static int[][] land;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(bf.readLine());
        year = 0;
        land = new int[N][N];

        int max = 0;

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j = 0; j < N ;j++) {
                land[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(land[i][j], max);
            }
        }

        while(max > 0) {
            boolean[][] visited = new boolean[N][N];
            int land_num = 0;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    if(land[i][j] > 0 && !visited[i][j]) {
                        bfs(i, j, visited);
                        land_num++;
                    }
                }
            }

            year_size.put(year, land_num);

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    land[i][j]--;
                }
            }

            max--;
            year++;
        }

        int answer = 0;
        for(int size : year_size.values()) {
            answer = Math.max(answer, size);
        }

        System.out.println(answer);
    }

    private static void bfs(int x, int y, boolean[][] visited) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(land[nx][ny] > 0 && !visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
