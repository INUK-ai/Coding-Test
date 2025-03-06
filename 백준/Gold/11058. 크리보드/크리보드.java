import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        long[] dp = new long[N + 1];

        for (int i = 1; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;

            for (int j = 3; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }

        System.out.println(dp[N]);
    }
}