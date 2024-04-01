import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int[] stairs;
    static int[] points;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        stairs = new int[N + 1];
        points = new int[N + 1];

        for(int i = 1; i < N + 1; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        points[1] = stairs[1];
        if(N >= 2) {
            points[2] = stairs[2] + stairs[1];
        }

        for(int i = 3; i < N + 1; i++) {
            points[i] = Math.max(points[i - 2], points[i - 3] + stairs[i - 1]) + stairs[i];
        }

        System.out.println(points[N]);
    }
}