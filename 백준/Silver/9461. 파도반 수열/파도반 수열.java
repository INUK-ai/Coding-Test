import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] p = new long[101];

        p[1] = 1;
        p[2] = 1;
        p[3] = 1;
        p[4] = 2;
        p[5] = 2;
        p[6] = 3;
        p[7] = 4;
        p[8] = 5;
        p[9] = 7;
        p[10] = 9;

        for(int i = 11; i < 101; i++) {
            p[i] = p[i - 1] + p[i - 5];
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < T; i++) {
            int current = Integer.parseInt(br.readLine());
            sb.append(p[current]).append("\n");
        }

        System.out.println(sb);
    }
}