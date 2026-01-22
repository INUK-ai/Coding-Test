import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    private static int R, C, T;
    private static int[][] room;

    private static int[] dx = {-1, 1, 0, 0};
    private static int[] dy = {0, 0, -1, 1};

    private static class Machine {
        private int x;
        private int y;

        public Machine(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    // 위쪽(반시계) 순환
    private static void operateUpper(Machine up) {
        int r = up.x;

        // 1) 왼쪽 세로(위로) : (r-1,0) <- (r-2,0) ... <- (0,0)
        for (int i = r - 1; i > 0; i--) {
            room[i][0] = room[i - 1][0];
        }

        // 2) 위쪽 가로(왼쪽으로) : (0,0) <- (0,1) <- ... <- (0,C-1)
        for (int j = 0; j < C - 1; j++) {
            room[0][j] = room[0][j + 1];
        }

        // 3) 오른쪽 세로(아래로) : (0,C-1) <- (1,C-1) <- ... <- (r,C-1)
        for (int i = 0; i < r; i++) {
            room[i][C - 1] = room[i + 1][C - 1];
        }

        // 4) 아래쪽 가로(오른쪽으로) : (r,C-1) <- (r,C-2) <- ... <- (r,1)
        for (int j = C - 1; j > 1; j--) {
            room[r][j] = room[r][j - 1];
        }

        // 청정기 바로 오른쪽은 깨끗한 공기
        room[r][1] = 0;

        // 청정기 위치 복구
        room[r][0] = -1;
    }

    // 아래쪽(시계) 순환
    private static void operateLower(Machine down) {
        int r = down.x;

        // 1) 왼쪽 세로(아래로) : (r+1,0) <- (r+2,0) ... <- (R-1,0)
        for (int i = r + 1; i < R - 1; i++) {
            room[i][0] = room[i + 1][0];
        }

        // 2) 아래쪽 가로(왼쪽으로) : (R-1,0) <- (R-1,1) <- ... <- (R-1,C-1)
        for (int j = 0; j < C - 1; j++) {
            room[R - 1][j] = room[R - 1][j + 1];
        }

        // 3) 오른쪽 세로(위로) : (R-1,C-1) <- (R-2,C-1) <- ... <- (r,C-1)
        for (int i = R - 1; i > r; i--) {
            room[i][C - 1] = room[i - 1][C - 1];
        }

        // 4) 위쪽 가로(오른쪽으로) : (r,C-1) <- (r,C-2) <- ... <- (r,1)
        for (int j = C - 1; j > 1; j--) {
            room[r][j] = room[r][j - 1];
        }

        // 청정기 바로 오른쪽은 깨끗한 공기
        room[r][1] = 0;

        // 청정기 위치 복구
        room[r][0] = -1;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        room = new int[R][C];
        Machine[] machines = new Machine[2];
        int machineIdx = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());
                if (room[i][j] == -1) {
                    machines[machineIdx++] = new Machine(i, j);
                }
            }
        }

        while (T-- > 0) {
            int[][] add =  new int[R][C];
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    if (room[i][j] == 0 || room[i][j] == -1) continue;
                    int current = room[i][j];
                    int dirCount = 0;
                    for (int k = 0; k < 4; k++) {
                        int nextX = i + dx[k];
                        int nextY = j + dy[k];
                        if (nextX < 0 || nextX >= R || nextY < 0 || nextY >= C) continue;
                        if (room[nextX][nextY] == -1) continue;

                        add[nextX][nextY] += current / 5;
                        dirCount++;
                    }
                    room[i][j] = current - (current / 5) * dirCount;
                }
            }
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {
                    room[i][j] += add[i][j];
                }
            }

            operateUpper(machines[0]);
            operateLower(machines[1]);
        }

        long sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (room[i][j] > 0) {
                    sum += room[i][j];
                }
            }
        }

        System.out.println(sum);
    }
}