import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception {

        int T = 10;

        for(int t = 1; t <= T; t++) {
            int[][] box = new int[100][100];

            int tc = Integer.parseInt(br.readLine());
            int max = 0;

            for(int i = 0; i < 100; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 100; j++) {
                    box[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 세로 구하기
            for(int i = 0; i < 100; i++) {
                int sum_horizontal = 0;
                int sum_vertical = 0;
                for(int j = 0; j < 100; j++) {
                    sum_horizontal += box[i][j];
                    sum_vertical += box[j][i];
                }

                max = Math.max(max, Math.max(sum_horizontal, sum_vertical));
            }

            int sum_cross = 0;
            int sum_reverse_cross = 0;

            // 대각선 구하기
            for(int i = 0; i < 100; i++) {
                sum_cross += box[i][i];
                sum_reverse_cross += box[99-i][i];
            }

            max = Math.max(max, Math.max(sum_cross, sum_reverse_cross));

            sb.append("#").append(tc).append(" ").append(max).append("\n");
        }

        System.out.println(sb);
    }
}