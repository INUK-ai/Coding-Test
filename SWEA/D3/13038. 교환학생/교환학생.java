import java.util.*;
import java.io.*;

class Solution
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    private static int days;
    private static int N;

    public static void main(String[] args) throws Exception {

        int T = Integer.parseInt(br.readLine());

        for(int t = 1; t <= T; t++) {

            N = Integer.parseInt(br.readLine());

            int[] classes = new int[7];
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 7; i++) {
                classes[i] = Integer.parseInt(st.nextToken());
            }

            days = Integer.MAX_VALUE;

            for(int i = 0; i < 7; i++) {

                if(classes[i] == 1) {
                    calculateDays(classes, i);
                }
            }

            sb.append("#").append(t).append(" ").append(days).append("\n");
        }

        System.out.println(sb);
    }

    private static void calculateDays(int[] classes, int idx) {

        int total_class = 0;
        int total = idx;
        while(total_class < N) {

            int current_day = total % 7;

            if(classes[current_day] == 1) {
                total_class++;
            }

            total++;
        }

        days = Math.min(days, total - idx);
    }
}