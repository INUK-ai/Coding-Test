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

        int T = Integer.parseInt(br.readLine());

        for (int testCase = 0; testCase < T; testCase++) {
            st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken()); // 서쪽 사이트의 수
            int M = Integer.parseInt(st.nextToken()); // 동쪽 사이트의 수

            sb.append(combination(M, N)).append("\n");
        }

        System.out.println(sb);
    }

    private static long combination(int n, int k) {

        long[][] dp = new long[n + 1][k + 1];

        for(int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }

        for(int i = 1; i < n + 1; i++) {
            for(int j = 1; j < Math.min(i, k) + 1; j++) {
                if(i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[n][k];
    }
}