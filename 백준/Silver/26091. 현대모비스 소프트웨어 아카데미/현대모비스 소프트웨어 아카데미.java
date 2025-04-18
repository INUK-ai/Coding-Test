import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;
    private static int[] students;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        students = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            students[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(students);

        int count = 0;
        int left = 0, right = N - 1;
        while (left < right) {
            int point = students[left] + students[right];
            if (point >= M) {
                count++;
                right--;
            }

            left++;
        }

        System.out.println(count);
    }
}