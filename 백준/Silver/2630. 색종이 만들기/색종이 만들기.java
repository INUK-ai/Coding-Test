import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[][] paper;
    static int white = 0;
    static int blue = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        paper = new int[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        divide(0, 0, N);

        sb.append(white).append("\n").append(blue);

        System.out.println(sb);
    }

    private static void divide(int x, int y, int size) {

        if(checkColor(x, y, size)) {
            if(paper[x][y] == 0) {
                white++;
            } else {
                blue++;
            }
        } else {
            int next_size = size / 2;

            divide(x, y, next_size);
            divide(x, y + next_size, next_size);
            divide(x + next_size, y, next_size);
            divide(x + next_size, y + next_size, next_size);
        }
    }

    private static boolean checkColor(int x, int y, int size) {
        int color = paper[x][y];

        for(int i = x; i < x + size; i++) {
            for(int j = y; j < y + size; j++) {
                if(paper[i][j] != color) {
                    return false;
                }
            }
        }

        return true;
    }
}