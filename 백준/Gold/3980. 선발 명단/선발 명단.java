import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();

    private static int tc, maxPoint;
    private static int[][] playerPoint;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {

        tc = Integer.parseInt(br.readLine());

        for (int t = 0; t < tc; t++) {
            playerPoint = new int[11][11];
            maxPoint = 0;
            visited = new boolean[11];
            for (int i = 0; i < 11; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < 11; j++) {
                    playerPoint[j][i] = Integer.parseInt(st.nextToken());
                }
            }

            backtracking(0, 0);

            sb.append(maxPoint).append("\n");
        }

        System.out.println(sb);
    }

    private static void backtracking(int position, int point) {

        if (position == 11) {
            maxPoint = Math.max(maxPoint, point);
            return;
        }

        for (int player = 0; player < 11; player++) {
            if (visited[player]) continue;
            if (playerPoint[position][player] == 0) continue;
            visited[player] = true;
            backtracking(position + 1, point + playerPoint[position][player]);
            visited[player] = false;
        }
    }
}