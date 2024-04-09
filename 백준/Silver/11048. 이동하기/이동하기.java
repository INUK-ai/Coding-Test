import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] maze = new int[N + 1][M + 1];

        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 1; j < M + 1; j++) {
                maze[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[N + 1][M + 1];

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < M + 1; j++) {
                dp[i][j] = Math.max(Math.max(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + maze[i][j];
            }
        }

        System.out.println(dp[N][M]);
    }
}