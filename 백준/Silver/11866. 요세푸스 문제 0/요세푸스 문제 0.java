import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0; i < N; i++) {
            q.offer(i + 1);
        }

        sb.append("<");

        int index = 1;
        while(q.size() > 1) {
            int current = q.poll();

            if(index < K) {
                q.offer(current);
            }

            if(index == K) {
                index = 0;
                sb.append(current).append(", ");
            }

            index++;
        }

        sb.append(q.poll()).append(">");
        System.out.println(sb);
    }
}