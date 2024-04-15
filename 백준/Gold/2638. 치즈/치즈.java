import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static int N, M;
    static int[][] cheeze;
    static int[][] minus;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeze = new int[N][M];
        minus = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++) {
                cheeze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        while(checkCheeze()) {

            visited = new boolean[N][M];
            bfs(0, 0);
            int[][] minus = new int[N][M];

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(cheeze[i][j] == 1) {
                        minus[i][j] = checkMinus(i, j);
                    }
                }
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(minus[i][j] > 1) {
                        cheeze[i][j] = 0;
                    }

                    if(cheeze[i][j] == 2) {
                        cheeze[i][j] = 0;
                    }
                }
            }

            count++;
        }

        System.out.println(count);
    }

    private static int checkMinus(int x, int y) {
        int count = 0;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                if(cheeze[nx][ny] == 2) {
                    count++;
                }
            }
        }

        return count;
    }

    public static boolean checkCheeze() {
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < M; j++) {
                if(cheeze[i][j] == 1) {
                    return true;
                }
            }
        }

        return false;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        cheeze[x][y] = 2;
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(!visited[nx][ny] && cheeze[nx][ny] == 0) {
                        cheeze[nx][ny] = 2;
                        visited[nx][ny] = true;
                        q.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }
}