import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static long B;
    private static int A;
    private static int[] gifts;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        B = Long.parseLong(st.nextToken());
        A = Integer.parseInt(st.nextToken());

        gifts = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            gifts[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(gifts);

        long sum = 0;
        int start = 0, end = 0;
        for (int i = 0; i < N; i++) {
            if (A > 0) {
                if (sum + (gifts[i] / 2) <= B) {
                    sum += (gifts[i] / 2);
                    A--;
                    end = i + 1;
                } else {
                    break;
                }
            } else {
                sum += (gifts[start] / 2);
                sum += (gifts[end] / 2);

                if (sum > B) {
                    break;
                } else {
                    start++;
                    end++;
                }
            }
        }

        System.out.println(end);
    }
}