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

        int[] maze = new int[N];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            maze[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for(int i = 0; i < N; i++) {
            if(dp[i] == INF) {
                continue;
            }

            for(int j = 1; j < maze[i] + 1 && i + j < N; j++) {
                dp[i + j] = Math.min(dp[i + j], dp[i] + 1);
            }
        }
        
        int answer = 0;
        if (dp[N-1] == INF) {
            answer = -1;
        } else {
            answer = dp[N - 1];
        }
        
        System.out.println(answer);
    }
}