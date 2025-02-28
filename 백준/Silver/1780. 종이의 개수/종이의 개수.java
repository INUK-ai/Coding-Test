import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int N;
    private static int[][] paper;
    private static int[] count = new int[3];

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        sb.append(count[0]).append(" ").append(count[1]).append(" ").append(count[2]);
        System.out.println(sb);
    }

    private static void divide(int y, int x, int size) {

        if (checkSame(y, x, size)) {
            count[paper[y][x] + 1]++;
            return;
        }

        int newSize = size / 3;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                divide(y + i * newSize, x + j * newSize, newSize);
            }
        }
    }

    private static boolean checkSame(int y, int x, int size) {
        int first = paper[y][x];
        for (int i = y; i < y + size; i++) {
            for (int j = x; j < x + size; j++) {
                if (paper[i][j] != first) return false;
            }
        }
        return true;
    }
}