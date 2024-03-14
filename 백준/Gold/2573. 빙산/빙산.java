import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int N, M;
    static int[][] ice;
    static int ice_id;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ice = new int[N][M];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());

            for(int j = 0; j < M; j++) {
                ice[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int year = 0;
        boolean isEnd;

        while(ice_id < 2) {
            boolean[][] visited = new boolean[N][M];
            int[][] minus = new int[N][M];
            ice_id = 0;
            isEnd = true;

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    if(ice[i][j] != 0 && !visited[i][j]) {
                        bfs(i, j, visited, minus);
                        ice_id++;
                    }
                }
            }

            if(ice_id >= 2) {
                break;
            }

            for(int i = 0; i < N; i++) {
                for(int j = 0; j < M; j++) {
                    ice[i][j] -= minus[i][j];

                    if(ice[i][j] < 0) {
                        ice[i][j] = 0;
                    }

                    if(isEnd && ice[i][j] > 0) {
                        isEnd = false;
                    }
                }
            }

            if(isEnd) {
                year = 0;
                break;
            }

            year++;
        }

        System.out.println(year);
    }

    private static void bfs(int x, int y, boolean[][] visited, int[][] minus) {

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{x, y});
        visited[x][y] = true;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int cx = current[0];
            int cy = current[1];

            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < M) {
                    if(ice[nx][ny] == 0) {
                        minus[cx][cy]++;
                    } else if(!visited[nx][ny]) {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }
    }
}
