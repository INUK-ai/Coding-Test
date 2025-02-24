import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, L, R, X, count;
    private static int[] level;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        level = new int[N];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            level[i] = Integer.parseInt(st.nextToken());
        }

        count = 0;

        backtrace(0, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);

        System.out.println(count);
    }

    private static void backtrace(int index, int sum, int min, int max) {

        if (isValid(sum, min, max)) {
            count++;
        }

        for (int i = index; i < N; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            int next = level[i];
            int tempMin = min;
            int tempMax = max;
            min = Math.min(min, next);
            max = Math.max(max, next);
            backtrace(i, sum + next, min, max);
            min = tempMin;
            max = tempMax;
            visited[i] = false;
        }
    }

    private static boolean isValid(int sum, int min, int max) {

        if (sum < L) return false;
        if (sum > R) return false;
        return (max - min) >= X;
    }
}