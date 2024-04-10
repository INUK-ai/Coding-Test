import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    public static class Work {
        int due;
        int pay;

        public Work(int due, int pay) {
            this.due = due;
            this.pay = pay;
        }
    }

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        Work[] works = new Work[N + 1];
        for(int i = 1; i < N + 1; i++) {
            st = new StringTokenizer(br.readLine());

            int work = Integer.parseInt(st.nextToken());
            int pay = Integer.parseInt(st.nextToken());
            works[i] = new Work(work, pay);
        }

        int[] dp = new int[N + 2];

        for(int i = N; i > 0; i--) {
            int due = works[i].due + i;
            int pay = works[i].pay;
            if(due <= N + 1) {
                dp[i] = Math.max(pay + dp[due], dp[i + 1]);
            } else {
                dp[i] = dp[i + 1];
            }
        }

        System.out.println(dp[1]);
    }
}