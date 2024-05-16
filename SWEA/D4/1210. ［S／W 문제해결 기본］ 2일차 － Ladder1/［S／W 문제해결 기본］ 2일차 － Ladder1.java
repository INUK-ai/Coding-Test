import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static int[][] ladder;
    private static boolean[][] visited;
    private static int[] dx = {0, 0, 1};
    private static int[] dy = {-1, 1, 0};
    private static int answer;

    public static void main(String[] args) throws Exception {

        int T = 10;

        for (int t = 1; t <= T; t++) {
            int tc = Integer.parseInt(br.readLine());

            ladder = new int[100][100];
            visited = new boolean[100][100];
            for (int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 100; j++) {
                    ladder[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int answer = 0;
            for(int j = 0; j < 100; j++) {
                if(ladder[99][j] == 2) {
                    answer = findStartPoint(j);
                    break;
                }
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int findStartPoint(int dest) {

        int y = dest;

        for(int x = 99; x >= 0; x--) {
            if(y > 0 && ladder[x][y - 1] == 1) {
                while(y > 0 && ladder[x][y - 1] == 1) {
                    y--;
                }
            } else if(y < 99 && ladder[x][y + 1] == 1) {
                while(y < 99 && ladder[x][y + 1] == 1) {
                    y++;
                }
            }
        }

        return y;
    }
}