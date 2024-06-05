import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;
    static char[][] board;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());
        board = new char[N][N];

        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        int maxCandies = 0;

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(j + 1 < N && board[i][j] != board[i][j+1]) {
                    swap(i, j, i, j + 1);
                    maxCandies = Math.max(maxCandies, getMaxCandies());
                    swap(i, j, i, j + 1);
                }

                if(i + 1 < N && board[i][j] != board[i+1][j]) {
                    swap(i, j, i + 1, j);
                    maxCandies = Math.max(maxCandies, getMaxCandies());
                    swap(i, j, i + 1, j);
                }
            }
        }

        sb.append(maxCandies);

        System.out.println(sb);
    }

    public static void swap(int x1, int y1, int x2, int y2) {

        char temp = board[x1][y1];
        board[x1][y1] = board[x2][y2];
        board[x2][y2] = temp;
    }

    private static int getMaxCandies() {

        int max = 0;

        for(int i = 0; i < N; i++) {
            int count = 1;

            for(int j = 1; j < N; j++) {
                if(board[i][j] == board[i][j - 1]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        for(int j = 0; j < N; j++) {
            int count = 1;

            for(int i = 1; i < N; i++) {
                if(board[i][j] == board[i - 1][j]) {
                    count++;
                } else {
                    max = Math.max(max, count);
                    count = 1;
                }
            }
            max = Math.max(max, count);
        }

        return max;
    }
}