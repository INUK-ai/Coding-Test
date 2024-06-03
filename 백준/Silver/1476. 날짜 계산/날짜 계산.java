import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int E, S, M;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int year = 1;

        while ((year - E) % 15 != 0 || (year - S) % 28 != 0 || (year - M) % 19 != 0) {
            year++;
        }

        System.out.println(year);
    }
}