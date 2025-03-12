import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int[][] puzzle = new int[9][9];
    private static List<int[]> blanks = new ArrayList<>();

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                puzzle[i][j] = Integer.parseInt(st.nextToken());
                if (puzzle[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        backtracing(0);
    }

    private static void backtracing(int index) {

        if (index == blanks.size()) {
            printBoard();
            System.exit(0);
        }

        int x = blanks.get(index)[0];
        int y = blanks.get(index)[1];

        for (int n = 1; n < 10; n++) {
            if (isValid(x, y, n)) {
                puzzle[x][y] = n;
                backtracing(index + 1);
                puzzle[x][y] = 0;
            }
        }
    }

    private static boolean isValid(int x, int y, int n) {

        for (int i = 0; i < 9; i++) {
            if (puzzle[x][i] == n) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (puzzle[i][y] == n) return false;
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (puzzle[i][j] == n) return false;
            }
        }

        return true;
    }

    private static void printBoard() {
        StringBuilder sb = new StringBuilder();
        for (int[] row : puzzle) {
            for (int num : row) {
                sb.append(num).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }
}