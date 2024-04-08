import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final int INF = Integer.MAX_VALUE;

    static int N;

    public static void main(String[] args) throws IOException {

        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());

        int answer = N / 5;
        int remain = N % 5;

        while(remain % 3 != 0 && answer > 0) {
            answer--;
            remain += 5;
        }

        if(answer == 0 && remain % 3 != 0) {
            answer = -1;
        } else {
            answer += remain / 3;
        }

        System.out.println(answer);
    }
}