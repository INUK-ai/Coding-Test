import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dist = new int[N];
        long[] prefix = new long[2 * N + 1];

        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            dist[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 0; i < 2 * N; i++) {
            prefix[i + 1] = prefix[i] + dist[i % N];
        }

        long total = prefix[N];
        long max = 0;
        int j = 0;

        for (int i = 0; i < N; i++) {
            while (j < i + N && prefix[j + 1] - prefix[i] <= total / 2) {
                long d = prefix[j + 1] - prefix[i];
                max = Math.max(max, d);
                j++;
            }
        }

        System.out.println(max);
    }
}