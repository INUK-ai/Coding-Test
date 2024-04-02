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
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        
        for(int i = 0; i < N; i++) {
            int current = Integer.parseInt(br.readLine());
            
            if(current != 0) {
                pq.offer(current);
                continue;
            }
            
            if(pq.isEmpty()) {
                sb.append(0).append("\n");
                continue;
            }
            
            sb.append(pq.poll()).append("\n");
        }
        
        System.out.println(sb);
    }
}