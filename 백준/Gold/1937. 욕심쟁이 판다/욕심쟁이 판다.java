import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, maxMove = Integer.MIN_VALUE;
    private static int[][] forest, dp;
    private static final int[] dx = {-1, 0, 1, 0};
    private static final int[] dy = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        forest = new int[N][N];
        dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                maxMove = Math.max(maxMove, dfs(i, j));
            }
        }

        System.out.println(maxMove);
    }

    private static int dfs(int y, int x) {

        if (dp[y][x] != 0) return dp[y][x];

        dp[y][x] = 1;
        for (int k = 0; k < 4; k++) {
            int ny = y + dy[k];
            int nx = x + dx[k];

            if (ny < 0 || ny >= N || nx < 0 || nx >= N) continue;
            if (forest[ny][nx] <= forest[y][x]) continue;

            dp[y][x] = Math.max(dp[y][x], 1 + dfs(ny, nx));
        }

        return dp[y][x];
    }
}
