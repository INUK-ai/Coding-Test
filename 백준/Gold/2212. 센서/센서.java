import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;
    private static int[] sensors;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        K = Integer.parseInt(br.readLine());

        sensors = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            sensors[i] = Integer.parseInt(st.nextToken());
        }

        if (K >= N) {
            System.out.println(0);
            return;
        }

        Arrays.sort(sensors);

        int[] diffs = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            diffs[i] = sensors[i + 1] - sensors[i];
        }

        Arrays.sort(diffs);
        int total = 0;
        for (int i = 0; i < N - K; i++) {
            total += diffs[i];
        }

        System.out.println(total);
    }
}