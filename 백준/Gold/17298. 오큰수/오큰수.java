import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static int N;

    public static void main(String[] args) throws IOException {

        N = Integer.parseInt(br.readLine());

        int[] A = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> stack = new Stack<>();
        int[] result = new int[N];

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && A[stack.peek()] < A[i]) {
                result[stack.pop()] = A[i];
            }
            stack.push(i);
        }

        while(!stack.isEmpty()) {
            result[stack.pop()] = -1;
        }
        
        for (int i = 0; i < N; i++) {
            sb.append(result[i]).append(" ");
        }

        System.out.println(sb);
    }
}