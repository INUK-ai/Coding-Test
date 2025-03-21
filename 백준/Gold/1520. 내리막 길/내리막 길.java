import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int M, N;
    private static int[][] map, dp;

    private static int[] dx = {0, 1, 0, -1};
    private static int[] dy = {-1, 0, 1, 0};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        dp = new int[M][N];
        for (int x = 0; x < M; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y = 0; y < N; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
                dp[x][y] = -1;
            }
        }

        System.out.println(dfs(0, 0));
    }

    private static int dfs(int x, int y) {
        
        if (x == M - 1 && y == N - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];
        
        dp[x][y] = 0;
        for (int dir = 0; dir < 4; dir++) {
            int nx = x + dx[dir];
            int ny = y + dy[dir];
            
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (map[nx][ny] >= map[x][y]) continue;
            
            dp[x][y] += dfs(nx, ny);
        }
        
        return dp[x][y];
    }
}