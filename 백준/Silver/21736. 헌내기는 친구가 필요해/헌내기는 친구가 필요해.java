import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static char[][] campus;
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};
    static boolean[][] visited;
    static int N, M, people;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        campus = new char[N][M];
        visited = new boolean[N][M];

        int x = 0;
        int y = 0;

        for(int i = 0; i < N; i++) {
            String info = br.readLine();

            for(int j = 0; j < M; j++) {
                campus[i][j] = info.charAt(j);
                
                if(campus[i][j] == 'I') {
                    x = i;
                    y = j;
                }
            }
        }

        bfs(x, y);

        if(people == 0) {
            sb.append("TT");
        } else {
            sb.append(people);
        }

        System.out.println(sb);
    }

    private static void bfs(int x, int y) {

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
                    if(!visited[nx][ny] && campus[nx][ny] != 'X') {
                        q.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                        if(campus[nx][ny] == 'P') {
                            people++;
                        }
                    }
                }
            }
        }
    }
}