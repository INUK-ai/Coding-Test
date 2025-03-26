import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int[][] board = new int[9][9];
    private static List<int[]> blanks = new ArrayList<>();
    private static boolean solved = false;

    public static void main(String[] args) throws IOException {

        for (int i = 0; i < 9; i++) {
            char[] numArr = br.readLine().toCharArray();
            for (int j = 0; j < 9; j++) {
                board[i][j] = numArr[j] - '0';
                if (board[i][j] == 0) {
                    blanks.add(new int[]{i, j});
                }
            }
        }

        backtracking(0);
    }

    private static void backtracking(int idx) {
        if (solved) return;
        if (idx == blanks.size()) {
            printBoard();
            solved = true;
            return;
        }

        int x = blanks.get(idx)[0];
        int y = blanks.get(idx)[1];

        for (int num = 1; num <= 9; num++) {
            if (isValid(x, y, num)) {
                board[x][y] = num;
                backtracking(idx + 1);
                board[x][y] = 0;
            }
        }
    }

    private static boolean isValid(int x, int y, int num) {
        for (int i = 0; i < 9; i++) {
            if (board[x][i] == num) return false;
        }

        for (int i = 0; i < 9; i++) {
            if (board[i][y] == num) return false;
        }

        int startX = (x / 3) * 3;
        int startY = (y / 3) * 3;
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] == num) return false;
            }
        }

        return true;
    }

    private static void printBoard() {
        for (int[] row : board) {
            for (int num : row) {
                sb.append(num);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}