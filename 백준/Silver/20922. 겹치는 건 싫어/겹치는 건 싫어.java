import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, K;
    private static int[] numbers;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        numbers = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[] numCount = new int[100001];
        int left = 0, right = 0, max = 0;

        while (right < N) {
            numCount[numbers[right]]++;
            while (numCount[numbers[right]] > K) {
                numCount[numbers[left++]]--;
            }
            max = Math.max(max, right - left + 1);
            right++;
        }

        System.out.println(max);
    }
}