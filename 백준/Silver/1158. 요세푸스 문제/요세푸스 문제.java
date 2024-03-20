import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < N; i++) {
            q.offer(i + 1);
        }
        
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        
        while(q.size() > 1) {
            for(int i = 0; i < K - 1; i++) {
                int temp = q.poll();
                q.offer(temp);
            }
            sb.append(q.poll()).append(", ");
        }
        
        sb.append(q.poll()).append(">");
        
        System.out.println(sb);
    }
}