import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer st;

    private static int N, M, H;
    private static int[][] map;
    private static List<int[]> milkList = new ArrayList<>();
    private static boolean[] visited;

    private static int hx, hy;
    private static int maxMilk = 0;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    hx = i;
                    hy = j;
                } else if (map[i][j] == 2) {
                    milkList.add(new int[]{i, j});
                }
            }
        }

        visited = new boolean[milkList.size()];
        backtracking(hx, hy, M, 0);

        System.out.println(maxMilk);
    }

    private static void backtracking(int x, int y, int hp, int result) {

        int homeDistance = Math.abs(hx - x) + Math.abs(hy - y);
        if (homeDistance <= hp) {
            maxMilk = Math.max(maxMilk, result);
        }

        for (int i = 0; i < milkList.size(); i++) {
            if (visited[i]) continue;

            int nx = milkList.get(i)[0];
            int ny = milkList.get(i)[1];
            int distance = Math.abs(nx - x) + Math.abs(ny - y);

            if (hp < distance) continue;

            visited[i] = true;
            int newHp = hp - distance + H;
            backtracking(nx, ny, newHp, result + 1);
            visited[i] = false;
        }
    }
}