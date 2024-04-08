import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int answer = 1;

        while(B > A) {
            if(B % 2 != 0 && B % 10 != 1) {
                break;
            }

            if(B % 2 == 0) {
                B /= 2;
            } else {
                B /= 10;
            }

            answer++;
        }

        if(A != B) {
            answer = -1;
        }

        System.out.println(answer);
    }
}