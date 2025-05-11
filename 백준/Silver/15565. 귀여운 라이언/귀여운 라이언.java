import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;
    private static int[] dolls;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dolls = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            dolls[i] = Integer.parseInt(st.nextToken());
        }

        int left = 0, right = 0, count = 0;
        int minLength = Integer.MAX_VALUE;

        while (right < N) {
            if (dolls[right] == 1) count++;

            while (count >= K) {
                minLength = Math.min(minLength, right - left + 1);
                if (dolls[left] == 1) count--;
                left++;
            }

            right++;
        }

        System.out.println(minLength == Integer.MAX_VALUE ? -1 : minLength);
    }
}