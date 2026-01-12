import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int K, N;
    private static long[] rope;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        K = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        rope = new long[K];
        long maxRope = 0;
        for (int i = 0; i < K; i++) {
            rope[i] = Long.parseLong(br.readLine());
            if (rope[i] > maxRope) {
                maxRope = rope[i];
            }
        }

        long low = 1, high = maxRope;
        long answer = 0;

        while (low <= high) {
            long mid = low + (high - low) / 2;
            long pieces = 0;

            for (long x : rope) {
                pieces += (x / mid);
                if (pieces >= N) break;
            }

            if (pieces >= N) {
                answer = mid;
                low = mid + 1;
            }  else {
                high = mid - 1;
            }
        }

        System.out.println(answer);
    }
}