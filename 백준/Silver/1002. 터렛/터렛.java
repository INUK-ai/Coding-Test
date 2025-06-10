import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            System.out.println(getPointCount(x1, y1, r1, x2, y2, r2));
        }
    }

    private static int getPointCount(int x1, int y1, int r1, int x2, int y2, int r2) {
        int dx = x2 - x1;
        int dy = y2 - y1;
        int distSq = dx * dx + dy * dy; 
        int sumR = r1 + r2;
        int diffR = Math.abs(r1 - r2);

        if (dx == 0 && dy == 0) {
            if (r1 == r2) return -1; 
            else return 0;
        }

        if (distSq > sumR * sumR) return 0; 
        if (distSq < diffR * diffR) return 0;
        if (distSq == sumR * sumR) return 1;
        if (distSq == diffR * diffR) return 1;  

        return 2;
    }
}