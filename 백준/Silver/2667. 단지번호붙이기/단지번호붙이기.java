import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static Map<Integer, Integer> apart = new HashMap<>();
    static int[][] map;
    static int apartId;
    static boolean[][] visited;

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(bf.readLine());

        map = new int[N][N];
        apartId = 0;
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            String line = bf.readLine();
            for(int j = 0; j < N; j++) {
                map[i][j] = line.charAt(j) - '0';
            }
        }

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(map[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, apartId, N);
                    apartId++;
                }
            }
        }

        ArrayList<Integer> apartSize = new ArrayList<>(apart.values());
        Collections.sort(apartSize);

        System.out.println(apartSize.size());
        for(int size : apartSize) {
            System.out.println(size);
        }
    }

    private static void bfs(int x, int y, int apartId, int N) {

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        int size = 0;

        while(!queue.isEmpty()) {
            int[] current = queue.poll();
            int cx = current[0];
            int cy = current[1];

            visited[cx][cy] = true;
            size++;
            for(int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];

                if(nx >= 0 && nx < N && ny >= 0 && ny < N) {
                    if(map[nx][ny] == 1 && !visited[nx][ny]) {
                        queue.offer(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        apart.put(apartId, size);
    }
}
