import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[] honey, prefixSum;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        honey = new int[N];
        prefixSum = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            honey[i] = Integer.parseInt(st.nextToken());
            prefixSum[i] = (i == 0) ? honey[i] : prefixSum[i - 1] + honey[i];
        }

        int maxHoney = 0;

        for (int mid = 1; mid < N - 1; mid++) {
            int bee1 = prefixSum[mid] - honey[0];
            int bee2 = prefixSum[N - 2] - prefixSum[mid - 1];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        for (int i = 1; i < N - 1; i++) {
            int bee1 = prefixSum[N - 2] - honey[i];
            int bee2 = prefixSum[i - 1];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        for (int i = 1; i < N - 1; i++) {
            int bee1 = prefixSum[N - 1] - honey[0] - honey[i];
            int bee2 = prefixSum[N - 1] - prefixSum[i];
            maxHoney = Math.max(maxHoney, bee1 + bee2);
        }

        System.out.println(maxHoney);
    }
}