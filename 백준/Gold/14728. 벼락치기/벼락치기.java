import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N, T;
    private static int[] dp;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        dp = new int[T + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());

            for (int j = T; j >= K; j--) {
                dp[j] = Math.max(dp[j], dp[j - K] + S);
            }
        }

        System.out.println(dp[T]);
    }
}