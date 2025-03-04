import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] jewels;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        jewels = new int[M];
        int maxJewels = 0;
        for (int i = 0; i < M; i++) {
            jewels[i] = Integer.parseInt(br.readLine());
            maxJewels = Math.max(maxJewels, jewels[i]);
        }

        int low = 1, high = maxJewels, result = high;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (isValid(mid)) {
                result = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        System.out.println(result);
    }

    private static boolean isValid(int maxPerStudent) {

        long requiredStudents = 0;

        for (int jewel : jewels) {
            requiredStudents += (jewel + maxPerStudent - 1) / maxPerStudent;
            if (requiredStudents > N) return false;
        }

        return requiredStudents <= N;
    }
}