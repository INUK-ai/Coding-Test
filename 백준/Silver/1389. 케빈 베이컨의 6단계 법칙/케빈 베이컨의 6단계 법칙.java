import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb;

    static int N, M;
    static int[][] arr;

    static final int INF = 987654321;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N + 1][N + 1];

        for(int i = 1; i < N + 1; i++) {
            for(int j = 1; j < N + 1; j++) {
                arr[i][j] = INF;

                if(i == j) {
                    arr[i][j] = 0;
                }
            }
        }

        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());

            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());

            arr[from][to] = 1;
            arr[to][from] = 1;
        }

        for(int k = 1; k < N + 1; k++) {
            for(int i = 1; i < N + 1; i++) {
                for(int j = 1; j < N + 1; j++) {
                    if(arr[i][j] > arr[i][k] + arr[k][j]) {
                        arr[i][j] = arr[i][k] + arr[k][j];
                    }
                }
            }
        }

        int min = INF;
        int min_index = 0;

        for(int i = 1; i < N + 1; i++) {
            int sum = 0;

            for(int j = 1; j < N + 1; j++) {
                sum += arr[i][j];
            }

            if(sum < min) {
                min = sum;
                min_index = i;
            }
        }

        System.out.println(min_index);
    }
}
