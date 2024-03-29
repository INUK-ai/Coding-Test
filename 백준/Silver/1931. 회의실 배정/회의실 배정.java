import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        /*
            끝나는 시간으로 dp
            dp[end time] = dp[start time] + 1, dp[end time - 1]
         */

        int N = Integer.parseInt(br.readLine());

        int[][] meeting = new int[N][2];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            meeting[i] = new int[]{x, y};
        }

        Arrays.sort(meeting, (x, y) -> (x[1] == y[1]) ? x[0] - y[0] : x[1] - y[1]);

        int count = 0;
        int end = 0;

        for(int i = 0; i < N ; i++) {
            int current_start = meeting[i][0];
            int current_end = meeting[i][1];

            if(current_start >= end) {
                end = current_end;
                count++;
            }
        }

        System.out.println(count);
    }
}