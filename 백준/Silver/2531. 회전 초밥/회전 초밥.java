import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, d, k, c;
    private static int[] sushi;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        sushi = new int[N + k];
        for (int i = 0; i < N; i++) {
            sushi[i] = Integer.parseInt(br.readLine());
        }

        for (int i = N; i < N + k; i++) {
            sushi[i] = sushi[i - N];
        }

        int[] count = new int[d + 1];
        int result = 0;
        int start = 0;
        int end = 0;
        int max = 0;

        while (end < k) {
            count[sushi[end]]++;
            if (count[sushi[end]] == 1) {
                result++;
            }
            end++;
        }

        if (count[c] == 0) {
            max = result + 1;
        } else {
            max = result;
        }

        while (end < N + k) {
            count[sushi[start]]--;
            if (count[sushi[start]] == 0) {
                result--;
            }

            start++;
            count[sushi[end]]++;

            if (count[sushi[end]] == 1) {
                result++;
            }
            end++;

            if (count[c] == 0) {
                max = Math.max(max, result + 1);
            } else {
                max = Math.max(max, result);
            }
        }

        System.out.println(max);
    }
}